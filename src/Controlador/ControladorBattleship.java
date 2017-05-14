package Controlador;

import Modelo.*;
import Vista.InfoJugador;
import Vista.InfoPartida;
import Vista.VistaJuego;
import Vista.VistaTablero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Josu on 11/05/2017.
 */
public class ControladorBattleship {

    VistaJuego vista;
    InfoPartida vistaInfoPartida;
    InfoJugador vistaInfoJugador;

    public ControladorBattleship(VistaTablero tableroJug, Tablero modeloJugador) {
        Battleship.getMyBattleship().inicializarJuego(modeloJugador);

        SwingUtilities.invokeLater(() -> {
            vistaInfoPartida = new InfoPartida();
            vistaInfoJugador = new InfoJugador();
            inicializarEtiquetasVista();
            vista = new VistaJuego(vistaInfoJugador, vistaInfoPartida, tableroJug);
            vista.añadirListenersJuego(new ListenerBattleship());
        });
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

    private class ListenerBattleship implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Battleship.getMyBattleship().isPartidaActiva()) {
                if (Battleship.getMyBattleship().getJugActivo() instanceof Humano) { //solo si el humano es el jugador actual
                    int x, y;
                    if (e.getActionCommand().split("\\.")[0].equalsIgnoreCase("ia")) { //se ha clickado el tablero ia
                        x = Integer.parseInt(e.getActionCommand().split("\\.")[1]) / 10;
                        y = Integer.parseInt(e.getActionCommand().split("\\.")[1]) % 10;

                        if (ListaJugadores.getMyListaJug().consultarArmaHumano(vista.getBotonArmaSeleccionada()) == null) {
                            JOptionPane.showMessageDialog(null, "No tienes armas de este tipo, prueba a comprar una primero");
                        } else {
                            Battleship.getMyBattleship().jugar(vista.getBotonArmaSeleccionada(), x, y);
                            vista.actualizarContadorArmas(vista.getCantArma() - 1, vista.getBotonArmaSeleccionada());
                            if (!(vista.getBotonArmaSeleccionada().equalsIgnoreCase("misildirig"))) {
                                if (ListaJugadores.getMyListaJug().getIA().getTablero().esBarco(x, y)) {
                                    vista.pintarPosTocado(x, y);
                                    if (ListaJugadores.getMyListaJug().getIA().getFlota().getBarcoPorPos(x, y).getHundido()) {
                                        Barco b = ListaJugadores.getMyListaJug().getIA().getFlota().getBarcoPorPos(x, y);
                                        for (int i = 0; i < b.getTamaño(); i++) {
                                            vista.pintarPosHundido(b.getParteBarco(i).getX(), b.getParteBarco(i).getY());
                                        }
                                    }
                                } else {
                                    vista.pintarPosAgua(x, y);
                                }
                            } else {
                                MisilDirig a = (MisilDirig) ListaJugadores.getMyListaJug().getHumano().getListaArmas().consultarArma(vista.getBotonArmaSeleccionada());
                                if (a.getDA().getDireccion().equalsIgnoreCase("noreste-suroeste")) {
                                    int i = x;
                                    int j = y;
                                    while (i >= 0 && j >= 0) {
                                        pintarDirig(i, j);
                                        i--;
                                        j--;
                                    }
                                    i = x;
                                    j = y;
                                    while (i < 10 && j < 10) {
                                        pintarDirig(i, j);
                                        i++;
                                        j++;
                                    }
                                } else if (a.getDA().getDireccion().equalsIgnoreCase("noroeste-sudeste")) {
                                    int i = x;
                                    int j = y;
                                    while (i < 10 && j >= 0) {
                                        pintarDirig(i, j);
                                        i++;
                                        j--;
                                    }
                                    i = x;
                                    j = y;
                                    while (i >= 0 && j < 10) {
                                        pintarDirig(i, j);
                                        i--;
                                        j++;
                                    }
                                } else {
                                    int i = x;
                                    int j = y;
                                    while (i >= 0) {
                                        pintarDirig(i, j);
                                        i--;
                                    }
                                    i = x;
                                    while (i < 10) {
                                        pintarDirig(i, j);
                                        i++;
                                    }
                                    i = x;
                                    while (j >= 0) {
                                        pintarDirig(i, j);
                                        j--;
                                    }
                                    j = y;
                                    while (j < 10) {
                                        pintarDirig(i, j);
                                        j++;
                                    }
                                }
                            }
                        }
                    } else if (e.getActionCommand().equalsIgnoreCase("comprar")) { //se ha clickado el boton de compra
                        if (!vista.getBotonArmaSeleccionada().equalsIgnoreCase("bomba")) {
                            if (!Battleship.getMyBattleship().getJugActivo().comprarArma(vista.getBotonArmaSeleccionada())) {
                                JOptionPane.showMessageDialog(null, "No tienes dinero suficiente para comprar este arma");
                            } else {
                                ListaJugadores.getMyListaJug().getHumano().comprarArma(vista.getBotonArmaSeleccionada());
                                vista.actualizarContadorArmas(vista.getCantArma() + 1, vista.getBotonArmaSeleccionada());
                                vista.actDinero(ListaJugadores.getMyListaJug().getHumano().getDinero());
                            }
                        }
                    } else { //se ha clickado sobre el tablero de juego
                        x = Integer.parseInt(e.getActionCommand()) / 10;
                        y = Integer.parseInt(e.getActionCommand()) % 10;

                        if (ListaJugadores.getMyListaJug().consultarArmaHumano(vista.getBotonArmaSeleccionada()) != null) {
                            if (ListaJugadores.getMyListaJug().consultarArmaHumano(vista.getBotonArmaSeleccionada()) instanceof Escudo) {
                                ((Humano) Battleship.getMyBattleship().getJugActivo()).jugarTurno(vista.getBotonArmaSeleccionada(), x, y);
                                Battleship.getMyBattleship().getJugActivo().getFlota().getBarcoPorPos(x, y).setEscudo();
                                Barco b = ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorPos(x, y);
                                for (int i = 0; i < b.getTamaño(); i++) {
                                    vista.pintarEscudo(b.getParteBarco(i).getX(), b.getParteBarco(i).getY());
                                }
                                vista.actualizarContadorArmas(vistaInfoJugador.getCantArmaSelec() - 1, vista.getBotonArmaSeleccionada());
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Espera a tu turno!!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fin de partida!!" + "Has ganado" + Battleship.getMyBattleship().getGanador() + "!!");
            }
        }

        private void pintarDirig(int i, int j) {
            if (ListaJugadores.getMyListaJug().getIA().getTablero().getTablero()[i][j] instanceof Agua || ListaJugadores.getMyListaJug().getIA().getTablero().getTablero()[i][j] instanceof AreaBarco) {
                vista.pintarPosAgua(i, j);
            } else {
                Barco b = ListaJugadores.getMyListaJug().getIA().getFlota().getBarcoPorPos(i, j);
                for (int x = 0; x < b.getTamaño(); x++) {
                    vista.pintarPosHundido(b.getParteBarco(x).getX(), b.getParteBarco(x).getY());
                }
            }
        }
    }
}
