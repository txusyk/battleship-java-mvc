package Modelo;

/**
 * Created by david on 14/04/2017.
 */
public class TableroJuego {

    private static TableroJuego miTableroJuego;
    private Tablero tableroJug;
    private Tablero tableroIA;
    private String tableroActivo;

    private TableroJuego(){
        tableroActivo = "jug";
        tableroJug = new Tablero(10,10);
        tableroIA = new Tablero(10,10);
    }

    public static TableroJuego getMiTableroJuego(){
        if(miTableroJuego == null){
            miTableroJuego = new TableroJuego();
        }
        return miTableroJuego;
    }

    public Tablero getTableroActivo(){
        return this.tableroIA;
    }

    public String getNombreTableroActivo(){
        return this.tableroActivo;
    }

}
