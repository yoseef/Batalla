/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Batalla2;

import acm.graphics.GImage;
import acm.graphics.GRectangle;
import java.util.Random;

/**
 *
 * @author user
 */
public class Soldat {

    Random r;
    GImage img;
    int velocitat;
    String bandol;
    boolean desti;

    //constructor
    public Soldat(GImage imatge, String nomBandol) {
        img = imatge;
        r = new Random();
        bandol = nomBandol;
        desti = false;
    }

    //getters
    public double getX() {
        return img.getX();
    }

    public double getY() {
        return img.getY();
    }

    public double getWidth() {
        return img.getWidth();
    }

    public double getHeight() {
        return img.getHeight();
    }

    public GRectangle getRectangleSoldat() {
        return img.getBounds();
    }

    public String getBandol() {
        return this.bandol;
    }

    public boolean getDesti() {
        return this.desti;
    }

    //setters
    private void setVelo() {
        velocitat = r.nextInt(15);
    }
    public void setDesti(boolean value){
        this.desti = value;
    }

    //metodes de la classe
    public void formar(double x, double y) {
        img.setLocation(x, y);
    }

    public void moure(int direccioX, double widthCanvas) {
        if (direccioX > 0 && img.getX() <= widthCanvas - img.getWidth()) {
            setVelo();
            img.move(direccioX * velocitat, 0);
        } else if (direccioX < 0 && img.getX() >= 0) {
            setVelo();
            img.move(direccioX * velocitat, 0);
        } else {
            desti = true;
        }
    }

    public boolean intersecta(Soldat soldat2) {
        return this.img.getBounds().intersects(soldat2.getRectangleSoldat());
    }

    public void borrarImatge() {
        img.getParent().remove(img);
        img = null;
    }
}
