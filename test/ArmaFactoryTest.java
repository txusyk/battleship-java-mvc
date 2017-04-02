import Modelo.Arma;
import Modelo.ArmaFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Josu on 23/03/2017.
 */
public class ArmaFactoryTest {

    private Arma bomba, misil, misildirig, radar, escudo;


    @BeforeMethod
    public void setUp() throws Exception {
        bomba = ArmaFactory.getArmaFactory().crearArma("bomba");
        misil = ArmaFactory.getArmaFactory().crearArma("misil");
        misildirig = ArmaFactory.getArmaFactory().crearArma("misildirig");
        radar = ArmaFactory.getArmaFactory().crearArma("radar");
        escudo = ArmaFactory.getArmaFactory().crearArma("escudo");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        bomba = null;
        misil =  null;
        misildirig = null;
        radar = null;
        escudo = null;
    }

    @Test
    public void testGetArmaFactory() throws Exception {
        Assert.assertNotNull(ArmaFactory.getArmaFactory());
    }

    @Test
    public void testCrearArma() throws Exception {
        Assert.assertNotNull(bomba);
        Assert.assertNotNull(misil);
        Assert.assertNotNull(misildirig);
        Assert.assertNotNull(radar);
        Assert.assertNotNull(escudo);

        Assert.assertEquals("bomba",getType(bomba));
        Assert.assertEquals("misil",getType(misil));
        Assert.assertEquals("misildirig",getType(misildirig));
        Assert.assertEquals("radar",getType(radar));
        Assert.assertEquals("escudo",getType(escudo));
    }

    private String getType(Arma pArma) {
        String type = String.valueOf(pArma.getClass());
        String[] arrAux = type.split(" ");
        type = arrAux[1].toLowerCase();
        return type;
    }

}