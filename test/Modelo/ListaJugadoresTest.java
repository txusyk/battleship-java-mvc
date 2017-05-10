package Modelo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Josu on 22/04/2017.
 */
public class ListaJugadoresTest {

    @BeforeClass
    public void setUp() throws Exception {
        GestorFicheros.getMyGestorFicheros().readXML("facil");
    }

    @Test
    public void testGetMyListaJug() throws Exception {
        Assert.assertNotNull(ListaJugadores.getMyListaJug());
    }

    @Test
    public void testInicializarJugadores() throws Exception {
        Assert.assertTrue(ListaJugadores.getMyListaJug().getHumano() instanceof Humano);
        Assert.assertTrue(ListaJugadores.getMyListaJug().getIA() instanceof IA);
    }
}