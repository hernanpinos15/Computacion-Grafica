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
public class Margarita extends Circunferencia {

    public Double Rd;

    public Margarita() {
        super(0.0, 0.0, 1.0);
        this.Rd = 1.0;
    }

    public Margarita(Double x0, Double y0, Double Rd) {
        super(x0, y0, Rd);
        this.Rd = Rd;
    }

    public Margarita(Double x0, Double y0, Double Rd, Color color) {
        super(x0, y0, Rd, color);
        this.Rd = Rd;
    }

    public Margarita(Integer x0, Integer y0, Double Rd, Color PINK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void encender(BufferedImage buffImg) {
        d = 2 * Math.PI * Rd * r;
        double dt = (1 / (r * d));
        double t = 0.0;
        do {
            x = x0 + Rd * Math.cos(4 * t) * Math.cos(t);
            y = y0 + Rd * Math.cos(4 * t) * Math.sin(t);
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= Math.PI * 2);
    }
}
