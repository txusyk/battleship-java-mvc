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

public class MisilDirig extends Arma {

    DireccionesArma da;

    public MisilDirig() {
        super();
        this.precio = GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getPrecioArma(this.getType());

        Random r = new Random();
        int i = 1 + r.nextInt(100);

        if (i <= 33) {
            da = DireccionesArma.NESO;
        } else if (i > 33 && i <= 66) {
            da = DireccionesArma.NOSE;
        } else if (i > 66 && i <= 100) {
            da = DireccionesArma.BOOM;
        }
    }

    @Override
    public void disparar(int x, int y) {
        if (da.getDireccion().equalsIgnoreCase("noreste-suroeste")) {
            dispararNESO(x, y);
        } else if (da.getDireccion().equalsIgnoreCase("noroeste-sudeste")) {
            dispararNOSE(x, y);
        } else {
            dispararBOOM(x, y);
        }
    }

    private void dispararNESO(int x, int y) {
        HerramientasJuego m = ArmaFactory.getArmaFactory().crearArma("misil");
        if ((x > 0 && x <= 9) && (y > 0 && y < 9)) {
            int i = x;
            int j = y;
            while (i >= 0 && j >= 0) {
                ((Misil) m).disparar(i, j);
                i--;
                j--;
            }
            i = x;
            j = y;
            while (i < 10 && j < 10) {
                ((Misil) m).disparar(i, j);
                i++;
                j++;
            }
        }
    }

    private void dispararNOSE(int x, int y) {
        HerramientasJuego m = ArmaFactory.getArmaFactory().crearArma("misil");
        if ((x > 0 && x <= 9) && (y > 0 && y < 9)) {
            int i = x;
            int j = y;
            while (i >= 10 && j >= 0) {
                ((Misil) m).disparar(i, j);
                i++;
                j--;
            }
            i = x;
            j = y;
            while (i >= 0 && j < 10) {
                ((Misil) m).disparar(i, j);
                i--;
                j++;
            }
        }
    }

    private void dispararBOOM(int x, int y) {
        HerramientasJuego m = ArmaFactory.getArmaFactory().crearArma("misil");
        if ((x > 0 && x <= 9) && (y > 0 && y < 9)) {
            int i = x;
            int j = y;
            while (i >= 0) {
                ((Misil) m).disparar(i, j);
                i--;
            }
            i = x;
            while (i < 10) {
                ((Misil) m).disparar(i, j);
                i++;
            }
            i = x;
            while (j >= 0) {
                ((Misil) m).disparar(i, j);
                j--;
            }
            j = y;
            while (j < 10) {
                ((Misil) m).disparar(i, j);
                j++;
            }
        }
    }

}