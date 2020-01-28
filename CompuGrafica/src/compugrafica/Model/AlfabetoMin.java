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
public class AlfabetoMin extends Circunferencia {

    public AlfabetoMin(Double x0, Double y0, Double Rd) {
        super(x0, y0, Rd);
    }

    public AlfabetoMin(Double x0, Double y0, Double Rd, Color color) {
        super(x0, y0, Rd, color);
    }

    //Constructor para dinamico
    public AlfabetoMin(Integer x0, Integer y0, Double Rd) {
        super(x0, y0, Rd);
        this.Rd = Rd / r;
    }

    public AlfabetoMin(Integer x0, Integer y0, Double Rd, Color color) {
        super(x0, y0, Rd, color);
        this.Rd = Rd / r;
    }

    double t;
    double d = 2 * Math.PI * Rd * r;
    double dt = (1 / (r * d));

    //Letra a
    public void encenderLa(BufferedImage buffImg) {

        t = Math.PI / 4;
        do {
            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);
            color = Color.BLUE;
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= 7 * Math.PI / 4);

        Segmento s = new Segmento(x0 + (Math.sqrt(2) / 2) * Rd, y0 + Rd, x0 + (Math.sqrt(2) / 2) * Rd, y0 - Rd, Color.BLUE);
        s.encender(buffImg);

    }

    //Letra b
    public void encenderLb(BufferedImage buffImg) {

        t = 4 * Math.PI / 3;
        do {
            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= 8 * Math.PI / 3);

        Segmento s = new Segmento(x0 - Rd * 0.5, y0 + Rd * 2, x0 - Rd * 0.5, y0 - Rd);
        s.encender(buffImg);

    }

    //Letra c
    public void encenderLc(BufferedImage buffImg) {

        t = Math.PI / 4;
        do {
            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= 7 * Math.PI / 4);

    }

    //Letra d
    public void encenderLd(BufferedImage buffImg) {

        t = Math.PI / 6;
        do {
            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * 1.15 * Math.sin(t);

            pixel(x, y, buffImg);
            t += dt;
        } while (t <= ((11 * Math.PI) / 6));

        Segmento s = new Segmento(x0 + Rd * 0.866, y0 - Rd * 1.15, x0 + Rd * 0.866, y0 + Rd * 2.30);
        s.encender(buffImg);
    }

    //Letra e
    public void encenderLe(BufferedImage buffImg) {

        t = 0;
        do {
            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= 7 * Math.PI / 4);

        Segmento s = new Segmento(x0 + 1 * Rd, y0, x0 - 1 * Rd, y0);
        s.encender(buffImg);
    }

    //Letra f
    public void encenderLf(BufferedImage buffImg) {

        t = Math.PI / 3;
        do {
            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= Math.PI);

        Segmento s = new Segmento(x0 - Rd, y0, x0 - Rd, y0 - 2.9 * Rd);

        Segmento s1 = new Segmento((x0 - Rd) - (Rd / 1.5), y0 - 0.5, (x0 - Rd) + (Rd / 1.5), y0 - 0.5);

        s.encender(buffImg);
        s1.encender(buffImg);
    }

    //Letra m
    public void encenderLm(BufferedImage buffImg) {

        t = 0;
        do {
            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= Math.PI);
        t = 0;
        do {
            x = (x0 - 2 * Rd) + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= Math.PI);

        Segmento s = new Segmento(x0 + Rd, y0, x0 + Rd, y0 - 1.5 * Rd);
        Segmento s1 = new Segmento(x0 - Rd, y0, x0 - Rd, y0 - 1.5 * Rd);
        Segmento s2 = new Segmento((x0 - 2.0) - Rd, y0 + Rd, (x0 - 2.0) - Rd, y0 - 1.5 * Rd);
        s.encender(buffImg);
        s1.encender(buffImg);
        s2.encender(buffImg);
    }
    
    //Letra f
    public void encenderLeccion(BufferedImage buffImg) {

        t = Math.PI/6;
        do {
            x = x0 + Rd * Math.cos(t);
            y = y0 + Rd * Math.sin(t);
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= Math.PI);
        
        t= Math.PI/4.4;
        do {
            x = x0 + Rd * Math.cos(t);
            y = (y0-0.4*Rd) + Rd * Math.sin(t);
            pixel(x, y, buffImg);
            t += dt;
        } while (t <= 5*Math.PI/6);

        Segmento s = new Segmento(x0 +0.866*Rd, y0+0.5*Rd, x0, y0 - 1.5*Rd);
        //Segmento s2 = new Segmento(x0 -0.707*Rd, y0+0.707*Rd, x0, y0);
        s.encender(buffImg);
        //s2.encender(buffImg);
    }

    
}
