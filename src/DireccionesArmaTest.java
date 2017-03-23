import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Josu on 23/03/2017.
 */
public class DireccionesArmaTest {

    @Test
    public void testGetDireccion() throws Exception {
        Assert.assertEquals("boom",DireccionesArma.BOOM.getDireccion());
        Assert.assertEquals("este-oeste", DireccionesArma.EO.getDireccion());
        Assert.assertEquals("norte-sur", DireccionesArma.NS.getDireccion());
    }

}