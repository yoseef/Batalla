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
    /**
     * crea un soldat de tipus rey que es mou de dalt a baix.
     * @param imatge necessaria per crearlo
     * @param b bandol correponent
     * @param widthCanvas amplda del canvas
     * @param heightCanvas alçada del canvas
     */
    public Rey(final GImage imatge, final int b, final double widthCanvas,
            final double heightCanvas) {
        setbandol(b);
        super.setImg(imatge);
        setHeigthCanvas(heightCanvas);
        setWidthCanvas(widthCanvas);
    }

    @Override
    public final void formar(final double x, final double y) {
        if (super.getbandol() > 0) {
            super.setLocation(0, 0);
        } else {
            super.setLocation(getHeigthCanvas() - getWidth(), 0);
        }
    }
    /**
     * guarda si el rey ha arribat al punt 0.
     */
    private boolean adalt;
    @Override
    public final int moure(final double desti) {
        setVelo();
        if (getY() <= 0) {
            adalt = true;
        } else if (getY() >= getHeigthCanvas() - getHeight()) {
            adalt = false;
        }
        if (getY() >= getHeigthCanvas() - getHeight() && desti == 0) {
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



