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
public class Circunferencia extends Vector {

    public Double Rd;
    

    public Circunferencia() {
        super(0.0, 0.0);
        this.Rd = 1.0;
    }

    public Circunferencia(Double x0, Double y0, Double Rd) {
        super(x0, y0);
        this.Rd = Rd;
    }

    public Circunferencia(Double x0, Double y0, Double Rd, Color color) {
        super(x0, y0, color);
        this.Rd = Rd;
    }

    //Proceso Carta Puntos Iniciales Y Finales
    public Circunferencia(Integer x0, Integer y0, Double Rd) {
        super(x0, y0);
        this.Rd = Rd / r;
    }

    public Circunferencia(Integer x0, Integer y0, Double Rd, Color color) {
        super(x0, y0, color);
        this.Rd = Rd / r;
    }

    @Override
    public void encender(BufferedImage buffImg) {
        d = 2 * Math.PI * Rd * r;
        double dt = (1 / (r * d));
        double t = 0.0;
        do {

            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);

            pixel(x, y, buffImg);
            t += dt;
        } while (t <= Math.PI * 2);
    }

    public void encenderInterpolado(BufferedImage buffImg, double radio) {
        for (double i = 0.0; i < radio; i += 0.01) {
            Rd = i;
            color = new Color((int) ((-255 / radio) * (i - radio)), 0, 0);
            encender(buffImg);
        }
    }

    public void encenderD2(BufferedImage buffImg) {

        //super.encender(buffImg);
        d = 2 * Math.PI * Rd * r;
        double dt = (1 / (r * d));
        double t = 0.0;
        do {

            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);

            Segmento s = new Segmento(x0, y0, x, y);
            s.encender(buffImg);

            t += dt;
        } while (t <= Math.PI * 2);
    }

    //Para la letra Alpha
    public void encenderLG1(BufferedImage buffImg) {
        d = 2 * Math.PI * Rd * r;
        double dt = (1 / (r * d));
        double t = 0.0;
        double t1 = 0.0;
        do {
            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= 2 * Math.PI);

        do {
            x = (x0) + (Rd) * Math.cos(t1);
            y = (y0) + (Rd) * Math.sin(t1);
            pixel(x, y, buffImg);
            t1 += dt;
        } while (t1 <= (Math.PI / 2));
    }

    //Para la letra D
    public void encenderLd(BufferedImage buffImg) {

        d = 2 * Math.PI * Rd * r;
        double dt = (1 / (r * d));
        double t = Math.PI / 6;
        do {

            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * 1.15 * Math.sin(t);

            pixel(x, y, buffImg);
            t += dt;
        } while (t <= ((11 * Math.PI) / 6));
    }

    //Para el 2
    public void encenderNum2(BufferedImage buffImg) {

        d = 2 * Math.PI * Rd * r;
        double dt = (1 / (r * d));
        double t = 11 * Math.PI / 6;
        do {

            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);

            //Segmento s = new Segmento(x0, y0, x, y);
            //s.encenderD2(buffImg);
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= 3 * Math.PI);
    }

    //Para el 2
    public void encenderNum3(BufferedImage buffImg) {

        d = 2 * Math.PI * Rd * r;
        double dt = (1 / (r * d));
        double t = 0;
        double t1 = ((3 * Math.PI) / 2);
        do {

            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);

            //Segmento s = new Segmento(x0, y0, x, y);
            //s.encenderD2(buffImg);
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= Math.PI / 2);
        do {

            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);

            //Segmento s = new Segmento(x0, y0, x, y);
            //s.encenderD2(buffImg);
            pixel(x, y, buffImg);
            t += dt;
        } while (t1 <= 2 * Math.PI);
    }

    //Para el 2
    public void encenderPag(BufferedImage buffImg) {

        d = 2 * Math.PI * Rd * r;
        double dt = (1 / (r * d));
        double t = (Math.PI / 4);
        do {

            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);

            //Segmento s = new Segmento(x0, y0, x, y);
            //s.encenderD2(buffImg);
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= ((7 * Math.PI) / 4));
    }
}
