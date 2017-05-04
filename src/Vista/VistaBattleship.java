package Vista;

import Modelo.Battleship;
import Modelo.GestorFicheros;
import Modelo.ListaJugadores;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    private boolean tableroActivo;



    private VistaBattleship() {
        crearBarraMenu();
    }


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

    private void lanzarPopUpInstruccionesJuego() {
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

    private void lanzarVistaInicializacionBarcos() {
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

    private void popUpInfoLogin(){
        JFrame popUp =new JFrame();
        popUp.setTitle("información");
        popUp.setBounds(200,100,1000,100);
        popUp.add(new JLabel("Este login fue desarrollado con el fin de mantener la seguridad del usuario , y asimismo proveer de un gestor de partidas al juego ¡disfuta!"), BorderLayout.CENTER);
        JButton btn=new JButton("entendido");
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                //controlador botón entendido
                popUp.dispose();

            }
        });
        popUp.add(btn, BorderLayout.EAST);
        popUp.setVisible(true);
    }

    private void popUpSalir(){
        JFrame popUp =new JFrame();
        popUp.setTitle("información");
        popUp.setBounds(200,100,1000,100);
        popUp.add(new JLabel("¿deseas salir ,o fué un erro? , cierrame si no estas seguro"), BorderLayout.CENTER);
        JButton btn=new JButton("salir");
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                //controlador botón entendido
                System.exit(0);

            }
        });
        popUp.add(btn, BorderLayout.EAST);
        popUp.setVisible(true);
    }

    private void popUpVerificacionUsuario(String pSeleccion){
        JFrame popUp =new JFrame();
        popUp.setTitle("verificación");
        popUp.setBounds(200,100,500,200);
        JPanel centro=new JPanel();
        centro.setLayout(new GridLayout(2,2));
        popUp.add(centro,BorderLayout.CENTER);
        popUp.add(new JLabel("se verificara tu usuario, cierrame si no estas seguro ,se aplicara la opcion sleccionada:" + pSeleccion), BorderLayout.NORTH);
        JLabel userLabel = new JLabel("User");
        userLabel.setSize( 80, 25);
        centro.add(userLabel);
        JTextField userText = new JTextField(20);
        userText.setSize( 80, 25);
        centro.add(userText);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setSize( 80, 25);
        centro.add(passwordLabel);
        JTextField passwordText = new JPasswordField(20);
        passwordText.setSize( 80, 25);
        centro.add(passwordText);
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        popUp.add(loginButton, BorderLayout.SOUTH);
        popUp.setVisible(true);

        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                //controlador botón login
                //(comprobar usuario)
                String usr=userText.getText();
                String psw=passwordText.getText();
                try{
                    //login correcto..(reiniciar con misma dificultad)
                    GestorFicheros.getMyGestorFicheros().comprobarLogin(usr,psw.toCharArray());
                    if(pSeleccion.equals("facil")||pSeleccion.equals("medio")||pSeleccion.equals("dificil")) {
                        try {
                            Battleship.getMyBattleship().setDificultad(pSeleccion);
                            Battleship.getMyBattleship().inicializarJuego(usr);
                        } catch (Exception e) {
                            fallo("error en la lectura de datos lo sentimos, vuelva a intentarlo");
                        }
                    }else if(pSeleccion.equals("cargar")){
                        GestorFicheros.getMyGestorFicheros().cargarJuego(usr);
                    }else if(pSeleccion.equals("guardar")){
                        try {
                            GestorFicheros.getMyGestorFicheros().guardarPartida(usr);
                        } catch (Exception e) {
                            fallo("error en la escritura de datos lo sentimos");
                        }
                    }

                }catch(Exception e){
                    //fallo en el login usuario o contraseña mal insertadas
                    fallo("usuario o contraseña incorrectos");
                }
            }
        }
        );
    }

    private void fallo(String pTipoFallo){
        JFrame popUp =new JFrame();
        popUp.setTitle("error");
        popUp.setBounds(400,300,300,100);
        popUp.add(new JLabel(pTipoFallo), BorderLayout.CENTER);
        JButton btn=new JButton("entendido");
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                //controlador botón de dificultad dificil
                popUp.dispose();

            }
        });
        popUp.add(btn, BorderLayout.EAST);
        popUp.setVisible(true);
    }

    private void popUpReiniciar(){
        JFrame popUp =new JFrame();
        popUp.setTitle("información");
        popUp.setBounds(200,100,1000,100);
        popUp.add(new JLabel("se reiniciara la partida con la misma configuración, cierrame si no estas seguro"), BorderLayout.CENTER);
        JButton btn=new JButton("reiniciar");
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                //controlador botón reiniciar
               popUpVerificacionUsuario(Battleship.getMyBattleship().getDificultad());
            }
        });
        popUp.add(btn, BorderLayout.EAST);
        popUp.setVisible(true);
    }


    private void popUpAcercaDe(){
        JFrame popUp =new JFrame();
        popUp.setTitle("información");
        popUp.setBounds(200,100,500,250);
        popUp.add(new JTextArea("Hola,parece que quieres conocernos,nosotros somos:\n  "+
                ".......Josu Álvarez , David Max y Edgar Andres ........Development Group,¡Disfrutad! "), BorderLayout.CENTER);
        popUp.setVisible(true);
    }


    private void popUpCambiarDif(){
            JPanel panel=new JPanel();
            JLabel difLabel = new JLabel("selecciona una dificultad");
            difLabel.setBounds(110, 110, 300, 25);
            panel.add(difLabel);
            ButtonGroup bg = new ButtonGroup();
            JRadioButton facil = new JRadioButton("facil");
            facil.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    //controlador botóncultad facil de difi
                   popUpVerificacionUsuario("facil");
                }
            });
            JRadioButton medio = new JRadioButton("medio");
            medio.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    //controlador botón de dificultad medio
                    popUpVerificacionUsuario("medio");
                }
            });
            JRadioButton dificil = new JRadioButton("dificil");
            dificil.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    //controlador botón de dificultad dificil
                    popUpVerificacionUsuario("dificil");
                }
            });
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

        JFrame popUp =new JFrame();
        popUp.add(panel, BorderLayout.CENTER);
        popUp.setTitle("información");
        popUp.setBounds(200,100,1000,100);
        popUp.add(new JLabel("se reiniciara la partida con la configuracion que desees, cierrame si no estas seguro"), BorderLayout.NORTH);
        popUp.setVisible(true);
    }


    private void programaEventos(){
        ActionListener acercaLoginAction=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popUpInfoLogin();
            }
        };
        acercaLogin.addActionListener(acercaLoginAction);

        ActionListener salirAction=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popUpSalir();
            }
        };
        salir.addActionListener(salirAction);

        ActionListener reiniciarAction=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popUpReiniciar();
            }
        };
        reiniciar.addActionListener(reiniciarAction);


        ActionListener cambiarDifAction=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popUpCambiarDif();
            }
        };
        cambiarDif.addActionListener(cambiarDifAction);

        ActionListener reglasAction=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lanzarPopUpInstruccionesJuego();
            }
        };
        reglasJuego.addActionListener(reglasAction);


        ActionListener acercaDeAction=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popUpAcercaDe();
            }
        };
        acercaDe.addActionListener(acercaDeAction);

        ActionListener guardarAction=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    popUpVerificacionUsuario("guardar");
                } catch (Exception e1) {
                    fallo("sucedió un fallo al guardar el archivo");
                }
            }
        };
        guardarPartida.addActionListener(guardarAction);

        ActionListener cargarAction=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    popUpVerificacionUsuario("cargar");
                } catch (Exception e1) {
                    fallo("sucedió un fallo al guardar el archivo");
                }
            }
        };
        cargarPartida.addActionListener(cargarAction);
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
