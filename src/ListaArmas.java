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
    private void init() {
        ls = new HashMap<>(); //inicializamos la lista

        inicializarArmas();
    }

    public void inicializarArmas(){
        Stack<Arma> s = new Stack<>(); //inicializamos el Stack auxiliar
        int i = 0;
        while (i < GestorFicheros.getMyGestorFicheros().getNumBombas()) {
            s.push(ArmaFactory.getArmaFactory().crearArma("bomba"));  //introducimos  bombas
            i++;
        }
        ls.put("bomba", s);
        i = 0;

        while (i < GestorFicheros.getMyGestorFicheros().getNumMisiles()) {
            s.push(ArmaFactory.getArmaFactory().crearArma("misil"));  //introducimos  misiles
            i++;
        }
        ls.put("misil", s);
        i = 0;
        while (i < GestorFicheros.getMyGestorFicheros().getNumMisilesDirig()) {
            s.push(ArmaFactory.getArmaFactory().crearArma("misildirig"));  //introducimos  misilDirig
            i++;
        }
        ls.put("misildirig", s);
        i = 0;

        while (i < GestorFicheros.getMyGestorFicheros().getNumRadares()) {
            s.push(ArmaFactory.getArmaFactory().crearArma("radar"));  //introducimos  radar
            i++;
        }
        ls.put("radar", s);
        i=0;

        while (i < GestorFicheros.getMyGestorFicheros().getNumEscudos()) {
            s.push(ArmaFactory.getArmaFactory().crearArma("escudo"));  //introducimos  escudo
            i++;
        }
        ls.put("escudo", s);
    }

    public Arma getArma(String pArma){
        return ls.get(pArma).pop();
    }

    public Arma consultarArma(String pArma){ return ls.get(pArma).peek();}

    public int getSize(String pArma){ return ls.get(pArma).size();}

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
