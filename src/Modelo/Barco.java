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

public abstract class Barco {

    protected ParteBarco[] partesBarco;
    protected Escudo escudo;
    protected int tamaño;
    private char horientacion;
    private int preciorReparacion;
    private boolean hundido;
    private boolean enTablero;

    /**
     * Constructora
     */
    public Barco() {
        this.preciorReparacion = GestorFicheros.getMyGestorFicheros().obtenerPrecioReparacion();
        this.escudo = null;
        this.hundido = false;
        this.horientacion = 'h';
        this.enTablero = false;
    }

    public boolean enTablero() {
        return enTablero;
    }

    public void setEnTablero(boolean enTablero) {
        this.enTablero = enTablero;
    }

    public boolean getHundido() {
        return hundido;
    }

    public int getTamaño() {
        return this.tamaño;
    }

    public ParteBarco getParteBarco(int i) {
        return this.partesBarco[i];
    }

    public char getHorientacion() {
        return this.horientacion;
    }

    public void setHorientacion(char horientacion) {
        this.horientacion = horientacion;
    }

    /**
     * @param x
     * @param y
     */
    public void reparar(int x, int y) {
        boolean tocado = false;
        int i = 0;
        while (i < partesBarco.length && !tocado) {
            tocado = partesBarco[i].comprobarPosicion(x, y);
        }
        if (tocado) {
            partesBarco[i].setState(new SNormal());
        }
    }

    /**
     * @param x
     * @param y
     * @return comprueba si el barco contiene la posicion
     */
    public boolean contiene(int x, int y) {
        boolean enc = false;
        int i = 0;
        while (i < tamaño && !enc) {
                enc = partesBarco[i].comprobarPosicion(x, y);
            i++;
        }
        return enc;
    }


    /**
     * @param x
     * @param y
     * @param direccion
     */
    public void inicializar(int x, int y, char direccion) {
        this.horientacion = direccion;
        int i = 0;
        if ('h' == direccion) {
            while (i < tamaño) {
                partesBarco[i].setPosicion(x + i, y);
                i++;
            }

        } else {
            while (i < tamaño) {
                partesBarco[i].setPosicion(x, y + i);
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
    private void comprobarSiHundido() {
        int i = 0;
        boolean estaHundido = true;
        while (i < partesBarco.length && estaHundido) {
            if (partesBarco[i].informacion()) {
                estaHundido = false;
            }
            i++;
        }
        hundido = estaHundido;
    }

    /**
     * @param x,y
     */
    public void hundir(int x, int y) {
        boolean hundir = false;
        if (escudo != null) {
            escudo.destruir();
            escudo = null;
        } else if (!getHundido() && escudo == null) {
            for (ParteBarco aPartesBarco : partesBarco) {
                if (aPartesBarco.comprobarPosicion(x, y)) {
                    hundir = true;
                }
            }
            if (hundir) {
                for (ParteBarco pb : partesBarco) {
                    pb.setState(new STocado());
                }
                hundido = true;
            }
        }
    }

    /**
     * @param x
     * @param y
     */
    public void recibirDaños(int x, int y) {
        if (escudo != null) {
            if (escudo.recibirImpacto()) {
                escudo = null;
            }
        } else if (!getHundido() && escudo == null) {
            boolean enc = false;
            int i = 0;
            while (i < partesBarco.length && !enc) {
                if (partesBarco[i] != null) {
                    if (partesBarco[i].comprobarPosicion(x, y)) {
                        enc = true;
                    } else {
                        i++;
                    }
                } else {
                    i++;
                }
            }
            if (enc) {
                if (partesBarco[i].informacion()) {
                    partesBarco[i].setState(new STocado());
                    comprobarSiHundido();
                } else {
                    //gestionar cuando se intenta disparar a una posicion ya tocada
                }
            } else {
                //gestionar si no existe
            }
        }
    }
}