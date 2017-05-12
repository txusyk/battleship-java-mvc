package Controlador;

import Vista.VistaJuego;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Josu on 11/05/2017.
 */
public class ControladorBattleship {

    VistaJuego vista;

    public ControladorBattleship(VistaJuego vistaJuego) {
        vista = vistaJuego;

        vista.añadirListenersJuego(new ListenerBattleship());
    }

    private class ListenerBattleship implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().split("\\.")[0].equalsIgnoreCase("ia")) {
                JOptionPane.showMessageDialog(null, "ia de mierda");
            } else {
                JOptionPane.showMessageDialog(null, "no soy ia wey");
            }
        }
    }


}
