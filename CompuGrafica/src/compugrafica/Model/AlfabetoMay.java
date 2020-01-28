/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compugrafica.Model;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author herna
 */
public class AlfabetoMay extends Circunferencia {

    public AlfabetoMay(Double x0, Double y0, Double Rd) {
        super(x0, y0, Rd);
    }

    public AlfabetoMay(Double x0, Double y0, Double Rd, Color color) {
        super(x0, y0, Rd, color);
    }

    public AlfabetoMay(Integer x0, Integer y0, Double Rd) {
        super(x0, y0, Rd);
        this.Rd = Rd / r;
    }

    public AlfabetoMay(Integer x0, Integer y0, Double Rd, Color color) {
        super(x0, y0, Rd, color);
        this.Rd = Rd / r;
    }

    double t;
    double d = 2 * Math.PI * Rd * r;
    double dt = (1 / (r * d));

    //Letra M
    public void encenderLM(BufferedImage buffImg) {

        Segmento s = new Segmento(x0 - 0.707 * Rd, y0 + 0.707 * Rd, x0 - 0.707 * Rd, y0 - 1.5 * Rd);
        Segmento s1 = new Segmento(x0 - 0.707 * Rd, y0 + 0.707 * Rd, x0, y0 - 1.5 * Rd);
        Segmento s2 = new Segmento(x0 + 0.707 * Rd, y0 + 0.707 * Rd, x0 + 0.707 * Rd, y0 - 1.5 * Rd);
        Segmento s3 = new Segmento(x0 + 0.707 * Rd, y0 + 0.707 * Rd, x0, y0 - 1.5 * Rd);
        s.encender(buffImg);
        s1.encender(buffImg);
        s2.encender(buffImg);
        s3.encender(buffImg);
    }

}
