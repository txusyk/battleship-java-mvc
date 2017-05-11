package Modelo;

/**
 * Created by Josu on 14/04/2017.
 */
public class ListaJugadores {

    private static ListaJugadores myListaJug;
    private Jugador[] listaJug;

    private ListaJugadores() {
        listaJug = new Jugador[2];
        listaJug[0] = new Humano();
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

    public Jugador getHumano() {
        return listaJug[0];
    }

    public Jugador getIA() {
        return listaJug[1];
    }

    public Jugador[] getListaJug() {
        return listaJug;
    }

    public Barco getBarcoAInicializar(String pTipoBarco) {
        return this.getHumano().getFlota().inicializarBarco(pTipoBarco);
    }

    public void setTableroJugador(String pJug, Tablero pTablero) {
        if (pJug.equalsIgnoreCase("humano")) {
            ((Humano) this.getHumano()).setTablero(pTablero);
        }
    }


}
