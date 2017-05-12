package Controlador;

import Modelo.GestorSonido;
import Vista.VistaJuego;

/**
 * Created by Josu on 11/05/2017.
 */
public class ControladorBattleship {

    VistaJuego vista;

    public ControladorBattleship(VistaJuego vistaJuego) {
        GestorSonido.getMyGestorSonido().lanzarSonido();
        vista = vistaJuego;
    }


}
