package Vista;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Josu on 16/04/2017.
 */
public class InfoJugador extends JPanel {

    private JLabel dinero, disp, cantDinero;


    private JLabel selArmas, bomba, misil, misildirig, escudo, radar;
    private JLabel cantBomba, cantMisil, cantMisildirig, cantEscudo, cantRadar;

    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton rbBomba = new JRadioButton(), rbMisil = new JRadioButton(), rbMisilDirig = new JRadioButton(), rbRadar = new JRadioButton(), rbEscudo = new JRadioButton();


    private JButton comprarArma;


    public InfoJugador() {
        initializeGui();
    }

    public void initializeGui() {
        this.setLayout(new GridLayout(10, 3));
        this.setBorder(new LineBorder(Color.BLACK));
        this.setBackground(Color.WHITE);

        this.dinero = new JLabel("Dinero");
        this.disp = new JLabel(" disponible ");
        this.dinero.setHorizontalAlignment(JLabel.RIGHT);
        this.disp.setHorizontalAlignment(JLabel.LEFT);
        Font font = new Font("Times New Roman", 2, 24);
        this.dinero.setFont(font);
        this.disp.setFont(font);
        this.add(dinero);
        this.add(disp);
        this.cantDinero = new JLabel("");
        this.add(cantDinero);

        this.add(new JSeparator(0));
        this.add(new JSeparator(0));
        this.add(new JSeparator(0));

        JLabel label = new JLabel("Selector ");
        this.selArmas = new JLabel("de armas");
        label.setHorizontalAlignment(JLabel.RIGHT);
        this.selArmas.setHorizontalAlignment(JLabel.LEFT);
        label.setFont(font);
        this.selArmas.setFont(font);
        this.add(label);
        this.add(selArmas);
        this.add(new JLabel(""));

        this.add(new JSeparator(0));
        this.add(new JSeparator(0));
        this.add(new JSeparator(0));

        Font fArmas = new Font("Tahoma", 0, 16);

        this.bomba = new JLabel("Bombas");
        this.bomba.setHorizontalAlignment(JLabel.CENTER);
        this.bomba.setFont(fArmas);
        this.add(bomba);
        this.cantBomba = new JLabel("∞");
        this.cantBomba.setHorizontalAlignment(JLabel.CENTER);
        this.cantBomba.setFont(fArmas);
        this.add(cantBomba);
        this.rbBomba.setHorizontalAlignment(JLabel.CENTER);
        this.rbBomba.setSelected(true);
        this.buttonGroup.add(rbBomba);
        this.add(rbBomba);

        this.misil = new JLabel("Misiles");
        this.misil.setHorizontalAlignment(JLabel.CENTER);
        this.misil.setFont(fArmas);
        this.add(misil);
        this.cantMisil = new JLabel("-");
        this.cantMisil.setHorizontalAlignment(JLabel.CENTER);
        this.cantMisil.setFont(fArmas);
        this.add(cantMisil);
        this.rbMisil.setHorizontalAlignment(JLabel.CENTER);
        this.buttonGroup.add(rbMisil);
        this.add(rbMisil);

        this.misildirig = new JLabel("Misiles dirigidos");
        this.misildirig.setHorizontalAlignment(JLabel.CENTER);
        this.misildirig.setFont(fArmas);
        this.add(misildirig);
        this.cantMisildirig = new JLabel("-");
        this.cantMisildirig.setHorizontalAlignment(JLabel.CENTER);
        this.cantMisildirig.setFont(fArmas);
        this.add(cantMisildirig);
        this.rbMisilDirig.setHorizontalAlignment(JLabel.CENTER);
        this.buttonGroup.add(rbMisilDirig);
        this.add(rbMisilDirig);

        this.radar = new JLabel("Radares");
        this.radar.setHorizontalAlignment(JLabel.CENTER);
        this.radar.setFont(fArmas);
        this.add(radar);
        this.cantRadar = new JLabel("-");
        this.cantRadar.setHorizontalAlignment(JLabel.CENTER);
        this.cantRadar.setFont(fArmas);
        this.add(cantRadar);
        this.rbRadar.setHorizontalAlignment(JLabel.CENTER);
        this.buttonGroup.add(rbRadar);
        this.add(rbRadar);

        this.escudo = new JLabel("Escudos");
        this.escudo.setHorizontalAlignment(JLabel.CENTER);
        this.escudo.setFont(fArmas);
        this.add(escudo);
        this.cantEscudo = new JLabel("-");
        this.cantEscudo.setHorizontalAlignment(JLabel.CENTER);
        this.cantEscudo.setFont(fArmas);
        this.add(cantEscudo);
        this.rbEscudo.setHorizontalAlignment(JLabel.CENTER);
        this.buttonGroup.add(rbEscudo);
        this.add(rbEscudo);

        this.comprarArma = new JButton("Comprar arma");
        this.comprarArma.setActionCommand("comprar");
        this.add(new JLabel(""));
        this.add(comprarArma);
        this.add(new JLabel(""));

        this.rbBomba.setActionCommand("bomba");
        this.rbMisil.setActionCommand("misil");
        this.rbMisilDirig.setActionCommand("misildirig");
        this.rbRadar.setActionCommand("radar");
        this.rbEscudo.setActionCommand("escudo");
    }

    public void añadirListenerCompra(ActionListener actionListener) {
        this.comprarArma.addActionListener(actionListener);
    }

    public void setCantDinero(int i) {
        this.cantDinero.setText(Integer.toString(i));
    }

    public void setCantMisil(int i) {
        this.cantMisil.setText(Integer.toString(i));
    }

    public void setCantMisildirig(int i) {
        this.cantMisildirig.setText(Integer.toString(i));
    }

    public void setCantEscudo(int i) {
        this.cantEscudo.setText(Integer.toString(i));
    }

    public void setCantRadar(int i) {
        this.cantRadar.setText(Integer.toString(i));
    }

    public String getSeleccionArma() {
        return buttonGroup.getSelection().getActionCommand();
    }


}
