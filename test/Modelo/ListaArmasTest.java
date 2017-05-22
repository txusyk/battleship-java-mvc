package Modelo;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Josu on 23/03/2017.
 */
public class ListaArmasTest {

    ListaArmas la;

    @BeforeClass
    public void inicializarGestorFicheros() throws ExcepcionFicheros {
        GestorArchivoInicializacion.getMyGestorArchivoInicializacion().readXML("facil");
    }

    @BeforeMethod
    public void setUp() throws Exception {
        la = new ListaArmas();
        la.inicializarArmas();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        la = null;
    }

    @Test
    public void testInicializarArmas() throws Exception {
        Assert.assertNotNull(la);
    }

    @Test
    public void getArma() throws Exception {
        Assert.assertEquals("bomba", getType(la.getArma("bomba")));
        Assert.assertEquals("misil", getType(la.getArma("misil")));
        Assert.assertEquals("misildirig", getType(la.getArma("misildirig")));
        Assert.assertEquals("radar", getType(la.getArma("radar")));
        Assert.assertEquals("escudo", getType(la.getArma("escudo")));
    }

    @Test
    public void testAñadirArma() throws Exception {
        Assert.assertNotNull(la.getArma("bomba"));
        Assert.assertNotNull(la.getArma("misil"));
        Assert.assertNotNull(la.getArma("misildirig"));
        Assert.assertNotNull(la.getArma("radar"));
        Assert.assertNotNull(la.getArma("escudo"));
    }

    @Test
    public void testEliminarArma() throws Exception {
        int valorPrev = la.getSize("bomba");
        la.eliminarArma("bomba");
        Assert.assertTrue(valorPrev > la.getSize("bomba"));

    }

    private String getType(HerramientasJuego pHerramientasJuego) {
        String type = String.valueOf(pHerramientasJuego.getClass());
        String[] arrAux = type.split("\\.");
        type = arrAux[1].toLowerCase();
        return type;
    }

}