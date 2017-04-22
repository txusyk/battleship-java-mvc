package Modelo;
/**
 * Created by Josu on 18/04/2017.
 */
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Josu on 23/03/2017.
 */
public class GestorFicherosTest {

    @BeforeClass
    public void lanzarleerXml() {
        GestorFicheros.getMyGestorFicheros().readXML("facil");
    }

    @Test
    public void testGetMyGestorFicheros() throws Exception {
        Assert.assertNotNull(GestorFicheros.getMyGestorFicheros());
    }

    @Test
    public void testGetNumArmas() throws Exception {
        Assert.assertEquals(99, GestorFicheros.getMyGestorFicheros().getNumeroArmas("bomba"));
        Assert.assertEquals(15, GestorFicheros.getMyGestorFicheros().getNumeroArmas("misil"));
        Assert.assertEquals(8, GestorFicheros.getMyGestorFicheros().getNumeroArmas("misildirig"));
        Assert.assertEquals(10, GestorFicheros.getMyGestorFicheros().getNumeroArmas("radar"));
        Assert.assertEquals(10, GestorFicheros.getMyGestorFicheros().getNumeroArmas("escudo"));
    }

    @Test
    public void testGetPreciosArmas() throws Exception {
        Assert.assertEquals(2500, GestorFicheros.getMyGestorFicheros().getPrecioArma("misil"));
        Assert.assertEquals(8000, GestorFicheros.getMyGestorFicheros().getPrecioArma("misildirig"));
        Assert.assertEquals(5000, GestorFicheros.getMyGestorFicheros().getPrecioArma("radar"));
        Assert.assertEquals(5000, GestorFicheros.getMyGestorFicheros().getPrecioArma("escudo"));
    }

    @Test
    public void testObtenerPrecioReparacion() throws Exception {
        Assert.assertEquals(2500, GestorFicheros.getMyGestorFicheros().obtenerPrecioReparacion());
    }

    @Test
    public void TestPrecioBaseImpacto() throws Exception {
        Assert.assertEquals(500, GestorFicheros.getMyGestorFicheros().getPrecioBaseImpacto());
    }

    @Test
    public void TestDineroInicial() throws Exception {
        Assert.assertEquals(15000, GestorFicheros.getMyGestorFicheros().getDineroInicial());
    }

    @Test
    public void TestGetNumBarcos() throws Exception {
        Assert.assertEquals(4, GestorFicheros.getMyGestorFicheros().getNumBarco("fragata"));
        Assert.assertEquals(3, GestorFicheros.getMyGestorFicheros().getNumBarco("destructor"));
        Assert.assertEquals(2, GestorFicheros.getMyGestorFicheros().getNumBarco("submarino"));
        Assert.assertEquals(1, GestorFicheros.getMyGestorFicheros().getNumBarco("portaaviones"));
    }
}