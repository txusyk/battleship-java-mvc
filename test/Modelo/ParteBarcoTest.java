package Modelo;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Josu on 22/04/2017.
 */
public class ParteBarcoTest {

    ParteBarco parteBarco;

    @BeforeMethod
    public void setUp() throws Exception {
        parteBarco = new ParteBarco();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        parteBarco = null;
    }

    @Test
    public void testGetEstado() throws Exception {
        Assert.assertTrue(parteBarco.informacion());
    }

    @Test
    public void testSetState() throws Exception {
        parteBarco.setState(new STocado());
        Assert.assertFalse(parteBarco.informacion());
    }

    @Test
    public void testSetPosicion() throws Exception {
        parteBarco.setPosicion(2, 3);
        Assert.assertTrue(parteBarco.comprobarPosicion(2, 3));
        Assert.assertFalse(parteBarco.comprobarPosicion(3, 2));

    }

    @Test
    public void testComprobarPosicion() throws Exception {
        Assert.assertTrue(parteBarco.comprobarPosicion(0, 0));
    }

}