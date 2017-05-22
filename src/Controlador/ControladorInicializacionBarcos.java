package Controlador;

import Modelo.*;
import Vista.VistaInicializacionBarcos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by david on 07/05/2017.
 */
public class ControladorInicializacionBarcos implements Runnable {

    private Tablero modelo;
    private VistaInicializacionBarcos vista;

    @Override
    public void run() {
        this.modelo = new Tablero(10, 10);
        this.vista = new VistaInicializacionBarcos();

        GestorArchivoInicializacion.getMyGestorArchivoInicializacion().readXML("facil");
        this.vista.añadirListenersInicializacionBarcos(new ListenersInicializacionBarcos());
    }

    private class ListenersInicializacionBarcos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int x = Integer.parseInt(e.getActionCommand()) / 10;
            int y = Integer.parseInt(e.getActionCommand()) % 10;
            Barco b = ListaJugadores.getMyListaJug().getBarcoAInicializar(vista.getBarcoSelec());
            b.inicializar(x, y, vista.getDirSelec());
            if (vista.getNumBarco(vista.getBarcoSelec()) > 0) {
                if (modelo.colocarBarco(b, x, y)) {
                    vista.reducirBarco(vista.getBarcoSelec());
                    vista.pintar(b.getTamaño(), vista.getDirSelec(), x, y);
                    pintarAreaBarco(b, x, y);
                    if ((vista.getNumBarco("fragata") == 0) && (vista.getNumBarco("destructor") == 0) && (vista.getNumBarco("submarino") == 0) && (vista.getNumBarco("portaaviones") == 0)) {
                        vista.eliminarListeners(this);
                        vista.modVisibilidadTableroJug();
                        vista.lanzarPopUp("Has colocado todos los barcos con exito! Ahora comenzara la partida", " ", JOptionPane.OK_OPTION);
                        vista.dispose();
                        new ControladorBattleship(vista.getPanelJuego(), modelo).run();
                    }
                } else {
                    vista.lanzarPopUp("Error al colocar: " + vista.getBarcoSelec(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                vista.lanzarPopUp("No te quedan barcos del tipo " + vista.getBarcoSelec(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void pintarAreaBarco(Barco pBarco, int x, int y) {
            int i = 0;
            while (i < pBarco.getTamaño()) {
                int posX = pBarco.getParteBarco(i).getX();
                int posY = pBarco.getParteBarco(i).getY();
                if (pBarco.getHorientacion() == 'v') {
                    if (i == 0 && pBarco.getTamaño() == 1) {
                        pintarPrimerasPosVert(x, y);
                        pintarPosEstandarVert(x, y);
                        pintarUltimasPosVert(x, y);
                    } else if (i == 0 && pBarco.getTamaño() != 1) {
                        pintarPrimerasPosVert(x, y);
                        pintarPosEstandarVert(x, y);
                    } else if (i == pBarco.getTamaño() - 1) {
                        pintarUltimasPosVert(posX, posY);
                        pintarPosEstandarVert(posX, posY);
                    } else {
                        pintarPosEstandarVert(posX, posY);
                    }
                    i++;
                } else {
                    if (i == 0 && pBarco.getTamaño() == 1) {
                        pintarPrimerasPosHor(x, y);
                        pintarPosEstandarHor(x, y);
                        pintarUltimasPosHor(x, y);
                    } else if (i == 0 && pBarco.getTamaño() != 1) {
                        pintarPrimerasPosHor(x, y);
                        pintarPosEstandarHor(x, y);
                    } else if (i == pBarco.getTamaño() - 1) {
                        pintarUltimasPosHor(posX, posY);
                        pintarPosEstandarHor(posX, posY);
                    } else {
                        pintarPosEstandarHor(posX, posY);
                    }
                    i++;
                }
            }
        }

        private void pintarUltimasPosHor(int x, int y) {
            if (x + 1 < 10 && y - 1 >= 0) {
                if (modelo.getTablero()[x + 1][y - 1] instanceof AreaBarco) {
                    vista.getTableroSeleccion().pintarArea(x + 1, y - 1);
                }
            }
            if (x + 1 < 10) {
                if (modelo.getTablero()[x + 1][y] instanceof AreaBarco) {
                    vista.getTableroSeleccion().pintarArea(x + 1, y);
                }
            }
            if (x + 1 < 10 && y + 1 < 10) {
                if (modelo.getTablero()[x + 1][y + 1] instanceof AreaBarco) {

                    vista.getTableroSeleccion().pintarArea(x + 1, y + 1);
                }
            }
        }

        private void pintarPosEstandarHor(int x, int y) {
            if (y - 1 >= 0) {
                if (modelo.getTablero()[x][y - 1] instanceof AreaBarco) {

                    vista.getTableroSeleccion().pintarArea(x, y - 1);
                }
            }
            if (y + 1 < 10) {

                if (modelo.getTablero()[x][y + 1] instanceof AreaBarco) {

                    vista.getTableroSeleccion().pintarArea(x, y + 1);
                }
            }
        }

        private void pintarPrimerasPosHor(int x, int y) {
            if (x - 1 >= 0) {
                if (modelo.getTablero()[x - 1][y] instanceof AreaBarco) {

                    vista.getTableroSeleccion().pintarArea(x - 1, y);
                }
            }
            if (x - 1 >= 0 && y + 1 < 10) {

                if (modelo.getTablero()[x - 1][y + 1] instanceof AreaBarco) {

                    vista.getTableroSeleccion().pintarArea(x - 1, y + 1);
                }
            }
            if (x - 1 >= 0 && y - 1 >= 0) {
                if (modelo.getTablero()[x - 1][y - 1] instanceof AreaBarco) {

                    vista.getTableroSeleccion().pintarArea(x - 1, y - 1);
                }
            }
        }


        private void pintarPrimerasPosVert(int x, int y) {
            if (x - 1 >= 0 && y - 1 >= 0) {
                if (modelo.getTablero()[x - 1][y - 1] instanceof AreaBarco) {

                    vista.getTableroSeleccion().pintarArea(x - 1, y - 1);
                }
            }
            if (y >= 0) {
                if (modelo.getTablero()[x][y - 1] instanceof AreaBarco) {

                    vista.getTableroSeleccion().pintarArea(x, y - 1);
                }
            }
            if (x + 1 < 10 && y >= 0) {
                if (modelo.getTablero()[x + 1][y - 1] instanceof AreaBarco) {

                    vista.getTableroSeleccion().pintarArea(x + 1, y - 1);
                }
            }
        }

        private void pintarPosEstandarVert(int x, int y) {
            if (x - 1 >= 0) {
                if (modelo.getTablero()[x - 1][y] instanceof AreaBarco) {

                    vista.getTableroSeleccion().pintarArea(x - 1, y);
                }
            }
            if (x + 1 < 10)
                if (modelo.getTablero()[x + 1][y] instanceof AreaBarco) {

                    vista.getTableroSeleccion().pintarArea(x + 1, y);
                }
        }

        private void pintarUltimasPosVert(int x, int y) {
            if (x + 1 < 10 && y + 1 < 10) {
                if (modelo.getTablero()[x + 1][y + 1] instanceof AreaBarco) {

                    vista.getTableroSeleccion().pintarArea(x + 1, y + 1);
                }
            }
            if (y + 1 < 10) {
                if (modelo.getTablero()[x][y + 1] instanceof AreaBarco) {

                    vista.getTableroSeleccion().pintarArea(x, y + 1);
                }
            }
            if (x - 1 < 10 && x - 1 > 0 && y < 10) {
                if (modelo.getTablero()[x - 1][y + 1] instanceof AreaBarco) {
                    vista.getTableroSeleccion().pintarArea(x - 1, y + 1);
                }
            }
        }
    }
}