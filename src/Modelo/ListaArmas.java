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

import java.util.HashMap;

/**
 * Created by Josu on 19/03/2017.
 */
public class ListaArmas {

    HashMap<String, StackArmas> ls;

    public ListaArmas() {
        ls = new HashMap<>();
        ls.put("bomba", new StackArmas(GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumeroArmas("bomba")));
        for (int i = 0; i < GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumeroArmas("bomba"); i++) {
            ls.get("bomba").push(ArmaFactory.getArmaFactory().crearArma("bomba"));
        }
        ls.put("misil", new StackArmas(GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumeroArmas("misil")));
        ls.put("misildirig", new StackArmas(GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumeroArmas("misildirig")));
        ls.put("radar", new StackArmas(GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumeroArmas("radar")));
        ls.put("escudo", new StackArmas(GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumeroArmas("escudo")));
    }

    /**
     * Inicializa las armas en base a los valores que recibe del configurador (Almacen)
     */
    public void inicializarArmas() {
        for (String s : ls.keySet()) {
            int cantArma = ls.get(s).getMaxSize();
            while (getSize(s) < cantArma) {
                ls.get(s).push(ArmaFactory.getArmaFactory().crearArma(s));
            }
        }

    }

    public HerramientasJuego getArma(String pArma) {
        if (!ls.get(pArma).isEmpty()) {
            return (HerramientasJuego) ls.get(pArma).pop();
        }
        return null;
    }

    public HerramientasJuego consultarArma(String pArma) {
        return (HerramientasJuego) ls.get(pArma).peek();
    }

    public int getSize(String pArma) {
        return ls.get(pArma).size();
    }

    /**
     * @param pHerramientasJuego
     */
    public void añadirArma(HerramientasJuego pHerramientasJuego) {
        if (ls.get(pHerramientasJuego.getType()) != null) {
            ls.get(pHerramientasJuego.getType()).push(pHerramientasJuego);
        }
    }

    /**
     * @param pHerramientasJuego
     */
    public void eliminarArma(String pHerramientasJuego) {
        ls.get(pHerramientasJuego).pop();
    }
}
