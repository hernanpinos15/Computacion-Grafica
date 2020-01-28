/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compugrafica.Model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author herna
 */
public class SplineGrado2 extends Vector{

     List<splineData> coeficientesPolinomio;
    List Vx;
    List Vy;

    public SplineGrado2(List Vx, List Vy) {
        this.Vx = Vx;
        this.Vy = Vy;
        this.coeficientesPolinomio = new ArrayList<>();
    }

    @Override
   public void encender(BufferedImage I) {
        double dt = 0.1, yf;
        double t = (double) Vx.get(0);
        double end = (double) Vx.get(Vx.size() - 1);
        y = (double) Vy.get(0);
        int i = 0;

        Color color = Color.RED;
        do {
            if (t <= (double) Vx.get(i + 1)) {
            } else {
                i++;
                if (i % 2 == 0) {
                    color = Color.BLUE;
                } else {
                    color = Color.RED;
                }
            }
            t = t + dt;
            yf = procesoSpline(t);
            Segmento seg = new Segmento(t - dt, y, t, yf, color);
            seg.encender(I);
            y = yf;
        } while (t <= end);
    }

    public double procesoSpline(double x) {
        spline(Vx, Vy);
        int j;
        for (j = 0; j < coeficientesPolinomio.size(); j++) {
            if (coeficientesPolinomio.get(j).x > x) {
                if (j == 0) {
                    j++;
                }
                break;
            }
        }
        j--;

        double dx = x - coeficientesPolinomio.get(j).x;
        double y = coeficientesPolinomio.get(j).a
                + coeficientesPolinomio.get(j).b * dx
                + coeficientesPolinomio.get(j).c * dx * dx
                + coeficientesPolinomio.get(j).d * dx * dx * dx;

        return y;
    }

    public void spline(List<Double> x, List<Double> y) {

        int n = x.size() - 1;
        List<Double> a = new ArrayList<>();
        for (Double y1 : y) {
            a.add(y1);
        }

        double[] b = new double[n];
        double[] d = new double[n];
        List<Double> h = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            h.add(x.get(i + 1) - x.get(i));
        }

        List<Double> alpha = new ArrayList<>();
        alpha.add(0.0);
        for (int i = 1; i < n; ++i) {
            alpha.add(3 * (a.get(i + 1) - a.get(i)) / h.get(i) - 3 * (a.get(i) - a.get(i - 1)) / h.get(i - 1));
        }
        double[] c = new double[n + 1];
        double[] l = new double[n + 1];
        double[] miu = new double[n + 1];
        double[] z = new double[n + 1];
        l[0] = 1;
        miu[0] = 0;
        z[0] = 0;

        for (int i = 1; i < n; ++i) {
            l[i] = 2 * (x.get(i + 1) - x.get(i - 1)) - h.get(i - 1) * miu[i - 1];
            miu[i] = h.get(i) / l[i];
            z[i] = (alpha.get(i) - h.get(i - 1) * z[i - 1]) / l[i];
        }

        l[n] = 1;
        z[n] = 0;
        c[n] = 0;

        for (int j = n - 1; j >= 0; --j) {
            c[j] = z[j] - miu[j] * c[j + 1];
            b[j] = (a.get(j + 1) - a.get(j)) / h.get(j) - h.get(j) * (c[j + 1] + 2 * c[j]) / 3;
            d[j] = (c[j + 1] - c[j]) / 3 / h.get(j);
        }

        splineData splineData;
        for (int i = 0; i < n; ++i) {
            splineData = new splineData();
            splineData.a = a.get(i);
            splineData.b = b[i];
            splineData.c = c[i];
            splineData.d = d[i];
            splineData.x = x.get(i);
            coeficientesPolinomio.add(splineData);
        }

    }

    public static class splineData {

        private Double a;// constante
        private Double b;// 1er coheficiente
        private Double c;// 2do coheficiente
        private Double d;// 3er coheficiente
        private Double x;//valor inicial  x
    }
}
