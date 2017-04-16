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
        this.setLayout(new GridLayout(13, 2));
        this.setBorder(new LineBorder(Color.BLACK));
        this.setBackground(Color.WHITE);

        this.almacen = new JLabel("Almacen");
        this.almacen.setFont(new Font("Times New Roman", 2, 24));
        this.add(almacen);
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

        this.barcos = new JLabel("Barcos disponibles");
        this.barcos.setFont(new Font("Times New Roman", 2, 24));
        this.add(barcos);
        this.add(new JLabel(""));

        this.add(new JSeparator(0));
        this.add(new JSeparator(0));

        this.fragata = new JLabel("Fragatas: ");
        this.fragata.setFont(fArmas);
        this.cantFragata = new JLabel("");
        this.cantFragata.setFont(fArmas);
        this.add(fragata);
        this.add(cantFragata);

        this.destructor = new JLabel("Fragatas: ");
        this.destructor.setFont(fArmas);
        this.cantDestr = new JLabel("");
        this.cantDestr.setFont(fArmas);
        this.add(destructor);
        this.add(cantDestr);

        this.submarino = new JLabel("Submarinos: ");
        this.submarino.setFont(fArmas);
        this.cantSub = new JLabel("");
        this.cantSub.setFont(fArmas);
        this.add(submarino);
        this.add(cantSub);

        this.portaaviones = new JLabel("Portaaviones: ");
        this.portaaviones.setFont(fArmas);
        this.cantPortaav = new JLabel("");
        this.cantPortaav.setFont(fArmas);
        this.add(portaaviones);
        this.add(cantPortaav);

    }

}
