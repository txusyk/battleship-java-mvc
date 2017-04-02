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

import javax.swing.*;
import java.awt.*;

/**
 * @author Josu
 */
public class VistaJuego extends javax.swing.JPanel {

    private JLabel almacenLabel,armamentoActualLabel,dineroRestanteCantLabel,dineroRestanteLabel,escudoAlmacenCantidadLabel,escudoAlmacenLabel,escudoArmActCantidadLabel, escudoArmActualLabel,misilArmActCantidadLabel;
    private JLabel misilDirigAlmacenCantidad,misilDirigAlmacenLabel,misilDirigArmActCantidadLabel,misilDirigArmActualLabel,misilesAlmacenCantidadLabel,misilesAlmacenLabel,misilesArmActualLabel;
    private JLabel radarAlmacenCantidadLabel,radarAlmacenLabel, radarArmActCantidadLabel,radarArmActualLabel,turnoActJugadorLabel, turnoActLabel;

    private javax.swing.JButton botonCompraAlmacen,botonSeleccionArma;
    private javax.swing.JComboBox<String> comboBoxAlmacen,comboBoxArmas;

    private javax.swing.JPanel info_juego, otros,vistaJuegoPanel;

    private javax.swing.JPanel tablero1Panel,tablero2Panel;


    /**
     * Creates new form VistaJuego
     */
    public VistaJuego() {
        initComponents();
        generarTablerosJuego();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        crearPaneles();
        añadirPanelesTablerosAJuego();

        crearEtiquetasAlmacen();
        crearEtiquetasArmamento();
        crearEtiquetasOtros();

        añadirPanelesTablerosAJuego();
        posicionarComponentesEnPaneles();
    }


    private void fijarTamañoPaneles() {
        setMinimumSize(new java.awt.Dimension(900, 500)); //fijamos el tamaño minimo del panel principal
        setPreferredSize(new java.awt.Dimension(1000, 500)); //fijamos el tamaño preferido para el panel principal

        vistaJuegoPanel.setPreferredSize(new java.awt.Dimension(530, 300));
        vistaJuegoPanel.setSize(new java.awt.Dimension(500, 300));

        tablero1Panel.setPreferredSize(new java.awt.Dimension(250, 250)); //fijamos el tamaño del tablero de juego1
        tablero1Panel.setSize(new java.awt.Dimension(250, 250));
        tablero1Panel.setLayout(new java.awt.GridLayout());

        tablero2Panel.setPreferredSize(new java.awt.Dimension(250, 250)); //fijamos el tamaño del tablero de juego2
        tablero2Panel.setSize(new java.awt.Dimension(250, 250));
        tablero2Panel.setLayout(new java.awt.GridLayout());
    }

