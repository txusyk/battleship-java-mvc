package Vista;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Josu
 */
public class VistaJuego extends JPanel {
    
    private JPanel tableroJug, tableroIA;
    private JTabbedPane tableroInfo;
    
    private JPanel pnInfoJuego,pnInfoAdicional;

    /**
     * Creates new form VJ
     */
    public VistaJuego() {
        GridLayout layout = new GridLayout(1,3);
        this.setLayout(layout);

        tableroJug = new VistaTablero();
        tableroIA = new VistaTablero();
        tableroInfo = new JTabbedPane();

        this.tableroInfo.addTab("Info. juego", this.pnInfoJuego);
        this.tableroInfo.addTab("Info. adic", this.pnInfoAdicional);


        this.add(this.tableroJug);
        this.add(this.tableroInfo);
        this.add(this.tableroIA);
    }
}
