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

import Modelo.GestorFicheros;
import Modelo.IA;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Josu on 19/03/2017.
 */
public class IATest {

    IA ia1, ia2;

    @BeforeClass
    public void leerXML() {
        GestorFicheros.getMyGestorFicheros().readXML("facil");
    }

    @BeforeMethod
    public void setUp() throws Exception {
        ia1 = new IA();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        ia1 = null;
    }

    @Test
    public void testGetDificultad() throws Exception {
        Assert.assertEquals("facil", ia1.getDificultad(), "La dificiltad deberia de ser 'facil'");
    }

    @Test
    public void testJugarTurnoIA() throws Exception {


    }

    @Test
    public void testColocarBarcosIA() throws Exception {

    }

}