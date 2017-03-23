import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Josu on 23/03/2017.
 */
public class BarcoFactoryTest {

    private Barco pa, s, d, f;

    @BeforeMethod
    public void setUp() throws Exception {
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
    public void testGetBarcoFactory() throws Exception {
        Assert.assertNotNull(BarcoFactory.getBarcoFactory());
    }

    @Test
    public void testCrearBarco() throws Exception {
        Assert.assertNotNull(pa);
        Assert.assertNotNull(s);
        Assert.assertNotNull(d);
        Assert.assertNotNull(f);
    }

}