    private void añadirPanelesTablerosAJuego() {
        //creamos el panel de juego
        javax.swing.GroupLayout vistaJuegoPanelLayout = new javax.swing.GroupLayout(vistaJuegoPanel);
        vistaJuegoPanel.setLayout(vistaJuegoPanelLayout);
        vistaJuegoPanelLayout.setHorizontalGroup(
                vistaJuegoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(vistaJuegoPanelLayout.createSequentialGroup()
                                .addComponent(tablero1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(tablero2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        vistaJuegoPanelLayout.setVerticalGroup(
                vistaJuegoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(vistaJuegoPanelLayout.createSequentialGroup()
                                .addGroup(vistaJuegoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tablero1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tablero2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 50, Short.MAX_VALUE))
        );
    }

    private void posicionarComponentesEnPaneles() {
        javax.swing.GroupLayout info_juegoLayout = new javax.swing.GroupLayout(info_juego);
        info_juego.setLayout(info_juegoLayout);
        info_juegoLayout.setHorizontalGroup(
                info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(info_juegoLayout.createSequentialGroup()
                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(info_juegoLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(misilDirigAlmacenLabel)
                                                        .addComponent(radarAlmacenLabel)
                                                        .addComponent(escudoAlmacenLabel)
                                                        .addComponent(misilesAlmacenLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(misilesAlmacenCantidadLabel)
                                                        .addComponent(escudoAlmacenCantidadLabel)
                                                        .addComponent(radarAlmacenCantidadLabel)
                                                        .addComponent(misilDirigAlmacenCantidad)))
                                        .addGroup(info_juegoLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(info_juegoLayout.createSequentialGroup()
                                                                .addComponent(comboBoxArmas, 0, 189, Short.MAX_VALUE)
                                                                .addGap(24, 24, 24)
                                                                .addComponent(botonSeleccionArma))
                                                        .addGroup(info_juegoLayout.createSequentialGroup()
                                                                .addComponent(comboBoxAlmacen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(21, 21, 21)
                                                                .addComponent(botonCompraAlmacen))))
                                        .addGroup(info_juegoLayout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(misilDirigArmActualLabel)
                                                        .addComponent(radarArmActualLabel)
                                                        .addComponent(escudoArmActualLabel)
                                                        .addComponent(misilesArmActualLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(misilArmActCantidadLabel)
                                                        .addComponent(escudoArmActCantidadLabel)
                                                        .addComponent(radarArmActCantidadLabel)
                                                        .addComponent(misilDirigArmActCantidadLabel))))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, info_juegoLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, info_juegoLayout.createSequentialGroup()
                                                .addComponent(armamentoActualLabel)
                                                .addGap(34, 34, 34))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, info_juegoLayout.createSequentialGroup()
                                                .addComponent(almacenLabel)
                                                .addGap(81, 81, 81))))
        );
        info_juegoLayout.setVerticalGroup(
                info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(info_juegoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(almacenLabel)
                                .addGap(18, 18, 18)
                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(misilesAlmacenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(misilesAlmacenCantidadLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(misilDirigAlmacenLabel)
                                        .addComponent(misilDirigAlmacenCantidad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(radarAlmacenLabel)
                                        .addComponent(radarAlmacenCantidadLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(escudoAlmacenLabel)
                                        .addComponent(escudoAlmacenCantidadLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboBoxAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botonCompraAlmacen))
                                .addGap(37, 37, 37)
                                .addComponent(armamentoActualLabel)
                                .addGap(18, 18, 18)
                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(misilesArmActualLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(misilArmActCantidadLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(misilDirigArmActualLabel)
                                        .addComponent(misilDirigArmActCantidadLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(radarArmActualLabel)
                                        .addComponent(radarArmActCantidadLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(escudoArmActualLabel)
                                        .addComponent(escudoArmActCantidadLabel))
                                .addGap(18, 18, 18)
                                .addGroup(info_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonSeleccionArma)
                                        .addComponent(comboBoxArmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout otrosLayout = new javax.swing.GroupLayout(otros);
        otros.setLayout(otrosLayout);
        otrosLayout.setHorizontalGroup(
                otrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, otrosLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(otrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, otrosLayout.createSequentialGroup()
                                                .addComponent(turnoActLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(turnoActJugadorLabel))
                                        .addGroup(otrosLayout.createSequentialGroup()
                                                .addComponent(dineroRestanteLabel)
                                                .addGap(86, 86, 86)
                                                .addComponent(dineroRestanteCantLabel)))
                                .addGap(143, 143, 143))
        );
        otrosLayout.setVerticalGroup(
                otrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(otrosLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(otrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dineroRestanteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dineroRestanteCantLabel))
                                .addGap(18, 18, 18)
                                .addGroup(otrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(turnoActLabel)
                                        .addComponent(turnoActJugadorLabel))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(vistaJuegoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(otros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(info_juego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(vistaJuegoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(otros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 183, Short.MAX_VALUE)
                                .addComponent(info_juego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

    }

    private void crearPaneles() {
        vistaJuegoPanel = new javax.swing.JPanel(); //creamos el panel que contendra los tableros y la información del juego

        tablero1Panel = new javax.swing.JPanel(); //panel del tablero de juego1
        tablero2Panel = new javax.swing.JPanel(); //panel del tablero de juego2

        info_juego = new javax.swing.JPanel(); //panel que contendra los elementos que estan en su bloque

        otros = new javax.swing.JPanel(); //panel que contendra los elementos que estan en su bloque

        fijarTamañoPaneles();
    }

    private void crearEtiquetasAlmacen() {
        almacenLabel = new javax.swing.JLabel(); //almacen
        almacenLabel.setFont(new java.awt.Font("Lucida Grande", 3, 16)); // NOI18N
        almacenLabel.setText("Almacén");

        misilesAlmacenLabel = new javax.swing.JLabel(); //labels de nombres de armas & sus cantidades
        misilesAlmacenLabel.setFont(new java.awt.Font("Bradley Hand", 0, 18)); // NOI18N
        misilesAlmacenLabel.setText("Misiles");
        misilesAlmacenCantidadLabel = new javax.swing.JLabel();
        misilesAlmacenCantidadLabel.setText("jLabel5");

        misilDirigAlmacenLabel = new javax.swing.JLabel();
        misilDirigAlmacenLabel.setFont(new java.awt.Font("Bradley Hand", 0, 18)); // NOI18N
        misilDirigAlmacenLabel.setText("Misiles dirigidos");
        misilDirigAlmacenCantidad = new javax.swing.JLabel();
        misilDirigAlmacenCantidad.setText("jLabel6");

        radarAlmacenLabel = new javax.swing.JLabel();
        radarAlmacenLabel.setFont(new java.awt.Font("Bradley Hand", 0, 18)); // NOI18N
        radarAlmacenLabel.setText("Radar");
        radarAlmacenCantidadLabel = new javax.swing.JLabel();
        radarAlmacenCantidadLabel.setText("jLabel9");

        escudoAlmacenLabel = new javax.swing.JLabel();
        escudoAlmacenLabel.setFont(new java.awt.Font("Bradley Hand", 0, 18)); // NOI18N
        escudoAlmacenLabel.setText("Modelo.Escudo");
        escudoAlmacenCantidadLabel = new javax.swing.JLabel();
        escudoAlmacenCantidadLabel.setText("jLabel9");

        comboBoxAlmacen = new javax.swing.JComboBox<>();
        comboBoxAlmacen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Misil", "Misil Dirigido", "Radar", "Modelo.Escudo"}));
        botonCompraAlmacen = new javax.swing.JButton();
        botonCompraAlmacen.setText("Comprar");
    }

    private void crearEtiquetasArmamento() {
        armamentoActualLabel = new javax.swing.JLabel(); //armamento actual
        armamentoActualLabel.setFont(new java.awt.Font("Lucida Grande", 3, 16)); // NOI18N
        armamentoActualLabel.setText("Armamento especial");

        misilesArmActualLabel = new javax.swing.JLabel();
        misilesArmActualLabel.setFont(new java.awt.Font("Bradley Hand", 0, 18)); // NOI18N
        misilesArmActualLabel.setText("Misiles");
        misilArmActCantidadLabel = new javax.swing.JLabel();
        misilArmActCantidadLabel.setText("jLabel5");

        misilDirigArmActualLabel = new javax.swing.JLabel();
        misilDirigArmActualLabel.setFont(new java.awt.Font("Bradley Hand", 0, 18)); // NOI18N
        misilDirigArmActualLabel.setText("Misiles dirigidos");
        misilDirigArmActCantidadLabel = new javax.swing.JLabel();
        misilDirigArmActCantidadLabel.setText("jLabel5");

        radarArmActualLabel = new javax.swing.JLabel();
        radarArmActualLabel.setFont(new java.awt.Font("Bradley Hand", 0, 18)); // NOI18N
        radarArmActualLabel.setText("Radar");
        radarArmActCantidadLabel = new javax.swing.JLabel();
        radarArmActCantidadLabel.setText("jLabel5");

        escudoArmActualLabel = new javax.swing.JLabel();
        escudoArmActualLabel.setFont(new java.awt.Font("Bradley Hand", 0, 18)); // NOI18N
        escudoArmActualLabel.setText("Modelo.Escudo");
        escudoArmActCantidadLabel = new javax.swing.JLabel();
        escudoArmActCantidadLabel.setText("jLabel5");


        botonSeleccionArma = new javax.swing.JButton();
        botonSeleccionArma.setText("Selec. arma");
        comboBoxArmas = new javax.swing.JComboBox<>();
        comboBoxArmas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Misil", "Misil Dirigido", "Radar", "Modelo.Escudo"}));
    }

    private void crearEtiquetasOtros() {
        dineroRestanteLabel = new javax.swing.JLabel();
        dineroRestanteLabel.setText("Dinero restante");
        dineroRestanteCantLabel = new javax.swing.JLabel();
        dineroRestanteCantLabel.setText("jLabel4");

        turnoActLabel = new javax.swing.JLabel();
        turnoActLabel.setText("Turno actual");
        turnoActJugadorLabel = new javax.swing.JLabel();
        turnoActJugadorLabel.setText("jLabel5");
    }

    private void generarTablerosJuego(){
        tablero1Panel.setLayout(new GridLayout(10, 10));
        tablero2Panel.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero1Panel.add(new VistaCasilla());
                tablero2Panel.add(new VistaCasilla());
            }
        }
    }

}