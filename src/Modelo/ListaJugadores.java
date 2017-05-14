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
    public Humano getHumano() {
        return (Humano) listaJug[0];
    }

    /**
     *
     * @return jugador IA
     */
    public IA getIA() {
        return (IA) listaJug[1];
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
        this.getHumano().setTablero(pTablero);
        this.getIA().colocarBarcos();
    }

    public HerramientasJuego consultarArmaHumano(String pArma) {
        return this.listaJug[0].getListaArmas().consultarArma(pArma);
    }


}
