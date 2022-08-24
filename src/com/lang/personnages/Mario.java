package com.lang.personnages;

import com.lang.jeu.main;
import com.lang.objets.Objet;
import com.lang.objets.Piece;

import javax.swing.*;
import java.awt.*;

public class Mario extends Personnage{

    // variables
    private Image imgMario;
    private ImageIcon icoMario;

    private boolean saut; // true if mario jump
    private int compteurSaut; // this variable is used to manage jump duration

    private boolean marche; // true when character walks
    private boolean versDroite; // true when character is turned to the right
    public int compteur; // counter step character

    //constructor
    public Mario(int x, int y){

        super(x, y, 28, 50);
        this.icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();

        this.saut = false;
        this.compteurSaut = 0;

        this.compteur = 0;
        this.marche = false;
        this.versDroite = true;
    }

    // getters

    public Image getImgMario(){
        return imgMario;
    }

    public boolean isSaut(){
        return saut;
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

    // setters
    public void setSaut(boolean saut){
        this.saut = saut;
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

    @Override
    public Image marche(String nom, int frequence){

        String str;
        ImageIcon ico;
        Image img;

        if(this.marche == false || main.scene.getxPos() < 0 || main.scene.getxPos() >= 4430){
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


    public Image saute(){

        ImageIcon ico;
        Image img;
        String str;

        this.compteurSaut++;
        // rise of the jump

        if(this.compteurSaut <= 40){
            if(this.getY() > main.scene.getHautPlafond()){
                this.setY(this.getY() - 4);
            }
            else{
                this.compteurSaut = 41;
            }
            if (this.isVersDroite() == true){
                str = "/images/marioSautDroite.png";
            }
            else {
                str = "/images/marioSautGauche.png";
            }
        }

        // jump descent

        else if (this.getY() + this.getHauteur() < main.scene.getySol()) {
            this.setY(this.getY() + 1);
            if (this.isVersDroite() == true){
                str = "/images/marioSautDroite.png";
            }
            else{
                str = "/images/marioSautGauche.png";
            }
        }

        // end of the jump

        else {
            if(this.isVersDroite() == true){
                str = "/images/marioArretDroite.png";
            }
            else {
                str = "/images/marioArretGauche.png";
            }
            this.saut = false;
            this.compteurSaut = 0;
        }

        // print mario picture
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

    public void contact(Objet objet){
        // horizontal contact
        if((super.contactAvant(objet) == true && this.isVersDroite() == true) || (super.contactArriere(objet) == true && this.isVersDroite() == false)){
            main.scene.setDx(0);
            this.setMarche(false);
        }

        // below contact
        if(super.contactDessous(objet) == true && this.saut == true){ // mario jump on an object
            main.scene.setySol(objet.getY());
        } else if (super.contactDessous(objet) == false) { // mario fall on an object
            main.scene.setySol(293); // initial value of the ground
            if(this.saut == false){
                this.setY(243); // initial altitude of mario
            }
            
        }

        // above contact
        if(super.contactDessus(objet) == true){
            main.scene.setHautPlafond(objet.getY() + objet.getHauteur()); // ceiling become the bottom of the object
        } else if (super.contactDessus(objet) == false && this.saut == false) {
            main.scene.setHautPlafond(0); // normal altitude of the ceiling
            
        }

    }

    public boolean contactPiece(Piece piece){
        if (this.contactArriere(piece) == true || this.contactAvant(piece) == true || this.contactDessus(piece) == true || this.contactDessous(piece) == true){
            return true;
        }
        else {
            return false;
        }
    }



}
