package Modelo;

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


public class Tablero {
    private ObjTablero[][] tablero;

    /**
     *
     * @param x
     * @param y
     */
    public Tablero(int x,int y) {
        this.tablero = new ObjTablero[x][y];
        for (int i=0; i<tablero.length; i++){
            for (int j=0; j<tablero.length; j++){
                this.tablero[i][j] = new Agua();
            }
        }
    }

    public void colocarBarco(Barco pBarco, int x, int y){
        if (entraBarco(pBarco, x,y)){

        }
    }

    private boolean entraBarco(Barco pBarco, int x, int y){
        boolean entra = false;
        if (pBarco.getHorientacion() == 'h') {
            for (int i = 0; i < pBarco.getTamaño(); i++) {
                entra = this.tablero[x + i][y] instanceof Agua;
            }
        }else{
            for (int i = 0; i < pBarco.getTamaño(); i++) {
                entra = this.tablero[x][y+i] instanceof Agua;
            }
        }
        return entra;
    }




}