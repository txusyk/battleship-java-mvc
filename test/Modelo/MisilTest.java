package Modelo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Edgar on 17/04/2017.
 */
public class MisilTest {
    Misil tmp;

    @BeforeMethod
    public void Init() throws ExcepcionFicheros {
        GestorArchivoInicializacion.getMyGestorArchivoInicializacion().readXML("facil");
        tmp = new Misil();
    }

    @Test
    public void TestConstructora() throws Exception {
        Assert.assertNotNull(tmp);
    }

    @Test
    public void TestGetPrecio() throws Exception {
        Assert.assertEquals(2500, tmp.getPrecio());
    }
}