/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Batalla2;

import acm.graphics.GImage;
import java.util.Random;

/**
 *
 * @author user
 */
public class Soldat extends SoldatGeneral {

    public Soldat(final GImage imatge, final int b) {
       setbandol(b);
        setImg(imatge);
        r = new Random();
    }

    /**
     * apatir de un punt que li indikem la image avançara fins arribari.
     *
     * @param desti el punt fins al que te que arribari el soldat
     * @return 1 en cas de haver avançat 0 en cas de no haver avançat
     */
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
