//define keyboard movement

package com.lang.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class clavier implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        // right movement
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (main.scene.getxPos() == -1){
                main.scene.setxPos(0);
                main.scene.setxFond1(-50);
                main.scene.setxFond2(750);
            }

            main.scene.setDx(1);

        // left movement
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            main.scene.setDx(-1);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        main.scene.setDx(0);

    }
}
