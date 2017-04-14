package Modelo;

/**
 * Created by Josu on 14/04/2017.
 */
public class ListaJugadores {

    private static ListaJugadores myListaJug;
    Jugador[] listaJug;

    private ListaJugadores(){
        listaJug = new Jugador[2];
    }

    public void inicializarJugadores(String pNombreHumano){
        listaJug[0] = new Humano(pNombreHumano);
        listaJug[1] = new IA();
    }


}
