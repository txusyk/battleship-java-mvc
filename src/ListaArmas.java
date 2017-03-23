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

/**
 * Created by Josu on 19/03/2017.
 */
public class ListaArmas {

    HashMap<String, Stack<Arma>> ls;

    public ListaArmas() {
        init();
    }

    /**
     * Inicializa los Stack<Arma>
     */
    private void init(){
        ls = new HashMap<>(); //inicializamos la lista
        ls.put("bomba", new Stack<>());
        ls.put("misil", new Stack<>());
        ls.put("misildirig", new Stack<>());
        ls.put("radar", new Stack<>());
        ls.put("escudo", new Stack<>());
    }

    /**
     * @param pNombre
     * @param pCantidad
     * @param pPrecio
     */
    public void inicializarArma(String pNombre, int pCantidad, int pPrecio) {
        Stack<Arma> s = new Stack<>(); //inicializamos el Stack auxiliar
        int i = 0;
        if (pNombre == "bomba") {
            while (i<pCantidad) {
                s.push(new Bomba(pPrecio));  //introducimos pCantidad bombas
                i++;
            }
            ls.put("bomba", s);
        }else if(pNombre == "misil") {
            while (i<pCantidad) {
                s.push(new Misil(pPrecio));  //introducimos pCantidad misiles
                i++;
            }
            ls.put("misil", s);
        }else if (pNombre == "misildirig") {
            while (i<pCantidad) {
                s.push(new MisilDir(pPrecio));  //introducimos pCantidad misilDirig
                i++;
            }
            ls.put("misildirig", s);
        }else if (pNombre == "radar") {
            while (i<pCantidad) {
                s.push(new Radar(pPrecio));  //introducimos pCantidad radar
                i++;
            }
            ls.put("radar", s);
        }else if(pNombre == "escudo") {
            while (i<pCantidad) {
                s.push(new Escudo(pPrecio));  //introducimos pCantidad escudo
                i++;
            }
            ls.put("escudo", s);
        }
    }

    /**
     * @param pArma
     * @return Stack<arma>
     */
    public Stack<Arma> get(String pArma) {
        return this.ls.get(pArma);
    }

    /**
     * @param pArma
     */
    public void añadirArma(Arma pArma) {
        ls.get(getType(pArma)).push(pArma);
    }

    /**
     * @param pArma
     */
    public void eliminarArma(Arma pArma) {
        ls.get(getType(pArma)).pop();
    }

    /**
     * @param pArma
     * @return String
     */
    private String getType(Arma pArma) {
        String type = String.valueOf(pArma.getClass());
        String[] arrAux = type.split(" ");
        type = arrAux[1].toLowerCase();
        return type;
    }

}
