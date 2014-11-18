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
    double h = 0;
    double w =0;

    public Rey(final GImage imatge, final int b , double widthCanvas , double heightCanvas) {
        setbandol(b);
        super.setImg(imatge);
        h = heightCanvas;
        w = widthCanvas;        
    }

    @Override
    public void formar(final double x, final double y) {
        if(super.getbandol() > 1 ){
            super.setLocation(0, r.nextInt((int)h));
        }else{
            super.setLocation(w - getWidth(), r.nextInt((int)h));
        }
    }

    @Override
    public int moure(final double desti) {
        if (getbandol() > 0 && getY() < 0) {
            setVelo();
            getImg().move(0, getVelo() * getbandol());
            return 1;
        } else if (getbandol() < 0 && getY() >= h) {
            setVelo();
            getImg().move(0, getVelo() * getbandol());
            return 1;
        } else {
            return 0;
        }
    }

}
