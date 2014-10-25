/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Batalla2;

import acm.graphics.GImage;
import acm.graphics.GLine;
import acm.program.GraphicsProgram;
import java.awt.Color;

/**
 *
 * @author user
 */
public class CampBatalla extends GraphicsProgram {

    int espaiFila;
    GLine linia;

    public void run() {
        this.setSize(800, 600);
        int numFiles = 8;
        espaiFila = this.getHeight() / numFiles;

        //dibueixar les lineas al camp:
        for (int i = 1; i < 8; i++) {
            linia = new GLine(0, espaiFila * i, this.getWidth(), espaiFila * i);
            add(linia);
        }
        Exercit romans = new Exercit(numFiles);
        for (int i = 0; i < 15; i++) {
            GImage img = new GImage("MB.png");
            this.add(img, 0, 0);
            img.setSize(100, espaiFila);
            Soldat nouSoldat = new Soldat(img);
            romans.afegirSoldat(nouSoldat);
        }
        romans.formarExercit(0);
    }
}
