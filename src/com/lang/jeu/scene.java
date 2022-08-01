package com.lang.jeu;

import javax.swing.*;
import java.awt.*;

public class scene extends JPanel {

    private ImageIcon icoFond;
    private Image imgFond1;

    private ImageIcon icoMario;
    private Image imgMario;

    private int xFond1;

    private int dx;

    // constructor
    public scene(){
        super();

        this.xFond1 = -50;

        this.dx = 0;

        icoFond = new   ImageIcon(getClass().getResource("/images/fondEcran.png"));
        this.imgFond1 = this.icoFond.getImage();

        icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new clavier());

        Thread chronoEcran = new Thread(new chrono());
        chronoEcran.start();
    }





    // getters
    public int getDx(){
        return dx;
    }

    // setters
    public void setDx(int dx){
        this.dx = dx;
    }


   // methods


    public void deplacementFond(){
        this.xFond1 = this.xFond1 - this.dx;
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;

        this.deplacementFond();

        g2.drawImage(this.imgFond1, this.xFond1, 0, null);
        g2.drawImage(imgMario, 300, 245, null);

    }

}
