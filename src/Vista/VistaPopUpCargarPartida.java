package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Josu on 09/05/2017.
 */
public class VistaPopUpCargarPartida extends JFrame {

    JTextField userText;
    JPasswordField passwordText;
    JButton ok, cancelar;

    public VistaPopUpCargarPartida() {
        this.setTitle("Cargar partida");
        this.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("User");
        this.getContentPane().add(userLabel);

        userText = new JTextField(20);
        this.getContentPane().add(userText);

        JLabel passwordLabel = new JLabel("Password");
        this.getContentPane().add(passwordLabel);

        passwordText = new JPasswordField(20);
        this.getContentPane().add(passwordText);

        ok = new JButton("OK");
        ok.setActionCommand("ok");
        ok.setBounds(10, 80, 80, 25);
        this.getContentPane().add(ok);

        cancelar = new JButton("Cancelar");
        cancelar.setActionCommand("cancelar");
        cancelar.setBounds(10, 80, 80, 25);
        this.getContentPane().add(cancelar);

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
    }

    public void añadirListeners(ActionListener listenerPopUp) {
        ok.addActionListener(listenerPopUp);
        cancelar.addActionListener(listenerPopUp);

    }

}
