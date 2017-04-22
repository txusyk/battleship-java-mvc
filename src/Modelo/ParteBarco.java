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
package Modelo;

public class ParteBarco extends Barco {

    private State estado;
    private int[] posicion = new int[2];


    public ParteBarco(int x, int y) {
        posicion[0] = x;
        posicion[1] = y;
        estado = new SNormal();
    }

    /**
     * @return State
     */
    public State getEstado() {
        return this.estado;
    }

    /**
     *
     * @param pEstado
     */
    public void setState(State pEstado) {
        this.estado = pEstado;
    }

    /**
     * @param x
     * @param y
     */
    public void setPosicion(int x, int y) {
        int[] pos = new int[2];
        pos[0] = x;
        pos[1] = y;
        this.posicion = pos;
    }

    /**
     * @param x
     * @param y
     * @return true en caso de que la posicion sea la que se recibe
     */
    public boolean comprobarPosicion(int x, int y){
        return posicion[0]==x&&posicion[1]==y;
    }

}