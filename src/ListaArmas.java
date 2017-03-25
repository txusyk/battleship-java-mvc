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
        ls = new HashMap<>();
        ls.put("bomba",new Stack<>());
        ls.put("misil",new Stack<>());
        ls.put("misildirig",new Stack<>());
        ls.put("radar",new Stack<>());
        ls.put("escudo",new Stack<>());
    }

    /**
     * Inicializa las armas en base a los valores que recibe del configurador
     */
    public void inicializarArmas(){
        while (ls.get("bomba").size() < GestorFicheros.getMyGestorFicheros().getNumBombas()) {
            añadirArma(ArmaFactory.getArmaFactory().crearArma("bomba"));
        }

        while (ls.get("misil").size() < GestorFicheros.getMyGestorFicheros().getNumMisiles()) {
            añadirArma(ArmaFactory.getArmaFactory().crearArma("misil"));
        }

        while (ls.get("misildirig").size() < GestorFicheros.getMyGestorFicheros().getNumMisilesDirig()) {
            añadirArma(ArmaFactory.getArmaFactory().crearArma("misildirig"));
        }

        while (ls.get("radar").size() < GestorFicheros.getMyGestorFicheros().getNumRadares()) {
            añadirArma(ArmaFactory.getArmaFactory().crearArma("radar"));
        }

        while (ls.get("escudo").size() < GestorFicheros.getMyGestorFicheros().getNumEscudos()) {
            añadirArma(ArmaFactory.getArmaFactory().crearArma("escudo"));
        }
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
        if (ls.get(getType(pArma)) != null){
            ls.get(getType(pArma)).push(pArma);
        }else{
            ls.put(getType(pArma),new Stack<>());
            ls.get(getType(pArma)).push(pArma);
        }
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
