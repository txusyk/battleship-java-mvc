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

public abstract class Barco {

	protected String nombre;
	protected int tamaño;
	protected int[] posicion;
	protected String estadoPosicion;
	protected boolean[] listaDaños;
	protected int preciorReparacion;

	public Barco(String pNombre) {
        this.nombre = pNombre;
        this.posicion = new int[2];
	}

	public String getNombre() { return this.nombre;}

	public int getTamaño() {
		return this.tamaño;
	}

	public String getEstadoPosicion() {
		return this.estadoPosicion;
	}

	public int getPrecio(String pNombre){
        	return this.preciorReparacion;
    	}

	/**
	 * 
	 * @param pArma
	 * @param posAtaq
	 */
	public void recibirDaños(Arma pArma, int posAtaq) {
		// TODO - implement Barco.recibirDaños
		throw new UnsupportedOperationException();
	}

    	/**
     	* @return int
     	*/
    	public int reparar(){
        	return preciorReparacion;
    	}
	
	public boolean estaDañado() {
		boolean flag = false;
		for(boolean b : listaDaños){
			if(!b){
				flag = true;
			}
		}
		return flag;
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
	 * @return boolean[]
	 */
	public boolean[] getListaDaños(){
		return this.listaDaños;
	}

}
