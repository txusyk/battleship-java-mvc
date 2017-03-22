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

    private void init(){
        ls = new HashMap<>(); //inicializamos la lista
        ls.put("bomba", new Stack<>());
        ls.put("misil", new Stack<>());
        ls.put("misildirig", new Stack<>());
        ls.put("radar", new Stack<>());
        ls.put("escudo", new Stack<>());
    }

    public void inicializarArma(String pNombre, int pCantidad) {
        Stack<Arma> s = new Stack<>(); //inicializamos el Stack auxiliar
        int i = 0;
        if (pNombre == "bomba") {
            while (i<pCantidad) {
                s.push(new Bomba());  //introducimos 25 bombas
            }
            ls.put("bomba", s);
        }else if(pNombre == "misil") {
            while (i<pCantidad) {
                s.push(new Misil());  //introducimos 25 bombas
            }
            ls.put("misil", s);
        }else if (pNombre == "misildirig") {
            while (i<pCantidad) {
                s.push(new MisilDir());  //introducimos 25 bombas
            }
            ls.put("misildirig", s);
        }else if (pNombre == "radar") {
            while (i<pCantidad) {
                s.push(new Radar());  //introducimos 25 bombas
            }
            ls.put("radar", s);
        }else if(pNombre == "escudo") {
            while (i<pCantidad) {
                s.push(new Escudo());  //introducimos 25 bombas
            }
            ls.put("escudo", s);
        }
    }

    public Stack<Arma> get(String pArma) {
        return this.ls.get(pArma);
    }

    public void añadirArma(Arma pArma) {
        ls.get(getType(pArma)).push(pArma);
    }

    public void eliminarArma(Arma pArma) {
        ls.get(getType(pArma)).pop();
    }

    private String getType(Arma pArma) {
        String type = String.valueOf(pArma.getClass());
        String[] arrAux = type.split(" ");
        type = arrAux[1].toLowerCase();
        return type;
    }

}
