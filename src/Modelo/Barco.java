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

public abstract class Barco extends ObjTablero{

    protected Posicion[] partesBarco;
    private int preciorReparacion;
    protected Escudo escudo;
    private boolean hundido;

    /**
     * Constructora
     */
    public Barco() {
        this.preciorReparacion = GestorFicheros.getMyGestorFicheros().obtenerPrecioReparacion();
        this.escudo = null;
        this.hundido = false;
    }

    /**
     *
     * @param pos
     */
    public void reparar(Posicion pos){
        boolean enc=false;
        int i=0;
        while(i<partesBarco.length && !enc){
            enc= partesBarco[i].comprobarPosicion(pos);
        }
        partesBarco[i].setState(new SNormal());
    }
    /**
     *
     * @param pos
     * @return
     */
    public boolean contiene(Posicion pos){
        boolean enc=false;
        int i=0;
        while(i<partesBarco.length && !enc){
            enc= partesBarco[i].comprobarPosicion(pos);
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
            while(i<partesBarco.length){
                partesBarco[i].setPosicion(pivote);
                x++;
                pivote[0]=x;
                i++;

            }

        }else{
            int y=pivote[1],i=0;
            while(i<partesBarco.length){
                partesBarco[i].setPosicion(pivote);
                y++;
                pivote[1]=y;
                i++;

            }
        }
    }


    /**
     * @return precioReparacion
     */
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
     * @return devuelve si esta hundido el barco
     */
    private boolean estaHundido(){
        boolean sink=false;
        int i =0;
        while(i<partesBarco.length){
            if (partesBarco[i].getEstado() instanceof STocado){
                sink=true;
            }
            i++;
        }
        return sink;
    }


    /**
     * @param pos
     */
    public void hundir(Posicion pos){
        if(escudo!=null){
            escudo.destruir();
            escudo=null;
        }else if (!estaHundido()){
            for(int i =0;i<partesBarco.length;i++){
                partesBarco[i].setState(new STocado());
            }
            hundido=true;
        }
    }

    /**
     * @param pos
     */
    public void recibirDaños(Posicion pos) {
        if(escudo!=null){
            if(escudo.recibirImpacto()){
                escudo=null;
            }
        }else if (!estaHundido()){
            boolean enc=false;
            int i=0;
            while(i<partesBarco.length && !enc){
                if (partesBarco[i].comprobarPosicion(pos)) {
                    enc = true;
                }else{
                    i++;
                }
            }
            if (partesBarco[i].getEstado() instanceof SNormal) {
                partesBarco[i].setState(new STocado());
                if (estaHundido()){
                    hundido = true;
                }
            }else{
                //gestionar cuando se intenta disparar a una posicion ya tocada
            }
        }
    }

}