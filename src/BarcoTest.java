import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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
        pa = new Portaaviones("portaaviones");
        s = new Submarino("submarino");
        d = new Destructor("destructor");
        f = new Fragata("fragata");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        pa = null;
        s = null;
        d = null;
        f = null;
    }

    @Test
    public void testGetNombre(){
        Assert.assertEquals("portaaviones",pa.getNombre());
        Assert.assertEquals("submarino",s.getNombre());
        Assert.assertEquals("destructor", d.getNombre());
        Assert.assertEquals("fragata",f.getNombre());
    }

    @Test
    public void getTamaño(){
        Assert.assertEquals(4,pa.getTamaño());
        Assert.assertEquals(3,s.getTamaño());
        Assert.assertEquals(2, d.getTamaño());
        Assert.assertEquals(1,f.getTamaño());
    }

    @Test
    public void getEstadoPosicion(){

    }

    @Test
    public void getPrecioReparacion(){
        Assert.assertEquals(4,pa.getPrecioReparacion());
        Assert.assertEquals(3,s.getPrecioReparacion());
        Assert.assertEquals(2, d.getPrecioReparacion());
        Assert.assertEquals(1,f.getPrecioReparacion());
    }
}