/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compugrafica.Model;

import java.awt.image.BufferedImage;
import static java.lang.Math.pow;
import java.util.ArrayList;

/**
 *
 * @author hernan
 */
public class Bezier extends Vector {

    public ArrayList<Double> vX;
    public ArrayList<Double> vY;

    protected double bzX;
    protected double bzY;

    public ArrayList<Double> BezierX = new ArrayList<>();
    public ArrayList<Double> BezierY = new ArrayList<>();

    public Bezier(ArrayList vX, ArrayList vY) {
        this.vX = vX;
        this.vY = vY;
    }

    @Override
    public void encender(BufferedImage I) {
        double t = 0;
        double dt = 0.02;

        bezier(t);

        do {
            x = bzX;
            y = bzY;
            BezierX.add(x);
            BezierY.add(y);
            t += dt;
            bezier(t);
            Segmento seg = new Segmento(x, y, bzX, bzY);
            seg.color = this.color;
            seg.encender(I);
        } while (t < 1);
    }

    public void bezier(double t) {
        int contador = vX.size(), i; 
        double nFactorial, iFactorial, n_iFactorial, facnum;
        facnum = contador - 1;
        nFactorial = factorial(facnum);
        bzX = 0;
        bzY = 0;
        for (i = 0; i <= facnum; i++) {
            iFactorial = factorial(i);
            n_iFactorial = factorial((facnum - i));
//            bzX = (vX.get(i) * (nFactorial / (iFactorial * n_iFactorial)) * (Math.pow(t, i)) * (Math.pow((1 - t), (facnum - i)))) + bzX;
//            bzY = (vY.get(i) * (nFactorial / (iFactorial * n_iFactorial)) * (Math.pow(t, i)) * (Math.pow((1 - t), (facnum - i)))) + bzY;
            bzX = bzX + ((vX.get(i) * factorial(facnum) * pow(1 - t, facnum - i) * pow(t, i)) / (factorial(i) * factorial(facnum - i)));
            bzY = bzY + ((vY.get(i) * factorial(facnum) * pow(1 - t, facnum - i) * pow(t, i)) / (factorial(i) * factorial(facnum - i)));

        }
    }

    //FACTORIAL
//    public static int factorial(int n) {
//        if (n == 0) {
//            return 1;
//        } else {
//            return n * factorial(n - 1);
//        }
//    }
    
    public static double factorial(double num){
        double fact=1;
        for (int i=1; i<=num;i++)
        {
            fact=fact*i;
        }
        return fact;
    }
}
