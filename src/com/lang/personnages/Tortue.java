package com.lang.personnages;

import javax.swing.*;
import java.awt.*;

public class Tortue extends Personnage implements Runnable{


    private Image imgTortue;
    private ImageIcon icoTortue;

    private final int PAUSE = 15; // waiting time between two loops

    private int dxTortue; // step tortle

    // constructor

    public Tortue (int x, int y){

        super(x, y, 43, 50);
        super.setVersDroite(true);
        super.setMarche(true);

        this.dxTortue = 1;

        this.icoTortue = new ImageIcon(getClass().getResource("/images/tortueArretGauche.png"));
        this.imgTortue = this.icoTortue.getImage();

        Thread chronoTortue = new Thread(this);
        chronoTortue.start();
    }

    // getters

    public Image getImgTortue(){
        return imgTortue;
    }



    // methods

    public void bouge(){
        if(super.isVersDroite() == true){
            this.dxTortue = 1;
        }
        else {
            this.dxTortue = -1;
        }

        super.setX(super.getX() + this.dxTortue);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(20);
        }
        catch (InterruptedException e){}

        while (true){
            this.bouge();
            try{Thread.sleep(PAUSE);}
            catch (InterruptedException e){}
        }
    }
}
