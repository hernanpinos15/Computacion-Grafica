/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compugrafica.Model;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;

/**
 *
 * @author herna
 */
public class Fum1 extends Vector {

    public int tipo;

    @Override
    public void encender(BufferedImage buffImg) {

        double dt = 0.05;
        double t = -6.0;
        double seg1 = t;
        double seg2 = (1 / (t + 1));
        double seg3 = 1.0 - t + Math.pow(t, 2) / 2 - Math.pow(t, 3) + Math.pow(t, 4);
        
        //double seg2 = Math.sin(t);
        //double seg3 = 1.0 + t + (Math.pow(x, 2) / 2) + (Math.pow(x, 3) / 6);

        do {
            x = t;

            //1
//            y = Math.sin(t);
//            Segmento s = new Segmento(seg1, seg2, x, y, Color.GREEN);
//            seg1 = t;
//            seg2 = y;
//            s.encender(buffImg);
//
//             y = t-t*t/2 - t*t*t/6 + t*t*t*t/24 + t*t*t*t*t/120 - t*t*t*t*t*t/720; 
//              color = Color.RED;
//            pixel(x, y, buffImg);
            //2
            y = (1 / (t + 1));
            Segmento s1 = new Segmento(seg1, seg2, x, y, Color.GREEN);
            seg1 = t;
            seg2 = y;
            s1.encender(buffImg);

            //y = 1.0-t+2*t*t/2-6*t*t*t/24+24*t*t*t*t*t/120-120*t*t*t*t*t*t/720; 
            y = 1.0 - t + Math.pow(t, 2) / 2 - Math.pow(t, 3) + Math.pow(t, 4);
            //color = Color.RED;
            Segmento s2 = new Segmento(seg1, seg3, x, y, Color.RED);
            seg1 = t;
            seg3 = y;
            s2.encender(buffImg);
            //pixel(x, y, buffImg);

//            //Polinomio de taylor
//            y = Math.pow(Math.E, t);
//            Segmento s = new Segmento(seg1, seg2, x, y, Color.GREEN);
//            seg1 = t;
//            seg2 = y;
//            s.encender(buffImg);
//
//            y = 1.0 + t + (Math.pow(x, 2) / 2) + (Math.pow(x, 3) / 6);
//            color = Color.RED;
//            pixel(x, y, buffImg);
            //Parabola
//            y = Math.pow(t, 2) + t - 4;
//            color = Color.ORANGE;
//            pixel(x, y, buffImg);
            //Exponencial
//            y = Math.pow(2, t) - 3;
//            color = Color.BLUE;
//            Segmento s = new Segmento(seg1, seg2, x, y);
//            seg1 = t;
//            seg2 = y;
//            s.encender(buffImg);
            //pixel(x, y, buffImg);
//            //Seno
//            y = Math.sin(t);
//            color = Color.MAGENTA;
//            pixel(x, y, buffImg);
//
//            //logaritmica
//            y = Math.log(t);
//            color = Color.CYAN;
//            pixel(x, y, buffImg);
//
//            //tangente
//            y = Math.tan(t);
//            color = Color.RED;
//            Segmento s = new Segmento(seg1, seg2, x, y);
//            seg1 = t;
//            seg2 = y;
//            s.encender(buffImg);
            t += dt;
        } while (t <= 6);

    }

//    //Seno
//    public void encenderSen(BufferedImage buffImg) {
//
//        double dt = 0.001;
//        double t = -6.0;
//        //int x0 = -6;
//        color = Color.MAGENTA;
//        do {
//            x = t;
//            y = Math.sin(t);
//            pixel(x, y, buffImg);
//            t += dt;
//        } while (t <= 6);
//        
//        do {
//            x = t;
//            y = Math.pow(2, t);
//            pixel(x, y, buffImg);
//            t += dt;
//        } while (t <= 6);
//    }
//
//    //Seno
//    public void encenderF3(BufferedImage buffImg) {
//
//        double dt = 0.001;
//        double t = -6.0;
//        color = Color.GREEN;
//        //int x0 = -6;
//        do {
//            x = t;
//            y = Math.pow(2, t);
//            pixel(x, y, buffImg);
//            t += dt;
//        } while (t <= 6);
//    }
//
//    //Tangente
//    public void encenderTan(BufferedImage buffImg) {
//
//        double dt = 0.001;
//        double t = -6.0;
//        color = Color.ORANGE;
//        //int x0 = -6;
//        do {
//            x = t;
//            y = Math.tan(t);
//            pixel(x, y, buffImg);
//            t += dt;
//        } while (t <= 6);
//    }
//
//    //Log
//    public void encenderLog(BufferedImage buffImg) {
//
//        double dt = 0.0005;
//        double t = -6.0;
//        color = Color.RED;
//        //int x0 = -6;
//        do {
//            x = t;
//            y = Math.log(t);
//            pixel(x, y, buffImg);
//            t += dt;
//        } while (t <= 6);
//    }
}
