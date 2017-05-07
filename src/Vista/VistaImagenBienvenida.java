package Vista;

import javax.swing.*;
import java.net.URL;

/**
 * Created by Josu on 23/04/2017.
 */
public class VistaImagenBienvenida {

    private JFrame frame;
    private ImageIcon imagenFondo;
    private JLabel contenedorImagen;
    private volatile boolean isImagenVisible;

    public VistaImagenBienvenida(JFrame theWindow) {
        frame = theWindow;
        URL url = this.getClass().getClassLoader().getResource("Title.png");
        imagenFondo = new ImageIcon(url);
        contenedorImagen = new JLabel(imagenFondo);
        isImagenVisible = true;
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
        isImagenVisible = false;
    }

    public boolean isImagenFondoVisible() {
        return isImagenVisible;
    }

    public boolean isImageVisible() {
        return isImagenVisible;
    }
}
