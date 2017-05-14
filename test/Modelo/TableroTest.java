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

        tab1.colocarBarco(BarcoFactory.getBarcoFactory().crearBarco("destructor"), 2, 3); //intentamos colocar un barco cerca de otro ya colocado
        Assert.assertFalse(tab1.esBarco(2, 3));
        tab1.colocarBarco(BarcoFactory.getBarcoFactory().crearBarco("fragata"), 0, 0); //colocamos un barco en un borde
        Assert.assertTrue(tab1.esBarco(0, 0));
        tab1.colocarBarco(BarcoFactory.getBarcoFactory().crearBarco("fragata"), 9, 9); //colocamos un barco en un borde
        Assert.assertTrue(tab1.esBarco(9, 9));
    }

    @Test
    public void testGetPosicion() throws Exception {
        tab1.colocarBarco(BarcoFactory.getBarcoFactory().crearBarco("fragata"), 2, 2);
        Assert.assertTrue(tab1.getPosicion(2, 2) instanceof ParteBarco);

        Assert.assertTrue(tab1.getPosicion(2, 3) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(1, 3) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(1, 2) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(1, 1) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(2, 1) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(3, 1) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(3, 2) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(3, 3) instanceof AreaBarco);

        tab1 = new Tablero(10, 10);
        Barco b = BarcoFactory.getBarcoFactory().crearBarco("destructor");
        tab1.colocarBarco(b, 2, 2);
        Assert.assertTrue(tab1.getPosicion(1, 3) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(1, 2) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(1, 1) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(2, 3) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(2, 1) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(3, 1) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(3, 3) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(4, 3) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(4, 2) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(4, 1) instanceof AreaBarco);


        tab1 = new Tablero(10, 10);
        b = BarcoFactory.getBarcoFactory().crearBarco("fragata");
        b.setHorientacion('v');
        tab1.colocarBarco(b, 2, 2);
        Assert.assertTrue(tab1.getPosicion(2, 3) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(1, 3) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(1, 2) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(1, 1) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(2, 1) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(3, 1) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(3, 2) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(3, 3) instanceof AreaBarco);

        tab1 = new Tablero(10, 10);
        b = BarcoFactory.getBarcoFactory().crearBarco("submarino");
        b.setHorientacion('v');
        tab1.colocarBarco(b, 2, 2);
        Assert.assertTrue(tab1.getPosicion(1, 1) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(2, 1) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(3, 1) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(1, 2) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(3, 2) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(1, 3) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(3, 3) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(1, 4) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(3, 4) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(1, 5) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(2, 5) instanceof AreaBarco);
        Assert.assertTrue(tab1.getPosicion(3, 5) instanceof AreaBarco);

        Assert.assertFalse(tab1.colocarBarco(BarcoFactory.getBarcoFactory().crearBarco("portaaviones"), 7, 7));
        b = BarcoFactory.getBarcoFactory().crearBarco("portaaviones");
        b.setHorientacion('v');
        Assert.assertFalse(tab1.colocarBarco(b, 3, 8));
    }

}