package com.lang.objets;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TuyauRouge extends Objet{

    // variable

    private Image imgTuyauRouge;
    private ImageIcon icoTuyauRouge;

    // constructor

    public TuyauRouge(int x, int y){
        super(x, y, 43, 65);
        this.icoTuyauRouge = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
        this.imgTuyauRouge = this.icoTuyauRouge.getImage();
    }

    // getters

    public Image getImgTuyauRouge(){
        return imgTuyauRouge;
    }
}

