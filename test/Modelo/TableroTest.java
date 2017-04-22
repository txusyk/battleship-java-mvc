package Modelo;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Josu on 21/04/2017.
 */
public class TableroTest {

    Tablero tab1;

    @BeforeMethod
    public void setUp() throws Exception {
        tab1 = new Tablero(10, 10);
        GestorFicheros.getMyGestorFicheros().readXML("facil");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        tab1 = null;
    }

    @Test
    public void testColocarBarcoEsBarcoyComprobarAlrededor() throws Exception {
        tab1.colocarBarco(BarcoFactory.getBarcoFactory().crearBarco("fragata"), 2, 2); //colocamos un barco
        Assert.assertTrue(tab1.esBarco(2, 2));
        tab1.colocarBarco(BarcoFactory.getBarcoFactory().crearBarco("fragata"), 2, 3); //intentamos colocar un barco cerca de otro ya colocado
        Assert.assertFalse(tab1.esBarco(2, 3));
        tab1.colocarBarco(BarcoFactory.getBarcoFactory().crearBarco("fragata"), 0, 0); //colocamos un barco en un borde
        Assert.assertFalse(tab1.esBarco(0, 0));
        tab1.colocarBarco(BarcoFactory.getBarcoFactory().crearBarco("fragata"), 9, 9); //colocamos un barco en un borde
        Assert.assertFalse(tab1.esBarco(9, 9));

    }

    @Test
    public void testGetPosicion() throws Exception {
        tab1.colocarBarco(BarcoFactory.getBarcoFactory().crearBarco("fragata"), 2, 2);
        Assert.assertTrue(tab1.getPosicion(2, 2) instanceof ParteBarco);
        Assert.assertTrue(tab1.getPosicion(2, 3) instanceof Agua);
    }

}