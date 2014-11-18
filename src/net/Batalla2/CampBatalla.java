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

    /**
     * direccio general que agafar l'exercit(pos inicial).
     */
    private final int direc = 1;
    /**
     * inica de quantes files constara el camp.
     */
    private final int numFiles = 5;

    @Override
    public final void run() {
        this.setSize(AMPLADA, ALTURA);
        Exercit romans = new Exercit(this.getWidth());
        GImage img;
        for (int i = 0; i < N15; i++) {
            img = new GImage("1.png");
            this.add(img, 0, 0);
            romans.afegirSoldat(new Soldat(img, direc));
        }
        img = new GImage("K.png");
        this.add(img, 0, 0);
        romans.afegirSoldat(new Rey(img, direc,this.getWidth(),this.getHeight()));

        romans.formarExercit(numFiles);

        Exercit mitics = new Exercit(this.getWidth());
        for (int i = 0; i < N15; i++) {
            img = new GImage("4.png");
            this.add(img, 0, 0);
            Soldat nouSoldat = new Soldat(img, -direc);
            mitics.afegirSoldat(nouSoldat);
        }
        mitics.formarExercit(numFiles);
        img = new GImage("K2.png");
        this.add(img, 0, 0);
        mitics.afegirSoldat(new Rey(img, -direc,this.getWidth(),this.getHeight()));

        play(romans, mitics);
    }
    /**
     * numero de soldats que volem tenir.
     */
    private static final int N15 = 10;
    /**
     * altura del de la finestra.
     */
    private static final int ALTURA = 600;
    /**
     * amplada de la finestra.
     */
    private static final int AMPLADA = 800;

    /**
     *
     * @param roma el primer exercit
     * @param mitics l¡exercit contrari
     */
    public final void play(final Exercit roma, final Exercit mitics) {
        while (roma.getSoldats().size() > 0 && mitics.getSoldats().size() > 0) {
            boolean atakar = roma.atacar();
            if (atakar) {
                if (roma.getSoldats().size() < N8
                        || mitics.getSoldats().size() < N8) {
                    int minSldts = Math.min(roma.getSoldats().size(),
                            mitics.getSoldats().size());
                    roma.changeDireccio();
                    roma.formarExercit(minSldts);
                } else {
                    roma.formarExercit(numFiles);
                    roma.changeDireccio();
                }
            }
            roma.comprovarMorts(mitics);

            boolean atakarOponent = mitics.atacar();
            if (atakarOponent) {
                if (roma.getSoldats().size() < N8
                        || mitics.getSoldats().size() < N8) {
                    int minSldts = Math.min(roma.getSoldats().size(),
                            mitics.getSoldats().size());
                    //"Han arribat"
                    mitics.changeDireccio();
                    mitics.formarExercit(minSldts);
                } else {
                    mitics.formarExercit(numFiles);
                    mitics.changeDireccio();
                }
            }
            mitics.comprovarMorts(roma);
            this.pause(N50);
        }
    }
    /**
     * numero 8.
     */
    private static final int N8 = 8;
    /**
     * numero 50.
     */
    private static final int N50 = 50;
}
