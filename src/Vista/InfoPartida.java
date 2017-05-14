package Vista;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Josu on 16/04/2017.
 */
public class InfoPartida extends JPanel {

    private JLabel preciosArmas, bomba, misil, misildirig, escudo, radar;
    private JLabel precioBomba, precioMisil, precioMisilDirig, precioEscudo, precioRadar;

    private JLabel barcos, fragata, submarino, destructor, portaaviones;
    private JLabel cantFragata, cantSub, cantDestr, cantPortaav;

    public InfoPartida() {
        initializeGui();
    }

    public void initializeGui() {
        this.setLayout(new GridLayout(13, 3));
        this.setBorder(new LineBorder(Color.BLACK));
        this.setBackground(Color.WHITE);

        this.preciosArmas = new JLabel("Precios de armas");
        this.preciosArmas.setHorizontalAlignment(JLabel.RIGHT);
        this.preciosArmas.setFont(new Font("Times New Roman", 2, 24));
        this.add(preciosArmas);
        this.add(new JLabel(""));

        this.add(new JSeparator(0));
        this.add(new JSeparator(0));

        Font fArmas = new Font("Tahoma", 0, 16);

        this.bomba = new JLabel("Bombas");
        this.bomba.setHorizontalAlignment(JLabel.CENTER);
        this.bomba.setFont(fArmas);
        this.precioBomba = new JLabel("0");
        this.precioBomba.setHorizontalAlignment(JLabel.CENTER);
        this.precioBomba.setFont(fArmas);
        this.add(bomba);
        this.add(precioBomba);

        this.misil = new JLabel("Misiles");
        this.misil.setHorizontalAlignment(JLabel.CENTER);
        this.misil.setFont(fArmas);
        this.add(misil);
        this.precioMisil = new JLabel("-");
        this.precioMisil.setHorizontalAlignment(JLabel.CENTER);
        this.precioMisil.setFont(fArmas);
        this.add(precioMisil);

        this.misildirig = new JLabel("Misiles dirigidos");
        this.misildirig.setHorizontalAlignment(JLabel.CENTER);
        this.misildirig.setFont(fArmas);
        this.add(misildirig);
        this.precioMisilDirig = new JLabel("-");
        this.precioMisilDirig.setHorizontalAlignment(JLabel.CENTER);
        this.precioMisilDirig.setFont(fArmas);
        this.add(precioMisilDirig);


        this.radar = new JLabel("Radares");
        this.radar.setHorizontalAlignment(JLabel.CENTER);
        this.radar.setFont(fArmas);
        this.add(radar);
        this.precioRadar = new JLabel("-");
        this.precioRadar.setHorizontalAlignment(JLabel.CENTER);
        this.precioRadar.setFont(fArmas);
        this.add(precioRadar);


        this.escudo = new JLabel("Escudos");
        this.escudo.setHorizontalAlignment(JLabel.CENTER);
        this.escudo.setFont(fArmas);
        this.add(escudo);
        this.precioEscudo = new JLabel("-");
        this.precioEscudo.setHorizontalAlignment(JLabel.CENTER);
        this.precioEscudo.setFont(fArmas);
        this.add(precioEscudo);

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

    public void setPrecioMisil(int pPrecioMisil) {
        this.precioMisil.setText(Integer.toString(pPrecioMisil));
    }

    public void setPrecioMisilDirig(int pPrecioMisilDirig) {
        this.precioMisilDirig.setText(Integer.toString(pPrecioMisilDirig));
    }

    public void setPrecioEscudo(int pPrecioEscudo) {
        this.precioEscudo.setText(Integer.toString(pPrecioEscudo));

    }

    public void setPrecioRadar(int pPrecioRadar) {
        this.precioRadar.setText(Integer.toString(pPrecioRadar));
    }

    public void setCantidadInicialBarcos() {
        this.cantFragata.setText("4");
        this.cantDestr.setText("3");
        this.cantSub.setText("2");
        this.cantPortaav.setText("1");

    }

    public int getPrecioArma(String s){
        if(s == "misil"){
            return Integer.parseInt(precioMisil.getText());
        }else if(s == "miisldirig"){
            return Integer.parseInt(precioMisilDirig.getText());
        }else if(s == "radar"){
            return Integer.parseInt(precioRadar.getText());
        }else if(s == "escudo"){
            return Integer.parseInt(precioEscudo.getText());
        }
        return 0;
    }
}
