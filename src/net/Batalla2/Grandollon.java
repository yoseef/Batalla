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
public class Grandollon extends SoldatGeneral {

    /**
     * numero de vidas que tindra aquest tipus de soldat.
     */
    private final int vidas;

    /**
     * Construeix un soldat de tipus gordo.
     *
     * @param imatge la imatge per crearlo
     * @param b el bandol corresponent del soldat
     */
    public Grandollon(final GImage imatge, final int b) {
        setbandol(b);
        setImg(imatge);
        vidas = 0;
    }

    @Override
    public final int moure(final double desti) {
        if (getbandol() > 0 && getX() <= desti) {
            setVelo();
            getImg().move(getbandol() * getVelo(), 0);
            return 1;
        } else if (getbandol() < 0 && getX() >= 0) {
            setVelo();
            getImg().move(getbandol() * getVelo(), 0);
            return 1;
        } else {
            return 0;
        }
    }
}
