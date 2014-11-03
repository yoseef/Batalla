/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Batalla2;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 *
 * @author user
 */
public class CampBatalla extends GraphicsProgram {

    int direc = 1;

    public void run() {
        this.setSize(800, 600);
        int numFiles = 5;

        Exercit romans = new Exercit(this.getWidth());
        for (int i = 0; i < 10; i++) {
            GImage img = new GImage("1.png");
            this.add(img, 0, 0);
            Soldat nouSoldat = new Soldat(img);
            romans.afegirSoldat(nouSoldat);
        }
        romans.formarExercit(direc, numFiles);

        Exercit mitics = new Exercit(this.getWidth());
        for (int i = 0; i < 10; i++) {
            GImage img = new GImage("4.png");
            this.add(img, 0, 0);
            Soldat nouSoldat = new Soldat(img);
            mitics.afegirSoldat(nouSoldat);
        }
        mitics.formarExercit(-direc, numFiles);

        play(romans, mitics);
    }

    public void play(Exercit romans, Exercit mitics) {
        //int minSoldats = Math.min(romans.getSoldats().size(), mitics.getSoldats().size());
        while (romans.getSoldats().size() > 0 && mitics.getSoldats().size() > 0) {
            int minSoldats = Math.min(romans.getSoldats().size(), mitics.getSoldats().size());
            boolean atakar = romans.atacar(direc);
            if (atakar) {
                //"Han arribat"
                direc *= -1;
                romans.formarExercit(direc, minSoldats);
            }
            romans.comprovarMorts(mitics);
            

            boolean atakarOponent = mitics.atacar(-direc);
            if (atakarOponent) {
                //"Han arribat"
                direc *= -1;
                //int minSoldats = Math.min(romans.getSoldats().size(), mitics.getSoldats().size());
                mitics.formarExercit(direc, minSoldats);
            }
            mitics.comprovarMorts(romans);
            //minSoldats = Math.min(romans.getSoldats().size(), mitics.getSoldats().size());
            this.pause(60);
        }
    }
}
