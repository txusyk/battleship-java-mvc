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
        new VistaImagenBienvenida().run();
        try {
            SwingUtilities.invokeAndWait(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    new ControladorLogin().run();
                } catch (UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
