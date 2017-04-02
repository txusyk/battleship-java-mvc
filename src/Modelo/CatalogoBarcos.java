package Modelo;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Josu on 23/03/2017.
 */
public class CatalogoBarcos {

    private static CatalogoBarcos myCatalogoBarcos;

    HashMap<String, Stack<Barco>> lsHumano;
    HashMap<String, Stack<Barco>> lsIA;


    private CatalogoBarcos() {
        init();
    }

    public static CatalogoBarcos getMyCatalogoBarcos(){
        if (myCatalogoBarcos == null){
            myCatalogoBarcos = new CatalogoBarcos();
        }
        return myCatalogoBarcos;
    }


    public void init() {
        HashMap<String, Stack<Barco>> ls = new HashMap<>();

        ls.put("portaaviones", new Stack());
        ls.put("destructor", new Stack());
        ls.put("fragata", new Stack());
        ls.put("submarino", new Stack());

        inicializarBarcos(ls);
    }

    public void inicializarBarcos(HashMap<String, Stack<Barco>> ls) {
        for (int i = 0; i < 1; i++) { //inicializamos portaaviones
            ls.get("portaaviones").push(crearBarco("portaaviones"));
        }
        for (int i = 0; i < 2; i++) { //inicializamos los submarinos
            ls.get("submarino").push(crearBarco("submarino"));
        }
        for (int i = 0; i < 3; i++) { //inicializamos los destructores
            ls.get("destructor").push(crearBarco("destructor"));
        }
        for (int i = 0; i < 4; i++) {
            ls.get("fragata").push(crearBarco("fragata"));
        }
        lsIA = ls;
        lsHumano = ls;
    }

    private Barco crearBarco(String pBarco) {
        return BarcoFactory.getBarcoFactory().crearBarco(pBarco);
    }

    public Barco getBarcoIA(String pNombreBarco){
        if (lsIA.get(pNombreBarco) != null){
            return lsIA.get(pNombreBarco).pop();
        }
        return null;
    }

    public Barco getBarcoHumano(String pNombreBarco){
        if (lsHumano.get(pNombreBarco) != null){
            return lsHumano.get(pNombreBarco).pop();
        }
        return null;
    }
}
