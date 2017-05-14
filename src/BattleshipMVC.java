import Controlador.ControladorLogin;
import Vista.VistaImagenBienvenida;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Josu on 05/05/2017.
 */
public class BattleshipMVC {

    private BattleshipMVC() {
    }

    public static void main(String[] args) {
        new VistaImagenBienvenida();
        try {
            SwingUtilities.invokeAndWait(() -> new ControladorLogin());
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
