package Vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VistaLogin extends JPanel {

    JPanel panel;
    JTextField userText;
    JPasswordField passwordText;
    JButton loginButton, registerButton;
    ButtonGroup bg;
    JRadioButton facil, medio, dificil;

    public VistaLogin() {
        panel = new JPanel();
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        generarCamposUsuario();
        generarCamposContraseña();
        generarCamposLoginYRegistro();
        generarSelectorDif();
    }

    private void generarCamposUsuario() {
        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);
    }

    private void generarCamposContraseña() {
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        panel.add(passwordText);
    }

    private void generarCamposLoginYRegistro() {
        loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        registerButton = new JButton("register");
        registerButton.setBounds(180, 80, 80, 25);
        panel.add(registerButton);
    }

    private void generarSelectorDif() {
        JLabel difLabel = new JLabel("Dificultad");
        difLabel.setBounds(110, 110, 300, 25);
        panel.add(difLabel);

        bg = new ButtonGroup();
        facil = new JRadioButton("facil");
        medio = new JRadioButton("medio");
        dificil = new JRadioButton("dificil");

        facil.setBounds(110, 140, 300, 25);
        medio.setBounds(110, 165, 300, 25);
        dificil.setBounds(110, 190, 300, 25);

        bg.add(facil);
        bg.add(medio);
        bg.add(dificil);

        bg.setSelected(facil.getModel(), true);

        panel.add(facil);
        panel.add(medio);
        panel.add(dificil);
    }

    public JPanel getVistaLogin() {
        return this.panel;
    }

    public JTextField getUserText() {
        return userText;
    }

    public JPasswordField getPasswordText() {
        return passwordText;
    }

    public ButtonGroup getBg() {
        return bg;
    }

    public final void añadirListenersLogin(ActionListener login) {
        this.loginButton.setActionCommand("login");
        this.loginButton.addActionListener(login);

        this.registerButton.setActionCommand("registro");
        this.registerButton.addActionListener(login);
    }

}