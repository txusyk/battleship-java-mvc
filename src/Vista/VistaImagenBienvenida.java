package Vista;

import javax.swing.*;
import java.net.URL;

/**
 * Created by Josu on 23/04/2017.
 */
public class VistaImagenBienvenida {

    private JFrame frame;
    private JLabel contenedorImagen;
    private volatile boolean isImagenFondoVisible;
    private URL urlImagen = this.getClass().getClassLoader().getResource("Title.png");

    public VistaImagenBienvenida(JFrame theWindow) {
        frame = theWindow;

        contenedorImagen = new JLabel(new ImageIcon(urlImagen));
        isImagenFondoVisible = true;
    }

    public void loadTitleScreen() {
        contenedorImagen.setSize(frame.getContentPane().getWidth(),
                frame.getContentPane().getHeight());
        contenedorImagen.setLocation(0, 0);
        frame.getContentPane().add(contenedorImagen);
        contenedorImagen.setVisible(true);

        frame.setVisible(true);
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

        double actTime = System.currentTimeMillis();
        boolean mostrarImagen = true;
        while (mostrarImagen) {
            mostrarImagen = System.currentTimeMillis() - actTime < 6000;
        }
        frame.getContentPane().remove(contenedorImagen);
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
        isImagenFondoVisible = false;
    }

    public boolean isImagenFondoVisible() {
        return isImagenFondoVisible;
    }
}
