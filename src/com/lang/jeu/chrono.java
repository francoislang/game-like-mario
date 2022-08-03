// define repaint background

package com.lang.jeu;


public class chrono implements Runnable{

    private final int PAUSE = 3; // waiting time between two loop turn

    public void run(){

        while(true){
            main.scene.repaint();

            try{
                Thread.sleep(PAUSE);
            }catch(InterruptedException e){
            }

        }

    }

}
