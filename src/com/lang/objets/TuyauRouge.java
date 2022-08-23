package com.lang.objets;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TuyauRouge extends Objet{

    // variable



    // constructor

    public TuyauRouge(int x, int y){
        super(x, y, 43, 65);
        super.icoObjet = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
        super.imgObjet = this.icoObjet.getImage();
    }

    // getters


}

