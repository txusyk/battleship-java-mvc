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

public class Posicion {

    private State estado;
    private int[] posicion;
    private boolean descubierta = false;

    public Posicion(int x, int y) {
        posicion = new int[2];
        posicion[0] = x;
        posicion[1] = y;
    }


    public void setState(State pEstado) {
        this.estado = pEstado;
    }

    public boolean equals(Posicion pOther) {
        return posicion[0]==pOther.getX() && posicion[1]==pOther.getY();
    }
    /**
     * @return State
     */
    public State getEstado() {
        return this.estado;
    }

    /**
     * @return int
     */
    public int getX() {
        return posicion[0];
    }

    public int getY() {
        return posicion[1];
    }


    /**
     * @param posicion
     */
    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }

    public boolean comprobarPosicion(Posicion other){
        return posicion[0]==other.getX()&&posicion[1]==other.getY();

    }
}