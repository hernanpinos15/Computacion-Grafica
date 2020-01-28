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
public class Astroide extends Circunferencia {

    public Astroide() {
        //vrER AQUI
    }

    public Astroide(double x0, double y0, double Rd) {
        super(x0, y0, Rd);
    }

    public Astroide(double x0, double y0, double Rd, Color color) {
        super(x0, y0, Rd, color);
    }

    public Astroide(int x0, int y0, double Rd) {
        super(x0, y0, Rd);
    }

    public Astroide(int x0, int y0, double Rd, Color color) {
        super(x0, y0, Rd);
    }

    @Override
    public void encender(BufferedImage buffImg) {
        double t = 0;
        double dt = 0.002;
        do {
            x = x0 + Rd * Math.pow(Math.cos(t), 3);
            y = y0 + Rd * Math.pow(Math.sin(t), 3);
//            Segmento s = new Segmento(x0, y0, x, y);
//            s.encenderInterplado(buffImg);
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= Math.PI * 2);
    }
    
}
