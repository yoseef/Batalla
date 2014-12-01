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
public abstract class SoldatGeneral {

    /**
     * crea enters aleatoris.
     */
    private Random r;

    public Random getR() {
        return r;
    }

    public void setR(Random r) {
        this.r = r;
    }
    /**
     * la imatge del soldat.
     */
    private GImage img;
    /**
     * indicara els punta que avaçara el soldat.
     */
    private int velocitat;
    /**
     * indicara la direccio en la que anira el soldat. pot ser u(si va a la
     * dreta) o menys u(si va cap a l'esquerra)
     */
    private int bandol;
    /**
     * amplada del canvas.
     */
    private double w;
    /**
     * alçada del canvas.
     */
    private double h;

    /**
     * Constructor per defecte.
     */
    public SoldatGeneral() {
        bandol = 0;
        img = null;
        r = new Random();
        this.w = 0;
    }

    /**
     * canvia la imatge del soldat.
     *
     * @param ruta la ruta de la nova imagte
     */
    public final void setImg(final String ruta) {
        img.setImage(ruta);
    }

    /**
     * setter de la imatge.
     *
     * @param img2 image
     */
    public final void setImg(final GImage img2) {
        img = img2;
    }

    /**
     * setter de location.
     *
     * @param x que tindra l'objecte
     * @param y que tindra
     */
    public final void setLocation(final double x, final double y) {
        img.setLocation(x, y);
    }

    /**
     * setter amplada del canvas.
     *
     * @param widthCanvas amplada
     */
    public final void setWidthCanvas(final double widthCanvas) {
        this.w = widthCanvas;
    }

    /**
     * obte lampladad el canvas.
     *
     * @return amplada
     */
    public final double getWidthCanvas() {
        return w;
    }

    /**
     * obte l'alçada del canvas.
     *
     * @return alçada del canvas
     */
    public final double getHeigthCanvas() {
        return h;
    }

    /**
     * canvia el valor de l'alçada.
     *
     * @param heigth alçada
     */
    public final void setHeigthCanvas(final double heigth) {
        h = heigth;
    }

    /**
     *
     * @return de quin bandol es el soldat
     */
    public final int getbandol() {
        return bandol;
    }

    /**
     *
     * @return la posicio x de la imatge(soldat)
     */
    public final double getX() {
        return img.getX();
    }

    /**
     *
     * @return la posicio Y de la imatge(soldat)
     */
    public final double getY() {
        return img.getY();
    }

    /**
     *
     * @return la amplada de la image del soldat
     */
    public final double getWidth() {
        return img.getWidth();
    }

    /**
     *
     * @return la altura de la image del soldat
     */
    public final double getHeight() {
        return img.getHeight();
    }

    /**
     *
     * @return el rectangle de la image
     */
    public final GRectangle getRectangleSoldat() {
        return img.getBounds();
    }

    /**
     * obte la imatge.
     *
     * @return la imatge
     */
    public final GImage getImg() {
        return img;
    }

    /**
     * obte la velocitat.
     *
     * @return la veloc
     */
    public final int getVelo() {
        return velocitat;
    }

    /**
     *
     * @param band modifica de quin bandol es el soldat
     */
    public final void setbandol(final int band) {
        bandol = band;
    }

    /**
     * propociona una velocitat al soldat (aleatoria).
     */
    public final void setVelo() {
        velocitat = r.nextInt(N10);
    }
    /**
     * numero 10.
     */
    private static final int N10 = 10;

    /**
     * apartir dels paremetres pocisiona la imatge.
     *
     * @param x la posicio x que tindra la image
     * @param y la posicio y que tindra la image
     */
    public void formar(final double x, final double y) {
        img.setLocation(x, y);
    }

    /**
     * apatir de un punt que li indikem la image avançara fins arribari.
     *
     * @param desti el punt fins al que te que arribari el soldat
     * @return numero 1 s'ha mogut sino 0
     */
    public abstract int moure(final double desti);

    /**
     *
     * @param soldat2 el segon soldat amb elque ens comaparem
     * @return true si el rectangle del primer toca el el rectangle del segon
     */
    public final boolean intersecta(final SoldatGeneral soldat2) {
        return this.getRectangleSoldat().intersects(
                soldat2.getRectangleSoldat());
    }

    /**
     * basicament borra la imatge del camp i anula el punter de la variable.
     */
    public final void borrarImatge() {
        img.getParent().remove(img);
        img = null;
    }

    /**
     * gira les imatges.
     */
    public final void flipHoriz() {

        int[][] array = getImg().getPixelArray();
        int height = array.length;
        int width = array[0].length;
        for (int y = 0; y < height; y++) {
            for (int x1 = 0; x1 < width / 2; x1++) {
                int x2 = width - x1 - 1;
                int temp = array[y][x1];
                array[y][x1] = array[y][x2];
                array[y][x2] = temp;
            }
        }
        getImg().setImage(new GImage(array).getImage());
    }
}
