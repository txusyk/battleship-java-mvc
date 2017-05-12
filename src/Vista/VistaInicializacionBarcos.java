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


    public int getNumBarco(String pBarco) {
        switch (pBarco) {
            case "fragata":
                return Integer.parseInt(this.numFragLabel.getText());
            case "destructor":
                return Integer.parseInt(this.numDestrLabel.getText());
            case "submarino":
                return Integer.parseInt(this.numSubLabel.getText());
            case "portaaviones":
                return Integer.parseInt(this.numPortaavLabel.getText());
            default:
                return 0;
        }
    }

    public void reducirBarco(String pBarco) {
        switch (pBarco) {
            case "fragata":
                this.numFragLabel.setText(Integer.toString(Integer.parseInt(numFragLabel.getText()) - 1));
                this.buttonGroupBarcos.setSelected(this.destr.getModel(), true);
                break;
            case "destructor":
                this.numDestrLabel.setText(Integer.toString(Integer.parseInt(numDestrLabel.getText()) - 1));
                break;
            case "submarino":
                this.numSubLabel.setText(Integer.toString(Integer.parseInt(numSubLabel.getText()) - 1));
                break;
            case "portaaviones":
                this.numPortaavLabel.setText(Integer.toString(Integer.parseInt(numPortaavLabel.getText()) - 1));
                break;
        }
        setBotonConBarcosRestantes();
    }

    private void setBotonConBarcosRestantes() {
        if (Integer.parseInt(this.numFragLabel.getText()) > 0) {
            this.buttonGroupBarcos.setSelected(this.frag.getModel(), true);
        } else if ((Integer.parseInt(this.numDestrLabel.getText()) > 0)) {
            this.buttonGroupBarcos.setSelected(this.destr.getModel(), true);
        } else if ((Integer.parseInt(this.numSubLabel.getText()) > 0)) {
            this.buttonGroupBarcos.setSelected(this.sub.getModel(), true);
        } else {
            this.buttonGroupBarcos.setSelected(this.portaav.getModel(), true);
        }
    }

    public String getBarcoSelec() {
        return buttonGroupBarcos.getSelection().getActionCommand();
    }

    public char getDirSelec() {
        return buttonGroupDirecciones.getSelection().getActionCommand().toLowerCase().toCharArray()[0];
    }

    public void añadirListenersInicializacionBarcos(ActionListener actionListener) {
        this.tableroSeleccion.añadirListenerACasilla(actionListener);
    }

    public void lanzarPopUp(String texto, String nombreVentana, int tipoVentana) {
        JOptionPane.showMessageDialog(this, texto, nombreVentana, tipoVentana);
    }

    public VistaTablero getPanelJuego() {
        return tableroSeleccion;
    }

    public void pintar(int tam, char dir, int x, int y) {
        while (tam != 0) {
            if (dir == 'h') {
                tableroSeleccion.getCasillas()[x][y].setBackground(Color.GREEN);
                tableroSeleccion.getCasillas()[x][y].setEnabled(false);
                x++;
                tam--;
            } else {
                tableroSeleccion.getCasillas()[x][y].setBackground(Color.GREEN);
                tableroSeleccion.getCasillas()[x][y].setEnabled(false);
                y++;
                tam--;
            }
        }
    }

}
