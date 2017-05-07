package Modelo;

/**
 * Created by Josu on 14/04/2017.
 */
public class ListaJugadores {

    private static ListaJugadores myListaJug;
    private Jugador[] listaJug;

    private ListaJugadores() {
        listaJug = new Jugador[2];
        listaJug[0] = new Humano("pepe");
        listaJug[1] = new IA();
    }

    /**
     * @return ListaJugadores
     */
    public static ListaJugadores getMyListaJug() {
        if (myListaJug == null) {
            myListaJug = new ListaJugadores();
        }
        return myListaJug;
    }

    /**
     * @param pNombreHumano
     */
    public void inicializarJugadores(String pNombreHumano) {
        listaJug[0] = new Humano(pNombreHumano);
        listaJug[1] = new IA();
    }

    public Jugador getHumano() {
        return listaJug[0];
    }

    public Jugador getIA() {
        return listaJug[1];
    }

    /**
     * @return jugActivo
     */
    public Jugador getJugNoActivo() {
        if (listaJug[0].isTurno()) {
            return listaJug[1];
        }
        return listaJug[0];
    }

    public void cambiarJugActivo() {
        if (listaJug[0].isTurno()) {
            listaJug[0].setTurno(false);
            listaJug[1].setTurno(true);
        } else {
            listaJug[1].setTurno(false);
            listaJug[0].setTurno(true);
        }
    }


    public Jugador[] getListaJug() {
        return listaJug;
    }
}
