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
public class ProcesoLagrange extends Vector {

    public ArrayList<Double> vX;
    public ArrayList<Double> vY;

    public ProcesoLagrange(ArrayList vX, ArrayList vY) {
        this.vX = vX;
        this.vY = vY;
    }

    @Override
    public void encender(BufferedImage buffImg) {
        double t, dt;
        t = vX.get(0);
        dt = 0.1;
        double py1 = procesoLagrange(t);

        do {
            t = t + dt;
            y = procesoLagrange(t);
            Segmento s1 = new Segmento(t - dt, py1, t, y);
            s1.encender(buffImg);
            py1 = y;
        } while (t <= (vX.get(vX.size() - 1)));
    }

    public double procesoLagrange(double x) {

        double S = 0, P;
        for (int i = 0; i < vX.size(); i++) {
            P = 1.0;
            for (int j = 0; j < vX.size(); j++) {
                if (i != j) {
                    P = P * (x - vX.get(j)) / (vX.get(i) - vX.get(j));
                }
            }
            S = S + vY.get(i) * P;
        }
        return S;
    }
}
