package Vista;
import Controlador.ControladorBarraHerramientas;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Josu on 31/03/2017.
 */
public class VistaBattleship extends JFrame {

    private static VistaBattleship myVb = new VistaBattleship();
    private JMenuBar barraLogin, barraJuego;
    private JMenu archivo, informacion, infoJuego, partida;
    private JMenuItem salir, reiniciar, cambiarDif, acercaLogin, acercaDe, reglasJuego, cargarPartida, guardarPartida;

    private JFrame frame;
    JTextField userText= new JPasswordField(20);
    JTextField passwordText= new JPasswordField(20);
    JFrame popUpAct;

    private boolean tableroActivo;



    private VistaBattleship() {
        crearBarraMenu();
    }

    public void disposePopUp(){popUpAct.dispose();;}
    public static VistaBattleship getVista(){
        if(myVb==null){
            myVb=new VistaBattleship();
        }
        return myVb;
    }
    public static void main(String args[]) {
         VistaBattleship.getVista().lanzarVentanaLogin();
         VistaBattleship.getVista().lanzarVistaJuego();
    }

    public String getUserToVerify(){return  userText.getText();}
    public String getPswToVerify(){return  userText.getText();}

    public void lanzarPopUpInstruccionesJuego() {
        JOptionPane.showMessageDialog(null,
                "Bienvenido al Battleship IS\n. " +
                        "\n\t- Para disparar, selecciona un arma y clicka sobre la casilla del tablero rival que tengas como objetivo." +
                        "\n\t- Para reparar, selecciona una casilla de tu tablero en estado tocado y haz click derecho sobre ella");
    }

    private void inicializarVentana(String pNombreVentana) {
        frame = new JFrame("User's login/registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void lanzarVentanaLogin() {
        inicializarVentana("Ventana de login/registro");
        frame.setJMenuBar(barraLogin);
        frame.setSize(300, 270);

        JPanel panel = new VistaLogin().getVistaLogin();
        frame.add(panel);

        frame.setResizable(false);

        centrarVentana();

        frame.setVisible(true);
    }

    public void lanzarVistaJuego() {
        lanzarPopUpInstruccionesJuego();
        inicializarVentana("Battleship");
        frame.setJMenuBar(barraJuego);

        JPanel panel = new VistaJuego();
        frame.setSize(panel.getMinimumSize().width,panel.getMinimumSize().height);
        frame.add(panel);
        frame.pack();
        frame.setResizable(true);

        centrarVentana();

        frame.setVisible(true);
    }

    public void lanzarVistaImagenBienvenida() {
        lanzarSonido();
        frame = new JFrame();

        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 615));
        frame.setMinimumSize(new Dimension(900, 615));
        frame.setResizable(false);
        frame.pack();

        centrarVentana();

        VistaImagenBienvenida mainM = new VistaImagenBienvenida(frame);
        mainM.loadTitleScreen();


        frame.setLayout(null);
        while (mainM.isImagenFondoVisible()) {
        }
        frame.setVisible(false);

