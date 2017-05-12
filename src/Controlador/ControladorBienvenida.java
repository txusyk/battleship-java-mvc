package Controlador;

import Modelo.Login;
import Vista.VistaImagenBienvenida;
import Vista.VistaLogin;

/**
 * Created by Josu on 11/05/2017.
 */
public class ControladorBienvenida {

    private VistaImagenBienvenida vBienvenida;

    public ControladorBienvenida() {
        this.vBienvenida = new VistaImagenBienvenida();
        lanzarLogin();
    }

    private void lanzarLogin() {
        new ControladorLogin(new Login(), new VistaLogin());
    }

}
