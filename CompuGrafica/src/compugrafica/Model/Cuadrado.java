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
public class Cuadrado extends Segmento {

     public Cuadrado(double x0, double y0, double xf, double yf) {
        super(x0, y0, xf, yf);
    }

    public Cuadrado(double x0, double y0, double xf, double yf, Color color) {
        super(x0, y0, xf, yf, color);
    }

    public Cuadrado(int x0, int y0, int xf, int yf) {
        super(x0, y0, xf, yf);
    }

    public Cuadrado(int x0, int y0, int xf, int yf, Color color) {
        super(x0, y0, xf, yf, color);
    }

    @Override
    public void encender(BufferedImage I) {
        Segmento v1 = new Segmento(x0, y0, xf, y0);
        v1.encender(I);
        Segmento v2 = new Segmento(x0, y0, x0, yf);
        v2.encender(I);
        Segmento v3 = new Segmento(xf, yf, xf, y0);
        v3.encender(I);
        Segmento v4 = new Segmento(xf, yf, x0, yf);
        v4.encender(I);
    }
}
