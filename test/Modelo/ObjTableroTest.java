package Modelo;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Josu on 22/04/2017.
 */
public class ObjTableroTest {

    ObjTablero objTablero;

    @BeforeMethod
    public void setUp() throws Exception {
        objTablero = new ObjTablero();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        objTablero = null;
    }

    @Test
    public void testGetVisible() throws Exception {
        Assert.assertFalse(objTablero.getVisible());
    }

    @Test
    public void testSetVisible() throws Exception {
        objTablero.setVisible(true);
        Assert.assertTrue(objTablero.getVisible());
    }

}