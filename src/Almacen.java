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

import java.util.HashMap;
import java.util.Stack;

public class Almacen {

    private HashMap<String, Stack<Arma>> almacen;
    private static Almacen miAlmacen;

    private Almacen() {
        almacen = new HashMap<>();
    }

    public static Almacen getMiAlmacen() {
        if (miAlmacen == null) {
            miAlmacen = new Almacen();
        }
        return miAlmacen;
    }

    /**
     * @param pNombre
     * @return Arma
     */
    public Arma comprarArma(String pNombre) {
        if (this.almacen.get(pNombre) != null) {
            if (this.almacen.get(pNombre).size() > 0) {
                return this.almacen.get(pNombre).pop();
            }
        }
        return null;
    }

    /**
     * @param pNombre
     * @return precio
     */
    public int getPrecioArma(String pNombre){
        return this.almacen.get(pNombre).peek().getPrecio();
    }

}