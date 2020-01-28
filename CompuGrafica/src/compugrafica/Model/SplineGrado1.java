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
public class SplineGrado1 extends Vector {

    private static Ecuacion[] splines;

    /*
     * Clase que representa una ecuación de la forma:
     * Y = a * X + B    limInf <= X < limSup
     */
    public ArrayList<Double> vX;
    public ArrayList<Double> vY;

    public SplineGrado1(ArrayList vX, ArrayList vY) {
        this.vX = vX;
        this.vY = vY;
    }

    private static class Ecuacion {

        private double limInf, limSup, a, b, y;

        public Ecuacion(double a1, double b1, double li, double ls) {
            limInf = li;
            limSup = ls;
            a = a1;
            b = b1;

        }

        public double calcularY(double x) {
            return (a * x + b);

        }

        public double getLimInf() {
            return limInf;
        }

        public double getLimSup() {
            return limSup;
        }

        public double getA() {
            return a;
        }

        public double getB() {
            return b;
        }

    }

    public static Ecuacion[] solucionar(ArrayList<Double> xs, ArrayList<Double> ys) {
        int n = xs.size();
        splines = new Ecuacion[n - 1];//crea vetor de ecuaciones menor en uno al numeor de puntos

        for (int i = 0; i < n - 1; i++) {
            double m = (ys.get(i + 1) - ys.get(i)) / (xs.get(i + 1) - xs.get(i)); //pendiente de la ecuacion 1 a n-1
            double b = ys.get(i) - xs.get(i) * m; //constante de la ecuacion 1 a n-1
            splines[i] = new Ecuacion(m, b, xs.get(i), xs.get(i + 1));//guarda  en el vector de ecuaciones spline
        }

        return splines; //retorna un arreglo de ecuaciones spline
    }

    @Override
    public void encender(BufferedImage buffImg) {
        double t, dt, yf, y;
        double d = 0;
       

        for (int i = 0; i < vX.size() - 1; i++) {
            d = d +Math.sqrt(Math.pow(vX.get(0) - vY.get(0), 2) + Math.pow(vX.get(vX.size() - 1) - vY.get(vY.size() - 1), 2));
             
            color = new Color((int) ((-255 / d) * (i - d)), (int) ((-255 / d) * (i - d)), (int) ((255 / d) * (i)));
            Segmento s = new Segmento(vX.get(i), vY.get(i), vX.get(i + 1), vY.get(i + 1), color);
            s.encender(buffImg);
        }
    }

}
