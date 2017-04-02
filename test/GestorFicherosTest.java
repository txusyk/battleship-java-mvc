import Modelo.GestorFicheros;
import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Josu on 23/03/2017.
 */
public class GestorFicherosTest {

    @BeforeClass
    public void lanzarleerXml(){
        GestorFicheros.getMyGestorFicheros().readXML("facil");
    }

    @Test
    public void testGetMyGestorFicheros() throws Exception {
        Assert.assertNotNull(GestorFicheros.getMyGestorFicheros());
    }

    @Test
    public void testGetNumBombas() throws Exception {
        Assert.assertEquals(99, GestorFicheros.getMyGestorFicheros().getNumBombas());
    }

    @Test
    public void testGetNumMisiles() throws Exception {
        Assert.assertEquals(15, GestorFicheros.getMyGestorFicheros().getNumMisiles());
    }

    @Test
    public void testGetNumMisilesDirig() throws Exception {
        Assert.assertEquals(8, GestorFicheros.getMyGestorFicheros().getNumMisilesDirig());
    }

    @Test
    public void testGetNumRadares() throws Exception {
        Assert.assertEquals(10, GestorFicheros.getMyGestorFicheros().getNumRadares());
    }

    @Test
    public void testGetNumEscudos() throws Exception {
        Assert.assertEquals(10, GestorFicheros.getMyGestorFicheros().getNumEscudos());
    }

    @Test
    public void testGetPrecioMisiles() throws Exception {
        Assert.assertEquals(2500,GestorFicheros.getMyGestorFicheros().getPrecioMisiles());
    }

    @Test
    public void testGetPrecioMisilesDirig() throws Exception {
        Assert.assertEquals(8000, GestorFicheros.getMyGestorFicheros().getPrecioMisilesDirig());
    }

    @Test
    public void testGetPrecioRadares() throws Exception {
        Assert.assertEquals(5000, GestorFicheros.getMyGestorFicheros().getPrecioRadares());
    }

    @Test
    public void testGetPrecioEscudos() throws Exception {
        Assert.assertEquals(5000, GestorFicheros.getMyGestorFicheros().getPrecioEscudos());
    }

    @Test
    public void testObtenerPrecioReparacion() throws Exception {
        Assert.assertEquals(2500, GestorFicheros.getMyGestorFicheros().obtenerPrecioReparacion());
    }

}