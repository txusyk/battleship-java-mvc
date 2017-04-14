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

public class Battleship {

    private static Battleship myBattleship;
    private String dificultad = "facil";

    private Battleship() {

    }

    public static Battleship getMyBattleship() {
        if (myBattleship == null) {
            myBattleship = new Battleship();
        }
        return myBattleship;
    }


    public String getDificultad() {
        return dificultad;
    }


    /**
     * @param pNombre
     */
    public void inicializarJuego(String pNombre) {
        GestorFicheros.getMyGestorFicheros().readXML(Battleship.getMyBattleship().getDificultad());
        Battleship.getMyBattleship().inicializarAlmacen();
    }

    private void inicializarJugadores(String pNombre) {
        ListaJugadores.getMyListaJug().inicializarJugadores(pNombre);
    }

    private void inicializarAlmacen() {
        Almacen.getMiAlmacen();
    }


    private void colocarFlotas() {
        // TODO - implement Battleship.colocarFlotas
        throw new UnsupportedOperationException();
    }

    private void inicializarTableros() {
        // TODO - implement Battleship.inicializarTableros
        throw new UnsupportedOperationException();
    }

    private void jugar() {
        // TODO - implement Battleship.jugar
        throw new UnsupportedOperationException();
    }
}