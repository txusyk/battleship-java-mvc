package Controlador;

import Modelo.Login;
import Vista.VistaBattleship;
import Vista.VistaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Josu on 05/05/2017.
 */
public class ControladorLogin implements ActionListener {

    private Login login;

    public ControladorLogin() {
        this.login = new Login();

        //inicializarVentanaLogin

        //muestra un popUp con la info sobre la colocación de barcos
        //this.vL.lanzarPopUp("En esta ventana pones tu nombre y xdddd");

        //configura y muestra el frame de inicializacion de barcos, añade los listeners necesarios

    }


    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("login")){
            System.out.println("Logear user");
        }
        else if(e.getActionCommand().equalsIgnoreCase("register")){
            System.out.println("Registrar user");
        }
    }
}
