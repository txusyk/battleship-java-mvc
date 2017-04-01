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

public abstract class BarcoEdgar {

	private int tamaño;
	private int ejeX;
	private int ejeY;
	private int direccion;//horizontal=0, vertical=1
	private int preciorReparacion;
	private Escudo escudo ;

	public Barco() {
		direccion=pDir;		preciorReparacion = GestorFicheros.getMyGestorFicheros().obtenerPrecioReparacion();
		escudo=null; //inicialmente no hay escudo
	}

	public void setTamaño(int pTamaño) {

		tamaño=pTamaño;
	}

	public void setEjeX(int pX) {

		ejeX=pX;
	}

	public void setEjeY(int pY) {

		ejeY=pY;
	}
	public void setDireccion(int pDir) {

		 direccion=pDir;
	}

	public int getTamaño() {

		return tamaño;
	}

	public int getEjeX() {

		return ejeX;
	}

	public int getEjeY() {

		return ejeY;
	}


	public void colocaEscudo(Escudo e) {
		escudo=e;//colocamos escudo
	}

	public int getPrecioReparacion(){

		return preciorReparacion;
	}

	/**
	 *
	 * @param pArma
	 * @param posAtaq
	 */
	public void recibirDaños(Arma pArma, Casilla posAtaq) {
		if(escudo!=null){//si  hay escudo..
			escudo.recibirImpacto(pArma);//mitigar daño(recibir golpe)
			if(escudo.getImpactosRestantes()==0){//escudo destruido..
				escudo=null;//quitar escudo
			}
		}else{//si no hay escudo..
			tablero.golpear(pArma,posAtaq,getPosiciones());//modificar tablero (recibir golpe)
			//falta implementar esto............
		}

	}


	public Casilla[] getPosiciones(){
		Casilla[] resultado;
		if(direccion==0) {//si horizontal..
			resultado=rellenarPosiciones(ejeX,ejeY,tamaño) //incrementar el eje X
		}else{//si vertical..
			resultado=rellenarPosiciones(ejeY,ejeX,tamaño) //incrementar el eje Y
		}

		return resultado;
	}


	private Casilla[] rellenarPosiciones(int x , int y , int tamaño){//rellenar posiciones
		int index=0;
		Casilla[] resultado=new Casilla[tamaño];
		while (x<x+tamaño) {//incrementar eje x hasta que coincida con el tamaño
			resultado[index]=new Casilla(x,y);
			x++;
			index++;
		}
		return reultado;
	}

}
