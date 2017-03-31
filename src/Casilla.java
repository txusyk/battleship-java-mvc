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
import java.awt.*;

public class Casilla extends JPanel {

	private State estado;
	private int row,column;
	private Color casillaColor;
	private boolean rellena;

	public Casilla(int pRow, int pColum, Color pColor, boolean pRelleno, State pEstado) {
		this.row =pRow;
		this.column = pColum;
		this.casillaColor = pColor;
		this.rellena = pRelleno;
		this.estado = pEstado;
	}

	public void setState(State estado) {
		// TODO - implement Casilla.setState
		throw new UnsupportedOperationException();
	}

	/**
	 * @return State
	 */
	public State getEstado(){
	    return this.estado;
    }

	public void accionarCasilla() {
		// TODO - implement Casilla.accionarCasilla
		throw new UnsupportedOperationException();
	}

	/**
	 * @return int[]
	 */
	public int[] getPosicion() {
		return this.posicion;
	}

	public Dimension getPrefferedSize(){
	    return new Dimension(25,25);
    }


    public void pintar(Graphics g){
	    super.paintComponent(g);
	    if(this.estado instanceof Agua){
	        g.setColor(Color.BLACK);
	        g.drawRect(0,0,24,24);
	        g.setColor(Color.GRAY);
	        g.fillRect(1,1,23,23);
        }else if (this.estado instanceof SBarco){
            g.setColor(Color.BLACK);
            g.drawRect(0, 0, 24, 24);
            g.setColor(Color.WHITE);
            g.fillRect(1, 1, 23, 23);
            g.setColor(casillaColor);
            g.fillRect(2, 2, 20, 20);
        }
    }

    public void setCasillaColor(Color pColor) {
        this.casillaColor = pColor;
    }

    public void setRellena(boolean fill) {
        this.rellena = fill;
    }
}