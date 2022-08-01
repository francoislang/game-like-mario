package com.lang.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class clavier implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            main.scene.setDx(1);
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            main.scene.setDx(-1);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        main.scene.setDx(0);

    }
}
