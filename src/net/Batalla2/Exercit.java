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

    ArrayList<Soldat> exercit;
    Random r;
    int files;
    double canvasWidth;
    private boolean posDesti;
    private double puntInicial;

    //constructor
    public Exercit(double widthCanvas) {
        exercit = new ArrayList<>();
        r = new Random();
        //files = numFiles;
        canvasWidth = widthCanvas;
        posDesti = false;
        puntInicial = 0;
    }

    //getters:
    public Soldat getObtenirSoldat(int pos) {
        return exercit.get(pos);
    }

    public boolean getposDesti() {
        return posDesti;
    }

    public ArrayList<Soldat> getSoldats() {
        return exercit;
    }

    //setter
    public void setposDesti(boolean value) {
        this.posDesti = value;
    }

    //metodes de classe
    public void afegirSoldat(Soldat nouSoldat) {
        exercit.add(nouSoldat);
    }

    /**
     * @param numFiles
     * @param pI inidica quina pos estaran dreta o esquerra
     */
    public void formarExercit(double pI, int numFiles) {
        puntInicial = pI;
        int[] files = new int[numFiles];
        int maxSoldat = exercit.size();
        int maxSoldatFila = 5;
        for (int i = 0; i < files.length; i++) {
            int numAleat = r.nextInt(maxSoldatFila);
            files[i] = numAleat;
            maxSoldat = maxSoldat - numAleat;
        }

        if (pI == 0) {
            int count = 0;
            for (int i = 0; i < files.length; i++) {
                for (int j = 0; j < files[i]; j++) {
                    if (count < exercit.size()) {
                        double h = i * exercit.get(count).getHeight() + 5;
                        double w = exercit.get(count).getWidth() * j;
                        exercit.get(count).formar(w, h);
                        count++;
                    }

                }
            }
            if (exercit.size() - count != 0) {

                for (int i = exercit.size() - 1; i >= count; i--) {
                    exercit.get(i).borrarImatge();
                    exercit.remove(i);
                }
            }

        } else {
            int count = 0;
            for (int i = 0; i < files.length; i++) {
                for (int j = 0; j < files[i]; j++) {
                    if (count < exercit.size()) {
                        double h = i * exercit.get(count).getHeight() + 5;
                        double w = pI - (exercit.get(count).getWidth() * j);
                        exercit.get(count).formar(w, h);
                        count++;
                    }

                }
            }
            if (exercit.size() - count != 0) {

                for (int i = exercit.size() - 1; i >= count; i--) {
                    exercit.get(i).borrarImatge();
                    exercit.remove(i);
                }
            }
        }
    }

    /**
     *
     * @param direccioX
     */
    public void atacar(int direccioX) {
        /*
         for (Soldat sd : exercit) {
         if (!sd.getDesti()) {
         sd.moure(direccioX, canvasWidth);
         posDesti = false;
         } else {
         posDesti = true;
         }
         }
         */
        for (int i = 0; i < exercit.size(); i++) {
            if (!exercit.get(i).getDesti()) {
                exercit.get(i).moure(direccioX, canvasWidth);
            } else {
                posDesti = true;
            }
        }

    }

    public void resetPosDesti() {
        for (int i = 0; i < exercit.size(); i++) {
            if (exercit.get(i).getDesti()) {
                exercit.get(i).setDesti(false);
            }
        }
    }

    public void comprovarMorts(Exercit exercitOponent) {
        for (int i = 0; i < exercit.size(); i++) {
            for (int j = 0; j < exercitOponent.getSoldats().size(); j++) {
                if (exercit.get(i).intersecta(exercitOponent.getSoldats().get(j))) {
                    //exercitOponent.getObtenirSoldat(j).borrarImatge();
                    //exercitOponent.getSoldats().remove(j);
                }
            }
        }
    }
}
