package Vista;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Josu
 */
public class VistaJuego extends JFrame {

    private JMenuBar barraJuego;
    private JMenu archivo, infoJuego, partida;
    private JMenuItem salir, reiniciar, cambiarDif, acercaDe, reglasJuego, cargarPartida, guardarPartida;

    private VistaTablero tableroJug, tableroIA;
    private JTabbedPane tableroInfo;

    private JPanel pnInfoJugador, pnInfoJuego;

    /**
     * Creates new form VJ
     */
    public VistaJuego(VistaTablero vistaTablero) {
        this.setLayout(new GridLayout(1, 3));

        tableroJug = vistaTablero;
        tableroIA = new VistaTablero(1);
        tableroInfo = new JTabbedPane();
        pnInfoJugador = new InfoJugador();
        pnInfoJuego = new InfoPartida();

        this.tableroInfo.addTab("Info. juego", this.pnInfoJugador);
        this.tableroInfo.addTab("Info. adic", this.pnInfoJuego);

        this.getContentPane().add(this.tableroJug);
        this.getContentPane().add(this.tableroInfo);
        this.getContentPane().add(this.tableroIA);

        this.setTitle("Battleship");
        crearBarraMenu();
        this.setJMenuBar(this.barraJuego);
        this.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize(); //Tamaño del frame actual (ancho x alto)
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);


        this.setResizable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        lanzarPopUpInstruccionesJuego();

    }

    public void añadirListenersJuego(ActionListener actionListener) {
        this.tableroJug.añadirListenerACasilla(actionListener);
        this.tableroIA.añadirListenerACasilla(actionListener);
    }

    public void lanzarPopUpInstruccionesJuego() {
        JOptionPane.showMessageDialog(null,
                "Bienvenido al Battleship IS\n. " +
                        "\n\t- Para disparar, selecciona un arma y clicka sobre la casilla del tablero rival que tengas como objetivo." +
                        "\n\t- Para reparar, selecciona una casilla de tu tablero en estado tocado y haz click derecho sobre ella");
    }

    private void crearBarraMenu() {
        barraJuego = new JMenuBar();

        archivo = new JMenu("Archivo");
        infoJuego = new JMenu("Inf. de juego");
        partida = new JMenu("Partida");

        salir = new JMenuItem("Salir");
        reiniciar = new JMenuItem("Reiniciar");
        cambiarDif = new JMenuItem("Cambiar dificultad");
        acercaDe = new JMenuItem("Info. developers");
        reglasJuego = new JMenuItem("Reglas del juego");
        cargarPartida = new JMenuItem("Cargar partida");
        guardarPartida = new JMenuItem("Guardar partida");

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
