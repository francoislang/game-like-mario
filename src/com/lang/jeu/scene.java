package com.lang.jeu;

import javax.swing.*;
import java.awt.*;

public class scene extends JPanel {

    private ImageIcon icoFond;
    private Image imgFond1;

    private ImageIcon icoMario;
    private Image imgMario;

    private int xFond1;
    // constructor
    public scene(){
        super();

        this.xFond1 = -50;

        icoFond = new ImageIcon(getClass().getResource("images/fondEcran.png"));
        this.imgFond1 = this.icoFond().getImage();

        icoMario = new ImageIcon(getClass().getResource("images/marioMarcheDroite.png"));
        this.imgMario = this.icoMario().getImage();

    }


    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;

        g2.drawImage(this.icoFond1, this.xFond1, 0, null);
        g2.drawImage(imgMario, 300, 245, null);

    }

}
