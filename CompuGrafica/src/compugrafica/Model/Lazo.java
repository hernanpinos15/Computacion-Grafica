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
public class Lazo extends Circunferencia {

    public Lazo(Double x0, Double y0, Double Rd) {
        super(x0, y0, Rd);
    }

    public Lazo(Double x0, Double y0, Double Rd, Color color) {
        super(x0, y0, Rd, color);
    }

    public Lazo(Integer x0, Integer y0, Double Rd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Lazo(Integer x0, Integer y0, Double Rd, Color GREEN) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void encender(BufferedImage I) {
        double t = 0.0;
        double dt = 0.001;
        do {
            x = x0 + Rd * Math.sin(2 * t);
            //y = y0 + Rd * Math.cos(3* t);
            y = y0 + Rd * Math.cos(t);
//            Segmento s = new Segmento(x0, y0, x, y);
//            s.encenderInterplado(I);
            pixel(x, y, I);
            t += dt;
        } while (t <= 2 * Math.PI);

    }
}
