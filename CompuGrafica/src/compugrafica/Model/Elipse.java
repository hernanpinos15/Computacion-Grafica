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
public class Elipse extends Circunferencia{
    public Double R1;
    public Double R2;
    
    
    public Elipse(Double x0, Double y0, Double R1, Double R2) {
        super(x0, y0, 0.0);
        this.R1 = R1;
        this.R2 = R2;
    }
    public Elipse(Integer x0, Integer y0, Integer R1, Integer R2) {
        super(x0, y0, 0.0);
        this.R1 = R1 / r;
        this.R2 = R2 / r;
    }
    @Override
    public void encender(BufferedImage buffImg) {
        double t = 0.0;
        double dt = 0.002;
        do {
            x = x0 + R1*Math.cos(t);
            y = y0 + R2* Math.sin(t);
            pixel(x,y,buffImg);
            t += dt;
        } while (t <= Math.PI * 2);
    }
    
}
