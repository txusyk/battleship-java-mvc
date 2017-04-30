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
package Modelo;

import java.util.Random;

public class Radar extends HerramientasJuego {

    /**
     * posición actual del radar (x,y)
     */
    private int x;
    private int y;

    /**
     * constructora del radar , lo colocará primeramente de forma aleatoria en el mapa
     */
    public Radar() {
        this.precio = GestorFicheros.getMyGestorFicheros().getPrecioArma(getType(this));
        Random randomGenerator = new Random();
        this.x = randomGenerator.nextInt(10);
        this.y = randomGenerator.nextInt(10);
    }

    /**
     * devuelve la posicion x
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * devuelve la posicion y
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *metodo que  colocará el radar y descubrira las posiciones colindantes
     *
     */
    public void accion(int x, int y) {
        colocarRadar(x, y);
        consultarRadar();
    }

    /**
     * colocar la posición del radar
     * @param posX
     * @param posY
     */
    public void colocarRadar(int posX, int posY){
        if (posX<10 && posX>0) {
            x = posX;
        }
        if(posY<10 && posY>0) {
            y = posY;
        }
    }

    /**
     * metodo para revelar las posiciones colindantes al radar
     */
    public void consultarRadar(){
        Battleship.getMyBattleship().getJugNoActivo().getTablero().desvelarAlrededor(x, y);
    }
}