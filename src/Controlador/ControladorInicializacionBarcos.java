package Controlador;

import Modelo.Barco;
import Modelo.GestorFicheros;
import Modelo.ListaJugadores;
import Modelo.Tablero;
import Vista.VistaInicializacionBarcos;
import Vista.VistaJuego;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by david on 07/05/2017.
 */
public class ControladorInicializacionBarcos {

    VistaJuego v;
    private Tablero modelo;
    private VistaInicializacionBarcos vista;

    public ControladorInicializacionBarcos() {
        this.modelo = new Tablero(10, 10);
        this.vista = new VistaInicializacionBarcos();

        GestorFicheros.getMyGestorFicheros().readXML("facil");
        this.vista.añadirListenersInicializacionBarcos(new ListenersInicializacionBarcos());
    }

    private class ListenersInicializacionBarcos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int x = Integer.parseInt(e.getActionCommand()) / 10;
            int y = Integer.parseInt(e.getActionCommand()) % 10;
            Barco b = ListaJugadores.getMyListaJug().getBarcoAInicializar(vista.getBarcoSelec());
            b.inicializar(x, y, vista.getDirSelec());
            if (vista.getNumBarco(vista.getBarcoSelec()) > 0) {
                if (modelo.colocarBarco(b, x, y)) {
                    vista.reducirBarco(vista.getBarcoSelec());
                    vista.pintar(b.getTamaño(), vista.getDirSelec(), x, y);
                    if ((vista.getNumBarco("fragata") == 0) && (vista.getNumBarco("destructor") == 0) && (vista.getNumBarco("submarino") == 0) && (vista.getNumBarco("portaaviones") == 0)) {
                        vista.eliminarListeners(this);
                        vista.modVisibilidadTableroJug();
                        vista.lanzarPopUp("Has colocado todos los barcos con exito! Ahora comenzara la partida", " ", JOptionPane.OK_OPTION);
                        vista.dispose();
                        new ControladorBattleship(vista.getPanelJuego(), modelo);
                    }
                } else {
                    vista.lanzarPopUp("Error al colocar: " + vista.getBarcoSelec(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                vista.lanzarPopUp("No te quedan barcos del tipo " + vista.getBarcoSelec(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}