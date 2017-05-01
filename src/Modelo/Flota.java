package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Josu on 02/04/2017.
 */
public class Flota {

    private HashMap<String, ListaBarcos> flota;

    public Flota() {
        flota = new HashMap<>();
        flota.put("fragata", new ListaBarcos("fragata"));
        flota.put("destructor", new ListaBarcos("destructor"));
        flota.put("submarino", new ListaBarcos("submarino"));
        flota.put("portaaviones", new ListaBarcos("portaaviones"));
    }

    private Iterator<String> getIterator() {
        return this.flota.keySet().iterator();
    }

    public Barco getBarcoPorPos(int x, int y) {
        boolean enc = false;
        Iterator<String> itr = this.getIterator();
        while (itr.hasNext() && !enc) {
            String nombreBarco = itr.next();
            if (flota.get(nombreBarco).buscarPorPos(x, y) != null) {
                return flota.get(nombreBarco).buscarPorPos(x, y);
            }
        }
        return null;
    }

    public Barco getBarcoPorTipo(String pBarco) {
        Barco b = null;
        if (this.flota.get(pBarco) != null) {
            b = this.flota.get(pBarco).getBarco();
        }
        return b;
    }

    public Barco inicializarBarco(String pBarco) {
        Barco b = null;
        if (this.flota.get(pBarco) != null) {
            b = this.flota.get(pBarco).buscarNoInicializado();
        }
        return b;
    }

    private class ListaBarcos {

        private ArrayList<Barco> lb;

        public ListaBarcos(String pTipo) {
            lb = new ArrayList<>();
            inicializarPorTipo(pTipo);
        }

        private Iterator<Barco> getIterator() {
            return lb.iterator();
        }

        private void añadir(Barco pBarco) {
            lb.add(pBarco);
        }

        private void eliminar(Barco pBarco) {
            lb.remove(pBarco);
        }

        private Barco getBarco() {
            if (!lb.isEmpty()) {
                return lb.get(0);
            }
            return null;
        }

        /**
         * @param x
         * @param y
         * @return
         */
        public Barco buscarPorPos(int x, int y) {
            boolean enc = false;
            Iterator<Barco> itr = this.getIterator();
            Barco b = null;
            while (itr.hasNext() && !enc) {
                b = itr.next();
                if (b.contiene(x, y)) {
                    enc = true;
                }
            }
            return b;
        }

        public Barco buscarNoInicializado() {
            boolean enc = false;
            Iterator<Barco> itr = this.getIterator();
            Barco b = null;
            while (itr.hasNext() && !enc) {
                b = itr.next();
                if (!b.enTablero()) {
                    enc = true;
                }
            }
            return b;
        }

        public void reparar(int x, int y) {
            Iterator<String> it = flota.keySet().iterator();
            boolean enc = false;
            Barco aReparar = null;
            while (it.hasNext() && !enc) {
                aReparar = flota.get(it.next()).buscarPorPos(x, y);
                if (aReparar != null) {
                    enc = true;
                }
            }
            if (enc) {
                aReparar.reparar(x, y);
            }
        }

        /**
         * @param pTipo
         */
        private void inicializarPorTipo(String pTipo) {
            if (pTipo.equalsIgnoreCase("fragata") || pTipo.equalsIgnoreCase("submarino") || pTipo.equalsIgnoreCase("destructor") || pTipo.equalsIgnoreCase("portaaviones")) {
                for (int i = 0; i < GestorFicheros.getMyGestorFicheros().getNumBarco(pTipo); i++) {
                    añadir(BarcoFactory.getBarcoFactory().crearBarco(pTipo));
                }
            }
        }
    }
}