package com.lang.objets;

import javax.swing.*;
import java.awt.*;

public class Bloc extends Objet{

    // variable

    private Image imgBloc;
    private ImageIcon icoBloc;

    // constructor

    public Bloc(int x, int y){
        super(x, y, 43, 65);
        this.icoBloc = new ImageIcon(getClass().getResource("/images/bloc.png"));
        this.imgBloc = this.icoBloc.getImage();
    }

    // getters

    public Image getImgBloc(){
        return imgBloc;
    }
}
