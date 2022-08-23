package com.lang.personnages;

import com.lang.jeu.main;

import javax.swing.*;
import java.awt.*;

public class Mario extends Personnage{

    // variables
    private Image imgMario;
    private ImageIcon icoMario;

    private boolean saut; // true if mario jump
    private int compteurSaut; // this variable is used to manage jump duration

    //constructor
    public Mario(int x, int y){

        super(x, y, 28, 50);
        this.icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();

        this.saut = false;
        this.compteurSaut = 0;
    }

    // getters

    public Image getImgMario(){
        return imgMario;
    }

    public boolean isSaut(){
        return saut;
    }

    // setters
    public void setSaut(boolean saut){
        this.saut = saut;
    }

    // methods

    public Image saute(){

        ImageIcon ico;
        Image img;
        String str;

        this.compteurSaut++;
        // rise of the jump

        if(this.compteurSaut <= 35){
            if(this.getY() > main.scene.getHautPlafond()){
                this.setY(this.getY() - 4);
            }
            else{
                this.compteurSaut = 36;
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


}
