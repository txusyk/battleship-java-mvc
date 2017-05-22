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

public class ParteBarco extends ObjTablero implements State {

    private State estado;
    private boolean barcoHundido;
    private boolean escudo;

    public ParteBarco() {
        barcoHundido = false;
        estado = new SNormal();
    }

    /**
     *
     * @param pEstado
     */
    public void setState(State pEstado) {
        this.estado = pEstado;
        setChanged();
        notifyObservers();
    }

    public boolean isBarcoHundido() {
        return barcoHundido;
    }

    public void setBarcoHundido(boolean barcoHundido) {
        this.barcoHundido = barcoHundido;
        setChanged();
        notifyObservers();
    }

    public boolean getEscudo() {
        return escudo;
    }

    public void setEscudo(boolean escudo) {
        this.escudo = escudo;
        setChanged();
        notifyObservers();
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
        return this.x == x && this.y == y;
    }

    @Override
    public boolean informacion() {
        return this.estado.informacion();
    }
}