package Controlador;

import Modelo.*;
import Vista.InfoJugador;
import Vista.InfoPartida;
import Vista.VistaJuego;
import Vista.VistaTablero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Observer;

/**
 * Created by Josu on 11/05/2017.
 */
public class ControladorBattleship implements Observer, Runnable {

    VistaJuego vista;
    InfoPartida vistaInfoPartida;
    InfoJugador vistaInfoJugador;
    VistaTablero vistaTableroJug;
    int x, y;

    public ControladorBattleship(VistaTablero tableroJug, Tablero modeloJugador) {
        Battleship.getMyBattleship().inicializarJuego(modeloJugador);
        vistaTableroJug = tableroJug;
    }

    @Override
    public void run() {
        vistaInfoPartida = new InfoPartida();
        vistaInfoJugador = new InfoJugador();
        inicializarEtiquetasVista();

        ListaJugadores.getMyListaJug().getIA().getTablero().añadirObservers(this);
        ListaJugadores.getMyListaJug().getHumano().getTablero().añadirObservers(this);

        vista = new VistaJuego(vistaInfoJugador, vistaInfoPartida, vistaTableroJug);
        vista.añadirListenersJuego(new ListenerBattleship());
    }

    /**
     * Inicializa los paneles de información, en base a la dificultad establecida por el jugador
     */
    private void inicializarEtiquetasVista() {
        this.vistaInfoPartida.setPrecioMisil(GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getPrecioArma("misil"));
        this.vistaInfoPartida.setPrecioMisilDirig(GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getPrecioArma("misildirig"));
        this.vistaInfoPartida.setPrecioRadar(GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getPrecioArma("radar"));
        this.vistaInfoPartida.setPrecioEscudo(GestorArchivoInicializacion.getMyGestorArchivoInicializacion().getPrecioArma("escudo"));
        this.vistaInfoJugador.setCantDinero(ListaJugadores.getMyListaJug().getHumano().getDinero());
        this.vistaInfoPartida.setCantidadInicialBarcos();
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        String tableroObjetivo;

        if (Battleship.getMyBattleship().isPartidaActiva()) {
            int x = ((ObjTablero) o).getX();
            int y = ((ObjTablero) o).getY();

            if (Battleship.getMyBattleship().getJugActivo() instanceof Humano) {
                if (vista.getBotonArmaSeleccionada().equalsIgnoreCase("escudo") || vista.getBotonArmaSeleccionada().equalsIgnoreCase("radar")) {
                    tableroObjetivo = "h";
                } else {
                    tableroObjetivo = "ia";
                }

                if (Objects.equals(tableroObjetivo, "ia")) {
                    if (o instanceof Agua || o instanceof AreaBarco) {
                        vista.pintarPosAgua(x, y, tableroObjetivo);
                    } else if (o instanceof ParteBarco) {
                        if (((ParteBarco) o).isBarcoHundido()) {
                            vista.pintarPosHundido(x, y, tableroObjetivo);
                        } else {
                            vista.pintarPosTocado(x, y, tableroObjetivo);
                        }
                    }
                } else {
                    if (!((ParteBarco) o).isBarcoHundido()) {
                        if (vista.getBotonArmaSeleccionada().equalsIgnoreCase("escudo")) {
                            vista.pintarEscudo(x, y, "h");
                        } else {
                            if (!((ParteBarco) o).informacion()) {
                                vista.pintarPosNormal(x, y, tableroObjetivo);
                            }
                        }
                    }
                }
            }
        }
    }


    private class ListenerBattleship implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Battleship.getMyBattleship().isPartidaActiva()) {
                if (Battleship.getMyBattleship().getJugActivo() instanceof Humano) { //solo si el humano es el jugador actual
                    if (e.getActionCommand().split("\\.")[0].equalsIgnoreCase("ia")) { //se ha clickado el tablero ia

                        x = Integer.parseInt(e.getActionCommand().split("\\.")[1]) / 10; //cogemos las coord. de donde ha clickado
                        y = Integer.parseInt(e.getActionCommand().split("\\.")[1]) % 10;

                        Arma a = (Bomba) ArmaFactory.getArmaFactory().crearArma("bomba");
                        a.disparar(x, y);
                        ListaJugadores.getMyListaJug().getIA().getTablero().imprimirTablero();

                    } else { //se ha clickado sobre el tablero del propio jugador

                        x = Integer.parseInt(e.getActionCommand()) / 10; //cogemos las coord. de donde ha clickado
                        y = Integer.parseInt(e.getActionCommand()) % 10;

                        if (Objects.equals(vista.getBotonArmaSeleccionada(), "escudo")) {
                            if (ListaJugadores.getMyListaJug().consultarArmaHumano("escudo") != null) {
                                Object[] opc = {"Si", "No"};
                                int i = JOptionPane.showOptionDialog(null,
                                        "Estas a punto de colocar escudo sobre un barco, estas seguro?", "Si / No",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opc, opc[0]);
                                if (i == JOptionPane.YES_OPTION) {
                                    Battleship.getMyBattleship().jugar("escudo", x, y);
                                    vista.actualizarContadorArmas(ListaJugadores.getMyListaJug().getHumano().getCantidadHerramientasJuego("escudo"), "escudo");
                                }
                            }
                        } else { //reparar barco
                            Object[] opc = {"Si", "No"};
                            int i = JOptionPane.showOptionDialog(null,
                                    "Estas a punto de reparar un barco por " + GestorArchivoInicializacion.getMyGestorArchivoInicializacion().obtenerPrecioReparacion(), "Si / No",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opc, opc[0]);

                            if (i == JOptionPane.YES_OPTION) {
                                if (ListaJugadores.getMyListaJug().getHumano().getDinero() >= GestorArchivoInicializacion.getMyGestorArchivoInicializacion().obtenerPrecioReparacion()) {
                                    if (ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorPos(x, y).reparar(x, y)) {
                                        JOptionPane.showMessageDialog(null, "Reparado correctamente");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Esta parte del barco esta OK, prueba con otra");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "No tienes dinero suficiente para reparar");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
