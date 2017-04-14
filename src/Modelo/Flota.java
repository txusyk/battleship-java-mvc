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

    private Iterator<String> getIterator(){
        return this.flota.keySet().iterator();
    }

    public Barco getBarcoPorPos(int x, int y){
        boolean enc = false;
        Iterator<String> itr = this.getIterator();
        while (itr.hasNext() && !enc){
            String nombreBarco = itr.next();
            if (flota.get(nombreBarco).buscarPorPos(x,y) != null){
                return flota.get(nombreBarco).buscarPorPos(x,y);
            }
        }
        return null;
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
            if (pTipo.equalsIgnoreCase("portaaviones")) {
                for (int i = 0; i < GestorFicheros.getMyGestorFicheros().getNumFrag(); i++) {
                    añadir(new Fragata());
                }
            } else if (pTipo.equalsIgnoreCase("submarino")) {
                for (int i = 0; i < GestorFicheros.getMyGestorFicheros().getNumSub(); i++) {
                    añadir(new Submarino());
                }
            } else if (pTipo.equalsIgnoreCase("destructor")) {
                for (int i = 0; i < GestorFicheros.getMyGestorFicheros().getNumDestr(); i++) {
                    añadir(new Destructor());
                }
            } else if (pTipo.equalsIgnoreCase("fragata")) {
                for (int i = 0; i < GestorFicheros.getMyGestorFicheros().getNumPortaav(); i++) {
                    añadir(new Portaaviones());
                }
            }
        }
    }


}