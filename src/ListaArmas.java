import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Josu on 19/03/2017.
 */
public class ListaArmas {

    HashMap<String, Stack<Arma>> ls;

    public ListaArmas(String pDif) {
        ls = new HashMap<>(); //inicializamos la lista
        establecerArmasPorDif(pDif);
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

    private void inicializarArmas(int pMisil, int pMisilDirig, int pRadar, int pEscudo) {
        Stack<Arma> s = new Stack<>(); //inicializamos el Stack auxiliar
        for (int i = 0; i < 100; i++) {
            s.push(new Bomba());  //introducimos 25 bombas
        }
        ls.put("bomba", s);

        for (int i = 0; i < 15; i++) {
            s.push(new Misil()); //introducimos 15 misiles
        }
        ls.put("misil", s);

        s = new Stack<>();
        for (int i = 0; i < 8; i++) {
            s.push(new MisilDir()); //introducimos 8 misiles dirigidos
        }
        ls.put("misildirig", s);

        s = new Stack<>();
        for (int i = 0; i < 10; i++) {
            s.push(new Radar()); //introducimos 10 radares
        }
        ls.put("radar", s);

        s = new Stack<>();
        for (int i = 0; i < 10; i++) {
            s.push(new Escudo());  //introducimos 10 escudos
        }
        ls.put("escudo", s);
    }


    private void establecerArmasPorDif(String pDif) {
        int misil = 0, misilDirig = 0, radar = 0, escudo = 0;

        if (pDif.equalsIgnoreCase("facil")) {
            misil = 15;
            misilDirig = 8;
            radar = 10;
            escudo = 10;
        } else if (pDif.equalsIgnoreCase("medio")) {
            misil = 10;
            misilDirig = 6;
            radar = 7;
            escudo = 7;
        } else if (pDif.equalsIgnoreCase("dificil")) {
            misil = 5;
            misilDirig = 2;
            radar = 4;
            escudo = 4;
        }
        inicializarArmas(misil, misilDirig, radar, escudo);
    }

}
