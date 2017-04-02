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

	protected int tamaño;

	protected int[] posicion;
	protected char direccion;

	protected int preciorReparacion;
	protected Escudo escudo;

	public Barco() {
		this.preciorReparacion = GestorFicheros.getMyGestorFicheros().obtenerPrecioReparacion();
		this.posicion = new int[2];
		this.escudo = null;
	}

    /**
     * @param x
     * @param y
     */
	public void setPosicion(int x, int y){
	    this.posicion[0] = x;
	    this.posicion[1] = y;
    }

    /**
     * @return direccion
     */
	public char getDireccion() {
		return this.direccion;
	}

	public int getPrecioReparacion(){
		return this.preciorReparacion;
	}

    /**
     *
     * @return int[]
     */
    public int[] getPosicion(){
        return posicion;
    }

    /**
     *
     * @param esc
     */
    public void setEscudo(Escudo esc){
	    this.escudo = esc;
    }

	/**
	 *
	 * @param pArma
	 * @param posAtaq
	 */
	public void recibirDaños(Arma pArma, int posAtaq) {
		// TODO - implement Modelo.Barco.recibirDaños
		throw new UnsupportedOperationException();
	}

}
