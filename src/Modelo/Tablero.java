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


import java.util.Observable;

public class Tablero extends Observable {

    private ObjTablero[][] tablero;

    /**
     * @param x
     * @param y
     */
    public Tablero(int x, int y) {
        this.tablero = new ObjTablero[x][y];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                this.tablero[i][j] = new Agua();
            }
        }
    }

    /**
     * @param pBarco
     * @param x
     * @param y
     * @return devuelve si el barco ha sido posicionado
     */
    public boolean colocarBarco(Barco pBarco, int x, int y) {
        if (entraBarco(pBarco, x, y) && (x >= 0 && x <= 9) && (y >= 0 && y <= 9)) {
            if (pBarco.getHorientacion() == 'h') {
                for (int i = 0; i < pBarco.getTamaño(); i++) {
                    pBarco.getParteBarco(i).setPosicion(x + i, y);
                    this.tablero[x + i][y] = pBarco.getParteBarco(i);
                }
            } else {
                for (int i = 0; i < pBarco.getTamaño(); i++) {
                    pBarco.getParteBarco(i).setPosicion(x, y + i);
                    this.tablero[x][y + i] = pBarco.getParteBarco(i);
                }
            }
            marcarAreaBarco(pBarco, x, y);
        } else {
            return false;
        }
        return true;
    }

    /**
     * * Marcara el area de alrededor de un barco . Dicho area sera marcado con casillas AreaBarco
     *
     * @param pBarco
     * @param x
     * @param y
     */
    private void marcarAreaBarco(Barco pBarco, int x, int y) {
        if (pBarco.getHorientacion() == 'h') {
            marcarAreaBarcoHoriz(pBarco, x, y);
        } else if (pBarco.getHorientacion() == 'v') {
            marcarAreaBarcoVert(pBarco, x, y);
        }
    }

    /**
     * * Marcara el area de alrededor de un barco horizontal. Dicho area sera marcado con casillas AreaBarco
     *
     * @param pBarco
     * @param x
     * @param y
     */
    private void marcarAreaBarcoHoriz(Barco pBarco, int x, int y) {
        for (int i = x - 1; i < x + pBarco.getTamaño(); i++) {
            if (i == x - 1) {
                if (x - 1 >= 0) {
                    if (!(this.tablero[x - 1][y] instanceof ParteBarco)) {
                        this.tablero[x - 1][y] = new AreaBarco();
                    }
                    if (y - 1 >= 0) {
                        if (!(this.tablero[x - 1][y - 1] instanceof ParteBarco)) {
                            this.tablero[x - 1][y - 1] = new AreaBarco();
                        }
                    }
                    if (y + 1 <= 9) {
                        if (!(this.tablero[x - 1][y + 1] instanceof ParteBarco)) {
                            this.tablero[x - 1][y + 1] = new AreaBarco();
                        }
                    }
                }
            } else if (i == x + pBarco.getTamaño() - 1) {
                if (x + 1 <= 9) {
                    if (!(this.tablero[x + 1][y] instanceof ParteBarco)) {
                        this.tablero[x + 1][y] = new AreaBarco();
                    }
                    if (y - 1 >= 0) {
                        if (!(this.tablero[x + 1][y - 1] instanceof ParteBarco)) {
                            this.tablero[x + 1][y - 1] = new AreaBarco();
                        }
                    }
                    if (y + 1 <= 9) {
                        if (!(this.tablero[x + 1][y + 1] instanceof ParteBarco)) {
                            this.tablero[x + 1][y + 1] = new AreaBarco();
                        }
                    }
                }
            }
            if (i >= 0 && i <= 9) {
                if (y - 1 >= 0) {

                    if (!(this.tablero[i][y - 1] instanceof ParteBarco)) {
                        this.tablero[i][y - 1] = new AreaBarco();
                    }
                }
                if (y + 1 <= 9) {

                    if (!(this.tablero[i][y + 1] instanceof ParteBarco)) {
                        this.tablero[i][y + 1] = new AreaBarco();
                    }
                }
            }
        }
    }

    /**
     * Marcara el area de alrededor de un barco vertical. Dicho area sera marcado con casillas AreaBarco
     *
     * @param pBarco
     * @param x
     * @param y
     */
    private void marcarAreaBarcoVert(Barco pBarco, int x, int y) {
        for (int i = y - 1; i < y + pBarco.getTamaño(); i++) {
            if (i == y - 1) { //posicionCabeza
                if (y - 1 >= 0) {
                    if (!(this.tablero[x][y - 1] instanceof ParteBarco)) {
                        this.tablero[x][y - 1] = new AreaBarco();
                    }
                    if (x - 1 >= 0) {
                        if (!(this.tablero[x - 1][y - 1] instanceof ParteBarco)) {
                            this.tablero[x - 1][y - 1] = new AreaBarco();
                        }
                    }
                    if (x + 1 <= 9) {
                        if (!(this.tablero[x + 1][y - 1] instanceof ParteBarco)) {
                            this.tablero[x + 1][y - 1] = new AreaBarco();
                        }
                    }
                }
            } else if (i == y + pBarco.getTamaño()) { //posicionFin
                if (y + 1 <= 9) {
                    if (!(this.tablero[x][y + 1] instanceof ParteBarco)) {
                        this.tablero[x][y + 1] = new AreaBarco();
                    }
                    if (x - 1 >= 0) {
                        if (!(this.tablero[x - 1][y + 1] instanceof ParteBarco)) {
                            this.tablero[x - 1][y + 1] = new AreaBarco();
                        }
                    }
                    if (x + 1 <= 9) {
                        if (!(this.tablero[x + 1][y + 1] instanceof ParteBarco)) {
                            this.tablero[x + 1][y + 1] = new AreaBarco();
                        }
                    }
                }
            }
            if (i >= 0 && i <= 9) {
                if (x - 1 >= 0) {
                    if (!(this.tablero[x - 1][i] instanceof ParteBarco)) {
                        this.tablero[x - 1][i] = new AreaBarco();
                    }
                }
                if (x + 1 <= 9) {
                    if (!(this.tablero[x + 1][i] instanceof ParteBarco)) {
                        this.tablero[x + 1][i] = new AreaBarco();
                    }
                }
            }
        }
    }

    /**
     * @param pBarco
     * @param x
     * @param y
     * @return si el barco puede ser posicionado
     */
    private boolean entraBarco(Barco pBarco, int x, int y) {
        boolean entra = false;
        if (pBarco.getHorientacion() == 'h') {
            int i = 0;
            boolean enc = false;
            while (i < pBarco.getTamaño() && !enc) {
                enc = tablero[x + i][y] instanceof Agua;
                i++;
            }
            if (enc) {
                entra = comprobarPosHor(x, y, pBarco);
            }
        } else if (pBarco.getHorientacion() == 'v') {
            int i = 0;
            boolean enc = false;
            while (i < pBarco.getTamaño() && !enc) {
                enc = tablero[x][y + i] instanceof Agua;
                i++;
            }
            if (enc) {
                entra = comprobarPosVer(x, y, pBarco);
            }
        }
        return entra;
    }

    /**
     * @param x
     * @param y
     * @param pBarco
     * @return true en caso de que haya espacio de 1 casilla al menos alrededor de un barco horizontal
     */
    private boolean comprobarPosHor(int x, int y, Barco pBarco) {
        int index = 0;
        boolean entra = true;
        while (index < pBarco.getTamaño() && entra) {
            if (index == 0) {
                if (x > 0) {
                    entra = tablero[x - 1][y] instanceof Agua || tablero[x - 1][y] instanceof AreaBarco;
                    if (y > 0) {
                        entra = tablero[x - 1][y - 1] instanceof Agua || tablero[x - 1][y - 1] instanceof AreaBarco;
                    }
                    if (y < 9) {
                        entra = tablero[x - 1][y + 1] instanceof Agua || tablero[x - 1][y + 1] instanceof AreaBarco;
                    }
                }
            } else if (index == pBarco.getTamaño() - 1) {
                if (x < 9) {
                    entra = tablero[x + 1][y] instanceof Agua || tablero[x + 1][y] instanceof AreaBarco;
                    if (y > 0) {
                        entra = tablero[x + 1][y - 1] instanceof Agua || tablero[x + 1][y - 1] instanceof AreaBarco;
                    }
                    if (y < 9) {
                        entra = tablero[x + 1][y + 1] instanceof Agua || tablero[x + 1][y + 1] instanceof AreaBarco;
                    }
                }

            }
            if (entra) {
                if (y > 0) {
                    entra = tablero[x][y - 1] instanceof Agua || tablero[x][y - 1] instanceof AreaBarco;
                }
                if (y < 9) {
                    entra = tablero[x][y + 1] instanceof Agua || tablero[x][y + 1] instanceof AreaBarco;
                }
            }
            index++;
        }
        return entra;
    }

    /**
     * @param x
     * @param y
     * @param pBarco
     * @return true en caso de que haya espacio de 1 casilla al menos alrededor de un barco vertical
     */
    private boolean comprobarPosVer(int x, int y, Barco pBarco) {
        int index = 0;
        boolean entra = true;
        while (index < pBarco.getTamaño() && entra) {
            if (index == 0) {
                if (y > 0) {
                    entra = tablero[x][y - 1] instanceof Agua || tablero[x][y - 1] instanceof AreaBarco;
                    if (x > 0) {
                        entra = tablero[x - 1][y - 1] instanceof Agua || tablero[x - 1][y - 1] instanceof AreaBarco;
                    }
                    if (x < 9) {
                        entra = tablero[x + 1][y - 1] instanceof Agua || tablero[x + 1][y - 1] instanceof AreaBarco;
                    }
                }
            } else if (index == pBarco.getTamaño() - 1) {
                if (y < 9) {
                    entra = tablero[x][y + 1] instanceof Agua || tablero[x][y + 1] instanceof AreaBarco;
                    if (x > 0) {
                        entra = tablero[x - 1][y + 1] instanceof Agua || tablero[x - 1][y + 1] instanceof AreaBarco;
                    }
                    if (x < 9) {
                        entra = tablero[x + 1][y + 1] instanceof Agua || tablero[x + 1][y + 1] instanceof AreaBarco;
                    }
                }
            }
            if (entra) {
                if (x > 0) {
                    entra = tablero[x - 1][y] instanceof Agua || tablero[x - 1][y] instanceof AreaBarco;
                }
                if (x < 9) {
                    entra = tablero[x + 1][y] instanceof Agua || tablero[x + 1][y] instanceof AreaBarco;
                }
            }
            index++;
        }
        return entra;
    }

    /**
     * @param x
     * @param y
     */
    public void desvelarAlrededor(int x, int y) {      //Metodo usado por el radar para comprobar las posiciones.
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!tablero[i][j].getVisible()) {
                    tablero[i][j].setVisible(true);
                }
            }
        }
    }

    /**
     * @param x
     * @param y
     * @return true en caso de que la posicion sea barco
     */
    public boolean esBarco(int x, int y) {
        return this.tablero[x][y] instanceof ParteBarco;
    }

    /**
     * @param x
     * @param y
     * @return
     */
    public ObjTablero getPosicion(int x, int y) {
        return this.tablero[x][y];
    }

}