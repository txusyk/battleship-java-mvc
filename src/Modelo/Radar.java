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

public class Radar extends Arma {

	private int x;
	private int y;
	private int numUsos = 3;

	public Radar(int pPrecio) {
		super(pPrecio);
		Random randomGenerator = new Random();
		this.x = randomGenerator.nextInt(10);
		this.y = randomGenerator.nextInt(10);
	}

	/**
	 * 
	 * @param posX, posY
	 */
	public void setPosicion(int posX, int posY) {
		x = posX;
		y = posY;
	}


	@Override
	public void accion() {
		System.out.println("Donde quieres colocar el radar?");
		System.out.println("\tIntroduce coordenada X: ");
		int posXRadar = Keyboard.getMyKeyboard().getInt();
		System.out.println("\tIntroduce coordenada Y:");
		int posYRadar = Keyboard.getMyKeyboard().getInt();

		Casilla[] posiciones = Battleship.getMyBattleship().colocarRadar(posXRadar, posYRadar);
		for(Casilla c : posiciones){
			c.desubrirCasilla();
		}
	}

}