package Controlador;

import Modelo.Arma;
import Modelo.Battleship;
import Modelo.ListaJugadores;
import Modelo.Tablero;
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

                if (ListaJugadores.getMyListaJug().getHumano().getListaArmas().getArma(vista.getBotonArmaSeleccionada()) == null) {
                    ListaJugadores.getMyListaJug().getHumano().comprarArma(vista.getBotonArmaSeleccionada());
                    System.out.println("\n\n");
                }
                ((Arma) ListaJugadores.getMyListaJug().getHumano().getListaArmas().getArma(vista.getBotonArmaSeleccionada())).disparar(x, y);
                ListaJugadores.getMyListaJug().getIA().getTablero().imprimirTablero();
            } else {
                JOptionPane.showMessageDialog(null, "no soy ia wey");
            }
        }
    }


}
