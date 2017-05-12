package Controlador;

import Modelo.GestorSonido;
import Modelo.Login;
import Vista.VistaImagenBienvenida;
import Vista.VistaLogin;

/**
 * Created by Josu on 11/05/2017.
 */
public class ControladorBienvenida {

    private VistaImagenBienvenida vBienvenida;

    public ControladorBienvenida() {
        GestorSonido.getMyGestorSonido().lanzarSonido();
        this.vBienvenida = new VistaImagenBienvenida();
        this.vBienvenida.loadTitleScreen();
        lanzarLogin();
    }

    private void lanzarLogin() {
        new ControladorLogin(new Login(), new VistaLogin());
    }

}
