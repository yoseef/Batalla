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

    public Soldat(GImage imatge) {
        img = imatge;
        r = new Random();
    }

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

    public void moure(int direccioX) {
        img.move(direccioX, img.getY());
    }

    public void formar(double x, double y) {
        img.setLocation(x, y);
    }

    public GRectangle rectangleSoldat() {
        return img.getBounds();
    }

    private void setVelo() {
        velocitat = r.nextInt(10);
    }

}
