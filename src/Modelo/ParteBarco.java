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

public class ParteBarco extends ObjTablero {

    private State estado;

    private int x, y;


    public ParteBarco() {
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


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * @param x
     * @param y
     */
    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param x
     * @param y
     * @return true en caso de que la posicion sea la que se recibe
     */
    public boolean comprobarPosicion(int x, int y){
        System.out.printf(this.x + "?" + x + "  " + this.y + "?" + y);
        //JOptionPane.showMessageDialog(null,this.x+" ? "+x+","+this.y+" ? "+y);
        return this.x == x && this.y == y;
    }

}