package Vista;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Josu on 30/04/2017.
 */
public class VistaInicializacionBarcos extends JPanel implements Observer {

    private JPanel selOpcBarco, tableroSeleccion;
    private int numFrag = 4, numDestr = 3, numSub = 2, numPortaav = 1;
    private JRadioButton frag, destr, sub, portaav;
    private ButtonGroup buttonGroupBarcos;
    private JRadioButton buttonVer, buttonHor;
    private ButtonGroup buttonGroupDirecciones;

    private static VistaInicializacionBarcos miVistaInicBarcos;

    private VistaInicializacionBarcos() {
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

        JLabel cantidadBarcos = new JLabel("Barcos restantes");
        JLabel numFragLabel = new JLabel(Integer.toString(numFrag));
        JLabel numDestrLabel = new JLabel(Integer.toString(numDestr));
        JLabel numSubLabel = new JLabel(Integer.toString(numSub));
        JLabel numPortaavLabel = new JLabel(Integer.toString(numPortaav));


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
        this.add(selOpcBarco);
        this.add(tableroSeleccion);


    }

    public static VistaInicializacionBarcos getMiVistaInicBarcos(){
        if(miVistaInicBarcos == null){
            miVistaInicBarcos = new VistaInicializacionBarcos();
        }
        return miVistaInicBarcos;
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

    public String getBarcoSelec(){
        return buttonGroupBarcos.getSelection().getActionCommand();
    }

    public String getDirSelec(){
        return buttonGroupDirecciones.getSelection().getActionCommand();
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
