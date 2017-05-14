package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Josu
 */
public class VistaJuego extends JFrame {

    private JMenuBar barraJuego;
    private JMenu archivo, infoJuego, partida;
    private JMenuItem salir, reiniciar, cambiarDif, acercaDe, reglasJuego, cargarPartida, guardarPartida;

    private VistaTablero tableroJug, tableroIA;
    private JTabbedPane tableroInfo;

    private InfoJugador pnInfoJugador;
    private InfoPartida pnInfoJuego;

    /**
     * Creates new form VJ
     */
    public VistaJuego(VistaTablero vistaTablero, InfoJugador infoJugador, InfoPartida infoPartida) {
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
            pnInfoJugador.setCantRadar(cantidad);
        }
    }

    public int getCantArma(String arma){
        return pnInfoJugador.getCantArmaSelec();
    }

    public void pintarEscudo(int x, int y){
        tableroJug.pintarPosEscudo(x,y);
    }

    public void pintarPosTocado(int x, int y){
        tableroIA.pintarPosTocado(x,y);
    }

    public void pintarPosHundido(int x, int y){
        tableroIA.pintarPosHundido(x,y);
    }

    public void pintarPosAgua(int x, int y){
        tableroIA.pintarAgua(x, y);
    }

    public void actDinero(int cant){
        pnInfoJugador.actualizarDinero(cant);
    }

    public int getPrecioArmaSelec(){
        return pnInfoJuego.getPrecioArma(getBotonArmaSeleccionada());
    }

}
