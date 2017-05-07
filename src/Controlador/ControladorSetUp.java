package Controlador;

import Modelo.*;
import Vista.VistaInicializacionBarcos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by david on 07/05/2017.
 */
public class ControladorSetUp implements ActionListener {

    private VistaInicializacionBarcos vIB;
    private Tablero tabJug;

    public ControladorSetUp(VistaInicializacionBarcos pVIB, Tablero pTabJug){
        vIB = pVIB;
        tabJug = pTabJug;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(vIB.getBarcoSelec()){
            case ("Fragata"):
                if (vIB.getDirSelec().equalsIgnoreCase("Vertical")) {
                    Fragata frag = new Fragata();
                    frag.setHorientacion('v');
                    tabJug.colocarBarco(frag, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                    System.out.println("Creada fragata vertical");
                }
                else {
                    Fragata frag = new Fragata();
                    frag.setHorientacion('h');
                    tabJug.colocarBarco(frag, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                    System.out.println("Creada fragata horizontal");
                }
                break;
            case ("Destructor"):
                if (vIB.getDirSelec().equalsIgnoreCase("Vertical")) {
                    Destructor destr = new Destructor();
                    destr.setHorientacion('v');
                    tabJug.colocarBarco(destr, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                    System.out.println("Creado destruc vertical");
                }
                else {
                    Destructor destr = new Destructor();
                    destr.setHorientacion('h');
                    tabJug.colocarBarco(destr, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                    System.out.println("Creada destruc horizontal");
                }
                break;
            case ("Submarino"):
                if (vIB.getDirSelec().equalsIgnoreCase("Vertical")) {
                    Submarino sub = new Submarino();
                    sub.setHorientacion('v');
                    tabJug.colocarBarco(sub, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                }
                else {
                    Submarino sub = new Submarino();
                    sub.setHorientacion('h');
                    tabJug.colocarBarco(sub, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                }
                break;
            case ("Portaaviones"):
                if (vIB.getDirSelec().equalsIgnoreCase("Vertical")) {
                    Portaaviones portaav = new Portaaviones();
                    portaav.setHorientacion('v');
                    tabJug.colocarBarco(portaav, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                }
                else {
                    Portaaviones portaav = new Portaaviones();
                    portaav.setHorientacion('h');
                    tabJug.colocarBarco(portaav, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                }
                break;
            default:
                break;
        }
    }
}
