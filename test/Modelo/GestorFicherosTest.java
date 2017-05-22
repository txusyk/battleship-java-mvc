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
    public void lanzarleerXml() throws ExcepcionFicheros {
        GestorArchivoInicializacion.getMyGestorArchivoInicializacion().readXML("facil");
    }

    @Test
    public void testGetMyGestorFicheros() throws Exception {
        Assert.assertNotNull(GestorArchivoInicializacion.getMyGestorArchivoInicializacion());
    }

    @Test
    public void testGetNumArmas() throws Exception {
        Assert.assertEquals(99, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumeroArmas("bomba"));
        Assert.assertEquals(15, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumeroArmas("misil"));
        Assert.assertEquals(8, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumeroArmas("misildirig"));
        Assert.assertEquals(10, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumeroArmas("radar"));
        Assert.assertEquals(10, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumeroArmas("escudo"));
    }

    @Test
    public void testGetPreciosArmas() throws Exception {
        Assert.assertEquals(2500, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getPrecioArma("misil"));
        Assert.assertEquals(8000, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getPrecioArma("misildirig"));
        Assert.assertEquals(5000, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getPrecioArma("radar"));
        Assert.assertEquals(5000, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getPrecioArma("escudo"));
    }

    @Test
    public void testObtenerPrecioReparacion() throws Exception {
        Assert.assertEquals(2500, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().obtenerPrecioReparacion());
    }

    @Test
    public void TestPrecioBaseImpacto() throws Exception {
        Assert.assertEquals(500, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getPrecioBaseImpacto());
    }

    @Test
    public void TestDineroInicial() throws Exception {
        Assert.assertEquals(15000, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getDineroInicial());
    }

    @Test
    public void TestGetNumBarcos() throws Exception {
        Assert.assertEquals(4, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumBarco("fragata"));
        Assert.assertEquals(3, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumBarco("destructor"));
        Assert.assertEquals(2, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumBarco("submarino"));
        Assert.assertEquals(1, GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumBarco("portaaviones"));
    }
}