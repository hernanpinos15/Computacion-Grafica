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
public class Curva3D extends Vector3D {

    public double Rd = 1;
    public double mRd = 0;
    public double ft = 0.0001;
    int TipoRotar;

    public int getTipoRotar() {
        return TipoRotar;
    }

    public void setTipoRotar(int TipoRotar) {
        this.TipoRotar = TipoRotar;
    }

    public Curva3D(double x0, double y0, double z0, double Rd) {
        super(x0, y0, z0);
        this.Rd = Rd;
    }

    public Curva3D(double x0, double y0, double z0, double Rd, Color color) {
        super(x0, y0, z0, color);
        this.Rd = Rd;
    }

//    
    //ENCENDER PIXEL
    @Override
    public void encender(BufferedImage I) {
        double h = 0;
        double dh = 0.01;
        do {
            x = x0 + Rd * Math.cos(h);
            y = y0 + Rd * Math.sin(h);
            z = z0 + h * ft;
            rotarOpc(x, y, z, TipoRotar);
            pixel3D(x, y, z, I);
            Rd += mRd;
//            Rd -= mRd;
            h += dh;
        } while (h <= Math.PI * 6);
    }

    //figuras
    public double t, dt, h, dh;

    public void encenderFig(BufferedImage I) {
        //Esfera
//        h = 0;
//        dh = 0.2;
//
//        do {
//            t = 0;
//            dt = 0.1;
//
//            do {
//                x = x0 + Rd * Math.sin(t) * Math.cos(h);
//                y = y0 + Rd * Math.sin(t) * Math.sin(h);
//                z = z0 + Rd * Math.cos(t);
//
//                pixel3D(x, y, z, I);
//                t = t + dt;
//            } while (t <= 2 * Math.PI);
//            h = h + dh;
//        } while (h <= 2 * Rd);

        //Cilindro
//        h = 0;
//        dh = 0.2;
//        do {
//
//            t = 0;
//            dt = 0.05;
//            do {
//
//                x = x0 + Rd * Math.cos(t);
//                y = y0 + Rd * Math.sin(t);
//                z = z0 + h;
//                pixel3D(x, y, z, I);
//                t = t + dt;
//            } while (t <= (Math.PI * 2));
//            h = h + dh;
//        } while (h <= 2 * Rd);
        
//        //Chupete
//        Vector3D v3d = new Vector3D();
//        Vector3D w = new Vector3D();
//        t = -5;
//        dt = 0.1;
//        do {
//            h = -5.5;
//            dh = 0.1;
//            do {
//                v3d.color = this.color;
//                v3d.x0 = x0 + Rd * Math.cos(t) * Math.cos(h);
//                v3d.y0 = y0 + Rd * Math.cos(t) * Math.sin(h) * Rd / 2;
//                v3d.z0 = z0 + Rd * Math.sin(t);
//
//                v3d.encender(I);
////                pixel3D(x, y, z, I);
//                h += dh;
//            } while (h <= Math.PI);
//            t += dt;
//        } while (t <= Math.PI);
//
//        t = -5;
//        dt = 0.1;
//        do {
//            h = -5.5;
//            dh = 0.1;
//            do {
//                color = this.color;
//                x = x0 + (Rd / 15)/* REDUCIR ANCHO*/ * Math.cos(t);
//                y = y0 + (Rd / 15) * Math.sin(t);
//                z = z0 + h - Rd - 3;
//                pixel3D(x, y, z, I);
////                v3d.encender(I);
//                h += dh;
//            } while (h <= Math.PI);
//            t += dt;
//        } while (t <= Math.PI);

        //Toroide
//        h = 0;
//            dh = 0.1;
//            do {
//                t = 0;
//                dt = 0.1;
//                do {
//
//                    x = x0 + Math.cos(t) * (Rd + (Rd / 4) * Math.cos(h));
//                    y = y0 + Math.sin(t) * (Rd + (Rd / 4) * Math.cos(h));
//                    z = z0 + (Rd / 4) * Math.sin(h);
//                    color = color;
//                    pixel3D(x, y, z, I);
//                    t = t + dt;
//                } while (t <= 2.01 * Math.PI);
//                h = h + dh;
//            } while (h <= 2 * Math.PI);

            //Sombirlla
             t = 0;
        dt = 0.1;
        do {
            h = 0;
            dh = 0.1;
            do {
                color = this.color;
                x = x0 + Rd * Math.cos(t) * Math.cos(h);
                y = y0 + Rd * Math.cos(t) * Math.sin(h) * Rd / 2;
                z = z0 + Rd * Math.sin(t);
                pixel3D(x, y, z, I);
                h += dh;
            } while (h <= Math.PI);
            t += dt;
        } while (t <= Math.PI);

        t = 0;
        dt = 0.1;
        do {
            h = 0;
            dh = 0.1;
            do {
                color = this.color;
                x = x0 + (Rd / 15)/* REDUCIR ANCHO*/ * Math.cos(t);
                y = y0 + (Rd / 15) * Math.sin(t);
                z = z0 + h - Rd - 3;
                pixel3D(x, y, z, I);
                h += dh;
            } while (h <= Math.PI * 2);
            t += dt;
        } while (t <= 2 * Rd + 3);
    }

    public void encenderI(BufferedImage I) {
        double h = 0;
        double dh = 0.01;
        do {
            x = x0 + Rd * Math.cos(h);
            y = y0 + Rd * Math.sin(h);
            z = z0 + h * ft;
            color = new Color(
                    (int) ((255 / -(Math.PI * 6)) * (h - (Math.PI * 6))),
                    (int) ((255 / (Math.PI * 6)) * (h)),
                    0);
            rotarOpc(x, y, z, TipoRotar);
            pixel3D(x, y, z, I);
            Rd += mRd;
            h += dh;
        } while (h <= Math.PI * 6);
    }

}
