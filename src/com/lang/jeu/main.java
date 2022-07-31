package com.lang.jeu;

import javax.swing.*;

public class main {

    public static scene scene;

    public static void main(String[] args) {

        // creation frame
        JFrame fenetre = new JFrame("Jeu style Mario");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(700,360);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setAlwaysOnTop(true);

        // creation objet scene
        scene = new scene();
        fenetre.setContentPane(scene);
        fenetre.setVisible(true);
    }

}
