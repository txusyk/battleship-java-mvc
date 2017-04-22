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
        ListaJugadores.getMyListaJug().inicializarJugadores("Prueba");
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

    @Test
    public void testGetJugNoActivo() throws Exception {
        ListaJugadores.getMyListaJug().cambiarJugActivo();
        Assert.assertTrue(ListaJugadores.getMyListaJug().getJugNoActivo() instanceof IA);
    }

    @Test
    public void cambiarJugActivo() throws Exception {
        ListaJugadores.getMyListaJug().cambiarJugActivo();
        Assert.assertTrue(ListaJugadores.getMyListaJug().getJugNoActivo() instanceof Humano);
    }

}