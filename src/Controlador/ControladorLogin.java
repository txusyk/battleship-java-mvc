package Controlador;

import Modelo.Humano;
import Modelo.ListaJugadores;
import Modelo.Login;
import Modelo.Tablero;
import Vista.VistaInicializacionBarcos;
import Vista.VistaLogin;
import Vista.VistaPopUpCargarPartida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Created by Josu on 05/05/2017.
 */
public class ControladorLogin {

    private Login modeloLogin;
    private VistaLogin vista;

    private String dificultad;

    public ControladorLogin(Login lg, VistaLogin vistaLogin) {
        this.modeloLogin = lg;
        this.vista = vistaLogin;

        this.vista.añadirListenersLogin(new ListenersLogin());
    }

    public void lanzarControladorInicializacionBarcos() {
        ((Humano) ListaJugadores.getMyListaJug().getHumano()).setNombre(vista.getUserText().toString());
        new ControladorInicializacionBarcos(new Tablero(10, 10), new VistaInicializacionBarcos());
    }

    private class ListenersLogin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dificultad = vista.getBotonSeleccionado();

            if (Objects.equals(e.getActionCommand(), "login")) {
                accionLogin();
            } else if (Objects.equals(e.getActionCommand(), "registro")) {
                accionRegistro();
            } else if (Objects.equals(e.getActionCommand(), "salir")) {
                vista.salir();
            } else if (Objects.equals(e.getActionCommand(), "reglas")) {
                vista.lanzarPopUp("Bienvenido al Battleship IS\n. " +
                        "\n\t- Para disparar, selecciona un arma y clicka sobre la casilla del tablero rival que tengas como objetivo." +
                        "\n\t- Para reparar, selecciona una casilla de tu tablero en estado tocado y haz click derecho sobre ella", "Reglas del juego", JOptionPane.PLAIN_MESSAGE);
            } else if (Objects.equals(e.getActionCommand(), "devs")) {
                vista.lanzarPopUp("Josu Álvarez, David Max y Edgar Andres han desarrollado esta aplicacion para la asignatura Ingenieria del Software para la EUITI, UPV/EHU", "Info sobre devs", JOptionPane.PLAIN_MESSAGE);
            } else if (Objects.equals(e.getActionCommand(), "infoLogin")) {
                vista.lanzarPopUp("Este login fue desarrollado con el fin de mantener la seguridad del usuario , y asimismo proveer de un gestor de partidas al juego", "Informacion sobre login/registro", JOptionPane.PLAIN_MESSAGE);
            } else if (Objects.equals(e.getActionCommand(), "cargar")) {
                new ControladorPopUpCarga(new VistaPopUpCargarPartida());
            }
        }

        private void accionLogin() {
            String user = vista.getUserText().getText();
            if (modeloLogin.estaUsuario(user)) {
                char[] pass = vista.getPasswordText().getPassword();
                if (modeloLogin.comprobarLogin(user, pass)) {
                    vista.lanzarPopUp("Login succesfull, " + user + "!", "Succes!", JOptionPane.PLAIN_MESSAGE);
                    lanzarControladorInicializacionBarcos();
                } else {
                    vista.lanzarPopUp("La contraseña introducida no coincide con la de la base de datos, pruebe de nuevo o cree un nuevo usuario", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                vista.lanzarPopUp("El usuario no existe en la base de datos, pruebe a registrarse primero", "Usuario no existe", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void accionRegistro() {
            String user = vista.getUserText().getText();
            if (!modeloLogin.estaUsuario(user)) {
                char[] pass = vista.getPasswordText().getPassword();
                modeloLogin.añadirUsuario(user, pass);
                vista.lanzarPopUp("Login succesfull, " + user + "!", "Succes!", JOptionPane.PLAIN_MESSAGE);
                lanzarControladorInicializacionBarcos();
            } else {
                vista.lanzarPopUp("El usuario ya existe. Pruebe con otro nombre o si usted es el dueño de ese alias, pruebe a loguearse", "Usuario existente", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
