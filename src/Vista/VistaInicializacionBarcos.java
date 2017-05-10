package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Josu on 30/04/2017.
 */
public class VistaInicializacionBarcos extends JFrame {

    private JPanel selOpcBarco;
    private VistaTablero tableroSeleccion;
    // private int numFrag = 4, numDestr = 3, numSub = 2, numPortaav = 1;
    private JRadioButton frag, destr, sub, portaav;
    private ButtonGroup buttonGroupBarcos;
    private JRadioButton buttonVer, buttonHor;
    private ButtonGroup buttonGroupDirecciones;

    private JLabel cantidadBarcos, numFragLabel, numDestrLabel, numSubLabel, numPortaavLabel;


    public VistaInicializacionBarcos() {
        this.setLayout(new GridLayout(1, 2));

        JLabel barcos = new JLabel("Selecc. un tipo de barco");

        frag = new JRadioButton("Fragata");
        frag.setActionCommand("fragata");
        destr = new JRadioButton("Destructor");
        destr.setActionCommand("destructor");
        sub = new JRadioButton("Submarino");
        sub.setActionCommand("submarino");
        portaav = new JRadioButton("Portaaviones");
        portaav.setActionCommand("portaaviones");

        buttonGroupBarcos = new ButtonGroup();
        buttonGroupBarcos.add(frag);
        buttonGroupBarcos.add(destr);
        buttonGroupBarcos.add(sub);
        buttonGroupBarcos.add(portaav);
        buttonGroupBarcos.setSelected(frag.getModel(), true);

        cantidadBarcos = new JLabel("Barcos restantes");
        numFragLabel = new JLabel("4");
        numDestrLabel = new JLabel("3");
        numSubLabel = new JLabel("2");
        numPortaavLabel = new JLabel("1");

        JLabel direccion = new JLabel("Direccion");
        buttonVer = new JRadioButton("Vertical");
        buttonVer.setActionCommand("v");
        buttonHor = new JRadioButton("Horizontal");
        buttonHor.setActionCommand("h");
        buttonGroupDirecciones = new ButtonGroup();
        buttonGroupDirecciones.add(buttonVer);
        buttonGroupDirecciones.add(buttonHor);
        buttonGroupDirecciones.setSelected(buttonHor.getModel(), true);

        selOpcBarco = new JPanel(new GridLayout(8, 3));

        selOpcBarco.add(barcos);
        selOpcBarco.add(new JLabel(""));
        selOpcBarco.add(cantidadBarcos);
        selOpcBarco.add(frag);
        selOpcBarco.add(new JLabel(""));
        selOpcBarco.add(numFragLabel);
        selOpcBarco.add(destr);
        selOpcBarco.add(new JLabel(""));
        selOpcBarco.add(numDestrLabel);
        selOpcBarco.add(sub);
        selOpcBarco.add(new JLabel(""));
        selOpcBarco.add(numSubLabel);
        selOpcBarco.add(portaav);
        selOpcBarco.add(new JLabel(""));
        selOpcBarco.add(numPortaavLabel);

        selOpcBarco.add(new JSeparator(0));
        selOpcBarco.add(new JSeparator(0));
        selOpcBarco.add(new JSeparator(0));


        selOpcBarco.add(direccion);
        selOpcBarco.add(new JLabel(""));
        selOpcBarco.add(new JLabel(""));
        selOpcBarco.add(buttonHor);
        selOpcBarco.add(new JLabel(""));
        selOpcBarco.add(buttonVer);


        tableroSeleccion = new VistaTablero();
        this.getContentPane().add(selOpcBarco);
        this.getContentPane().add(tableroSeleccion);

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

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }

    //Reduce en uno la cantidad de barcos restantes por colocar.
    public void reducirBarco(String tipoBarco) {
        if (tipoBarco == "fragata") {
            if (getNumFragatas() > 0) {
                reducFrag();
            } else {
                System.out.println("Ya has colocado todas las fragatas");
            }
        } else if (tipoBarco == "submarino") {
            if (getNumSub() > 0) {
                reducSub();
            } else {
                System.out.println("Ya has colocado todos los submarinos");
            }
        }
        if (tipoBarco == "destructor") {
            if (getNumDestr() > 0) {
                reducDestr();
            } else {
                System.out.println("Ya has colocado todos las destructores");
            }
        } else if (tipoBarco == "portaaviones") {
            if (getNumPortaav() > 0) {
                reducPortaav();
            } else {
                System.out.println("Ya has colocado todos los submarinos");
            }
        }
    }

    public void reducFrag() {
        this.numFragLabel.setText(Integer.toString(getNumFragatas() - 1));
    }

    public int getNumFragatas() {
        return Integer.parseInt(this.numFragLabel.getText());
    }

    public int getNumSub() {
        return Integer.parseInt(numSubLabel.getText());
    }

    public void reducSub() {
        this.numSubLabel.setText(Integer.toString(getNumSub() - 1));
    }

    public int getNumDestr() {
        return Integer.parseInt(numDestrLabel.getText());
    }

    public void reducDestr() {
        this.numDestrLabel.setText(Integer.toString(getNumDestr() - 1));
    }

    public int getNumPortaav() {
        return Integer.parseInt(numPortaavLabel.getText());
    }

    public void reducPortaav() {
        this.numPortaavLabel.setText(Integer.toString(getNumPortaav() - 1));
    }

    public String getBarcoSelec() {
        return buttonGroupBarcos.getSelection().getActionCommand();
    }

    public String getDirSelec() {
        return buttonGroupDirecciones.getSelection().getActionCommand();
    }

    public void añadirListenersInicializacionBarcos(ActionListener actionListener) {
        this.tableroSeleccion.añadirListenerACasilla(actionListener);
    }

    public void pintar(int tam, String dir, int x, int y) {

        while (tam != 0) {
            if (dir.equalsIgnoreCase("h")) {
                tableroSeleccion.getCasillas()[y][x].setBackground(Color.GREEN);
                tableroSeleccion.getCasillas()[y][x].setEnabled(false);
                y++;
                tam--;
            } else if (dir.equalsIgnoreCase("v")) {
                System.out.println(y + " " + x);
                tableroSeleccion.getCasillas()[y][x].setBackground(Color.GREEN);
                tableroSeleccion.getCasillas()[y][x].setEnabled(false);
                x++;
                tam--;
            }
        }
    }
}
