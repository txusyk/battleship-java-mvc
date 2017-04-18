package Modelo;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Josu on 23/03/2017.
 */
public class DireccionesArmaTest {

    @Test
    public void testGetDireccion() throws Exception {
        Assert.assertEquals("boom", DireccionesArma.BOOM.getDireccion());
        Assert.assertEquals("noreste-suroeste", DireccionesArma.NESO.getDireccion());
        Assert.assertEquals("noroeste-sureste", DireccionesArma.NOSE.getDireccion());
    }
}