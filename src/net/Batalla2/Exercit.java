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
    private double puntInicial;

    //constructor
    public Exercit(double widthCanvas) {
        exercit = new ArrayList<>();
        r = new Random();        
        canvasWidth = widthCanvas;        
        puntInicial = 0;
    }

    //getters:
    
    public Soldat getObtenirSoldat(int pos) {
        return exercit.get(pos);
    }   
    
    public ArrayList<Soldat> getSoldats() {
        return exercit;
    }

    //setter    

    //metodes de classe
    public void afegirSoldat(Soldat nouSoldat) {
        exercit.add(nouSoldat);
    }

    /**
     * @param numFiles que hihaura
     * @param pI inidica quina pos estaran dreta o esquerra
     */
    public void formarExercit(int pI, int numFiles) {
  
        int[] files = new int[numFiles];
        for (int i = 0; i < exercit.size(); i++) {
            int numAleat = r.nextInt(files.length);
            files[numAleat] += 1;
        }
        int count = 0;
        for (int i = 0; i < files.length; i++) {
            for (int j = 0; j < files[i]; j++) {
                if (count < exercit.size()) {
                    double h = i * exercit.get(count).getHeight() + i * 15;
                    double w;
                    if (pI > 0) {
                        w = exercit.get(count).getWidth() * j;
                    } else {
                        puntInicial = canvasWidth - exercit.get(count).getWidth();
                        w = puntInicial - (exercit.get(count).getWidth() * j);
                    }
                    exercit.get(count).formar(w, h);
                    count++;
                }
            }
        }
    }

    /**
     *
     * @param direccioX
     */
    boolean hanArribat = true;
    public boolean atacar(int direccioX) {
        double desti;
        int totalMoguts = 0;
        for (int i = 0; i < exercit.size(); i++) {
            if (direccioX > 0) {
                //dreta
                desti = canvasWidth - exercit.get(i).getWidth();
            } else {
                //esquerra 
                desti = 0;
            }
            totalMoguts += exercit.get(i).moure(direccioX, desti);
            if (totalMoguts == 0) {
                hanArribat = true;
            } else {
                hanArribat = false;
            }
        }
        return hanArribat;
    }

    public void comprovarMorts(Exercit exercitOponent) {
        for (int i = 0; i < exercit.size(); i++) {
            for (int j = 0; j < exercitOponent.getSoldats().size(); j++) {
                if (exercit.get(i).intersecta(exercitOponent.getSoldats().get(j))) {
                    exercitOponent.getObtenirSoldat(j).borrarImatge();
                    exercitOponent.getSoldats().remove(j);
                }
            }
        }
    }
}
