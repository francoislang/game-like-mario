package com.lang.personnages;

import javax.swing.*;
import java.awt.*;

public class Mario extends Personnage{

    // variables
    private Image imgMario;
    private ImageIcon icoMario;

    //constructor
    public Mario(int x, int y){

        super(x, y, 28, 50);
        this.icoMario = new ImageIcon("src/images/marioMarcheDroite.png");
        this.imgMario = this.icoMario.getImage();
    }

    // getters

    public Image getImgMario(){
        return imgMario;
    }


}
