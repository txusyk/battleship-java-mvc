package Vista; /**
 * Created by Josu on 05/04/2017.
 */

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class VistaTablero extends JPanel {

    private static final String COLS = "ABCDEFGHIJ";
    private JButton[][] casillas = new JButton[10][10];

    public VistaTablero() {
        initializeGui();
    }

    public final void initializeGui() {
        // fijamos la GUI principal
        this.setLayout(new GridLayout(0, 11));
        this.setBorder(new LineBorder(Color.BLACK));

        // creamos las casillas para el tablero
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // fijamos el tamaño a traves de una imagen transparente
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                b.setBackground(Color.BLUE);

                casillas[j][i] = b;
            }
        }

        //rellenamos el tablero
        this.add(new JLabel(""));
        // fill the top row
        for (int i = 0; i < 10; i++) {
            this.add(new JLabel(COLS.substring(i, i + 1), SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int i = 0; i < 10; i++) {
            for (int jj = 0; jj < 10; jj++) {
                switch (jj) {
                    case 0:
                        this.add(new JLabel("" + (i + 1), SwingConstants.CENTER));
                    default:
                        this.add(casillas[jj][i]);
                }
            }
        }
    }
}