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
public class Heroi extends SoldatGeneral {

    public Heroi(final GImage imatge, final int b, double widthCanvas, double heightCanvas) {
        setbandol(b);
        setImg(imatge);
        h = heightCanvas;
        w = widthCanvas;
    }    

    @Override
    public int moure(double desti) {
        if (getbandol() > 0) {
            setVelo();
            getImg().move(getVelo(), getVelo());
            return 1;
        } else if (getbandol() < 0) {
            getImg().move(-getVelo(), getVelo());
            return 1;
        }
        return 0;
    }

}
