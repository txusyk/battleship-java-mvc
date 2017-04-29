package Vista;

import javax.swing.*;

public class VistaImagenBienvenida {

    private JFrame window;
    private ImageIcon backgroundImageIcon;
    private JLabel bkgImageContainer;
    private volatile boolean isImageVisible;

    public VistaImagenBienvenida(JFrame theWindow) {
        window = theWindow;
        backgroundImageIcon = new ImageIcon("Title.png");
        bkgImageContainer = new JLabel(backgroundImageIcon);
        isImageVisible = true;
    }

    public void loadTitleScreen() {
        bkgImageContainer.setSize(window.getContentPane().getWidth(),
                window.getContentPane().getHeight());
        bkgImageContainer.setLocation(0, 0);
        window.getContentPane().add(bkgImageContainer);
        bkgImageContainer.setVisible(true);

        window.setVisible(true);
        window.getContentPane().revalidate();
        window.getContentPane().repaint();

        double actTime = System.currentTimeMillis();
        boolean mostrarImagen = true;
        while (mostrarImagen) {
            mostrarImagen = System.currentTimeMillis() - actTime < 6000;
        }
        window.getContentPane().remove(bkgImageContainer);
        window.getContentPane().revalidate();
        window.getContentPane().repaint();
        isImageVisible = false;
    }

    public boolean isImageVisible() {
        return isImageVisible;
    }
}
