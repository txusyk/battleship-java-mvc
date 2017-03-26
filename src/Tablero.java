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

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Tablero {

	private Casilla[][] casillas;
	private ListaBarcos ls;

	private boolean area[][] = new boolean[10][10];

	public Tablero(ListaBarcos pFlota) {

	}

	public JPanel pintarTablero(){
	    JPanel tablero = new JPanel();
	    tablero.setBorder(new TitledBorder("Battleship"));
        tablero.setLayout(new GridLayout(10,10,0,0));

        reiniciarTablero();

        casillas = new Casilla[10][10];

        for (int row = 0; row < casillas.length; row++){
            for(int colum = 0; colum < casillas[row].length; colum++){
                casillas[row][colum] = new Casilla(row,colum,Color.BLACK,area[row][colum],new Agua());
                tablero.add(casillas[row][colum]);
            }
        }

        return tablero;
    }

    public void repintarTablero(){
	    componentes.clear();
	    reiniciarTablero();
	    reiniciarCasillasTablero();
	    repintarCasillasTablero();
    }

    public void reiniciarTablero(){
        for (int row = 0; row < area.length; row++) {
            for (int column = 0; column < area[row].length; column++) {
                area[row][column] = false;
            }
        }
    }

    public void reiniciarCasillasTablero(){
        for (int row = 0; row < casillas.length; row++) {
            for (int column = 0; column < casillas[row].length; column++) {
                casillas[row][column].setCasillaColor(Color.BLACK);
                casillas[row][column].setRellena(false);
                casillas[row][column].repaint();
            }
        }
    }

    public void repintarCasillasTablero(){
        for (int row = 0; row < casillas.length; row++) {
            for (int column = 0; column < casillas[row].length; column++) {
                casillas[row][column].setRellena(area[row][column]);
                casillas[row][column].repaint();
            }
        }
    }



}