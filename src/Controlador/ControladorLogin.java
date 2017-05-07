package Controlador;

import Modelo.Login;
import Vista.VistaInicializacionBarcos;
import Vista.VistaLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * Created by Josu on 05/05/2017.
 */
public class ControladorLogin {

    private JMenuBar barraLogin;
    private JMenu informacion, infoJuego, partida, archivo;
    private JMenuItem salir, reiniciar, cambiarDif, acercaLogin, acercaDe, reglasJuego, cargarPartida, guardarPartida;


    private Login modeloLogin;
    private VistaLogin vista;
    private JFrame frame;

    public ControladorLogin(Login lg, VistaLogin vistaLogin) {
        this.modeloLogin = lg;
        this.vista = vistaLogin;
        frame = ControladorBattleship.getMyControladorBattleship().getFrame();

        lanzarVentanaLogin();

    }

    private void lanzarVentanaLogin() {
        //inicializarVentanaLoginm
        crearBarraMenu();
        frame.setJMenuBar(barraLogin);
        frame.setTitle("Login / Registro de usuarios");
        URL url = this.getClass().getClassLoader().getResource("user-picture.png");
        if (url != null) {
            ImageIcon img = new ImageIcon(url);
            frame.setIconImage(img.getImage());
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 270);

        this.vista.añadirListenersLogin(new ListenersLogin());

        frame.getContentPane().add(vista.getVistaLogin());

        frame.setResizable(false);
        ControladorBattleship.getMyControladorBattleship().centrarVentana(frame);

        frame.setVisible(true);
    }

    private void crearBarraMenu() {
        archivo = new JMenu("Archivo");
        salir = new JMenuItem("Salir");
        archivo.add(salir);

        infoJuego = new JMenu("Inf. de juego");
        reglasJuego = new JMenuItem("Reglas del juego");
        infoJuego.add(reglasJuego);

        informacion = new JMenu("Informacion");
        acercaDe = new JMenuItem("Info. developers");
        acercaLogin = new JMenuItem("Informacion sobre el login");
        informacion.add(acercaLogin);
        informacion.add(acercaDe);

        partida = new JMenu("Partida");
        reiniciar = new JMenuItem("Reiniciar");
        cambiarDif = new JMenuItem("Cambiar dificultad");
        cargarPartida = new JMenuItem("Cargar partida");
        guardarPartida = new JMenuItem("Guardar partida");
        partida.add(cambiarDif);
        partida.add(cargarPartida);
        partida.add(guardarPartida);
        partida.add(reiniciar);


        barraLogin = new JMenuBar();
        barraLogin.add(archivo);
        barraLogin.add(informacion);
        barraLogin.add(infoJuego);
        barraLogin.add(partida);
    }

    private class ListenersLogin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "login") {
                String user = vista.getUserText().getText();
                if (modeloLogin.estaUsuario(user)) {
                    char[] pass = vista.getPasswordText().getPassword();
                    if (modeloLogin.comprobarLogin(user, pass)) {
                        JOptionPane.showMessageDialog(frame, "Login succesfull!");

                        frame.setTitle("Inicializacion de los barcos del jugador " + user);
                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(new VistaInicializacionBarcos());
                        frame.pack();
                        ControladorBattleship.getMyControladorBattleship().centrarVentana(frame);
                    } else {
                        JOptionPane.showMessageDialog(frame, "La contraseña introducida no coincide con la de la base de datos, pruebe de nuevo o cree un nuevo usuario");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "El usuario no existe en la base de datos, pruebe a registrarse primero");
                }
            } else if (e.getActionCommand() == "registro") {
                String user = vista.getUserText().getText();
                if (!modeloLogin.estaUsuario(user)) {
                    char[] pass = vista.getPasswordText().getPassword();
                    modeloLogin.añadirUsuario(user, pass);
                    JOptionPane.showMessageDialog(frame, "Login succesfull!");
                } else {
                    JOptionPane.showMessageDialog(frame, "El usuario ya existe. Pruebe con otro nombre o si usted es el dueño de ese alias, pruebe a loguearse");
                }
            }
        }
    }
}
