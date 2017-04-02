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


public class Tablero {

	private Casilla[][] tablero;
	private ListaBarcos flota;
	private int tamañoX;
	private int tamañoY;

	public Tablero(ListaBarcos pListaBarcos, int pMaxX, int pMaxY) {
		this.tamañoX = pMaxX;
		this.tamañoY = pMaxY;
        this.tablero = new Casilla[tamañoX][tamañoY];
        for (int i=0; i<10 ; i++){
            for (int j=0; j<10; j++){
                tablero[i][j] = new Casilla(i, j);
            }
        }
		this.flota = pListaBarcos;
	}

	public Casilla[] getAlrededor(int posX, int posY){       //Nos devuelve las 9 casillas al rededor de una posicion en un Array
        Casilla[] auxL = new Casilla[9];

        auxL[0] = this.tablero[posX-1][posY+1];
        auxL[1] = this.tablero[posX][posY+1];
        auxL[2] = this.tablero[posX+1][posY+1];
        auxL[3] = this.tablero[posX-1][posY];
        auxL[4] = this.tablero[posX][posY];
        auxL[5] = this.tablero[posX+1][posY];
        auxL[6] = this.tablero[posX-1][posY-1];
        auxL[7] = this.tablero[posX][posY-1];
        auxL[8] = this.tablero[posX+1][posY-1];

        for (int i=0; i<3;i++){
            for
        }

        return auxL;
    }

	/**
	 * 
	 * @param pBarco
	 */
	public boolean posicionarBarco(Barco pBarco, int posX, int posY) {
		if (tablero[posX][posY].getEstado() != null){
            if (pBarco.getEstadoPosicion() == "H"){
                int ultPos = posX+pBarco.getTamaño();
                if (ultPos<10){
                    if (posY <10){
                        for (int i=0; i<pBarco.getTamaño(); i++){
                            tablero[posX+i][posY].setState(null);
                        }
                    }
                }
            }
        }
        return false;
	}


}