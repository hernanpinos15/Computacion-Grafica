/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compugrafica.Model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author herna
 */
//
public class Mandelbort extends Circunferencia {

    public int Mandelbrot(double Xm, double Ym) {
        double Xn1, Yn1, Xn, Yn, d; //d es igual a la distancia del punto que se genera al centro de la circunferencia
        int i, colorM;//contador
        Xn = Xm;
        Yn = Ym;
        i = 0;
        do {
            Xn1 = Math.pow(Xn, 2) - Math.pow(Yn, 2) + Xm;
            Yn1 = (2 * Xn * Yn) + Ym;
            d = Math.pow((Math.pow((Xn1 - Xm), 2) + Math.pow((Yn1 - Ym), 2)), 0.5);
            i++;
            Xn = Xn1;
            Yn = Yn1;
            i = i + 1;
        } while (i < 100 && d < 2);
        if (i < 100) {
            colorM = (i % 14) + 1; //diverge
        } else {
            colorM = 0; //converge
        }
        return colorM;
    }

    public int Julia(double Xm, double Ym) {
        double Xn1, Yn1, Xn, Yn, d; //d es igual a la distancia del punto que se genera al centro de la circunferencia
        int i, colorM;//contador
        Xn = Xm;
        Yn = Ym;
        i = 0;
        do {
            Xn1 = Math.pow(Xn, 2) - Math.pow(Yn, 2) - 1;
            Yn1 = (2 * Xn * Yn) + 0.25;

            d = Math.pow((Math.pow((Xn1), 2) + Math.pow((Yn1), 2)), 0.5);
            i++;
            Xn = Xn1;
            Yn = Yn1;
            i = i + 1;
        } while (i < 100 && d < 2.8);
        if (i < 100) {
            colorM = (i % 14) + 1; //diverge
        } else {
            colorM = 0; //converge
        }
        return colorM;
    }

}
