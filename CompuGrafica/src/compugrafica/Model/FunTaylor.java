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
public class FunTaylor extends Vector {

    @Override
    public void encender(BufferedImage buffImg) {

        double dt = 0.05;
        double t = -6.0;
        double seg1 = t;
        double seg2;
        double seg3;
        //double seg2 = Math.sin(t);
        //double seg3 = 1.0 + t + (Math.pow(x, 2) / 2) + (Math.pow(x, 3) / 6);
        seg2 = Math.atan(t);
        seg3 = t - Math.pow(t, 3) / 3 + Math.pow(t, 5) / 5 - Math.pow(t, 7) / 7;

        do {
            x = t;

            //1
//            y = Math.sin(t);
//            Segmento s = new Segmento(seg1, seg2, x, y, Color.GREEN);
//            seg1 = t;
//            seg2 = y;
//            s.encender(buffImg);
//
//            y = t - Math.pow(t, 3) / 6 + Math.pow(t, 5) / 120;
//            Segmento s1 = new Segmento(seg1, seg3, x, y, Color.RED);
//            seg1 = t;
//            seg3 = y;
//            s1.encender(buffImg);
//            y = Math.log(2 * t);
//            Segmento s = new Segmento(seg1, seg2, x, y, Color.GREEN);
//            seg1 = t;
//            seg2 = y;
//            s.encender(buffImg);
//
//            y = Math.log(2) + (t - 1) - Math.pow(t - 1, 2) / 2 + Math.pow(t - 1, 3) / 3 - Math.pow(t - 1, 4) / 4 + Math.pow(t - 1, 5) / 5;
//            Segmento s1 = new Segmento(seg1, seg3, x, y, Color.RED);
//            seg1 = t;
//            seg3 = y;
//            s1.encender(buffImg);
            y = Math.atan(t);
            Segmento s = new Segmento(seg1, seg2, x, y, Color.GREEN);
            seg1 = t;
            seg2 = y;
            s.encender(buffImg);

            y = t - Math.pow(t, 3) / 3 + Math.pow(t, 5) / 5 - Math.pow(t, 7) / 7 + Math.pow(t, 9) / 9 - Math.pow(t, 11) / 11;
            Segmento s1 = new Segmento(seg1, seg3, x, y, Color.RED);
            seg1 = t;
            seg3 = y;
            s1.encender(buffImg);

            t += dt;
        } while (t <= 6);

    }
}
