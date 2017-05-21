package Vista;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Josu on 31/03/2017.
 */
public class VistaCasilla extends JButton {

    public VistaCasilla() {
        this.setPreferredSize(new Dimension(25, 25));
        //Border border = new LineBorder(Color.BLACK, 1);
        //this.setBorder(border);
        this.setBackground(Color.WHITE);
        this.setForeground(Color.DARK_GRAY);
    }
}

