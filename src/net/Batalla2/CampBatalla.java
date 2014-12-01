/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Batalla2;

import acm.graphics.GImage;
import acm.graphics.GLabel;
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
            img = new GImage("img/1.png");
            this.add(img, 0, 0);
            romans.afegirSoldat(new Soldat(img, direc));
        }
        img = new GImage("img/H.png");
        this.add(img, 0, 0);
        romans.afegirSoldat(new Heroi(img, direc, this.getWidth(),
                this.getHeight()));

        img = new GImage("img/K.png");
        this.add(img, 0, 0);
        romans.afegirSoldat(new Rey(img, direc, this.getWidth(),
                this.getHeight()));
        img = new GImage("img/Grand.png");
        this.add(img, 0, 0);
        romans.afegirSoldat(new Grandollon(img, direc));
        romans.formarExercit(numFiles);

        Exercit mitics = new Exercit(this.getWidth());
        for (int i = 0; i < N15; i++) {
            img = new GImage("img/4.png");
            this.add(img, 0, 0);
            Soldat nouSoldat = new Soldat(img, -direc);
            mitics.afegirSoldat(nouSoldat);
        }
        img = new GImage("img/H2.png");
        this.add(img, 0, 0);
        mitics.afegirSoldat(new Heroi(img, -direc, this.getWidth(),
                this.getHeight()));
        img = new GImage("img/K2.png");
        this.add(img, 0, 0);
        mitics.afegirSoldat(new Rey(img, -direc, this.getWidth(),
                this.getHeight()));
        img = new GImage("img/Grand2.png");
        this.add(img, 0, 0);
        mitics.afegirSoldat(new Grandollon(img, -direc));
        mitics.formarExercit(numFiles);
        clicaPerComencar();
        play(romans, mitics);
    }
    /**
     * numero de soldats que volem tenir.
     */
    private static final int N15 = 15;
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
     * Mostra una etiqueta, i espera fins que es cliqui.
     */
    private void clicaPerComencar() {
        GLabel label = new GLabel("Clica per començar");
        double x = (getWidth() - label.getWidth()) / 2;
        double y = (getHeight() + label.getAscent()) / 2;
        add(label, x, y);
        waitForClick();
        remove(label);
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
