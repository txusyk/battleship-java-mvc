package Modelo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by david on 20/04/2017.
 */
public class BarcoTest {

    private Barco p;
    private Barco s;
    private Barco d;
    private Barco f;

    @BeforeClass
    public void readXML() throws ExcepcionFicheros {
        GestorArchivoInicializacion.getMyGestorArchivoInicializacion().readXML("facil");
    }

    @BeforeMethod
    public void setUp() {
        p = BarcoFactory.getBarcoFactory().crearBarco("portaaviones");
        s = BarcoFactory.getBarcoFactory().crearBarco("submarino");
        d = BarcoFactory.getBarcoFactory().crearBarco("destructor");
        f = BarcoFactory.getBarcoFactory().crearBarco("fragata");
    }

    @Test
    public void testGetTamaño() throws Exception {
        Assert.assertEquals(p.getTamaño(), 4);
        Assert.assertEquals(s.getTamaño(), 3);
        Assert.assertEquals(d.getTamaño(), 2);
        Assert.assertEquals(f.getTamaño(), 1);
    }

    @Test
    public void testGetParteBarco() throws Exception {
        Assert.assertNotNull(p.getParteBarco(0));
        Assert.assertNotNull(s.getParteBarco(0));
        Assert.assertNotNull(d.getParteBarco(0));
        Assert.assertNotNull(f.getParteBarco(0));
    }

    @Test
    public void testGetHorientacion() throws Exception {
        int[] pivote = new int[2];
        pivote[0] = 1;
        pivote[1] = 1;
        p.inicializar(pivote[0], pivote[1], 'h');
        Assert.assertEquals(p.getHorientacion(), 'h');
    }

    @Test
    public void testReparar() throws Exception {
        p.partesBarco[0].setState(new STocado());
        Assert.assertFalse(p.partesBarco[0].informacion());
        int x = p.partesBarco[0].getX();
        int y = p.partesBarco[0].getY();
        p.reparar(x, y);
        Assert.assertTrue(p.partesBarco[0].informacion());
    }

    @Test
    public void testContiene() throws Exception {
        int x = p.partesBarco[0].getX();
        int y = p.partesBarco[0].getY();
        Assert.assertTrue(p.contiene(x, y));

        p.partesBarco[1].setPosicion(3, 3);
        Assert.assertTrue(p.contiene(x, y));
    }

    @Test
    public void testInicializar() throws Exception {
        p.getParteBarco(1).setPosicion(2, 2);
        Assert.assertTrue(p.contiene(2, 2));
    }

    @Test
    public void testGetPrecioReparacion() throws Exception {
        Assert.assertEquals(p.getPrecioReparacion(), GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getPrecioBaseReparacion());
    }

    @Test
    public void testHundir() throws Exception {
        Flota fl = new Flota();
        d = fl.inicializarBarco("destructor");
        Assert.assertFalse(d.getHundido());
        d.getParteBarco(0).setPosicion(3, 3);
        d.getParteBarco(1).setPosicion(3, 4);
        d.hundir(3, 3);
        d.setHorientacion('v');
        Assert.assertTrue(d.getHundido());
    }

    @Test
    public void testRecibirDaños() throws Exception {
        Flota fl = new Flota();

        f = fl.inicializarBarco("fragata");
        d = fl.inicializarBarco("destructor");
        s = fl.inicializarBarco("submarino");

        ParteBarco pb1 = f.getParteBarco(0);

        ParteBarco pb2 = d.getParteBarco(0);
        ParteBarco pb3 = d.getParteBarco(1);

        ParteBarco pb4 = s.getParteBarco(0);
        ParteBarco pb5 = s.getParteBarco(1);
        ParteBarco pb6 = s.getParteBarco(2);

        pb1.setPosicion(2, 2);
        f.recibirDaños(2, 2);
        Assert.assertTrue(f.getHundido());

        pb2.setPosicion(3, 3);
        pb3.setPosicion(3, 4);

        pb4.setPosicion(5, 5);
        pb5.setPosicion(5, 6);
        pb6.setPosicion(5, 7);
        s.recibirDaños(5, 6);
        Assert.assertFalse(s.getParteBarco(1).informacion());
    }

}