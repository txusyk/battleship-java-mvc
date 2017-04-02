import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Josu on 23/03/2017.
 */
public class ListaBarcos {

    HashMap<String, Stack<Barco>> ls;

    public ListaBarcos(){
        ls = new HashMap<>();
        init();
    }

    public void init(){
        ls.put("portaaviones", new Stack());
        ls.put("destructor", new Stack());
        ls.put("fragata", new Stack());
        ls.put("submarino", new Stack());
        inicializarBarcos();
    }

    public void inicializarBarcos(){
        for (int i = 0; i<1; i++) { //inicializamos portaaviones
            ls.get("portaaviones").push(crearBarco("portaaviones"));
        }
        for (int i=0; i < 2; i++){ //inicializamos los submarinos
            ls.get("submarino").push(crearBarco("submarino"));
        }
        for (int i=0; i<3; i++){ //inicializamos los destructores
            ls.get("destructor").push(crearBarco("destructor"));
        }
        for (int i=0; i<4; i++){
            ls.get("fragata").push(crearBarco("fragata"));
        }
    }

    private Barco crearBarco(String pBarco){
        return BarcoFactory.getBarcoFactory().crearBarco(pBarco);
    }

    public void añadirBarco(Barco pBarco){
        ls.get(getType(pBarco)).push(pBarco);
    }

    public void eliminarBarco(Barco pBarco){
        ls.get(getType(pBarco)).push(pBarco);
    }

    public Barco obtenerBarco(String pTipoBarco){
        return ls.get(pTipoBarco.toLowerCase()).pop();
    }

    private String getType(Barco pBarco) {
        String type = String.valueOf(pBarco.getClass());
        String[] arrAux = type.split(" ");
        type = arrAux[1].toLowerCase();
        return type;
    }
}
