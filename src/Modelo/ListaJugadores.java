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

    /**
     * @return jugador humano
     */
    public Jugador getHumano() {
        return listaJug[0];
    }

    /**
     *
     * @return jugador IA
     */
    public Jugador getIA() {
        return listaJug[1];
    }

    /**
     *
     * @return ListaJugadores
     */
    public Jugador[] getListaJug() {
        return listaJug;
    }

    /**
     * @param pTipoBarco
     * @return
     */
    public Barco getBarcoAInicializar(String pTipoBarco) {
        return this.getHumano().getFlota().inicializarBarco(pTipoBarco);
    }

    /**
     * @param pTablero
     */
    public void setTableroJugadores(Tablero pTablero) {
            ((Humano) this.getHumano()).setTablero(pTablero);
        ((IA) this.getIA()).colocarBarcos();
    }


}
