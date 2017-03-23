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
import org.testng.annotations.Test;

/**
 * Created by Josu on 23/03/2017.
 */
public class AlmacenTest {

    @Test
    public void testGetMiAlmacen() throws Exception {
        Assert.assertNotNull(Almacen.getMiAlmacen());
    }

    @Test
    public void testComprarArma() throws Exception {
        Assert.assertEquals(new Bomba(0).getClass(),Almacen.getMiAlmacen().comprarArma("bomba").getClass());
        Assert.assertEquals(new Misil(0).getClass(),Almacen.getMiAlmacen().comprarArma("misil").getClass());
        Assert.assertEquals(new MisilDirig(0).getClass(),Almacen.getMiAlmacen().comprarArma("misildirig").getClass());
    }

    @Test
    public void testGetPrecioArma() throws Exception {
        Assert.assertEquals(new Bomba(0).getPrecio(), Almacen.getMiAlmacen().getPrecioArma("bomba"));
        Assert.assertEquals(new Misil(2500).getPrecio(), Almacen.getMiAlmacen().getPrecioArma("misil"));
    }

    @Test
    public void cantidadRestante() throws Exception {
        int cantidadInicial =  Almacen.getMiAlmacen().cantidadRestante("bomba");
        Almacen.getMiAlmacen().comprarArma("bomba");
        Assert.assertNotEquals(cantidadInicial,Almacen.getMiAlmacen().cantidadRestante("bomba"));
        Assert.assertEquals(cantidadInicial-1,Almacen.getMiAlmacen().cantidadRestante("bomba"));
    }
}