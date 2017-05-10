package Controlador;

import Modelo.*;
import Vista.VistaInicializacionBarcos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by david on 07/05/2017.
 */
public class ControladorInicializacionBarcos {

    private Tablero modelo;
    private VistaInicializacionBarcos vista;

    public ControladorInicializacionBarcos(Tablero modeloTablero, VistaInicializacionBarcos vistaInicializacionBarcos) {
        this.modelo = modeloTablero;
        this.vista = vistaInicializacionBarcos;

        this.vista.añadirListenersInicializacionBarcos(new ListenersInicializacionBarcos());
    }

    private class ListenersInicializacionBarcos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (vista.getBarcoSelec()) {
                case ("fragata"):
                    if (vista.getDirSelec().equalsIgnoreCase("v")) {
                        Fragata frag = (Fragata) ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("fragata");
                        frag.setHorientacion('v');
                        if (ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(frag, Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10) && vista.getNumFragatas() > 0) {
                            vista.reducirBarco("fragata");
                            vista.pintar(frag.getTamaño(), "v", Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10);
                            frag.soutPrimeraPos();
                            System.out.println("Creada fragata vertical");
                        }
                    } else {
                        Fragata frag = (Fragata) ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("fragata");
                        frag.setHorientacion('h');
                        if (ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(frag, Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10) && vista.getNumFragatas() > 0) {
                            vista.reducirBarco("fragata");
                            vista.pintar(frag.getTamaño(), "h", Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10);
                            frag.soutPrimeraPos();
                            System.out.println("Creada fragata horizontal");
                        }
                    }
                    break;
                case ("destructor"):
                    if (vista.getDirSelec().equalsIgnoreCase("v")) {
                        Destructor dest = (Destructor) ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("destructor");
                        dest.setHorientacion('v');
                        if (ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(dest, Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10) && vista.getNumDestr() > 0) {
                            vista.reducirBarco("destructor");
                            System.out.println(Integer.parseInt(e.getActionCommand()) / 10 + " " + Integer.parseInt(e.getActionCommand()) % 10);
                            vista.pintar(dest.getTamaño(), "v", Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10);
                            System.out.println("Creado destruc vertical");
                            dest.soutPrimeraPos();
                        }
                    } else {
                        Destructor dest = (Destructor) ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("destructor");
                        dest.setHorientacion('h');
                        if (ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(dest, Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10) && vista.getNumDestr() > 0) {
                            vista.pintar(dest.getTamaño(), "h", Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10);
                            vista.reducirBarco("destructor");
                            System.out.println("Creada destruc horizontal");
                            dest.soutPrimeraPos();
                        }
                    }
                    break;
                case ("submarino"):
                    if (vista.getDirSelec().equalsIgnoreCase("v")) {
                        Submarino sub = (Submarino) ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("submarino");
                        sub.setHorientacion('v');
                        if (ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(sub, Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10) && vista.getNumSub() > 0) {
                            vista.reducirBarco("submarino");
                            vista.pintar(sub.getTamaño(), "v", Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10);
                            System.out.println("Creada sub vertical");
                            sub.soutPrimeraPos();
                        }
                    } else {
                        Submarino sub = (Submarino) ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("submarino");
                        sub.setHorientacion('h');
                        if (ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(sub, Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10) && vista.getNumSub() > 0) {
                            vista.reducirBarco("submarino");
                            vista.pintar(sub.getTamaño(), "h", Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10);
                            System.out.println("Creada sub horizontal");
                            sub.soutPrimeraPos();
                        }
                    }
                    break;
                case ("portaaviones"):
                    if (vista.getDirSelec().equalsIgnoreCase("v")) {
                        Portaaviones portaav = (Portaaviones) ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("portaaviones");
                        portaav.setHorientacion('v');
                        if (ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(portaav, Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10) && vista.getNumPortaav() > 0) {
                            vista.reducirBarco("portaaviones");
                            vista.pintar(portaav.getTamaño(), "v", Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10);
                            System.out.println("Creada portaav vertical");
                            portaav.soutPrimeraPos();
                        }
                    } else {
                        Portaaviones portaav = (Portaaviones) ListaJugadores.getMyListaJug().getHumano().getFlota().getBarcoPorTipo("portaaviones");
                        portaav.setHorientacion('h');
                        if (ListaJugadores.getMyListaJug().getHumano().getTablero().colocarBarco(portaav, Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10) && vista.getNumPortaav() > 0) {
                            vista.reducirBarco("portaaviones");
                            vista.pintar(portaav.getTamaño(), "h", Integer.parseInt(e.getActionCommand()) / 10, Integer.parseInt(e.getActionCommand()) % 10);
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
