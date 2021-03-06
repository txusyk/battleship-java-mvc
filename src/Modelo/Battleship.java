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
    private boolean partidaActiva = false;

    private Battleship() {
        partidaActiva = true;
    }

    public static Battleship getMyBattleship() {
        if (myBattleship == null) {
            myBattleship = new Battleship();
        }
        return myBattleship;
    }


    /**
     * @return dificultad
     */
    public String getDificultad() {
        return dificultad;
    }

    /**
     * @param dificultad
     */
    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    /**
     * @param t
     */
    public void inicializarJuego(Tablero t) {
        ListaJugadores.getMyListaJug().setTableroJugadores(t);
    }

    /**
     * @param pArma
     * @param x
     * @param y
     */
    public void jugar(String pArma, int x, int y) {
        if (this.getJugActivo() instanceof Humano) {
            if (pArma.equalsIgnoreCase("bomba") || pArma.equalsIgnoreCase("misil") || pArma.equalsIgnoreCase("misildirig")) {
                ((Humano) this.getJugActivo()).jugarTurno(pArma, x, y);
                cambiarJugActivo();
                ((IA) this.getJugActivo()).jugarTurno();
            } else {
                ((Humano) this.getJugActivo()).jugarTurno(pArma, x, y);
            }
        }
    }

    /**
     *
     * @return si la partida esta activa (true)
     */
    public boolean isPartidaActiva() {
        return partidaActiva = ListaJugadores.getMyListaJug().getHumano().quedanBarcos() && ListaJugadores.getMyListaJug().getIA().quedanBarcos();
    }

    /**
     *
     * @return nombre del ganador
     */
    public String getGanador() {
        if (!partidaActiva) {
            if (ListaJugadores.getMyListaJug().getHumano().quedanBarcos()) {
                return ListaJugadores.getMyListaJug().getHumano().getNombre();
            } else {
                return "IA";
            }
        } else {
            return null;
        }
    }

    /**
     * @return el jugador no activo (cuyo turno no esta en curso)
     */
    public Jugador getJugNoActivo() {
        if (ListaJugadores.getMyListaJug().getListaJug()[0].isTurno()) {
            return ListaJugadores.getMyListaJug().getListaJug()[1];
        }
        return ListaJugadores.getMyListaJug().getListaJug()[0];
    }

    /**
     * @return el jugador cuyo turno esta actualmente en juego
     */
    public Jugador getJugActivo() {
        if (ListaJugadores.getMyListaJug().getListaJug()[0].isTurno()) {
            return ListaJugadores.getMyListaJug().getListaJug()[0];
        }
        return ListaJugadores.getMyListaJug().getListaJug()[1];
    }

    /**
     * cambia al jugador activo a inactivo y viceversa
     */
    public void cambiarJugActivo() {
        if (ListaJugadores.getMyListaJug().getListaJug()[0].isTurno()) {
            ListaJugadores.getMyListaJug().getListaJug()[0].setTurno(false);
            ListaJugadores.getMyListaJug().getListaJug()[1].setTurno(true);
        } else {
            ListaJugadores.getMyListaJug().getListaJug()[1].setTurno(false);
            ListaJugadores.getMyListaJug().getListaJug()[0].setTurno(true);
        }
    }
}