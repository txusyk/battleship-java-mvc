package Controlador;

import Modelo.*;
import Vista.InfoJugador;
import Vista.VistaInicializacionBarcos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by david on 07/05/2017.
 */
public class ControladorCasilla implements ActionListener {

    private InfoJugador infJug;
    private Tablero tabJug;

    public ControladorCasilla(Tablero pTabJug){
        tabJug = pTabJug;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        System.out.println(VistaInicializacionBarcos.getMiVistaInicBarcos().getBarcoSelec());
        System.out.println(VistaInicializacionBarcos.getMiVistaInicBarcos().getDirSelec());
        if(infJug!=null) {
            System.out.println(e.getActionCommand());
            Bomba a = (Bomba) Battleship.getMyBattleship().getJugActivo().getListaArmas().getArma(infJug.getArmaSelec());
            a.accion(Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10);
        }
        else{
            switch(VistaInicializacionBarcos.getMiVistaInicBarcos().getBarcoSelec()){
                case ("fragata"):
                    if (VistaInicializacionBarcos.getMiVistaInicBarcos().getDirSelec().equalsIgnoreCase("v")) {
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
                case ("destructor"):
                    if (VistaInicializacionBarcos.getMiVistaInicBarcos().getDirSelec().equalsIgnoreCase("v")) {
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
                case ("submarino"):
                    if (VistaInicializacionBarcos.getMiVistaInicBarcos().getDirSelec().equalsIgnoreCase("v")) {
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
                case ("portaaviones"):
                    if (VistaInicializacionBarcos.getMiVistaInicBarcos().getDirSelec().equalsIgnoreCase("v")) {
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
    }
