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
package Modelo;

public abstract class Jugador {

    protected boolean turno;
    protected int dinero;
    protected ListaArmas lArmas;
    protected Flota flota;
    protected Tablero tablero;


    public Jugador() {
        this.flota = new Flota();
        this.lArmas = new ListaArmas();
        this.tablero = new Tablero(10,10);
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Flota getFlota(){
        return flota;
    }

    public ListaArmas getListaArmas() {
        return lArmas;
    }

    /**
     * @param pCantidad
     * @return boolean
     */
    protected boolean decrementarDinero(int pCantidad) {
        if (dinero >= pCantidad) {
            dinero -= pCantidad;
            return true;
        }
        return false;
    }

    /**
     * añade el arma deseada a la lista de armas del jugador
     * @param pArma
     */
    public void comprarArma(String pArma) {
        if (this.dinero >= Almacen.getMiAlmacen().getPrecioArma(pArma)) {
            lArmas.añadirArma(Almacen.getMiAlmacen().comprarArma(pArma));
            decrementarDinero(Almacen.getMiAlmacen().getPrecioArma(pArma));
        }
    }

    /**
     * @param pBarco
     */
    /*protected void repararBarco(Barco pBarco) {
		if (this.dinero>=flota.obtenerBarco(getType(pBarco)).preciorReparacion) {
            //flota.repararBarco(pBarco);
        }
	}*/

    private String getType(Barco pBarco) {
        String type = String.valueOf(pBarco.getClass());
        String[] arrAux = type.split("\\.");
        type = arrAux[1].toLowerCase();
        return type;
    }

    public boolean quedanBarcos(){
        return flota.quedanBarcos();
    }

    public abstract void jugarTurno();

}