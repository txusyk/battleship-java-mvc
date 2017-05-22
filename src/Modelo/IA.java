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


    public IA() {
        super();
        this.turno = false;
        inicializarDinero();
    }

    /**
     * Inicializa el dinero inicial del jugador en base a la dificultad del juego
     */
    private void inicializarDinero() {
        if (Battleship.getMyBattleship().getDificultad().equalsIgnoreCase("facil")) {
            this.dinero = 15000;
        } else if (Battleship.getMyBattleship().getDificultad().equalsIgnoreCase("medio")) {
            this.dinero = 20000;
        } else if (Battleship.getMyBattleship().getDificultad().equalsIgnoreCase("dificil")) {
            this.dinero = 75000;
        }
    }

    /**
     * Ejecuta todos los pasos relativos al turno de la IA
     */
    public void jugarTurno() {
        decidirSiComprarArma();
        disparar();
        Battleship.getMyBattleship().cambiarJugActivo();
    }

    /**
     * en base a un arbol de decisiones, decide si comprar un arma y de que tipo ha de ser en caso de comprarla (en base a la dif)
     */
    private void decidirSiComprarArma() {
        Random random = new Random();
        if (Battleship.getMyBattleship().getDificultad().equalsIgnoreCase("facil")) {
            if (this.dinero >= 10000) {
                if (random.nextInt(100) <= 30) { //30%
                    if (random.nextInt(100) >= 20) {
                        Almacen.getMiAlmacen().comprarArma("misil"); //80%
                    } else {
                        Almacen.getMiAlmacen().comprarArma("misildirig"); //20%
                    }
                }
            }
        } else if (Battleship.getMyBattleship().getDificultad().equalsIgnoreCase("medio")) {
            if (this.dinero >= 7500) {
                if (random.nextInt(100) >= 50) { //%50
                    if (random.nextInt(100) >= 40) {
                        Almacen.getMiAlmacen().comprarArma("misil"); //60%
                    } else {
                        Almacen.getMiAlmacen().comprarArma("misildirig"); //40%
                    }
                }
            }

        } else if (Battleship.getMyBattleship().getDificultad().equalsIgnoreCase("dificil")) {
            if (this.dinero >= 5000) {
                if (random.nextInt(100) >= 30) { //%70
                    if (random.nextInt(100) >= 80) {
                        Almacen.getMiAlmacen().comprarArma("misil"); //20%
                    } else {
                        Almacen.getMiAlmacen().comprarArma("misildirig"); //80%
                    }
                }
            }
        }
    }

    /**
     * decide el arma que va a utilizar y la dispara
     */
    private void disparar() {
        Random random = new Random();
        if (Battleship.getMyBattleship().getDificultad().equalsIgnoreCase("facil")) {
            if (this.lArmas.getSize("misil") > 0 && this.lArmas.getSize("misildirig") > 0) {
                int index = 1 + random.nextInt(100);
                if (index <= 20) { //20%
                    dispararMisilDirig();
                } else if (index > 20 && index <= 50) { //30%
                    dispararMisil();
                } else { //50%
                    dispararBomba();
                }
            } else if (this.lArmas.getSize("misil") > 0 || this.lArmas.getSize("misildirig") > 0) {
                int index = random.nextInt(100);

                if (this.lArmas.getSize("misil") > 0 && index <= 50) { //50%
                    dispararMisil();
                } else if (this.lArmas.getSize("misildirig") > 0 && (index > 50 && index <= 60)) { //10%
                    dispararMisilDirig();
                } else { //40%
                    dispararBomba();
                }
            } else {
                dispararBomba();
            }
        } else if (Battleship.getMyBattleship().getDificultad().equalsIgnoreCase("medio")) {
            if (this.lArmas.getSize("misil") > 0 && this.lArmas.getSize("misildirig") > 0) {
                int index = 1 + random.nextInt(100);
                if (index <= 30) { //30%
                    dispararMisilDirig();
                } else if (index > 30 && index <= 70) { //40%
                    dispararMisil();
                } else { //30%
                    dispararBomba();
                }
            } else if (this.lArmas.getSize("misil") > 0 || this.lArmas.getSize("misildirig") > 0) {
                int index = random.nextInt(100);

                if (this.lArmas.getSize("misil") > 0 && index <= 50) { //50%
                    dispararMisil();
                } else if (this.lArmas.getSize("misildirig") > 0 && (index > 50 && index <= 75)) { //25%
                    dispararMisilDirig();
                } else { //25%
                    dispararBomba();
                }
            } else {
                dispararBomba();
            }

        } else if (Battleship.getMyBattleship().getDificultad().equalsIgnoreCase("dificil")) {
            if (this.lArmas.getSize("misil") > 0 && this.lArmas.getSize("misildirig") > 0) {
                int index = 1 + random.nextInt(100);
                if (index <= 60) { //60%
                    dispararMisilDirig();
                } else if (index > 60 && index <= 90) { //30%
                    dispararMisil();
                } else { //10%
                    dispararBomba();
                }
            } else if (this.lArmas.getSize("misil") > 0 || this.lArmas.getSize("misildirig") > 0) {
                int index = random.nextInt(100);

                if (this.lArmas.getSize("misil") > 0 && index <= 35) { //35%
                    dispararMisil();
                } else if (this.lArmas.getSize("misildirig") > 0 && (index > 35 && index <= 85)) { //50%
                    dispararMisilDirig();
                } else { //15%
                    dispararBomba();
                }
            } else {
                dispararBomba();
            }
        }
    }

    /**
     * metodo interno para disparar un misil
     */
    private void dispararMisil() {
        int[] posDisparo = generarPosicionAleatoriaTableroHumano();
        ((Arma) this.lArmas.getArma("misil")).disparar(posDisparo[0], posDisparo[1]);
    }

    /**
     * metodo interno para disparar un misilDirig
     */
    private void dispararMisilDirig() {
        int[] posDisparo = generarPosicionAleatoriaTableroHumano();
        ((Arma) this.lArmas.getArma("misildirig")).disparar(posDisparo[0], posDisparo[1]);
    }

    /**
     * metodo interno para disparar una bomba
     */
    private void dispararBomba() {
        int[] posDisparo = generarPosicionAleatoriaTableroHumano();
        ((Arma) this.lArmas.getArma("bomba")).disparar(posDisparo[0], posDisparo[1]);
    }


    /**
     * metodo para inicializar el tablero de la IA
     */
    public void colocarBarcos() {
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                colocarBarcoPorTipo("fragata", 4);
            }
            if (i == 1) {
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

    /**
     * @param pTipoBarco
     * @param cant
     */
    private void colocarBarcoPorTipo(String pTipoBarco, int cant) {
        for (int i = 0; i < cant; i++) {
            Barco b = this.flota.inicializarBarco(pTipoBarco);

            int[] pos = generarPosicionAleatoriaValidaPosBarco();
            char horientacion = generarHorientacionAleatoria();

            b.inicializar(pos[0], pos[1], horientacion);
            while (!this.tablero.colocarBarco(b, pos[0], pos[1])) {
                pos = generarPosicionAleatoriaValidaPosBarco();
                b.inicializar(pos[0], pos[1], horientacion);

            }
        }
    }

    /**
     * genera una tupla valida de colocacion inicial para un barco
     *
     * @return devuelve dicha tupla
     */
    private int[] generarPosicionAleatoriaValidaPosBarco() {
        Random r = new Random();
        int i = r.nextInt(9);
        int j = r.nextInt(9);

        while (this.tablero.esBarco(i, j)) {
            i = r.nextInt(9);
            j = r.nextInt(9);
        }
        int[] arr = new int[2];
        arr[0] = i;
        arr[1] = j;

        return arr;
    }

    /**
     * genera un caracter que sera la horientacion del barco (50% prob de ser vertical o horizontal)
     * @return devuelve dicho caracter
     */
    private char generarHorientacionAleatoria() {
        int direccion = new Random().nextInt(100);

        if (direccion < 50) {
            return 'v';
        } else {
            return 'h';
        }
    }

    /**
     * generar una posicion valida de disparo para el tablero humano (una que no sea ya visible, y si lo es que no este en estado normal)
     * @return dicha posicion de disparo
     */
    private int[] generarPosicionAleatoriaTableroHumano() {
        Random r = new Random();
        int i = r.nextInt(10);
        int j = r.nextInt(10);

        while (ListaJugadores.getMyListaJug().getHumano().tablero.getPosicion(i, j).getVisible()) {
            i = r.nextInt(10);
            j = r.nextInt(10);
        }
        int[] arr = new int[2];
        arr[0] = i;
        arr[1] = j;

        return arr;
    }


}