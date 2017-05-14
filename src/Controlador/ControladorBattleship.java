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
            vista = new VistaJuego(tableroJug, vistaInfoJugador, vistaInfoPartida);
            vista.añadirListenersJuego(new ListenerBattleship());
        });
    }

    /**
     * Inicializa los paneles de información, en base a la dificultad establecida por el jugador
     */
    private void inicializarEtiquetasVista() {
        this.vistaInfoPartida.setPrecioMisil(GestorFicheros.getMyGestorFicheros().getPrecioArma("misil"));
        this.vistaInfoPartida.setPrecioMisilDirig(GestorFicheros.getMyGestorFicheros().getPrecioArma("misildirig"));
        this.vistaInfoPartida.setPrecioRadar(GestorFicheros.getMyGestorFicheros().getPrecioArma("radar"));
        this.vistaInfoPartida.setPrecioEscudo(GestorFicheros.getMyGestorFicheros().getPrecioArma("escudo"));
        this.vistaInfoJugador.setCantDinero(ListaJugadores.getMyListaJug().getHumano().getDinero());
        this.vistaInfoPartida.setCantidadInicialBarcos();
    }

    private class ListenerBattleship implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Battleship.getMyBattleship().getJugActivo() instanceof Humano) { //solo si el humano es el jugador actual
                int x, y;
                if (e.getActionCommand().split("\\.")[0].equalsIgnoreCase("ia")) { //se ha clickado el tablero ia
                    x = Integer.parseInt(e.getActionCommand().split("\\.")[1]) / 10;
                    y = Integer.parseInt(e.getActionCommand().split("\\.")[1]) % 10;

                    if (ListaJugadores.getMyListaJug().consultarArmaHumano(vista.getBotonArmaSeleccionada()) == null) {
                        JOptionPane.showMessageDialog(null, "No tienes armas de este tipo, prueba a comprar una primero");
                    } else {
                        Battleship.getMyBattleship().jugar(vista.getBotonArmaSeleccionada(), x, y);
                    }

                } else if (e.getActionCommand().equalsIgnoreCase("comprar")) { //se ha clickado el boton de compra
                    if (!vista.getBotonArmaSeleccionada().equalsIgnoreCase("bomba")) {
                        if (!Battleship.getMyBattleship().getJugActivo().comprarArma(vista.getBotonArmaSeleccionada())) {
                            JOptionPane.showMessageDialog(null, "No tienes dinero suficiente para comprar este arma");
                        } else {
                            vista.actualizarContadorArmas((ListaJugadores.getMyListaJug().getHumano()).getCantidadHerramientasJuego(vista.getBotonArmaSeleccionada()), vista.getBotonArmaSeleccionada());
                        }
                    }
                } else { //se ha clickado sobre el tablero de juego
                    x = Integer.parseInt(e.getActionCommand()) / 10;
                    y = Integer.parseInt(e.getActionCommand()) % 10;

                    if (ListaJugadores.getMyListaJug().consultarArmaHumano(vista.getBotonArmaSeleccionada()) != null) {
                        if (ListaJugadores.getMyListaJug().consultarArmaHumano(vista.getBotonArmaSeleccionada()) instanceof Escudo) {
                            Battleship.getMyBattleship().jugar(vista.getBotonArmaSeleccionada(), x, y);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Espera a tu turno!!");
            }
        }
    }
}
