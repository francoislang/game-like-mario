package com.lang.personnages;

import com.lang.jeu.main;
import com.lang.objets.Objet;

import javax.swing.*;
import java.awt.*;
import java.io.ObjectStreamException;

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

        if(this.marche == false  ){
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


    public void deplacement(){
        if(main.scene.getxPos() >= 0){
            this.x = this.x - main.scene.getDx();

        }
    }

    // contact detection on the right side of mario
    protected boolean contactAvant(Objet objet) {
        if (this.x + this.largeur < objet.getX() || this.x + this.largeur > objet.getX() + 5 || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()) {
            return false;
        }
        else{
            return true;
        }
    }

    // contact detection on the left side of mario
    protected boolean contactArriere(Objet objet){
        if(this.x > objet.getX() + objet.getLargeur() || this.x + this.largeur < objet.getX() + objet.getLargeur() - 5 ||this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()){
            return false;
        }
        else {
            return true;
        }
    }

    // contact detection below mario
    protected boolean contactDessous(Objet objet){
        if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || this.y + this.hauteur < objet.getY() || this.y + this.hauteur > objet.getY() + 5 ){
            return false;
        }
        else {
            return true;
        }
    }

    // contact detection above mario
    protected boolean contactDessus(Objet objet){
        if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || this.y < objet.getY() +  objet.getHauteur() || this.y > objet.getY() + objet.getHauteur() + 5){
            return false;
        }
        else {
            return true;
        }
    }

    // to avoid problem between detection of object in scene it's necessary to create this method
    public boolean proche(Objet objet){
        if((this.x > objet.getX() - 10 && this.x < objet.getX() + objet.getLargeur() + 10) || (this.x + this.largeur > objet.getX() - 10 && this.x  + this.largeur < objet.getX() + objet.getLargeur() + 10))
        {
            return true;
        }
        else{
            return  false;
        }
    }
}
