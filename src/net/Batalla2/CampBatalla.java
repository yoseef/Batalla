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
        for (int i = 0; i < N10; i++) {
            GImage img = new GImage("1.png");
            this.add(img, 0, 0);
            romans.afegirSoldat(new Soldat(img, direc));
        }
        romans.formarExercit(numFiles);

        Exercit mitics = new Exercit(this.getWidth());
        for (int i = 0; i < N10; i++) {
            GImage img = new GImage("4.png");
            this.add(img, 0, 0);
            Soldat nouSoldat = new Soldat(img, -direc);
            mitics.afegirSoldat(nouSoldat);
        }
        mitics.formarExercit(numFiles);

        play(romans, mitics);
    }
    /**
     * numero de soldats que volem tenir.
     */
    private static final int N10 = 10;
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
                int minSldts = Math.min(roma.getSoldats().size(),
                        mitics.getSoldats().size());
                //"Han arribat"
                roma.changeDireccio();
                roma.formarExercit(minSldts);
            }
            roma.comprovarMorts(mitics);

            boolean atakarOponent = mitics.atacar();
            if (atakarOponent) {
                int minSldts = Math.min(roma.getSoldats().size(),
                        mitics.getSoldats().size());
                //"Han arribat"
                mitics.changeDireccio();
                mitics.formarExercit(minSldts);
            }
            mitics.comprovarMorts(roma);
            this.pause(N50);
        }
    }
    /**
     * numero 50.
     */
    private static final int N50 = 50;
}
