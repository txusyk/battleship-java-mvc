import Modelo.Barco;
import Modelo.BarcoFactory;
import Modelo.GestorFicheros;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Josu on 23/03/2017.
 */
public class BarcoTest {

    Barco pa;
    Barco s;
    Barco d;
    Barco f;

    @BeforeMethod
    public void setUp() throws Exception {
        GestorFicheros.getMyGestorFicheros().readXML("facil");
        pa = BarcoFactory.getBarcoFactory().crearBarco("portaaviones");
        s = BarcoFactory.getBarcoFactory().crearBarco("submarino");
        d = BarcoFactory.getBarcoFactory().crearBarco("destructor");
        f = BarcoFactory.getBarcoFactory().crearBarco("fragata");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        pa = null;
        s = null;
        d = null;
        f = null;
    }

    @Test
    public void getEstadoPosicion(){

    }

    @Test
    public void getPrecioReparacion(){
        Assert.assertEquals(2500,pa.getPrecioReparacion());
        Assert.assertEquals(2500,s.getPrecioReparacion());
        Assert.assertEquals(2500, d.getPrecioReparacion());
        Assert.assertEquals(2500,f.getPrecioReparacion());
    }

}