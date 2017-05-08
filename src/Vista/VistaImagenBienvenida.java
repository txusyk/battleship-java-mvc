package Vista;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by Josu on 23/04/2017.
 */
public class VistaImagenBienvenida extends JFrame {

    private JLabel contenedorImagen;
    private URL urlImagen = this.getClass().getClassLoader().getResource("Title.png");

    public VistaImagenBienvenida() {
        contenedorImagen = new JLabel(new ImageIcon(urlImagen));

        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(900, 615));
        this.setMinimumSize(new Dimension(900, 615));
        this.setResizable(false);
        this.pack();
    }

    public void loadTitleScreen() {
        contenedorImagen.setSize(this.getContentPane().getWidth(),
                this.getContentPane().getHeight());
        contenedorImagen.setLocation(0, 0);
        this.getContentPane().add(contenedorImagen);
        contenedorImagen.setVisible(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension thisSize = this.getSize(); //Tamaño del this actual (ancho x alto)
        if (thisSize.height > screenSize.height) {
            thisSize.height = screenSize.height;
        }
        if (thisSize.width > screenSize.width) {
            thisSize.width = screenSize.width;
        }
        this.setLocation((screenSize.width - thisSize.width) / 2, (screenSize.height - thisSize.height) / 2);

        this.setVisible(true);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();

        double actTime = System.currentTimeMillis();
        boolean mostrarImagen = true;

        while (mostrarImagen) {
            mostrarImagen = ((System.currentTimeMillis() / 1000) - actTime / 1000) < 5;
        }
        this.getContentPane().remove(contenedorImagen);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }

}
