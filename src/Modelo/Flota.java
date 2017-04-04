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
        flota.put("fragata", new ListaBarcos("destructor"));
        flota.put("fragata", new ListaBarcos("submarino"));
        flota.put("fragata", new ListaBarcos("portaaviones"));
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

        public Barco buscarPorPos(int[] pos) {
            boolean enc = false;
            Iterator<Barco> itr = this.getIterator();
            Barco b = null;
            while (itr.hasNext() && !enc) {
                b = itr.next();
                if (b.getPosicion()[0] == pos[0] && b.getPosicion()[1] == pos[1]) {
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