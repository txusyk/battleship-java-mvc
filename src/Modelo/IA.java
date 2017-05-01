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

public class IA extends Jugador {

    private String dificultad;


    public IA() {
        super();
        this.dificultad = Battleship.getMyBattleship().getDificultad();
        this.turno = false;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void jugarTurnoIA() {
        // TODO - implement IA.jugarTurnoIA
        throw new UnsupportedOperationException();
    }

    public void colocarBarcosIA() {
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                colocarBarcoPorTipo("fragata", 4);
            } else if (i == 1) {
                colocarBarcoPorTipo("destructor", 3);
            }
            if (i == 2) {
                colocarBarcoPorTipo("submarino", 2);
            }
            if (i == 3) {
                colocarBarcoPorTipo("portaaviones", 1);
            }
        }
    }

    private void colocarBarcoPorTipo(String pTipoBarco, int cant) {
        for (int i = 0; i < cant; i++) {
            Barco b = this.flota.inicializarBarco(pTipoBarco);

            Object[] pos = generarPosicionAleatoriaValida();
            b.setHorientacion((char) pos[2]);
            while (!this.tablero.colocarBarco(b, (int) pos[0], (int) pos[1])) {
                pos = generarPosicionAleatoriaValida();
            }
            b.setEnTablero(true);
        }
    }

    private Object[] generarPosicionAleatoriaValida() {
        Random r = new Random();
        int i = r.nextInt(9);
        int j = r.nextInt(9);
        int direccion = r.nextInt(1);

        while (this.tablero.esBarco(i, j)) {
            i = r.nextInt(9);
            j = r.nextInt(9);
        }
        Object[] arr = new Object[3];
        arr[0] = i;
        arr[1] = j;
        if (direccion == 0) {
            arr[2] = 'v';
        } else {
            arr[2] = 'h';
        }

        return arr;
    }


}