package Modelo;
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Josu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Josu on 19/03/2017.
 */
public class IATest {

    IA h1;

    @BeforeClass
    public void leerXML() {
        GestorFicheros.getMyGestorFicheros().readXML("facil");
    }

    @BeforeMethod
    public void setUp() throws Exception {
        h1 = new IA();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        h1 = null;
    }

    @Test
    public void testJugarTurnoIA() throws Exception {


    }

    @Test
    public void testColocarBarcosIA() throws Exception {

    }


    @Test
    public void testIsTurno() throws Exception {
        Assert.assertEquals(false, h1.isTurno());
    }

    @Test
    public void testGetTablero() throws Exception {
        Assert.assertNotNull(h1.getTablero());
    }

    @Test
    public void testGetFlota() throws Exception {
        Assert.assertNotNull(h1.getFlota());
    }

    @Test
    public void testGetListaArmas() throws Exception {
        Assert.assertNotNull(h1.getListaArmas());
    }


    @Test
    public void testDecrementarDinero() throws Exception {
        Assert.assertTrue(h1.decrementarDinero(GestorFicheros.getMyGestorFicheros().getDineroInicial()));
    }

    @Test
    public void testComprarArmas() throws Exception {
        h1.comprarArma("bomba");
        Assert.assertEquals(1, h1.getListaArmas().getSize("bomba"));
    }

}