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

public class VistaLogin extends JPanel {

    JPanel panel;

    public VistaLogin() {
        panel = new JPanel();
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        generarCamposUsuario();
        generarCamposContraseña();
        generarCamposLoginYRegistro();
        generarSelectorDif();
    }

    private void generarCamposUsuario() {
        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);
    }

    private void generarCamposContraseña() {
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        panel.add(passwordText);
    }

    private void generarCamposLoginYRegistro() {
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        JButton registerButton = new JButton("register");
        registerButton.setBounds(180, 80, 80, 25);
        panel.add(registerButton);
    }

    private void generarSelectorDif() {
        JLabel difLabel = new JLabel("Dificultad");
        difLabel.setBounds(110, 110, 300, 25);
        panel.add(difLabel);

        ButtonGroup bg = new ButtonGroup();
        JRadioButton facil = new JRadioButton("facil");
        JRadioButton medio = new JRadioButton("medio");
        JRadioButton dificil = new JRadioButton("dificil");
        facil.setBounds(110, 140, 300, 25);
        medio.setBounds(110, 165, 300, 25);
        dificil.setBounds(110, 190, 300, 25);
        bg.add(facil);
        bg.add(medio);
        bg.add(dificil);
        bg.setSelected(facil.getModel(), true);
        panel.add(facil);
        panel.add(medio);
        panel.add(dificil);
    }

    public JPanel getVistaLogin() {
        return this.panel;
    }
}