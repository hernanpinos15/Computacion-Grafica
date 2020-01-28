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
public class Segmento3D extends Vector3D {

    double xf;
    double yf;
    double zf;

    public Segmento3D() {
    }

    public Segmento3D(double x0, double y0, double z0, double xf, double yf, double zf) {
        super(x0, y0, z0);
        this.xf = xf;
        this.yf = yf;
        this.zf = zf;
    }

    public Segmento3D(double x0, double y0, double z0, double xf, double yf, double zf, Color color) {
        super(x0, y0, z0, color);
        this.xf = xf;
        this.yf = yf;
        this.zf = zf;
    }

    @Override
    public void encender(BufferedImage I) {

        double dh = 0.001;
        double h = 0.0;

        do {
            x = x0 * (1 - h) + (xf * h);
            y = y0 * (1 - h) + (yf * h);
            z = z0 * (1 - h) + (zf * h);
            pixel3D(x, y, z, I);
            h += dh;
        } while (h <= 1);
    }
}
