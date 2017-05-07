package Controlador;

import Modelo.Login;
import Vista.VistaImagenBienvenida;
import Vista.VistaInicializacionBarcos;
import Vista.VistaJuego;
import Vista.VistaLogin;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Josu on 31/03/2017.
 */
public class ControladorBattleship {

    private static ControladorBattleship myControladorBattleship;
    private JMenuBar barraLogin, barraJuego;
    private JMenu archivo, informacion, infoJuego, partida;
    private JMenuItem salir, reiniciar, cambiarDif, acercaLogin, acercaDe, reglasJuego, cargarPartida, guardarPartida;
    private JFrame frame, frameInicio;

    private ControladorBattleship() {
        frame = new JFrame("mainFrame");
        frameInicio = new JFrame();
    }

    public static ControladorBattleship getMyControladorBattleship() {
        if (myControladorBattleship == null) {
            myControladorBattleship = new ControladorBattleship();
        }
        return myControladorBattleship;
    }

    private static void lanzarPopUpInstruccionesJuego() {
        JOptionPane.showMessageDialog(null,
                "Bienvenido al Battleship IS\n. " +
                        "\n\t- Para disparar, selecciona un arma y clicka sobre la casilla del tablero rival que tengas como objetivo." +
                        "\n\t- Para reparar, selecciona una casilla de tu tablero en estado tocado y haz click derecho sobre ella");
    }

    public JFrame getFrame() {
        return frame;
    }

    public void iniciar() {
        lanzarSonido();
        frameInicio.getContentPane().setLayout(null);
        frameInicio.getContentPane().setBackground(Color.WHITE);
        frameInicio.setPreferredSize(new Dimension(900, 615));
        frameInicio.setMinimumSize(new Dimension(900, 615));
        frameInicio.setResizable(false);
        frameInicio.pack();
        centrarVentana(frameInicio);

        VistaImagenBienvenida mainM = new VistaImagenBienvenida(frameInicio);
        mainM.loadTitleScreen();

        frameInicio.dispose();

        new ControladorLogin(new Login(), new VistaLogin());
    }

    private void lanzarSonido() {
        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("drunken.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void centrarVentana(JFrame pFrame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = pFrame.getSize(); //Tamaño del frame actual (ancho x alto)
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        pFrame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }

    public void lanzarVistaJuego() {
        lanzarPopUpInstruccionesJuego();
        frame.setTitle("Battleship");
        frame.setJMenuBar(barraJuego);

        JPanel panel = new VistaJuego();
        frame.setSize(panel.getMinimumSize().width,panel.getMinimumSize().height);
        frame.add(panel);
        frame.pack();
        frame.setResizable(true);


        frame.setVisible(true);
    }



    private void lanzarVistaInicializacionBarcos() {
        frame.setTitle("Inicializacion de barcos");

        JPanel panel = new VistaInicializacionBarcos();
        frame.setSize(panel.getMinimumSize().width, panel.getMinimumSize().height);
        frame.add(panel);
        frame.pack();
        frame.setResizable(true);


        frame.setVisible(true);
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
