package Modelo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by david on 20/04/2017.
 */
public class ArmaFactoryTest {

    HerramientasJuego b;
    HerramientasJuego m;
    HerramientasJuego mD;

    @BeforeMethod
    public void setUp() {
        b = null;
        m = null;
        mD = null;
    }

    @Test
    public void testGetArmaFactory() throws Exception {
        Assert.assertNotNull(ArmaFactory.getArmaFactory());
    }

    @Test
    public void testCrearArma() throws Exception {
        b = ArmaFactory.getArmaFactory().crearArma("bomba");
        Assert.assertNotNull(b);
        m = ArmaFactory.getArmaFactory().crearArma("misil");
        Assert.assertNotNull(m);
        mD = ArmaFactory.getArmaFactory().crearArma("misildirig");
        Assert.assertNotNull(mD);
    }

}