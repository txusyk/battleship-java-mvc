package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * @author Josu
 */
public class VistaJuego extends JFrame {

    private JMenuBar barraJuego;
    private JMenu archivo, infoJuego, partida;
    private JMenuItem salir, acercaDe, reglasJuego, cargarPartida, guardarPartida;

    private VistaTablero tableroJug, tableroIA;
    private JTabbedPane tableroInfo;

    private InfoJugador pnInfoJugador;
    private InfoPartida pnInfoJuego;

    /**
     * Creates new form VJ
     */
    public VistaJuego(InfoJugador infoJugador, InfoPartida infoPartida, VistaTablero vistaTablero) {
        this.setLayout(new GridLayout(1, 3));

        tableroJug = vistaTablero;
        tableroIA = new VistaTablero(1);
        tableroInfo = new JTabbedPane();
        pnInfoJugador = infoJugador;
        pnInfoJuego = infoPartida;

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

        URL url = this.getClass().getClassLoader().getResource("pirates_ship.png");
        if (url != null) {
            ImageIcon img = new ImageIcon(url);
            this.setIconImage(img.getImage());
        }

        this.setResizable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        lanzarPopUpInstruccionesJuego();
    }

    /**
     * Añade los listeners al tablero de juego (casillas, propias y enemigas y el boton de compra)
     *
     * @param actionListener
     */
    public void añadirListenersJuego(ActionListener actionListener) {
        this.tableroJug.añadirListenerACasilla(actionListener);
        this.tableroIA.añadirListenerACasilla(actionListener);
        this.pnInfoJugador.añadirListenerCompra(actionListener);

        this.salir.addActionListener(actionListener);
        this.reglasJuego.addActionListener(actionListener);
        this.acercaDe.addActionListener(actionListener);
        this.cargarPartida.addActionListener(actionListener);
        this.guardarPartida.addActionListener(actionListener);

    }

    /**
     *
     * @return un String que indica que arma esta seleccionada en el JRadioButton
     */
    public String getBotonArmaSeleccionada() {
        return this.pnInfoJugador.getSeleccionArma();
    }

    /**
     * Lanza el popUp de la informacion del juego
     */
    public void lanzarPopUpInstruccionesJuego() {
        JOptionPane.showMessageDialog(null,
                "Bienvenido al Battleship IS\n. " +
                        "\n\t- Para disparar, selecciona un arma y clicka sobre la casilla del tablero rival que tengas como objetivo." +
                        "\n\t- Para reparar, selecciona una casilla de tu tablero en estado tocado y haz click sobre ella" +
                        "\n\t- Para colocar un escudo, selecciona el escudo en el menu y clicka sobre el barco de tu elección que no haya sido hundido");
    }

    /**
     * Crea la JMenuBar de la ventana
     */
    private void crearBarraMenu() {
        barraJuego = new JMenuBar();

        archivo = new JMenu("Archivo");
        infoJuego = new JMenu("Inf. de juego");
        partida = new JMenu("Partida");

        salir = new JMenuItem("Salir");
        salir.setActionCommand("salir");
        acercaDe = new JMenuItem("Info. developers");
        acercaDe.setActionCommand("devs");
        reglasJuego = new JMenuItem("Reglas del juego");
        reglasJuego.setActionCommand("reglas");
        cargarPartida = new JMenuItem("Cargar partida");
        cargarPartida.setActionCommand("cargar");
        guardarPartida = new JMenuItem("Guardar partida");
        guardarPartida.setActionCommand("guardar");

        barraJuego.add(archivo);
        barraJuego.add(infoJuego);
        barraJuego.add(partida);
        archivo.add(salir);
        infoJuego.add(reglasJuego);
        infoJuego.add(acercaDe);
        partida.add(cargarPartida);
        partida.add(guardarPartida);
    }

    /**
     * Actualiza el label del @arma indicada
     *
     * @param arma
     */
    public void actualizarContadorArmas(int cantidad, String arma) {
        if (arma.equalsIgnoreCase("misil")) {
            pnInfoJugador.setCantMisil(cantidad);
        } else if (arma.equalsIgnoreCase("misildirig")) {
            pnInfoJugador.setCantMisildirig(cantidad);
        } else if (arma.equalsIgnoreCase("escudo")) {
            pnInfoJugador.setCantEscudo(cantidad);
        } else if (arma.equalsIgnoreCase("misil")) {
            pnInfoJugador.setCantMisil(cantidad);
        } else if (arma.equalsIgnoreCase("radar")){
            pnInfoJugador.setCantRadar(cantidad);
        }
    }

    public int getCantArma() {
        return pnInfoJugador.getCantArmaSelec();
    }

    public void pintarEscudo(int x, int y, String tab) {
        if (tab.equalsIgnoreCase("h")) {
            tableroJug.pintarPosEscudo(x, y);
        } else {
            tableroIA.pintarPosEscudo(x, y);
        }
    }

    public void pintarSinEscudo(int x, int y, String tab) {
        if (tab.equalsIgnoreCase("h")) {
            tableroJug.pintarPosSinEscudo(x, y);
        } else {
            tableroIA.pintarPosSinEscudo(x, y);
        }
    }

    public void pintarPosTocado(int x, int y, String tab) {
        if (tab.equalsIgnoreCase("h")) {
            tableroJug.pintarPosTocado(x, y);
        } else {
            tableroIA.pintarPosTocado(x, y);
        }
    }

    public void pintarPosHundido(int x, int y, String tab) {
        if (tab.equalsIgnoreCase("h")) {
            tableroJug.pintarPosHundido(x, y);
        } else {
            tableroIA.pintarPosHundido(x, y);
        }
    }

    public void pintarPosAgua(int x, int y, String tab) {
        if (tab.equalsIgnoreCase("h")) {
            tableroJug.pintarAgua(x, y);
        } else {
            tableroIA.pintarAgua(x, y);
        }
    }

    public void pintarPosNormal(int x, int y, String tab) {
        if (tab.equalsIgnoreCase("h")) {
            tableroJug.pintarPosNormal(x, y);
        } else {
            tableroIA.pintarPosNormal(x, y);
        }
    }

    public void pintarTocadoHumano(int x, int y) {
        tableroJug.pintarPosTocadoHumano(x, y);
    }

    public void actDinero(int cant) {
        this.pnInfoJugador.actualizarDinero(cant);
    }

    public void salir() {
        System.exit(0);
    }
}