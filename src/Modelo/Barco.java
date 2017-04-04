package Modelo;/*
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

import java.util.Iterator;

public abstract class Barco {

    protected int  cntTocados;
    protected Posicion[] posicion;
    protected int preciorReparacion;
    protected Escudo escudo;

    /**
     *
     */
    public Barco() {
        cntTocados=0;
        this.preciorReparacion = GestorFicheros.getMyGestorFicheros().obtenerPrecioReparacion();
        this.escudo = null;
    }

    /**
     *
     * @param pos
     */
    public void reparar(Posicion pos){
        boolean enc=false;
        int i=0;
        while(i<posicion.length && !enc){
            enc= posicion[i].equals(pos);
        }
         posicion[i].reparar();
    }
    /**
     *
     * @param pos
     * @return
     */
    public boolean contiene(Posicion pos){
        boolean enc=false;
        int i=0;
        while(i<posicion.length && !enc){
           enc= posicion[i].equals(pos);
        }
        return enc;
    }


    /**
     *
     * @param pivote
     * @param direccion
     */
    public void inicializar (int[] pivote ,char direccion ) {
        if('H' == direccion){
            int x=pivote[0],i=0;
            while(i<posicion.length){
                posicion[i].setPosicion(pivote);
                x++;
                pivote[0]=x;
                i++;

            }

        }else{
            int y=pivote[1],i=0;
            while(i<posicion.length){
                posicion[i].setPosicion(pivote);
                y++;
                pivote[1]=y;
                i++;

            }
        }
    }


    public int getPrecioReparacion() {
        return this.preciorReparacion;
    }


    /**
     * @param esc
     */
    public void setEscudo(Escudo esc) {
        this.escudo = esc;
    }

    /**
     * @param pArma
     * @param posAtaq
     */
    public void recibirDaños(Arma pArma, int posAtaq) {
        // TODO - implement Modelo.Barco.recibirDaños
        throw new UnsupportedOperationException();
    }

}
