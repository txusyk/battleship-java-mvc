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
    private int x,y;

    /**
     *
     * @param x
     * @param y
     */
    public Tablero(int x,int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param pPosicion
     */

    public void reparar( Posicion pPosicion){
        //una reparacion hara que :
        //      posicion normal --> posicion normal
        //      posicion tocado --> posicion normal
        //      posicion escudo --> posicion escudo

        if(Battleship.getMyBattleship().turnoAct()){
            flotaHumano.reparar( pPosicion);
        }else{
            flotaOrdenador.reparar( pPosicion);
        }
    }



   /* public Posicion[] getAlrededor(int posX, int posY) {       //Nos devuelve las 9 casillas al rededor de una posicion en un Array
        Posicion[] auxL = new Posicion[9];
        int index = 0;

        for (int i = posX - 1; i <= posX + 1; i++) {
            for (int k = posY - 1; k <= posX - 1; k++) {
                auxL[index] = this.tablero[i][k];
                index++;
            }
        }


        return auxL;
    }
*/
}