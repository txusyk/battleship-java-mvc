package Vista;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Josu on 16/04/2017.
 */
public class InfoPartida extends JPanel {

    private JLabel almacen, bomba, misil, misildirig, escudo, radar;
    private JLabel cantBomba, cantMisil, cantMisildirig, cantEscudo, cantRadar;

    private JLabel barcos, fragata, submarino, destructor, portaaviones;
    private JLabel cantFragata, cantSub, cantDestr, cantPortaav;

    public InfoPartida() {
        initializeGui();
    }

    public void initializeGui() {
        this.setLayout(new GridLayout(13, 3));
        this.setBorder(new LineBorder(Color.BLACK));
        this.setBackground(Color.WHITE);

        this.almacen = new JLabel("Almacen");
        this.almacen.setHorizontalAlignment(JLabel.RIGHT);
        this.almacen.setFont(new Font("Times New Roman", 2, 24));
        this.add(almacen);
        this.add(new JLabel(""));

        this.add(new JSeparator(0));
        this.add(new JSeparator(0));

        Font fArmas = new Font("Tahoma", 0, 16);

        this.bomba = new JLabel("Bombas");
        this.bomba.setHorizontalAlignment(JLabel.CENTER);
        this.bomba.setFont(fArmas);
        this.cantBomba = new JLabel("∞");
        this.cantBomba.setHorizontalAlignment(JLabel.CENTER);
        this.cantBomba.setFont(fArmas);
        this.add(bomba);
        this.add(cantBomba);

        this.misil = new JLabel("Misiles");
        this.misil.setHorizontalAlignment(JLabel.CENTER);
        this.misil.setFont(fArmas);
        this.add(misil);
        this.cantMisil = new JLabel("-");
        this.cantMisil.setHorizontalAlignment(JLabel.CENTER);
        this.cantMisil.setFont(fArmas);
        this.add(cantMisil);

        this.misildirig = new JLabel("Misiles dirigidos");
        this.misildirig.setHorizontalAlignment(JLabel.CENTER);
        this.misildirig.setFont(fArmas);
        this.add(misildirig);
        this.cantMisildirig = new JLabel("-");
        this.cantMisildirig.setHorizontalAlignment(JLabel.CENTER);
        this.cantMisildirig.setFont(fArmas);
        this.add(cantMisildirig);


        this.radar = new JLabel("Radares");
        this.radar.setHorizontalAlignment(JLabel.CENTER);
        this.radar.setFont(fArmas);
        this.add(radar);
        this.cantRadar = new JLabel("-");
        this.cantRadar.setHorizontalAlignment(JLabel.CENTER);
        this.cantRadar.setFont(fArmas);
        this.add(cantRadar);


        this.escudo = new JLabel("Escudos");
        this.escudo.setHorizontalAlignment(JLabel.CENTER);
        this.escudo.setFont(fArmas);
        this.add(escudo);
        this.cantEscudo = new JLabel("-");
        this.cantEscudo.setHorizontalAlignment(JLabel.CENTER);
        this.cantEscudo.setFont(fArmas);
        this.add(cantEscudo);

        this.barcos = new JLabel("Barcos");
        this.barcos.setHorizontalAlignment(JLabel.RIGHT);
        this.barcos.setFont(new Font("Times New Roman", 2, 24));
        JLabel disponibles = new JLabel(" disponibles");
        disponibles.setFont(new Font("Times New Roman", 2, 24));
        disponibles.setHorizontalAlignment(JLabel.LEFT);
        this.add(barcos);
        this.add(disponibles);

        this.add(new JSeparator(0));
        this.add(new JSeparator(0));

        this.fragata = new JLabel("Fragatas");
        this.fragata.setHorizontalAlignment(JLabel.CENTER);
        this.fragata.setFont(fArmas);
        this.cantFragata = new JLabel("-");
        this.cantFragata.setHorizontalAlignment(JLabel.CENTER);
        this.cantFragata.setFont(fArmas);
        this.add(fragata);
        this.add(cantFragata);

        this.destructor = new JLabel("Destructores");
        this.destructor.setHorizontalAlignment(JLabel.CENTER);
        this.destructor.setFont(fArmas);
        this.cantDestr = new JLabel("-");
        this.cantDestr.setHorizontalAlignment(JLabel.CENTER);
        this.cantDestr.setFont(fArmas);
        this.add(destructor);
        this.add(cantDestr);

        this.submarino = new JLabel("Submarinos");
        this.submarino.setHorizontalAlignment(JLabel.CENTER);
        this.submarino.setFont(fArmas);
        this.cantSub = new JLabel("-");
        this.cantSub.setHorizontalAlignment(JLabel.CENTER);
        this.cantSub.setFont(fArmas);
        this.add(submarino);
        this.add(cantSub);

        this.portaaviones = new JLabel("Portaaviones");
        this.portaaviones.setHorizontalAlignment(JLabel.CENTER);
        this.portaaviones.setFont(fArmas);
        this.cantPortaav = new JLabel("-");
        this.cantPortaav.setHorizontalAlignment(JLabel.CENTER);
        this.cantPortaav.setFont(fArmas);
        this.add(portaaviones);
        this.add(cantPortaav);

    }

}
