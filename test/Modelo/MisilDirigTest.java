package Modelo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Edgar on 17/04/2017.
 */
public class MisilDirigTest {
    MisilDirig tmp;

    @BeforeMethod
    public void init() {
        GestorFicheros.getMyGestorFicheros().readXML("facil");
        tmp = new MisilDirig();

    }

    @Test
    public void testConstructora() throws Exception {
        Assert.assertNotNull(tmp);
    }

    @Test
    public void testgetPrecio() throws Exception {
        Assert.assertEquals(8000, tmp.getPrecio());
    }
}