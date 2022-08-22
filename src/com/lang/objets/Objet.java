package com.lang.objets;

import com.lang.jeu.main;

public class Objet {

    // variable
    private int largeur, hauteur; // object dimension
    private int x, y; // object position

    //constructor
    public Objet(int x, int y, int largeur, int hauteur){

        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
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

    // setters

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setLarg(int largeur){
        this.largeur = largeur;
    }

    public void setHaut(int hauteur){
        this.hauteur = hauteur;
    }


    //methods

    public void deplacement(){
        if(main.scene.getxPos() >= 0){
            this.x = this.x - main.scene.getDx();

        }
    }
}
