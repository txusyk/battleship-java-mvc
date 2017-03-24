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
	private ListaBarcos flota;
	private int dinero = 15000;
	private ListaArmas lArmas;


	public Jugador() {
		this.tablero = new Tablero(new ListaBarcos(),10,10);
		this.tableroAdv = new Tablero(new ListaBarcos(),10,10);
		this.flota = new ListaBarcos();
		this.lArmas = new ListaArmas();
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
	        lArmas.añadirArma(Almacen.getMiAlmacen().comprarArma(pArma));
	        this.decrementarDinero(Almacen.getMiAlmacen().getPrecioArma(pArma));
        }
	}

	/**
	 * 
	 * @param pBarco
	 */
	protected void repararBarco(Barco pBarco) {
		if (this.dinero>=flota.obtenerBarco(getType(pBarco)).preciorReparacion) {
            //flota.repararBarco(pBarco);
        }
	}

	private String getType(Barco pBarco) {
		String type = String.valueOf(pBarco.getClass());
		String[] arrAux = type.split(" ");
		type = arrAux[1].toLowerCase();
		return type;
	}


}