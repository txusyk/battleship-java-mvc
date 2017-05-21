package Vista;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Josu on 23/04/2017.
 */
public class VistaImagenBienvenida extends JFrame implements Runnable {

    private JLabel contenedorImagen;
    private URL urlImagen;
    private Clip clip = null;

    public VistaImagenBienvenida() {
        urlImagen = this.getClass().getClassLoader().getResource("Title.png");

        contenedorImagen = new JLabel(new ImageIcon(urlImagen));
        this.add(contenedorImagen);

        this.pack();
        this.setResizable(false);

        JOptionPane.showMessageDialog(null, "Para ejecutar el juego es necesario que copies los archivos '.xml' a " + System.getProperty("user.home"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension thisSize = this.getSize(); //Tamaño del this actual (ancho x alto)
        if (thisSize.height > screenSize.height) {
            thisSize.height = screenSize.height;
        }
        if (thisSize.width > screenSize.width) {
            thisSize.width = screenSize.width;
        }
        setLocation((screenSize.width - thisSize.width) / 2, (screenSize.height - thisSize.height) / 2);


    }

    @Override
    public void run() {
        setVisible(true);

        double actTime = System.currentTimeMillis();
        boolean mostrarImagen = true;

        try {
            URL url = this.getClass().getClassLoader().getResource("mgs.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.setFramePosition(120);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

        while (mostrarImagen) {
            mostrarImagen = ((System.currentTimeMillis() / 1000) - actTime / 1000) < 5;
        }
        clip.stop();
        this.dispose();
    }
}
