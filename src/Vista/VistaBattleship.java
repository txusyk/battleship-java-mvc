package Vista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Josu on 31/03/2017.
 */
public class VistaBattleship extends JFrame {

    private static VistaBattleship myVb = new VistaBattleship();
    private JMenuBar barraLogin, barraJuego;
    private JMenu archivo, informacion, infoJuego, partida, archivoLogin;
    private JMenuItem salir, reiniciar, cambiarDif, acercaLogin, acercaDe, reglasJuego, cargarPartida, guardarPartida;


    private VistaBattleship() {
        crearBarraMenu();
    }


    public static void main(String args[]) {
        //VistaBattleship.myVb.lanzarVentanaLogin();
        VistaBattleship.myVb.lanzarVistaJuego();
    }

    private static void lanzarPopUpInstruccionesJuego() {
        JOptionPane.showMessageDialog(null,
                "Bienvenido al Battleship IS\n. " +
                        "\n\t- Para disparar, selecciona un arma y clicka sobre la casilla del tablero rival que tengas como objetivo." +
                        "\n\t- Para reparar, selecciona una casilla de tu tablero en estado tocado y haz click derecho sobre ella");
    }

    public void lanzarVentanaLogin() {
        JFrame frame = new JFrame("User's login/registration");
        frame.setJMenuBar(barraLogin);
        frame.setSize(300, 270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new VistaLogin().getVistaLogin();
        frame.add(panel);

        frame.setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize(); //Tamaño del frame actual (ancho x alto)
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

        frame.setVisible(true);
    }

    public void lanzarVistaJuego() {
        lanzarPopUpInstruccionesJuego();
        JFrame frame = new JFrame("Battleship");
        frame.setJMenuBar(barraJuego);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new VistaJuego();
        frame.setSize(panel.getMinimumSize().width,panel.getMinimumSize().height);
        frame.add(panel);
        frame.pack();
        frame.setResizable(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize(); //Tamaño del frame actual (ancho x alto)
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

        frame.setVisible(true);
    }

    private void crearBarraMenu() {
        barraLogin = new JMenuBar();
        barraJuego = new JMenuBar();

        archivo = new JMenu("Archivo");
        archivoLogin = new JMenu("Archivo");
        informacion = new JMenu("Informacion");
        infoJuego = new JMenu("Inf. de juego");
        partida = new JMenu("Partida");

        salir = new JMenuItem("Salir");
        reiniciar = new JMenuItem("Reiniciar");
        cambiarDif = new JMenuItem("Cambiar dificultad");
        acercaLogin = new JMenuItem("Info. pantalla login");
        acercaDe = new JMenuItem("Info. developers");
        reglasJuego = new JMenuItem("Reglas del juego");
        cargarPartida = new JMenuItem("Cargar partida");
        guardarPartida = new JMenuItem("Guardar partida");


        barraLogin.add(archivoLogin);
        barraLogin.add(informacion);
        archivoLogin.add(salir);
        informacion.add(acercaLogin);
        informacion.add(acercaDe);

        barraJuego.add(archivo);
        barraJuego.add(infoJuego);
        barraJuego.add(partida);
        infoJuego.add(reglasJuego);
        infoJuego.add(acercaDe);
        partida.add(cambiarDif);
        partida.add(cargarPartida);
        partida.add(guardarPartida);
        partida.add(reiniciar);
    }


}
