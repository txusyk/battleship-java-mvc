package Vista;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Josu on 16/04/2017.
 */
public class InfoJugador extends JPanel {

    private JLabel dinero, cantDinero;
    private JLabel selArmas, bomba, misil, misildirig, escudo, radar;
    private JLabel cantBomba, cantMisil, cantMisildirig, cantEscudo, cantRadar;

    private JButton comprarArma, dispararArma;


    public InfoJugador() {
        initializeGui();
    }

    public void initializeGui() {
        this.setLayout(new GridLayout(10, 2));
        this.setBorder(new LineBorder(Color.BLACK));
        this.setBackground(Color.WHITE);

        this.dinero = new JLabel("Dinero disponible: ");
        this.dinero.setFont(new Font("Times New Roman", 2, 24));
        this.add(dinero);
        this.cantDinero = new JLabel("");
        this.add(cantDinero);

        this.add(new JSeparator(0));
        this.add(new JSeparator(0));

        this.selArmas = new JLabel("Selector de armas");
        this.selArmas.setFont(new Font("Times New Roman", 2, 24));
        this.add(selArmas);
        this.add(new Label(""));
        this.add(new JSeparator(0));
        this.add(new JSeparator(0));

        Font fArmas = new Font("Tahoma", 0, 16);

        this.bomba = new JLabel("Bombas");
        this.bomba.setFont(fArmas);
        this.cantBomba = new JLabel("∞");
        this.cantBomba.setFont(fArmas);
        this.add(bomba);
        this.add(cantBomba);

        this.misil = new JLabel("Misiles");
        this.misil.setFont(fArmas);
        this.add(misil);
        this.cantMisil = new JLabel("");
        this.cantMisil.setFont(fArmas);
        this.add(cantMisil);

        this.misildirig = new JLabel("Misiles Dirigidos");
        this.misildirig.setFont(fArmas);
        this.add(misildirig);
        this.cantMisildirig = new JLabel("");
        this.cantMisildirig.setFont(fArmas);
        this.add(cantMisildirig);


        this.radar = new JLabel("Radares");
        this.radar.setFont(fArmas);
        this.add(radar);
        this.cantRadar = new JLabel("");
        this.cantRadar.setFont(fArmas);
        this.add(cantRadar);


        this.escudo = new JLabel("Escudos");
        this.escudo.setFont(fArmas);
        this.add(escudo);
        this.cantEscudo = new JLabel("");
        this.cantEscudo.setFont(fArmas);
        this.add(cantEscudo);


        this.comprarArma = new JButton("Comprar arma");
        this.dispararArma = new JButton("Disparar arma selec.");
        this.add(comprarArma);
        this.add(dispararArma);
    }


}
