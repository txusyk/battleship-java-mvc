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
                    this.tablero[x + i][y] = pBarco.getParteBarco(i);
                }
            } else {
                for (int i = 0; i < pBarco.getTamaño(); i++) {
                    this.tablero[x][y + i] = pBarco.getParteBarco(i);
                }
            }
            pBarco.setEnTablero(true);
            marcarAreaBarco(pBarco, x, y);
            return true;
        } else {
            return false;
        }
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
                if (i + 1 <= 9) {
                    if (!(this.tablero[i + 1][y] instanceof ParteBarco)) {
                        this.tablero[i + 1][y] = new AreaBarco();
                    }
                    if (y - 1 >= 0) {
                        if (!(this.tablero[i + 1][y - 1] instanceof ParteBarco)) {
                            this.tablero[i + 1][y - 1] = new AreaBarco();
                        }
                    }
                    if (y + 1 <= 9) {
                        if (!(this.tablero[i + 1][y + 1] instanceof ParteBarco)) {
                            this.tablero[i + 1][y + 1] = new AreaBarco();
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
            } else if (i == y + pBarco.getTamaño() - 1) { //posicionFin
                if (i + 1 <= 9) {
                    if (!(this.tablero[x][i + 1] instanceof ParteBarco)) {
                        this.tablero[x][i + 1] = new AreaBarco();
                    }
                    if (x - 1 >= 0) {
                        if (!(this.tablero[x - 1][i + 1] instanceof ParteBarco)) {
                            this.tablero[x - 1][i + 1] = new AreaBarco();
                        }
                    }
                    if (x + 1 <= 9) {
                        if (!(this.tablero[x + 1][i + 1] instanceof ParteBarco)) {
                            this.tablero[x + 1][i + 1] = new AreaBarco();
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
        boolean entra = true;
        if (comprobarPorTamaño(pBarco, x, y)) {
            if (pBarco.getHorientacion() == 'h') {
                int i = 0;
                while (i < pBarco.getTamaño() && entra) {
                    entra = tablero[x + i][y] instanceof Agua;
                    i++;
                }
                if (entra) {
                    entra = comprobarPosAlrededor(pBarco, x, y);
                }
            } else if (pBarco.getHorientacion() == 'v') {
                int i = 0;
                while (i < pBarco.getTamaño() && entra) {
                    entra = tablero[x][y + i] instanceof Agua;
                    i++;
                }
                if (entra) {
                    entra = comprobarPosAlrededor(pBarco, x, y);
                }
            }
            return entra;
        }
        return false;
    }

    private boolean comprobarPorTamaño(Barco pBarco, int x, int y) {
        if (pBarco.getHorientacion() == 'h') {
            return ((pBarco.getTamaño() - 1) + x) <= 9;
        } else {
            return ((pBarco.getTamaño() - 1) + y) <= 9;
        }
    }

    /**
     * @param x
     * @param y
     * @param pBarco
     * @return true en caso de que haya espacio de 1 casilla al menos alrededor de un barco horizontal
     */
    private boolean comprobarPosAlrededor(Barco pBarco, int x, int y) {
        int index = 0;
        boolean entra = true;
        while (index < pBarco.getTamaño() && entra) {
            if (index == 0) {
                entra = comprobarPrimeraPos(pBarco.getHorientacion(), x, y) && comprobarPosEstandar(pBarco.getHorientacion(), x, y);
            } else if (index == pBarco.getTamaño() - 1) {
                entra = comprobarUltimaPos(pBarco.getHorientacion(), x, y) && comprobarPosEstandar(pBarco.getHorientacion(), x, y);
            }
            index++;
        }
        return entra;
    }

    /**
     * @param direccion
     * @param x
     * @param y
     * @return true en caso de que las posiciones de alrededor a la  primera posicion no sean barco
     */
    private boolean comprobarPrimeraPos(char direccion, int x, int y) {
        boolean entra = true;
        if (direccion == 'h') {
            if (x > 0) {
                entra = tablero[x - 1][y] instanceof Agua || tablero[x - 1][y] instanceof AreaBarco;
                if (y > 0) {
                    entra = tablero[x - 1][y - 1] instanceof Agua || tablero[x - 1][y - 1] instanceof AreaBarco;
                }
                if (y < 9) {
                    entra = tablero[x - 1][y + 1] instanceof Agua || tablero[x - 1][y + 1] instanceof AreaBarco;
                }
            }
        } else {
            if (y > 0) {
                entra = tablero[x][y - 1] instanceof Agua || tablero[x][y - 1] instanceof AreaBarco;
                if (x > 0) {
                    entra = tablero[x - 1][y - 1] instanceof Agua || tablero[x - 1][y - 1] instanceof AreaBarco;
                }
                if (x < 9) {
                    entra = tablero[x + 1][y - 1] instanceof Agua || tablero[x + 1][y - 1] instanceof AreaBarco;
                }
            }
        }
        return entra;
    }

    /**
     * @param direc
     * @param x
     * @param y
     * @return true en caso de que las posiciones de alrededor a la  ultima posicion no sean barco
     */
    private boolean comprobarUltimaPos(char direc, int x, int y) {
        boolean entra = true;
        if (direc == 'h') {
            if (x < 9) {
                entra = tablero[x + 1][y] instanceof Agua || tablero[x + 1][y] instanceof AreaBarco;
                if (y > 0) {
                    entra = tablero[x + 1][y - 1] instanceof Agua || tablero[x + 1][y - 1] instanceof AreaBarco;
                }
                if (y < 9) {
                    entra = tablero[x + 1][y + 1] instanceof Agua || tablero[x + 1][y + 1] instanceof AreaBarco;
                }
            }
        } else {
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
        return entra;
    }

    /**
     * @param direc
     * @param x
     * @param y
     * @return true en caso de que las posiciones de alrededor a cualquier posicion no sean barco
     */
    private boolean comprobarPosEstandar(char direc, int x, int y) {
        boolean entra = true;
        if (direc == 'h') {
            if (y > 0) {
                entra = tablero[x][y - 1] instanceof Agua || tablero[x][y - 1] instanceof AreaBarco;
            }
            if (y < 9) {
                entra = tablero[x][y + 1] instanceof Agua || tablero[x][y + 1] instanceof AreaBarco;
            }
        } else {
            if (x > 0) {
                entra = tablero[x - 1][y] instanceof Agua || tablero[x - 1][y] instanceof AreaBarco;
            }
            if (x < 9) {
                entra = tablero[x + 1][y] instanceof Agua || tablero[x + 1][y] instanceof AreaBarco;
            }
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

    public void imprimirTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                char icon = ' ';
                if (tablero[j][i].getClass().toString().split("\\.")[1].toLowerCase().charAt(1) == 'g') {
                    icon = tablero[j][i].getClass().toString().split("\\.")[1].toLowerCase().charAt(0);
                } else if (tablero[j][i].getClass().toString().split("\\.")[1].toLowerCase().charAt(0) == 'p') {
                    if (((ParteBarco) tablero[j][i]).informacion()) {
                        icon = ' ';
                    } else {
                        icon = '?';
                    }
                } else if (tablero[j][i].getClass().toString().split("\\.")[1].toLowerCase().charAt(1) == 'r') {
                    icon = '*';
                }

                if (j == 0) {
                    System.out.print("\n" + icon + "\t");
                } else {
                    System.out.print(icon + "\t");
                }
            }
        }
        System.out.println("\n\n\n");
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

    public ObjTablero[][] getTablero() {
        return tablero;
    }
}