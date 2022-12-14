package com.lang.objets;

import javax.swing.*;
import java.awt.*;

public class Piece extends Objet implements Runnable {

    // variables

    private int compteur;

    private final int PAUSE = 15; // waiting time between two loop

    public Piece(int x, int y) {
        super(x, y, 30, 30);

        super.icoObjet = new ImageIcon(getClass().getResource("/images/piece1.png"));
        super.imgObjet = super.icoObjet.getImage();
    }

    // methods
    public Image bouge() {

        String str;
        ImageIcon ico;
        Image img;

        this.compteur++;
        if (this.compteur / 100 == 0) {
            str = "/images/piece1.png";
        } else {
            str = "/images/piece2.png";
        }
        if (this.compteur == 200) {
            this.compteur = 0;
        }

        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(20); // time to allow that all object appear before run the infinite loop
        } catch (InterruptedException e) {
        }

        while (true) {
            this.bouge();
            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
            }
        }
    }
}
