package Vista;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by Josu on 23/04/2017.
 */
public class VistaImagenBienvenida extends JFrame {

    private JLabel contenedorImagen;
    private URL urlImagen = this.getClass().getClassLoader().getResource("Title.png");
    private Clip clip = null;

    public VistaImagenBienvenida() {
        contenedorImagen = new JLabel(new ImageIcon(urlImagen));
        this.add(contenedorImagen);

        this.pack();
        this.setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension thisSize = this.getSize(); //Tamaño del this actual (ancho x alto)
        if (thisSize.height > screenSize.height) {
            thisSize.height = screenSize.height;
        }
        if (thisSize.width > screenSize.width) {
            thisSize.width = screenSize.width;
        }
        setLocation((screenSize.width - thisSize.width) / 2, (screenSize.height - thisSize.height) / 2);

        setVisible(true);

        double actTime = System.currentTimeMillis();
        boolean mostrarImagen = true;

        while (mostrarImagen) {
            mostrarImagen = ((System.currentTimeMillis() / 1000) - actTime / 1000) < 5;
        }
        this.dispose();
    }

    public void loadTitleScreen() {

        //contenedorImagen.setVisible(true);


    }

}
