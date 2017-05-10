package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;

public class VistaLogin extends JFrame {

    VistaPopUpCargarPartida popUpCargarPartida;

    JPanel panel;
    JTextField userText;
    JPasswordField passwordText;
    JButton loginButton, registerButton;
    ButtonGroup bg;
    JRadioButton facil, medio, dificil;

    private JMenuBar barraLogin;
    private JMenu info, infoJuego, partida, archivo;
    private JMenuItem salir, acercaLogin, acercaDe, reglasJuego, cargarPartida;


    public VistaLogin() {
        popUpCargarPartida = new VistaPopUpCargarPartida();

        panel = new JPanel();
        placeComponents(panel);

        this.setTitle("Login / Registro de usuarios");
        URL url = this.getClass().getClassLoader().getResource("user-picture.png");
        if (url != null) {
            ImageIcon img = new ImageIcon(url);
            this.setIconImage(img.getImage());
        }
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300, 270);

        crearBarraMenu();
        this.setJMenuBar(barraLogin);

        this.getContentPane().add(this.panel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize(); //Tamaño del frame actual (ancho x alto)
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

        this.setResizable(false);
        this.setVisible(true);
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

        registerButton = new JButton("registro");
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

    private void crearBarraMenu() {
        archivo = new JMenu("Archivo");
        salir = new JMenuItem("Salir");
        salir.setActionCommand("salir");
        archivo.add(salir);

        infoJuego = new JMenu("Inf. de juego");
        reglasJuego = new JMenuItem("Reglas del juego");
        reglasJuego.setActionCommand("reglas");
        infoJuego.add(reglasJuego);

        info = new JMenu("Informacion");
        acercaDe = new JMenuItem("Info. developers");
        acercaDe.setActionCommand("devs");
        acercaLogin = new JMenuItem("Informacion sobre el login");
        acercaLogin.setActionCommand("infoLogin");
        info.add(acercaLogin);
        info.add(acercaDe);

        partida = new JMenu("Partida");
        cargarPartida = new JMenuItem("Cargar partida");
        cargarPartida.setActionCommand("cargar");
        partida.add(cargarPartida);


        barraLogin = new JMenuBar();
        barraLogin.add(archivo);
        barraLogin.add(info);
        barraLogin.add(infoJuego);
        barraLogin.add(partida);
    }

    public final void añadirListenersLogin(ActionListener login) {
        this.loginButton.setActionCommand("login");
        this.loginButton.addActionListener(login);

        this.registerButton.setActionCommand("registro");
        this.registerButton.addActionListener(login);

        this.salir.addActionListener(login);
        this.reglasJuego.addActionListener(login);
        this.acercaDe.addActionListener(login);
        this.acercaLogin.addActionListener(login);
        this.cargarPartida.addActionListener(login);
    }

    public JTextField getUserText() {
        return userText;
    }

    public JPasswordField getPasswordText() {
        return passwordText;
    }

    public String getBotonSeleccionado() {
        if (bg.isSelected(dificil.getModel())) {
            return "dificil";
        } else if (bg.isSelected(medio.getModel())) {
            return "medio";
        } else {
            return "facil";
        }
    }

    public void lanzarPopUp(String texto, String nombreVentana, int tipoVentana) {
        JOptionPane.showMessageDialog(this, texto, nombreVentana, tipoVentana);
    }

    public void salir() {
        System.exit(0);
    }

}