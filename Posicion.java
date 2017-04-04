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
    public boolean equals(Posicion other){
        return posicion[0]==other.getX()&&posicion[1]==other.getY();

    }


    public void  recibirDisparo(){
        if(estado instanceof sNormal){
            setState(new Tocado());
        }
    }


    public void  reparar(){
        if(estado instanceof Tocado){
            setState(new sNormal());
        }
    }

    /**
     *
     * @param estado
     */
    public void setState(State estado) {
        // TODO - implement Posicion.setState
        throw new UnsupportedOperationException();
    }

    /**
     * @return State
     */
    public State getEstado() {
        return this.estado;
    }

    public void accionarCasilla() {
        // TODO - implement Posicion.accionarCasilla
        throw new UnsupportedOperationException();
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


    public void desubrirCasilla() {
        if (!descubierta) {
            descubierta = true;
        } else {
            System.out.println("Ya estaba descubierta.");
        }
    }
}