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

import java.util.HashMap;
import java.util.Stack;

public class Flota {

	private HashMap<String, Stack<Barco>> listaBarcos = new HashMap<>();

	/**
	 * 
	 * @param pAviones
	 * @param pSub1
	 * @param pSub2
	 * @param pDestr1
	 * @param pDestr2
	 * @param pDestr3
	 * @param pFrag1
	 * @param pFrag2
	 * @param pFrag3
	 * @param pFrag4
	 */
	public Flota(Barco pAviones, Barco pSub1, Barco pSub2, Barco pDestr1, Barco pDestr2, Barco pDestr3, Barco pFrag1, Barco pFrag2, Barco pFrag3, Barco pFrag4) {
		Stack s = new Stack();
		s.add(pAviones);
		this.listaBarcos.put("portaaviones",s);
        s = new Stack();
		s.add(pSub1);
		s.add(pSub2);
		this.listaBarcos.put("submarino",s);
        s = new Stack();
		s.add(pDestr1);
		s.add(pDestr2);
		s.add(pDestr3);
		this.listaBarcos.put("destructor",s);
        s = new Stack();
		s.add(pFrag1);
		s.add(pFrag2);
		s.add(pFrag3);
		s.add(pFrag4);
		this.listaBarcos.put("fragata",s);
	}

	/**
	 * 
	 * @param pBarco
	 */
	public void añadirBarco(Barco pBarco) {
	    if (this.listaBarcos.get(pBarco.getNombre()) != null){
	        this.listaBarcos.get(pBarco.getNombre()).add(pBarco);
        }else{
	        Stack s = new Stack();
	        s.add(pBarco);
	        this.listaBarcos.put(pBarco.getNombre(),s);
        }
	}

	/**
	 * 
	 * @param pBarco
	 */
	public Barco eliminarBarco(Barco pBarco) {
        if (this.listaBarcos.get(pBarco.getNombre()) != null) {
            return this.listaBarcos.get(pBarco.getNombre()).pop();
        }
        return null;
	}

	/**
	 * 
	 * @param pBarco
	 */
	public Barco buscarBarco(Barco pBarco) {
		if (this.listaBarcos.get(pBarco.getNombre())!= null){
		    return this.listaBarcos.get(pBarco.getNombre()).peek();
        }
        return null;
	}

    /**
     *
     * @param pBarco
     */
    public boolean repararBarco(Barco pBarco){
        if (pBarco.estaDañado()) {
            pBarco.reparar();
            return true;
        }
        return false;
    }

}