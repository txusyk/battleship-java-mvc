package Controlador;

import Modelo.Tablero;
import Vista.VistaCasilla;
import Vista.VistaTablero;

import java.awt.event.ActionListener;

/**
 * Created by Josu on 01/05/2017.
 */
public class ControladorTablero {

    private Tablero tablero;
    private VistaTablero vistaTablero;
    private ActionListener actionListener;

    public ControladorTablero(Tablero tablero, VistaTablero vistaTablero) {
        this.tablero = tablero;
        this.vistaTablero = vistaTablero;
    }

    public void añadirListener() {
        actionListener = e -> click();
        for (VistaCasilla[] lvC : vistaTablero.getCasillas()) {
            for (VistaCasilla vC : lvC) {
                vC.addActionListener(actionListener);
            }
        }
    }

    private void click() {

    }
}
