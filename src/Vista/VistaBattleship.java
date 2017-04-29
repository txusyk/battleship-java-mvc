package Vista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Josu on 31/03/2017.
 */
public class VistaBattleship {

    private static VistaBattleship myVb = new VistaBattleship();
    private JMenuBar barraLogin, barraJuego;
    private JMenu archivo, informacion, infoJuego, partida;
    private JMenuItem salir, reiniciar, cambiarDif, acercaLogin, acercaDe, reglasJuego, cargarPartida, guardarPartida;

    private JFrame frame;

    private boolean tableroActivo;


    private VistaBattleship() {
        crearBarraMenu();
    }


    public static void main(String args[]) {
        //VistaBattleship.myVb.lanzarVentanaLogin();
        VistaBattleship.myVb.lanzarVistaImagenBienvenida();
    }

    private static void lanzarPopUpInstruccionesJuego() {
        JOptionPane.showMessageDialog(null,
                "Bienvenido al Battleship IS\n. " +
                        "\n\t- Para disparar, selecciona un arma y clicka sobre la casilla del tablero rival que tengas como objetivo." +
                        "\n\t- Para reparar, selecciona una casilla de tu tablero en estado tocado y haz click derecho sobre ella");
    }

    private void inicializarVentana(String pNombreVentana) {
        frame = new JFrame("User's login/registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void lanzarVentanaLogin() {
        inicializarVentana("Ventana de login/registro");
        frame.setJMenuBar(barraLogin);
        frame.setSize(300, 270);

        JPanel panel = new VistaLogin().getVistaLogin();
        frame.add(panel);

        frame.setResizable(false);

        centrarVentana();

        frame.setVisible(true);
    }

    public void lanzarVistaJuego() {
        lanzarPopUpInstruccionesJuego();
        inicializarVentana("Battleship");
        frame.setJMenuBar(barraJuego);

        JPanel panel = new VistaJuego();
        frame.setSize(panel.getMinimumSize().width,panel.getMinimumSize().height);
        frame.add(panel);
        frame.pack();
        frame.setResizable(true);

        centrarVentana();

        frame.setVisible(true);
    }

    public void lanzarVistaImagenBienvenida() {
        frame = new JFrame();

        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 615));
        frame.setMinimumSize(new Dimension(900, 615));
        frame.setResizable(false);
        frame.pack();

        centrarVentana();

        VistaImagenBienvenida mainM = new VistaImagenBienvenida(frame);
        mainM.loadTitleScreen();


        frame.setLayout(null);
        while (mainM.isImageVisible()) {
        }
        frame.setVisible(false);


        lanzarVistaJuego();
    }

    private void centrarVentana() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize(); //Tamaño del frame actual (ancho x alto)
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }

    private void crearBarraMenu() {
        barraLogin = new JMenuBar();
        barraJuego = new JMenuBar();

        archivo = new JMenu("Archivo");
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


        barraLogin.add(informacion);
        informacion.add(acercaLogin);
        informacion.add(acercaDe);

        barraJuego.add(archivo);
        barraJuego.add(infoJuego);
        barraJuego.add(partida);
        archivo.add(salir);
        infoJuego.add(reglasJuego);
        infoJuego.add(acercaDe);
        partida.add(cambiarDif);
        partida.add(cargarPartida);
        partida.add(guardarPartida);
        partida.add(reiniciar);
    }


}
