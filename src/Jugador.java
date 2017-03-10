/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Josu Alvarez / David Max
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import java.util.HashMap;
import java.util.Stack;


public abstract class Jugador {

	private Tablero tablero;
	private Tablero tableroAdv;
	private Flota flota;
	private int dinero = 15000;
	private HashMap<String,Stack<Arma>> lArmas;

	/**
	 * 
	 * @param pFlota
	 * @param pArmas
	 */
	public Jugador(Flota pFlota, HashMap<String,Stack<Arma>> pArmas) {
		this.tablero = new Tablero();
		this.tableroAdv = new Tablero();
		this.flota = pFlota;
		this.lArmas = pArmas;
	}

	/**
	 * 
	 * @param pCantidad
     * @return boolean
	 */
	protected boolean decrementarDinero(int pCantidad) {
		if (dinero > pCantidad){
		    dinero -= pCantidad;
		    return true;
        }
        return false;
	}

	/**
	 * 
	 * @param pArma
	 */
	protected void comprarArma(String pArma) {
	    if (this.dinero>=Almacen.getMiAlmacen().getPrecioArma(pArma)){
	        lArmas.get(pArma).add(Almacen.getMiAlmacen().comprarArma(pArma));
        }
	}

	/**
	 * 
	 * @param pBarco
	 */
	protected void repararBarco(Barco pBarco) {
		flota.repararBarco(pBarco);
	}


}