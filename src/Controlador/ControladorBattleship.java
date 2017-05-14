package Controlador;

import Modelo.*;
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

    public ControladorBattleship(VistaTablero tableroJug, Tablero modeloJugador) {
        Battleship.getMyBattleship().inicializarJuego(modeloJugador);
        vista = new VistaJuego(tableroJug);

        vista.añadirListenersJuego(new ListenerBattleship());
    }

    private class ListenerBattleship implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().split("\\.")[0].equalsIgnoreCase("ia")) {
                int x = Integer.parseInt(e.getActionCommand().split("\\.")[1]) / 10;
                int y = Integer.parseInt(e.getActionCommand().split("\\.")[1]) % 10;
                Barco b = Battleship.getMyBattleship().getJugNoActivo().getFlota().getBarcoPorPos(x, y);
                if (ListaJugadores.getMyListaJug().getHumano().getListaArmas().getArma(vista.getBotonArmaSeleccionada()) == null) {
                   JOptionPane.showMessageDialog(null, "Para usar este arma, antes compra una.");
                }
                else {
                    Arma a = (Arma) ListaJugadores.getMyListaJug().getHumano().getListaArmas().getArma(vista.getBotonArmaSeleccionada());
                    a.disparar(x, y);
                    if (!(a instanceof MisilDirig)) {
                        if (b != null) {
                            vista.pintarPosTocado(x, y);
                            if (b.getHundido()) {
                                for (ParteBarco pB : b.getPartesBarco()) {
                                    vista.pintarPosHundido(pB.getX(), pB.getY());
                                }
                            }
                        } else {
                            vista.pintarPosAgua(x, y);
                        }
                    } else {
                        if (((MisilDirig) a).getDA().getDireccion().equalsIgnoreCase("noreste-suroeste")) {
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
                        } else if (((MisilDirig) a).getDA().getDireccion().equalsIgnoreCase("noroeste-sudeste")) {
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
            } else if (e.getActionCommand().equalsIgnoreCase("comprar")) {
                Battleship.getMyBattleship().getJugActivo().comprarArma(vista.getBotonArmaSeleccionada());
            } else {
                int x = Integer.parseInt(e.getActionCommand()) / 10;
                int y = Integer.parseInt(e.getActionCommand()) % 10;
                Barco b = Battleship.getMyBattleship().getJugActivo().getFlota().getBarcoPorPos(x, y);
                Battleship.getMyBattleship().getJugActivo().getFlota().getBarcoPorPos(x, y).setEscudo();
                for (ParteBarco pB : b.getPartesBarco()) {
                    vista.pintarEscudo(pB.getX(), pB.getY());
                }
            }
        }

        private void pintarDirig(int i, int j) {
            if (ListaJugadores.getMyListaJug().getIA().getTablero().getTablero()[i][j] instanceof Agua || ListaJugadores.getMyListaJug().getIA().getTablero().getTablero()[i][j] instanceof AreaBarco) {
                vista.pintarPosAgua(i, j);
            } else {
                Barco b = ListaJugadores.getMyListaJug().getIA().getFlota().getBarcoPorPos(i, j);
                for (ParteBarco pB : b.getPartesBarco()) {
                    vista.pintarPosHundido(pB.getX(), pB.getY());
                }
            }
        }
    }
}


