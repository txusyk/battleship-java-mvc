package Controlador;

import Modelo.Login;
import Vista.VistaBattleship;

/**
 * Created by Josu on 01/05/2017.
 */
public class ControladorBattleship {

    private Login login;
    private VistaBattleship vistaBattleship;

    public ControladorBattleship(Login login, VistaBattleship vistaBattleship) {
        this.login = login;
        this.vistaBattleship = vistaBattleship;

        //inicializarVentanaLogin
        this.vistaBattleship.lanzarVentanaLogin();


        //muestra un popUp con la info sobre la colocación de barcos
        this.vistaBattleship.lanzarPopUp("En esta ventana se muestran el numero de barcos" +
                "el nombre y direccion de los mismos. Debes de seleccionar una opción en cada uno de los desplegables" +
                "y debes clickar a continuación en la posicion donde quieres que comience a colocarse el barco. " +
                "\n\t-Los barcos solo se colocan hacia la derecha cuando se selecciona horizontalmente" +
                "\n\t-Los barcos solo se colocaran hacia abajo cuando se seleccione verticalmente");

        //configura y muestra el frame de inicializacion de barcos, añade los listeners necesarios


    }


}
