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

public class BarcoFactory {

	private static BarcoFactory miBarcoFactory;

	private BarcoFactory() {}

	public static BarcoFactory getBarcoFactory() {
		if(miBarcoFactory == null){
			miBarcoFactory = new BarcoFactory();
		}
		return miBarcoFactory;
	}

	/**
	 *
	 * return @Barco
	 */
	public Barco crearBarco() {

		System.out.println("Que barco quieres crear? (Portaaviones, Submarino, Destructor o Fragata)");
		String pNombre = Keyboard.getMyKeyboard().getString();
		System.out.println("\t**Vas a crear: "+pNombre);

		Barco b = null;
		if(pNombre.equals("Portaaviones")){
			b = new Portaaviones(pNombre);
		}
		else if(pNombre.equals("Submarino")){
			b = new Submarino(pNombre);
		}
		else if(pNombre.equals("Destructor")){
			b = new Destructor(pNombre);
		}
		else if(pNombre.equals("Fragata")){
			b = new Fragata(pNombre);
		}

		return b;
	}

	public static void main(String[] args){
		System.out.println("Comprobaremos que se crea una fragata: ");
		Barco barco1 = BarcoFactory.getBarcoFactory().crearBarco();
		System.out.println("Se ha creado un barco con: "+barco1.getTamaño()+" posiciones.\n");

		System.out.println("Comprobaremos que se crea un destructor: ");
		Barco barco2 = BarcoFactory.getBarcoFactory().crearBarco();
		System.out.println("Se ha creado un barco con: "+barco2.getTamaño()+" posiciones.\n");

		System.out.println("Comprobaremos que se crea un submarino: ");
		Barco barco3 = BarcoFactory.getBarcoFactory().crearBarco();
		System.out.println("Se ha creado un barco con: "+barco3.getTamaño()+" posiciones.\n");

		System.out.println("Comprobaremos que se crea un portaaviones: ");
		Barco barco4 = BarcoFactory.getBarcoFactory().crearBarco();
		System.out.println("Se ha creado un barco con: "+barco4.getTamaño()+" posiciones.\n");	}

}