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

public class ArmaFactory {

	private static ArmaFactory miArmaFactory;

	private ArmaFactory() {
	}

	public static ArmaFactory getArmaFactory() {
		if (miArmaFactory == null){
			miArmaFactory = new ArmaFactory();
		}
		return miArmaFactory;
	}

	/**
	 * 
	 * @param pTipoArma
	 */
	public Arma crearArma(String pTipoArma) {
	    Arma a = null;
	    if (pTipoArma.equalsIgnoreCase("bomba")){
	        a = new Bomba(0);
        }else if (pTipoArma.equalsIgnoreCase("misil")){
	        a = new Misil(GestorFicheros.getMyGestorFicheros().getPrecioMisiles());
        }else if (pTipoArma.equalsIgnoreCase("misildirig")){
            a = new MisilDirig(GestorFicheros.getMyGestorFicheros().getPrecioMisilesDirig());
        }else if (pTipoArma.equalsIgnoreCase("radar")){
            a = new Radar(GestorFicheros.getMyGestorFicheros().getPrecioRadares());
        }else if (pTipoArma.equalsIgnoreCase("escudo")){
            a = new Escudo(GestorFicheros.getMyGestorFicheros().getPrecioEscudos());
        }
		return a;
	}

}