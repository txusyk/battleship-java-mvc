package Modelo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Edgar on 18/04/2017.
 */
public class RadarTest {

    Radar tmp;

    @BeforeMethod
    public void init() {
        GestorArchivoInicializacion.getMyGestorArchivoInicializacion().readXML("facil");
        tmp = new Radar();

    }

    @Test
    public void testConstructora() throws Exception {
        Assert.assertNotNull(tmp);
    }

    @Test
    public void testgetPrecio() throws Exception {
        Assert.assertEquals(5000, tmp.getPrecio());
    }


    @Test
    public void testAccion() throws Exception {
        //falta la inicialización
    }

    @Test
    public void testColocarRadarValido() throws Exception {
        tmp.colocarRadar(5, 5);
        Assert.assertEquals(5, tmp.getX());
        Assert.assertEquals(5, tmp.getY());
    }


    @Test
    public void testColocarRadarNoValido() throws Exception {
        tmp.colocarRadar(11, 11);
        Assert.assertNotEquals(11, tmp.getX());
        Assert.assertNotEquals(11, tmp.getY());
    }

    @Test
    public void testConsultarRadar() throws Exception {
        //falta la inicialización
    }
}