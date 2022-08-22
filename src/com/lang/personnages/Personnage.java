package com.lang.personnages;

import com.lang.jeu.main;
import com.lang.objets.Objet;

import javax.swing.*;
import java.awt.*;

public class Personnage {
    //variables

    private int largeur, hauteur; // character dimension
    private int x, y; // character position
    private boolean marche; // true when character walks
    private boolean versDroite; // true when character is turned to the right
    public int compteur; // counter step character

    // Constructor

    public Personnage(int x, int y, int largeur, int hauteur){

        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.compteur = 0;
        this.marche = false;
        this.versDroite = true;
    }

    // getters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public boolean isMarche() {
        return marche;
    }

    public boolean isVersDroite() {
        return versDroite;
    }

    public int getCompteur() {
        return compteur;
    }

    // Setters

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setMarche(boolean marche){
        this.marche = marche;
    }

    public void setVersDroite(boolean versDroite){
        this.versDroite = versDroite;
    }

    public void setCompteur(int compteur){
        this.compteur = compteur;
    }


    // methods
    public Image marche(String nom, int frequence){

        String str;
        ImageIcon ico;
        Image img;

        if(this.marche == false || main.scene.getxPos() <= 0){
            if(this.versDroite == true){
                str = "/images/" + nom + "ArretDroite.png";
            } else{
                str = "/images/" + nom + "ArretGauche.png";
            }
        }else {
            this.compteur++;
            if (this.compteur / frequence == 0){
                if(this.versDroite == true){
                    str = "/images/" + nom + "ArretDroite.png";
                }else{
                    str = "/images/" + nom + "ArretGauche.png";
                }
            }else{
                if(this.versDroite == true){
                    str = "/images/" + nom + "MarcheDroite.png";
                }else{
                    str = "/images/" + nom + "MarcheGauche.png";
                }
            }if(this.compteur == 2*frequence){
                this.compteur = 0;
            }
        }
        //show character picture
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

    public boolean contactAvant(Objet objet){

        if(this.isVersDroite() == true){
            if(this.x + this.largeur <= objet.getX() || this.x + this.largeur >= objet.getX() + 5 || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur())
            {
                return false;
            }
            else{
                return true;
            }

        }else{
            return false;
        }



}
}
