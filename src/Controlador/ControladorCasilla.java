package Controlador;

import Modelo.*;
import Vista.InfoJugador;
import Vista.VistaCasilla;
import Vista.VistaInicializacionBarcos;
import Vista.VistaLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by david on 07/05/2017.
 */
public class ControladorCasilla implements ActionListener {

    private InfoJugador infJug;
    public ControladorCasilla(Tablero pTabJug){
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(infJug!=null) {
            System.out.println(e.getActionCommand());
            Bomba a = (Bomba) Battleship.getMyBattleship().getJugActivo().getListaArmas().getArma(infJug.getArmaSelec());
            a.accion(Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10);
        }
        else{
            switch(VistaInicializacionBarcos.getMiVistaInicBarcos().getBarcoSelec()){
                case ("fragata"):
                    if (VistaInicializacionBarcos.getMiVistaInicBarcos().getDirSelec().equalsIgnoreCase("v")) {
                        Fragata frag = (Fragata)ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("fragata");
                        frag.setHorientacion('v');
                        if(ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(frag, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10) && VistaInicializacionBarcos.getMiVistaInicBarcos().getNumFragatas()>0) {
                            VistaInicializacionBarcos.getMiVistaInicBarcos().reducirBarco("fragata");
                            VistaInicializacionBarcos.getMiVistaInicBarcos().pintar(frag.getTamaño(), "v", Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                            frag.soutPrimeraPos();
                            System.out.println("Creada fragata vertical");
                        }
                    }
                    else {
                        Fragata frag = (Fragata)ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("fragata");
                        frag.setHorientacion('h');
                        if(ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(frag, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10) && VistaInicializacionBarcos.getMiVistaInicBarcos().getNumFragatas()>0) {
                            VistaInicializacionBarcos.getMiVistaInicBarcos().reducirBarco("fragata");
                            VistaInicializacionBarcos.getMiVistaInicBarcos().pintar(frag.getTamaño(), "h", Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                            frag.soutPrimeraPos();
                            System.out.println("Creada fragata horizontal");
                        }
                    }
                    break;
                case ("destructor"):
                    if (VistaInicializacionBarcos.getMiVistaInicBarcos().getDirSelec().equalsIgnoreCase("v")) {
                        Destructor dest = (Destructor)ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("destructor");
                        dest.setHorientacion('v');
                        if(ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(dest, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10)&& VistaInicializacionBarcos.getMiVistaInicBarcos().getNumDestr()>0){
                            VistaInicializacionBarcos.getMiVistaInicBarcos().reducirBarco("destructor");
                            System.out.println(Integer.parseInt(e.getActionCommand())/10 +" "+ Integer.parseInt(e.getActionCommand())%10);
                            VistaInicializacionBarcos.getMiVistaInicBarcos().pintar(dest.getTamaño(), "v", Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                            System.out.println("Creado destruc vertical");
                            dest.soutPrimeraPos();
                        }
                    }
                    else {
                        Destructor dest = (Destructor)ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("destructor");
                        dest.setHorientacion('h');
                        if(ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(dest, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10) && VistaInicializacionBarcos.getMiVistaInicBarcos().getNumDestr()>0){
                            VistaInicializacionBarcos.getMiVistaInicBarcos().pintar(dest.getTamaño(), "h", Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                            VistaInicializacionBarcos.getMiVistaInicBarcos().reducirBarco("destructor");
                            System.out.println("Creada destruc horizontal");
                            dest.soutPrimeraPos();
                        }
                    }
                    break;
                case ("submarino"):
                    if (VistaInicializacionBarcos.getMiVistaInicBarcos().getDirSelec().equalsIgnoreCase("v")) {
                        Submarino sub = (Submarino)ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("submarino");
                        sub.setHorientacion('v');
                        if(ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(sub, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10)&& VistaInicializacionBarcos.getMiVistaInicBarcos().getNumSub()>0) {
                            VistaInicializacionBarcos.getMiVistaInicBarcos().reducirBarco("submarino");
                            VistaInicializacionBarcos.getMiVistaInicBarcos().pintar(sub.getTamaño(), "v", Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                            System.out.println("Creada sub vertical");
                            sub.soutPrimeraPos();
                        }
                    }
                    else {
                        Submarino sub = (Submarino)ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("submarino");
                        sub.setHorientacion('h');
                        if(ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(sub, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10)&& VistaInicializacionBarcos.getMiVistaInicBarcos().getNumSub()>0) {
                            VistaInicializacionBarcos.getMiVistaInicBarcos().reducirBarco("submarino");
                            VistaInicializacionBarcos.getMiVistaInicBarcos().pintar(sub.getTamaño(), "h", Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                            System.out.println("Creada sub horizontal");
                            sub.soutPrimeraPos();
                        }
                    }
                    break;
                case ("portaaviones"):
                    if (VistaInicializacionBarcos.getMiVistaInicBarcos().getDirSelec().equalsIgnoreCase("v")) {
                        Portaaviones portaav = (Portaaviones) ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("portaaviones");
                        portaav.setHorientacion('v');
                        if(ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(portaav, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10) && VistaInicializacionBarcos.getMiVistaInicBarcos().getNumPortaav()>0) {
                            VistaInicializacionBarcos.getMiVistaInicBarcos().reducirBarco("portaaviones");
                            VistaInicializacionBarcos.getMiVistaInicBarcos().pintar(portaav.getTamaño(), "v", Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                            System.out.println("Creada portaav vertical");
                            portaav.soutPrimeraPos();
                        }
                    }
                    else {
                        Portaaviones portaav = (Portaaviones)ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("portaaviones");
                        portaav.setHorientacion('h');
                        if(ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(portaav, Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10)&& VistaInicializacionBarcos.getMiVistaInicBarcos().getNumPortaav()>0) {
                            VistaInicializacionBarcos.getMiVistaInicBarcos().reducirBarco("portaaviones");
                            VistaInicializacionBarcos.getMiVistaInicBarcos().pintar(portaav.getTamaño(), "h", Integer.parseInt(e.getActionCommand())/10, Integer.parseInt(e.getActionCommand())%10);
                            System.out.println("Creada portaav horizontal");
                            portaav.soutPrimeraPos();
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        }
    }
