package Controlador;

import Modelo.Login;
import Vista.VistaImagenBienvenida;
import Vista.VistaLogin;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Josu on 31/03/2017.
 */
public class ControladorBienvenida {

    private static ControladorBienvenida myControladorBienvenida;
    Clip clip;
    private JMenuBar barraLogin, barraJuego;
    private JMenu archivo, informacion, infoJuego, partida;
    private JMenuItem salir, reiniciar, cambiarDif, acercaLogin, acercaDe, reglasJuego, cargarPartida, guardarPartida;

    private ControladorBienvenida() {
    }

    public static ControladorBienvenida getMyControladorBienvenida() {
        if (myControladorBienvenida == null) {
            myControladorBienvenida = new ControladorBienvenida();
        }
        return myControladorBienvenida;
    }

    public void iniciar() {
        lanzarSonido("inicio");

        VistaImagenBienvenida mainM = new VistaImagenBienvenida();
        mainM.loadTitleScreen();
        mainM.dispose();

        new ControladorLogin(new Login(), new VistaLogin());
    }

    public void lanzarSonido(String pSonido) {
        URL url;
        if (pSonido.equalsIgnoreCase("inicio")) {
            url = this.getClass().getClassLoader().getResource("mgs.wav");
        } else {
            url = this.getClass().getClassLoader().getResource("drunken.wav");
        }
        try {
            // Open an audio input stream.
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void lanzarVistaJuego() {
        /*lanzarPopUpInstruccionesJuego();
        frame.setTitle("Battleship");
        frame.setJMenuBar(barraJuego);

        JPanel panel = new VistaJuego();
        frame.setSize(panel.getMinimumSize().width,panel.getMinimumSize().height);
        frame.add(panel);
        frame.pack();
        frame.setResizable(true);


        frame.setVisible(true);*/
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
