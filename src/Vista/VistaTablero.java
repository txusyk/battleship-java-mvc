package Vista; /**
 * Created by Josu on 05/04/2017.
 */

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class VistaTablero extends JPanel {

    private static final String COLS = "ABCDEFGHIJ";
    private VistaCasilla[][] casillas = new VistaCasilla[10][10];
    private int jugador;

    public VistaTablero(int jugador) {
        this.jugador = jugador;
        initializeGui();
    }

    public void initializeGui() {
        // fijamos la GUI principal
        this.setLayout(new GridLayout(0, 11));
        this.setBorder(new LineBorder(Color.BLACK));

        // creamos las casillas para el tablero
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                VistaCasilla b = new VistaCasilla();
                b.setMargin(buttonMargin);
                if (jugador == 0) {
                    b.setActionCommand(String.valueOf(j) + "" + String.valueOf(i));
                } else {
                    b.setActionCommand("ia." + String.valueOf(j) + "" + String.valueOf(i));

                }
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
            for (int j = 0; j < 10; j++) {
                switch (j) {
                    case 0:
                        this.add(new JLabel("" + (i + 1), SwingConstants.CENTER));
                    default:
                        this.add(casillas[j][i]);
                }
            }
        }
    }

    public void añadirListenerACasilla(ActionListener actionListener) {
        for (VistaCasilla[] lvC : this.casillas) {
            for (VistaCasilla vC : lvC) {
                if (vC.isEnabled()) {
                    vC.addActionListener(actionListener);
                }
            }
        }
    }

    public void eliminarListeners(ActionListener aL) {
        for (VistaCasilla[] lvC : this.casillas) {
            for (VistaCasilla vC : lvC) {
                vC.removeActionListener(aL);
            }
        }
    }

    /*private void imprimirTablero() {
        for (VistaCasilla[] vC : casillas) {
            for (VistaCasilla b : vC) {
                int i = Integer.parseInt(b.getActionCommand()) / 10;
                int j = Integer.parseInt(b.getActionCommand()) % 10;
                if (j == 0) {
                    System.out.print("\n" + j+","+i+"   ");
                } else {
                    System.out.print(j+","+i+"   ");
                }
            }
        }

    }*/

    public void modificarVisibilidadCasillas() {
        for (VistaCasilla[] lvC : this.casillas) {
            for (VistaCasilla vC : lvC) {
                if (vC.getText().equals("b")) {
                    vC.setEnabled(true);
                } else {
                    vC.setEnabled(false);
                }
                vC.setText("");
            }
        }
    }

    public VistaCasilla[][] getCasillas() {
        return casillas;
    }

}