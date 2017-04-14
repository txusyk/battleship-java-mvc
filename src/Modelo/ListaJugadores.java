package Modelo;

/**
 * Created by Josu on 14/04/2017.
 */
public class ListaJugadores {

    private static ListaJugadores myListaJug;
    private Jugador[] listaJug;

    private ListaJugadores() {
        listaJug = new Jugador[2];
    }

    /**
     * @return ListaJugadores
     */
    public static ListaJugadores getMyListaJug() {
        if (myListaJug == null) {
            return myListaJug;
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

    /**
     *
     * @return jugActivo
     */
    public Jugador getJugActivo() {
        if (listaJug[0].isTurno()) {
            return listaJug[0];
        }
        return listaJug[1];
    }


}
