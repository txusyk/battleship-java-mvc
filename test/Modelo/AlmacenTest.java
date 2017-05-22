package Modelo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by david on 20/04/2017.
 */
public class AlmacenTest {

    @BeforeClass
    public void readXML() throws ExcepcionFicheros {
        GestorArchivoInicializacion.getMyGestorArchivoInicializacion().readXML("facil");
    }

    @Test
    public void testGetMiAlmacen() throws Exception {
        Assert.assertNotNull(Almacen.getMiAlmacen());
    }

    @Test
    public void testComprarArma() throws Exception {
        Assert.assertNotNull(Almacen.getMiAlmacen().comprarArma("bomba"));
        Assert.assertNotNull(Almacen.getMiAlmacen().comprarArma("misil"));
        Assert.assertNotNull(Almacen.getMiAlmacen().comprarArma("misildirig"));
        Assert.assertNotNull(Almacen.getMiAlmacen().comprarArma("radar"));
        Assert.assertNotNull(Almacen.getMiAlmacen().comprarArma("escudo"));
    }

    @Test
    public void testGetPrecioArma() throws Exception {

        Assert.assertEquals(Almacen.getMiAlmacen().getPrecioArma("misil"), 2500);

    }

    @Test
    public void testCantidadRestante() throws Exception {
        Assert.assertEquals(Almacen.getMiAlmacen().cantidadRestante("bomba"), 200);
    }

}