package Vista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Josu on 30/04/2017.
 */
public class VistaInicializacionBarcos extends JFrame {

    private JPanel selOpcBarco, tableroSeleccion;
    private int numFrag = 4, numDestr = 3, numSub = 2, numPortaav = 1;


    public VistaInicializacionBarcos() {
        this.setLayout(new GridLayout(1, 2));


        JLabel barcos = new JLabel("Selecc. un tipo de barco");

        JRadioButton frag = new JRadioButton("Fragata");
        JRadioButton destr = new JRadioButton("Destructor");
        JRadioButton sub = new JRadioButton("Submarino");
        JRadioButton portaav = new JRadioButton("Portaaviones");

        ButtonGroup buttonGroupBarcos = new ButtonGroup();
        buttonGroupBarcos.add(frag);
        buttonGroupBarcos.add(destr);
        buttonGroupBarcos.add(sub);
        buttonGroupBarcos.add(portaav);
        buttonGroupBarcos.setSelected(frag.getModel(), true);

        JLabel cantidadBarcos = new JLabel("Barcos restantes");
        JLabel numFragLabel = new JLabel(Integer.toString(numFrag));
        JLabel numDestrLabel = new JLabel(Integer.toString(numDestr));
        JLabel numSubLabel = new JLabel(Integer.toString(numSub));
        JLabel numPortaavLabel = new JLabel(Integer.toString(numPortaav));


        JLabel direccion = new JLabel("Direccion");
        JRadioButton buttonVer = new JRadioButton("Vertical");
        JRadioButton buttonHor = new JRadioButton("Horizontal");
        ButtonGroup buttonGroupDirecciones = new ButtonGroup();
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

        this.setTitle("Inicializacion de barcos");
        this.setSize(this.getMinimumSize().width, this.getMinimumSize().height);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
    }

    public void setNumFrag(int numFrag) {
        this.numFrag = numFrag;
    }

    public void setNumDestr(int numDestr) {
        this.numDestr = numDestr;
    }

    public void setNumSub(int numSub) {
        this.numSub = numSub;
    }

    public void setNumPortaav(int numPortaav) {
        this.numPortaav = numPortaav;
    }
}
