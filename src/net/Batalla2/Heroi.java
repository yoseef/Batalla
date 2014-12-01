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
    /**
     * construeix un nou soldat de tipus heroi.
     * @param imatge la imatge del soldat
     * @param b bandol correponent
     * @param widthCanvas amplada canvas
     * @param heightCanvas alçada canvas
     */
    public Heroi(final GImage imatge, final int b, final double widthCanvas,
            final double heightCanvas) {
        setbandol(b);
        setImg(imatge);
        setHeigthCanvas(heightCanvas);
        setWidthCanvas(widthCanvas);
    }
    @Override
    public final int moure(final double desti) {
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
