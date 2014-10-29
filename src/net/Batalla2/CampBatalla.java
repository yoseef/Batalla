/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Batalla2;

import acm.graphics.GImage;
import acm.graphics.GLine;
import acm.program.GraphicsProgram;

/**
 *
 * @author user
 */
public class CampBatalla extends GraphicsProgram {

    double espaiFila;
    GLine linia;

    public void run() {
        this.setSize(950, 700);
        System.out.println(this.getHeight());
        int numFiles = 5;
        espaiFila = this.getHeight() / numFiles;

        //dibuxar les lineas al camp:
        for (int i = 1; i < 8; i++) {
            linia = new GLine(0, espaiFila * i, this.getWidth(), espaiFila * i);
            add(linia);
        }
        Exercit romans = new Exercit(this.getWidth());
        for (int i = 0; i < 15; i++) {
            GImage img = new GImage("1.png");
            this.add(img, 0, 0);            
            img.setSize(50, espaiFila);
            Soldat nouSoldat = new Soldat(img, "romans");
            romans.afegirSoldat(nouSoldat);
        }
        romans.formarExercit(0, numFiles);

        Exercit mitics = new Exercit(this.getWidth());
        for (int i = 0; i < 15; i++) {
            GImage img = new GImage("4.png");                       
            this.add(img, 0, 0);            
            img.setSize(50, espaiFila);
            Soldat nouSoldat = new Soldat(img, "mitics");
            mitics.afegirSoldat(nouSoldat);
        }
        mitics.formarExercit(this.getWidth() - (int) mitics.getObtenirSoldat(0).getWidth(), numFiles);
        int direc = 1;
        while (romans.getSoldats().size() > 0 && mitics.getSoldats().size() > 0) {

            if (!romans.getposDesti()) {
                romans.atacar(direc);
                this.pause(100);
            } else {                
                 if (direc == 1) {
                 direc = -1;
                 } else {
                 direc = 1;
                 }
                 romans.setposDesti(false);
                 romans.resetPosDesti();
                 
            }
            romans.comprovarMorts(mitics);

            if (!mitics.getposDesti()) {
                mitics.atacar(-direc);
                this.pause(100);
            } else {
                
                 if (direc == 1) {
                 direc = -1;
                 } else {
                 direc = 1;
                 }
                 mitics.setposDesti(false);
                 mitics.resetPosDesti();
                 
            }
            mitics.comprovarMorts(romans);
        }
    }
}
