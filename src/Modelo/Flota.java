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

    public void reparar(Posicion pos){
        Iterator<String> it=flota.keySet().iterator();
        boolean enc=false;
        Barco aReparar=null;
        while(it.hasNext()&& !enc){
            aReparar=flota.get(it.next()).buscarPorPos(pos);
            if(aReparar!=null){
                enc=true;
            }
        }
        if(enc) {
            aReparar.reparar(pos);
        }
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
         *
         * @param pos
         * @return
         */
        public Barco buscarPorPos(Posicion pos) {
            boolean enc = false;
            Iterator<Barco> itr = this.getIterator();
            Barco b = null;
            while (itr.hasNext() && !enc) {
                b = itr.next();
                if (b.contiene(pos)) {
                    enc = true;
                }
            }
            return b;
        }

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