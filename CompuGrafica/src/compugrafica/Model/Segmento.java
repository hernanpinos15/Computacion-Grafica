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
public class Segmento extends Vector {

//    @Override
//    public void encender(BufferedImage I) {
//        //Calculo de pixeles
//        double p = 0;
//
//        //NORMA Distancia
//        d = Math.sqrt(Math.pow(xf - x0, 2) + Math.pow(yf - y0, 2));
//        //Norma 1
//        //d = Math.abs(xf - x0) + Math.abs(yf - y0);
//        //System.out.println(d);
//        double dt = (1 / (r * d)) + 0.000001;
//
//        //INFINITO 
//        //double inf = Double.POSITIVE_INFINITY;
//        //System.out.println(dt);
//        double t = 0.0;
//        do {
//            x = x0 * (1 - t) + xf * t;
//            y = y0 * (1 - t) + yf * t;
//            pixel(x, y, I);
//            t += dt;
//            p += t;
//        } while (t <= 1);
//        //System.out.println(p);
//    }

    
    public double xf;
    public double yf;

    public Segmento() {
        super(-2.0, -2.0);
        this.xf = 2.0;
        this.yf = 2.0;
    }

    public Segmento(double x0, double y0, double xf, double yf) {
        super(x0, y0);
        this.xf = xf;
        this.yf = yf;
    }

    public Segmento(double x0, double y0, double xf, double yf, Color color) {
        super(x0, y0, color);
        this.xf = xf;
        this.yf = yf;
    }

    //Proceso Carta Puntos Iniciales y Finales
    public Segmento(int x0, int y0, int xf, int yf) {
        super(x0, y0);
        procesoCarta(xf, yf);
        this.xf = Sx;
        this.yf = Sy;
    }

    //Proceso Carta Puntos Iniciales Con Color
    public Segmento(int x0, int y0, int xf, int yf, Color color) {
        super(x0, y0, color);
        procesoCarta(xf, yf);
        this.xf = Sx;
        this.yf = Sy;
    }

    public void Segmento(double x0, double y0, double xf, double yf) {
        this.x0 = x0;
        this.y0 = y0;
        this.xf = xf;
        this.yf = yf;
    }
    
    public void Segmento(int x0, int y0, int xf, int yf) {
        procesoCarta(x0, y0);
        this.x0 = Sx;
        this.y0 = Sy;
        procesoCarta(xf, yf);
        this.xf = Sx;
        this.yf = Sy;
    }

    @Override
    public void encender(BufferedImage I) {
        d = Math.sqrt(Math.pow(xf - x0, 2) + Math.pow(yf - y0, 2));
        double dt = (1 / (r * d)) + 0.000001;
        double t = 0.0;
        do {
            x = x0 * (1 - t) + xf * t;
            y = y0 * (1 - t) + yf * t;
            pixel(x, y, I);
            t += dt;
        } while (t <= 1);
    }

    public void encenderInterplado(BufferedImage I) {
        d = Math.sqrt(Math.pow(xf - x0, 2) + Math.pow(yf - y0, 2));

        double dt = (1 / (r * d)) + 0.000001;
        double t = 0.0;
        do {
            x = x0 * (1 - t) + xf * t;
            y = y0 * (1 - t) + yf * t;
            color = new Color(255, 0, (int) (-(255) * (t - 1)));
            pixel(x, y, I);
            t += dt;
        } while (t <= 1);
    }

    public void interpolarFranja(BufferedImage I) {
        d = Math.sqrt(Math.pow(xf - x0, 2) + Math.pow(yf - y0, 2));

        double dt = (1 / (r * d)) + 0.000001;
        double t = 0.0;
        do {
            x = x0 * (1 - t) + xf * t;
            y = y0 * (1 - t) + yf * t;
            color = new Color(255, 0, (int) (-(255) * (t - 1)));

            for (double j = -4.0; j < 4; j += 0.01) {
                pixel(x, y + j, I);
            }
            t += dt;
        } while (t <= 1);
    }
    
}
