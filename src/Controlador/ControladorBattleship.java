package Controlador;

import Modelo.Battleship;
import Vista.VistaBattleship;

/**
 * Created by Josu on 01/05/2017.
 */
public class ControladorBattleship {

    private Battleship modelo;
    private VistaBattleship vista;

    public ControladorBattleship(Battleship bt, VistaBattleship vistaBattleship) {
        this.modelo = bt;
        this.vista = vistaBattleship;

        //inicializarVentanaLogin
        this.vista.lanzarVistaJuego();


        //muestra un popUp con la info sobre la colocación de barcos
        this.vista.lanzarPopUp("En esta ventana se muestran el numero de barcos" +
                "el nombre y direccion de los mismos. Debes de seleccionar una opción en cada uno de los desplegables" +
                "y debes clickar a continuación en la posicion donde quieres que comience a colocarse el barco. " +
                "\n\t-Los barcos solo se colocan hacia la derecha cuando se selecciona horizontalmente" +
                "\n\t-Los barcos solo se colocaran hacia abajo cuando se seleccione verticalmente");

        //configura y muestra el frame de inicializacion de barcos, añade los listeners necesarios


    }


}