        lanzarVistaInicializacionBarcos();
    }

    public void lanzarVistaInicializacionBarcos() {
        inicializarVentana("Inicializacion de barcos");

        JPanel panel = new VistaInicializacionBarcos();
        frame.setSize(panel.getMinimumSize().width, panel.getMinimumSize().height);
        frame.add(panel);
        frame.pack();
        frame.setResizable(true);

        centrarVentana();

        frame.setVisible(true);
    }

    private void centrarVentana() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize(); //Tamaño del frame actual (ancho x alto)
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }

    private void crearBarraMenu() {
        barraLogin = new JMenuBar();
        barraJuego = new JMenuBar();

        //opciones
        archivo = new JMenu("Archivo");
        informacion = new JMenu("Informacion");
        infoJuego = new JMenu("Inf. de juego");
        partida = new JMenu("Partida");
        salir = new JMenuItem("Salir");
        reiniciar = new JMenuItem("Reiniciar");
        cambiarDif = new JMenuItem("Cambiar dificultad");
        acercaLogin = new JMenuItem("Info. pantalla login");
        acercaDe = new JMenuItem("Info. developers");
        reglasJuego = new JMenuItem("Reglas del juego");
        cargarPartida = new JMenuItem("Cargar partida");
        guardarPartida = new JMenuItem("Guardar partida");

        barraLogin.add(informacion);
        informacion.setToolTipText("informacion sobre el login");
        informacion.add(acercaLogin);
        informacion.add(acercaDe);
        barraJuego.add(archivo);
        archivo.setToolTipText("opciones generales");
        barraJuego.add(infoJuego);
        infoJuego.setToolTipText("información general");
        barraJuego.add(partida);
        partida.setToolTipText("opciones de partida");
        archivo.add(salir);
        infoJuego.add(reglasJuego);
        infoJuego.add(acercaDe);
        partida.add(cambiarDif);
        partida.add(cargarPartida);
        partida.add(guardarPartida);
        partida.add(reiniciar);
        programaEventos();
    }

    public void popUpVerificacionUsuario(String pSeleccion){
        popUpAct =new JFrame();
        popUpAct.setTitle("verificación");
        popUpAct.setBounds(200,100,500,200);
        JPanel centro=new JPanel();
        centro.setLayout(new GridLayout(2,2));
        popUpAct.add(centro,BorderLayout.CENTER);
        popUpAct.add(new JLabel("se verificara tu usuario, cierrame si no estas seguro ,se aplicara la opcion sleccionada:" + pSeleccion), BorderLayout.NORTH);
        JLabel userLabel = new JLabel("User");
        userLabel.setSize( 80, 25);
        centro.add(userLabel);
        userText = new JTextField(20);
        userText.setSize( 80, 25);
        centro.add(userText);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setSize( 80, 25);
        centro.add(passwordLabel);
        passwordText = new JPasswordField(20);
        passwordText.setSize( 80, 25);
        centro.add(passwordText);
        JButton verificar = new JButton("verificar");
        verificar.setBounds(10, 80, 80, 25);
        popUpAct.add(verificar, BorderLayout.SOUTH);
        popUpAct.setVisible(true);
        verificar.addActionListener(ControladorBarraHerramientas.getControladorBarraHerramientas());
    }

    public void popUpInformacion(String pInfo,String pTextBtn){
        popUpAct =new JFrame();
        popUpAct.setTitle("información");
        popUpAct.setBounds(200,100,1000,100);
        popUpAct.add(new JLabel(pInfo), BorderLayout.CENTER);
        JButton btn=new JButton(pTextBtn);
        btn.addActionListener(ControladorBarraHerramientas.getControladorBarraHerramientas());
        popUpAct.add(btn, BorderLayout.EAST);
        popUpAct.setVisible(true);
    }

    public void popUpError(String pTipoFallo){
        popUpAct =new JFrame();
        popUpAct.setTitle("error");
        popUpAct.setBounds(400,300,300,100);
        popUpAct.add(new JLabel(pTipoFallo), BorderLayout.CENTER);
        JButton btn=new JButton("entendido");
        btn.addActionListener(ControladorBarraHerramientas.getControladorBarraHerramientas());
        popUpAct.add(btn, BorderLayout.EAST);
        popUpAct.setVisible(true);
    }

    public void popUpCambiarDif(){
            JPanel panel=new JPanel();
            JLabel difLabel = new JLabel("selecciona una dificultad");
            difLabel.setBounds(110, 110, 300, 25);
            panel.add(difLabel);
            ButtonGroup bg = new ButtonGroup();
            JRadioButton facil = new JRadioButton("dificultad facil");
            facil.addActionListener(ControladorBarraHerramientas.getControladorBarraHerramientas());
            JRadioButton medio = new JRadioButton("dificultad medio");
            medio.addActionListener(ControladorBarraHerramientas.getControladorBarraHerramientas());
            JRadioButton dificil = new JRadioButton("dificultad dificil");
            dificil.addActionListener(ControladorBarraHerramientas.getControladorBarraHerramientas());
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

        popUpAct =new JFrame();
        popUpAct.add(panel, BorderLayout.CENTER);
        popUpAct.setTitle("información");
        popUpAct.setBounds(200,100,1000,100);
        popUpAct.add(new JLabel("se reiniciara la partida con la configuracion que desees, cierrame si no estas seguro"), BorderLayout.NORTH);
        popUpAct.setVisible(true);
    }

    private void programaEventos(){
        acercaLogin.addActionListener(ControladorBarraHerramientas.getControladorBarraHerramientas());
        salir.addActionListener(ControladorBarraHerramientas.getControladorBarraHerramientas());
        reiniciar.addActionListener(ControladorBarraHerramientas.getControladorBarraHerramientas());
        cambiarDif.addActionListener(ControladorBarraHerramientas.getControladorBarraHerramientas());
        reglasJuego.addActionListener(ControladorBarraHerramientas.getControladorBarraHerramientas());
        acercaDe.addActionListener(ControladorBarraHerramientas.getControladorBarraHerramientas());
        guardarPartida.addActionListener(ControladorBarraHerramientas.getControladorBarraHerramientas());
        cargarPartida.addActionListener(ControladorBarraHerramientas.getControladorBarraHerramientas());
    }

    private void lanzarSonido() {
        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("drunken.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}
