// define the game's stage

package com.lang.jeu;

import com.lang.objets.Bloc;
import com.lang.objets.TuyauRouge;
import com.lang.personnages.Mario;

import javax.swing.*;
import java.awt.*;

public class scene extends JPanel {

    // Variables
    private ImageIcon icoFond;
    private Image imgFond1;
    private Image imgFond2;



    private ImageIcon icoChateau1;
    private Image imgChateau1;

    private ImageIcon icoDepart;
    private Image imgDepart;

    private int xFond1;
    private int xFond2;

    private int dx;

    private int xPos;

    private int ySol; // normal height of the ground

    private int hauteurPlafond; // normal height of ceiling

    public Mario mario;
    public TuyauRouge tuyauRouge1;
    public Bloc bloc1;

    // constructor
    public scene(){
        super();

        this.xFond1 = -50;
        this.xFond2 = 750;

        this.dx = 0;
        this.xPos = -1;

        this.ySol = 293;
        this.hauteurPlafond = 0;

        icoFond = new   ImageIcon(getClass().getResource("/images/fondEcran.png"));
        this.imgFond1 = this.icoFond.getImage();
        this.imgFond2 = this.icoFond.getImage();



        this.icoChateau1 = new ImageIcon((getClass().getResource("/images/chateau1.png")));
        this.imgChateau1 = this.icoChateau1.getImage();

        this.icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
        this.imgDepart = this.icoDepart.getImage();

        mario = new Mario(300, 245);
        tuyauRouge1 = new TuyauRouge(600, 230);
        bloc1 = new Bloc(400, 180);

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
    public int getxPos(){
        return xPos;
    }

    public int getySol(){
        return ySol;
    }

    public int getHautPlafond(){
        return hauteurPlafond;
    }

    // setters
    public void setDx(int dx){
        this.dx = dx;
    }
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setxFond1(int xFond1){
        this.xFond1 = xFond1;
    }

    public void setxFond2(int xFond2){
        this.xFond2 = xFond2;
    }

    // methods


    // screen movement to show Mario movement
    public void deplacementFond(){


        // stop left movement at start of the game
        if (this.xPos >= 0) {
            this.xPos = this.xPos + this.dx;
            this.xFond1 = this.xFond1 - this.dx;
            this.xFond2 = this.xFond2 - this.dx;
        }

        // repeat background with 2 images
        if (this.xFond1 == -800){
            this.xFond1 = 800;
        } else if (this.xFond2 == 800) {
            this.xFond2 = -800;
        } else if (this.xFond1 == 800) {
            this.xFond1 = -800;

        } else if (this.xFond2 == -800) {
            this.xFond2 = 800;

        }
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;

        // contact with object

        if(this.mario.contactAvant(tuyauRouge1) == true){
            this.mario.setMarche(false);
            this.dx = 0;
        }

        this.deplacementFond();
        this.tuyauRouge1.deplacement();



        g2.drawImage(this.imgFond1, this.xFond1, 0, null);
        g2.drawImage(this.imgFond2, this.xFond2, 0, null);


        g2.drawImage(imgChateau1, 10 - this.xPos, 95, null);
        g2.drawImage(imgDepart, 220 - this.xPos, 234, null);

        g2.drawImage(this.tuyauRouge1.getImgTuyauRouge(), this.tuyauRouge1.getX(), this.tuyauRouge1.getY(), null);
        g2.drawImage(this.bloc1.getImgBloc(), this.bloc1.getX() - this.xPos , this.bloc1.getY(), null);

        if(this.mario.isSaut()){
            g2.drawImage(this.mario.saute(), this.mario.getX(), this.mario.getY(), null);
        }
        else {
            g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);
        }


    }

}
