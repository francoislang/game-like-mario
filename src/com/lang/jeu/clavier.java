//define keyboard action

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

            //fix castle and start game
            
            if (main.scene.getxPos() == -1){
                main.scene.setxPos(0);  // reset xPos
                main.scene.setxFond1(-50); // rest xFond1
                main.scene.setxFond2(750); // reset xFond2
            }
            main.scene.mario.setMarche(true);
            main.scene.mario.setVersDroite(true);
            main.scene.setDx(1); // scene movement to the left

        // left movement
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if (main.scene.getxPos() == 4431){
                main.scene.setxPos(4430);
                main.scene.setxFond1(-50);
                main.scene.setxFond2(750);
            }

            main.scene.mario.setMarche(true);
            main.scene.mario.setVersDroite(false);
            main.scene.setDx(-1); // scene movement to the right
        }

        // mario jump
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            main.scene.mario.setSaut(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // this function is necessary to stop the scene movement when we release a move button
        main.scene.mario.setMarche(false);
        main.scene.setDx(0);

    }
}
