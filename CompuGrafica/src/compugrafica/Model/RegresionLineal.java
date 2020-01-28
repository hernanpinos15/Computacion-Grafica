/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compugrafica.Model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author herna
 */
public class RegresionLineal extends Segmento {

    public ArrayList<Double> vX;
    public ArrayList<Double> vY;

    public RegresionLineal(ArrayList vX, ArrayList vY) {
        this.vX = vX;
        this.vY = vY;
    }

    @Override
    public void encender(BufferedImage buffImg) {
        //int contador = vX.size();
        double sumxy = 0;
        double sumx = 0;
        double sumy = 0;
        double sumxx = 0;
        double dominioX = 6.0;

        for (int i = 0; i < vX.size(); ++i) {
            sumx = vX.get(i) + sumx;
            sumxx = (vX.get(i) * vX.get(i)) + sumxx;
            sumxy = (vX.get(i) * vY.get(i)) + sumxy;
            sumy = vY.get(i) + sumy;
        }
        double m = (vX.size() * sumxy - sumx * sumy) / (vX.size() * sumxx - (sumx * sumx));
        double b = (sumy - m * sumx) / vX.size();
        Segmento(-dominioX, (m * (-dominioX) + b), dominioX, (m * dominioX + b));
        super.encender(buffImg);
    }
}
