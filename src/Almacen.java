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

public class Almacen {

    private ListaArmas existencias;
    private static Almacen miAlmacen;

    private Almacen() {
        existencias = new ListaArmas();
    }

    public static Almacen getMiAlmacen() {
        if (miAlmacen == null) {
            miAlmacen = new Almacen();
        }
        return miAlmacen;
    }

    /**
     * @param pArma
     * @return Arma
     */
    public Arma comprarArma(String pArma) {
        if (existeArma(pArma)) {
            if (!this.estaVacio(pArma)) {
                return this.existencias.getArma(pArma);
            }
        }
        return null;
    }

    /**
     * @param pArma
     * @return boolean
     */
    private boolean existeArma(String pArma) {
        if (this.existencias.consultarArma(pArma.toLowerCase()) != null){
            return true;
        }
        return false;
    }

    /**
     * @param pArma
     * @return boolean
     */
    private boolean estaVacio(String pArma) {
        return this.existencias.getSize(pArma) != 0;
    }

    /**
     * @param pArma
     * @return precio
     */
    public int getPrecioArma(String pArma) {
        return this.existencias.consultarArma(pArma).precio;
    }

    /**
     * @param pNombreArma
     * @return int
     */
    public int cantidadRestante(String pNombreArma){ return this.existencias.getSize(pNombreArma);}

}