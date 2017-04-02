/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Josu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package Vista;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Josu on 31/03/2017.
 */
public class VistaCasilla extends JButton{

    JButton casilla;

    public VistaCasilla(){
        this.casilla = new JButton();
        this.casilla.setPreferredSize(new Dimension(25,25));
        this.casilla.setText("");
        this.casilla.setBackground(Color.DARK_GRAY);
    }

    public void pintar(Graphics g){
        super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.drawRect(0,0,24,24);
            g.setColor(Color.GRAY);
            g.fillRect(1,1,23,23);
    }
}
