/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Batalla2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author user
 */
public class Exercit {

    /**
     * Guarda tots el soldats.
     */
    private final ArrayList<Soldat> exercit;
    /**
     * crea enters aleatoris.
     */
    private final Random r;
    /**
     * necessitem calcluar la mida del camp per poder controlar els soldats.
     */
    private final double canvasWidth;
    /**
     * indica si el soldat ha arribat el desti.
     */
    boolean hanArribat;

    /**
     *
     * @param midaCamp la mida del camp
     */
    public Exercit(final double midaCamp) {
        exercit = new ArrayList<>();
        r = new Random();
        canvasWidth = midaCamp;
        hanArribat = true;
    }

    /**
     *
     * @param pos si volem un soldat especific apartir de la posicio
     * @return retorna el soldat de la posicio
     */
    public final Soldat getObtenirSoldat(final int pos) {
        return exercit.get(pos);
    }

    /**
     *
     * @return la array amb tots els soldats.
     */
    public final ArrayList<Soldat> getSoldats() {
        return exercit;
    }

    /**
     *
     * @param nouSoldat va afegint soldats a l'array
     */
    public final void afegirSoldat(final Soldat nouSoldat) {
        exercit.add(nouSoldat);
    }

    /**
     *
     * @param numFiles fer la formacio apartir del numero de files
     */
    public final void formarExercit(final int numFiles) {

        int[] files = new int[numFiles];
        for (int i = 0; i < exercit.size(); i++) {
            int numAleat = r.nextInt(files.length);
            files[numAleat] += 1;
        }
        int count = 0;
        for (int i = 0; i < files.length; i++) {
            for (int j = 0; j < files[i]; j++) {
                if (count < exercit.size()) {
                    double h = i * exercit.get(count).getHeight() + i * N15;
                    double w;
                    if (exercit.get(count).getbandol() > 0) {
                        w = exercit.get(count).getWidth() * j;
                    } else {
                        double formEsque = canvasWidth
                                - exercit.get(count).getWidth();
                        w = formEsque - (exercit.get(count).getWidth() * j);
                    }
                    exercit.get(count).formar(w, h);
                    count++;
                }
            }
        }
    }
    /**
     * numero 15.
     */
    private static final int N15 = 15;
    /**
     *
     * @return false si tots els soldats encara es poden moure i true si jan han
     * arribat i no poden moure.
     */
    public final boolean atacar() {
        double desti;
        int totalMoguts = 0;
        for (int i = 0; i < exercit.size(); i++) {
            if (exercit.get(i).getbandol() > 0) {
                //dreta
                desti = canvasWidth - exercit.get(i).getWidth();
            } else {
                //esquerra
                desti = 0;
            }
            totalMoguts += exercit.get(i).moure(desti);
            if (totalMoguts == 0) {
                hanArribat = true;
            } else {
                hanArribat = false;
            }
        }
        return hanArribat;
    }

    /**
     *
     * @param exOponent el seguent exercit amb el que es compara si han
     * xucat
     */
    public final void comprovarMorts(final Exercit exOponent) {
        for (int i = 0; i < exercit.size(); i++) {
            for (int j = 0; j < exOponent.getSoldats().size(); j++) {
                if (exercit.get(i).intersecta(exOponent.getSoldats().get(j))) {
                    exOponent.getObtenirSoldat(j).setImg("exp.png");
                    exOponent.getObtenirSoldat(j).borrarImatge();
                    exOponent.getSoldats().remove(j);
                }
            }
        }
    }

    /**
     * canvia la direccio de al soldat perque vagi en sentit contrari.
     */
    public final void changeDireccio() {
        for (Soldat sldt : exercit) {
            int tmp = sldt.getbandol() * -1;
            sldt.setbandol(tmp);
        }
    }
}
