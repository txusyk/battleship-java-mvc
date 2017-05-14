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

public class Humano extends Jugador {

    private String nombre;


    public Humano() {
        super();
        this.turno = true;
        this.dinero = GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getDineroInicial();
    }

    /**
     * @return devuelve el nombre del jugador
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void jugarTurno(String pArma, int x, int y) {
        if (this.lArmas.consultarArma(pArma) != null) {
            if (pArma.equalsIgnoreCase("bomba") || pArma.equalsIgnoreCase("misil") || pArma.equalsIgnoreCase("misildirig")) {
                ((Arma) this.lArmas.getArma(pArma)).disparar(x, y);
                if (this.tablero.esBarco(x, y)) {
                    this.dinero += 500;
                }
                Battleship.getMyBattleship().cambiarJugActivo();
            } else if (pArma.equalsIgnoreCase("radar")) {
                ((Radar) lArmas.getArma(pArma)).accion(x, y);
            } else if (pArma.equalsIgnoreCase("escudo")) {
                if (this.tablero.esBarco(x, y)) {
                    this.flota.getBarcoPorPos(x, y).setEscudo();
                }
            }
        }
    }

    /**
     * @param pTablero
     */
    public void setTablero(Tablero pTablero) {
        this.tablero = pTablero;
    }

    public HerramientasJuego getArma(String pArma) {
        return this.lArmas.getArma(pArma);
    }

    /**
     * @param pHerramienta
     * @return el numero de herramientas de ese tipo
     */
    public int getCantidadHerramientasJuego(String pHerramienta) {
        if (this.lArmas.consultarArma(pHerramienta) != null) {
            return this.lArmas.getSize(pHerramienta);
        } else return 0;
    }

}