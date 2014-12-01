/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Batalla2;
import acm.graphics.GImage;

/**
 *
 * @author user
 */
public class Rey extends SoldatGeneral {

    public Rey(final GImage imatge, final int b, double widthCanvas, double heightCanvas) {
        setbandol(b);
        super.setImg(imatge);
        h = heightCanvas;
        w = widthCanvas;
    }

    @Override
    public void formar(final double x, final double y) {
        if (super.getbandol() > 0) {
            super.setLocation(0, 0);
            // super.setLocation(0, y);
        } else {
            super.setLocation(w - getWidth(), 0);
            // super.setLocation(w - getWidth(), y);
        }
    }
    boolean adalt;
    boolean abaix;

    @Override
    public int moure(final double desti) {
        setVelo();
        if (getY() <= 0) {
            adalt = true;
        } else if (getY() >= h - getHeight()) {
            adalt = false;
        } 
        if (getY() >= h - getHeight() && desti == 0) {
            getImg().move(0, -getVelo());
            return 1;
        } else if (getY() >= 0 && desti > 0) {
            getImg().move(0, getVelo());
            return 1;
        } else {
            return 0;
        }
    }
}



