package Modelo;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Josu on 12/05/2017.
 */
public class GestorSonido {

    private static GestorSonido myGestorSonido;
    private Clip clip;

    private GestorSonido() {
        clip = null;
    }

    public static GestorSonido getMyGestorSonido() {
        if (myGestorSonido == null) {
            myGestorSonido = new GestorSonido();
        }
        return myGestorSonido;
    }

    public void lanzarSonido() {
        URL url;
        try {
            if (clip == null) {
                url = this.getClass().getClassLoader().getResource("mgs.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip = AudioSystem.getClip();
                clip.open(audioIn);
            } else {
                clip.stop();
                url = this.getClass().getClassLoader().getResource("drunken.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.setFramePosition(100);
            }
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
