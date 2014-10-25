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

    public Exercit(int numFiles) {
        exercit = new ArrayList<>();
        r = new Random();
        files = numFiles;
    }

    public void afegirSoldat(Soldat nouSoldat) {
        exercit.add(nouSoldat);
    }

    /**
     *
     * @param puntInicial inidica quina pos estaran dreta o esquerra
     */
    public void formarExercit(int puntInicial) {
        /*
         for (Soldat sd : exercit) {
         //passem la x = puntInicial, la y > sera el num de files
         int y = r.nextInt(files) * (int) sd.getHeight();
         sd.formar(puntInicial, y);
            
         }
         */
        for (int i = 0; i < exercit.size(); i++) {
            int y = r.nextInt(files) * (int) exercit.get(i).getHeight();
            exercit.get(i).formar(puntInicial, y);
        }
        for (int i = 0; i < exercit.size() - 1; i++) {
            for (int j = i + 1; j < exercit.size(); j++) {
                if (exercit.get(i).getX() == exercit.get(j).getX()) {
                    exercit.get(i).formar(exercit.get(i).getX() + exercit.get(i).getWidth(), exercit.get(i).getY());
                }
            }
        }
    }

    /**
     *
     * @param direccioX
     */
    public void atacar(int direccioX) {
        for (Soldat sd : exercit) {
            //passem la x = puntInicial, la y > sera el num de files            
            sd.moure(direccioX);
        }
    }

}
