package Controlador;

import Modelo.Battleship;
import Modelo.GestorArchivoInicializacion;
import Modelo.ListaJugadores;
import Modelo.Login;
import Vista.VistaLogin;
import Vista.VistaPopUpCargarPartida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Created by Josu on 05/05/2017.
 */
public class ControladorLogin implements Runnable {

    private Login modeloLogin;
    private VistaLogin vista;

    @Override
    public void run() {
        this.modeloLogin = new Login();
        vista = new VistaLogin();
        vista.añadirListenersLogin(new ListenersLogin());
    }

    private class ListenersLogin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
                vista.lanzarPopUp("Josu Álvarez y David Max han desarrollado esta aplicacion para la asignatura Ingenieria del Software para la EUITI, UPV/EHU", "Info sobre devs", JOptionPane.PLAIN_MESSAGE);
            } else if (Objects.equals(e.getActionCommand(), "infoLogin")) {
                vista.lanzarPopUp("Este login fue desarrollado con el fin de mantener la seguridad del usuario , y asimismo proveer de un gestor de partidas al juego", "Informacion sobre login/registro", JOptionPane.PLAIN_MESSAGE);
            } else if (Objects.equals(e.getActionCommand(), "cargar")) {
                new ControladorPopUpCarga(new VistaPopUpCargarPartida());
            }
        }

        private void accionLogin() {
            String usuario = vista.getUserText().getText();
            String dificultad = vista.getBotonSeleccionado();

            if (modeloLogin.estaUsuario(usuario)) {
                if (modeloLogin.comprobarLogin(usuario, vista.getPasswordText().getPassword())) {
                    GestorArchivoInicializacion.getMyGestorArchivoInicializacion().readXML(dificultad);
                    Battleship.getMyBattleship().setDificultad(dificultad);
                    ListaJugadores.getMyListaJug().getHumano().setNombre(usuario);
                    vista.lanzarPopUp("Login succesfull, " + usuario + "!", "Success!", JOptionPane.PLAIN_MESSAGE);
                    vista.dispose();
                    new ControladorInicializacionBarcos().run();
                } else {
                    vista.lanzarPopUp("La contraseña introducida no coincide con la de la base de datos, pruebe de nuevo o cree un nuevo usuario", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                vista.lanzarPopUp("El usuario no existe en la base de datos, pruebe a registrarse primero", "Usuario no existe", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void accionRegistro() {
            String usuario = vista.getUserText().getText();
            String dificultad = vista.getBotonSeleccionado();

            if (!modeloLogin.estaUsuario(usuario)) {
                modeloLogin.añadirUsuario(usuario, vista.getPasswordText().getPassword());
                GestorArchivoInicializacion.getMyGestorArchivoInicializacion().readXML(dificultad);
                Battleship.getMyBattleship().setDificultad(dificultad);
                ListaJugadores.getMyListaJug().getHumano().setNombre(usuario);
                vista.lanzarPopUp("Login succesfull, " + usuario + "!", "Success!", JOptionPane.PLAIN_MESSAGE);
                vista.dispose();
                new ControladorInicializacionBarcos().run();
            } else {
                vista.lanzarPopUp("El usuario ya existe. Pruebe con otro nombre o si usted es el dueño de ese alias, pruebe a loguearse", "Usuario existente", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
