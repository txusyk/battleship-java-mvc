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

    /**
     * @param pBarco
     * @return null en caso de que no haya barcos sin inicializar, en caso contrario, el barco en si
     */
    public Barco inicializarBarco(String pBarco) {
        if (this.flota.get(pBarco) != null) {
            return this.flota.get(pBarco).buscarNoInicializado();
        }
        return null;
    }

    public Barco getBarcoPorPos(int x, int y) {
        boolean enc = false;
        String nombreBarco = null;
        Iterator<String> itr = this.getIterator();
        while (itr.hasNext() && !enc) {
            nombreBarco = itr.next();
            if (flota.get(nombreBarco).buscarPorPos(x, y) != null) {
                enc = true;
            }
        }
        if (enc) {
            return flota.get(nombreBarco).buscarPorPos(x, y);
        }
        return null;
    }

    public boolean quedanBarcosSinHundir() {
        boolean sinHundir = false;
        String nombreBarco;
        Iterator<String> itr = this.getIterator();
        while (itr.hasNext() && !sinHundir) {
            nombreBarco = itr.next();
            if (flota.get(nombreBarco).quedanBarcosSinHundir()) {
                sinHundir = true;
            }
        }
        return sinHundir;
    }

    private class ListaBarcos {

        private ArrayList<Barco> lb;

        public ListaBarcos(String pTipo) {
            lb = new ArrayList<>();
            inicializarPorTipo(pTipo);
        }

        /**
         * @return un iterador de Barco
         */
        private Iterator<Barco> getIterator() {
            return lb.iterator();
        }

        /**
         * @param pBarco
         */
        private void añadir(Barco pBarco) {
            lb.add(pBarco);
        }

        /**
         * @return devuelve un barco que no haya sido posicionado previamente
         */
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
            if (!enc) {
                b = null;
            }
            return b;
        }

        /**
         * Repara un barco
         *
         * @param x
         * @param y
         */
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
         * @return true en caso de que aun queden barcos sin hundir
         */
        public boolean quedanBarcosSinHundir() {
            boolean flag = false;
            Iterator<Barco> itr = getIterator();
            Barco b;

            while (!flag && itr.hasNext()) {
                b = itr.next();
                if (!b.getHundido()) {
                    flag = true;
                }
            }

            return flag;
        }


        /**
         * @param pTipo
         */
        private void inicializarPorTipo(String pTipo) {
            if (pTipo.equalsIgnoreCase("fragata") || pTipo.equalsIgnoreCase("submarino") || pTipo.equalsIgnoreCase("destructor") || pTipo.equalsIgnoreCase("portaaviones")) {
                for (int i = 0; i < GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getNumBarco(pTipo); i++) {
                    añadir(BarcoFactory.getBarcoFactory().crearBarco(pTipo));
                }
            }
        }


    }
}