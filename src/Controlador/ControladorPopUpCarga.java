package Controlador;

import Vista.VistaPopUpCargarPartida;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Created by Josu on 09/05/2017.
 */
public class ControladorPopUpCarga {

    private VistaPopUpCargarPartida vista;

    public ControladorPopUpCarga(VistaPopUpCargarPartida vistaPopUpCargarPartida) {
        this.vista = vistaPopUpCargarPartida;
        this.vista.setVisible(true);

        this.vista.añadirListeners(new ListenersCarga());
    }

    private class ListenersCarga implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Objects.equals(e.getActionCommand(), "ok")) {
                vista.dispose();
            } else if (Objects.equals(e.getActionCommand(), "cancelar")) {
                vista.dispose();
            }
        }
    }
}
