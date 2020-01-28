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
public class Vector3D extends Vector {

    public double betaX = 0;
    public double betaY = 0;
    public double betaZ = 0;

    public double teta1 = 0;
    public double teta2 = 0;
    public double teta3 = 0;

    public double tetaSR = 0;

    public double z0;
    public double z;
    public double Ax;
    public double Ay;
    public double Alfa = Math.PI / 4;

    public double Ro = 0.5;

    public Vector3D() {
    }

    public Vector3D(double x0, double y0, double z0) {
        super(x0, y0);
        this.z0 = z0;
    }

    public Vector3D(double x0, double y0, double z0, Color color) {
        super(x0, y0, color);
        this.z0 = z0;

    }

    @Override
    public void encender(BufferedImage I) {
        pixel3D(x0, y0, z0, I);
    }

    public void ProcesoAxonometria(double x0, double y0, double z0) {
        rotarx(x0, y0, z0);
        rotary(x, y, z);
        rotarz(x, y, z);
//        System.out.println(x + "---" + y);
        Ax = y - x * Ro * Math.cos(Alfa);
        Ay = z - x * Ro * Math.sin(Alfa);

//        Ax = y0 + x0 * Ro * Math.cos(Alfa);
//        Ay = z0 + x0 * Ro * Math.sin(Alfa);
//        Ax = y0 - x0 * Ro * Math.cos(Alfa);
//        Ay = z0 + x0 * Ro * Math.sin(Alfa);
//        Ax = y0 + x0 * Ro * Math.sin(Alfa);
//        Ay = z0 - x0 * Ro * Math.cos(Alfa);
    }

    public void rotarOpc(double x0, double y0, double z0, int eje) {

        if (eje == 1) {
            this.x = x0;
            this.y = y0 * Math.cos(teta1) - z0 * Math.sin(teta1);
            this.z = y0 * Math.sin(teta1) + z0 * Math.cos(teta1);
        } else {
            if (eje == 2) {
                this.x = x0 * Math.cos(teta2) + z0 * Math.sin(teta2);
                this.y = y0;
                this.z = -x0 * Math.sin(teta2) + z0 * Math.cos(teta2);
            } else {
                if (eje == 3) {
                    this.x = x0 * Math.cos(teta3) - y0 * Math.sin(teta3);
                    this.y = x0 * Math.sin(teta3) + y0 * Math.cos(teta3);
                    this.z = z0;
                } else {
                    if (eje == 4) {
                        this.x = x0 * Math.sin(teta) - y0 * Math.cos(teta) - z0 * Math.sin(teta);
                        this.y = -x0 * Math.cos(teta) + y0 * Math.sin(teta) + z0 * Math.cos(teta);
                        this.z = -x0 * Math.sin(teta) + y0 * Math.sin(teta) + z0 * Math.cos(teta);
                    }
                }
            }
        }

    }

    public void rotarx(double x0, double y0, double z0) {
        this.x = x0;
        this.y = y0 * Math.cos(teta1) - z0 * Math.sin(teta1);
        this.z = y0 * Math.sin(teta1) + z0 * Math.cos(teta1);
    }

    public void rotary(double x0, double y0, double z0) {
        this.x = x0 * Math.cos(teta2) + z0 * Math.sin(teta2);
        this.y = y0;
        this.z = -x0 * Math.sin(teta2) + z0 * Math.cos(teta2);
    }

    public void rotarz(double x0, double y0, double z0) {
        this.x = x0 * Math.cos(teta3) - y0 * Math.sin(teta3);
        this.y = x0 * Math.sin(teta3) + y0 * Math.cos(teta3);
        this.z = z0;
    }
//    public void rotarx(double x0, double y0, double z0) {
//        this.x = x0;
//        this.y = y0 * Math.cos(betaX) - z0 * Math.sin(betaX);
//        this.z = y0 * Math.sin(betaX) + z0 * Math.cos(betaX);
//    }
//
//    public void rotary(double x0, double y0, double z0) {
//        this.x = x0 * Math.cos(betaY) + z0 * Math.sin(betaY);
//        this.y = y0;
//        this.z = -x0 * Math.sin(betaY) + z0 * Math.cos(betaY);
//    }
//
//    public void rotarz(double x0, double y0, double z0) {
//        this.x = x0 * Math.cos(betaZ) - y0 * Math.sin(betaZ);
//        this.y = x0 * Math.sin(betaZ) + y0 * Math.cos(betaZ);
//        this.z = z0;
//    }

    public void rotarPrueba(double x0, double y0, double z0) {
        this.x = x0 * Math.sin(teta) - y0 * Math.cos(teta) - z0 * Math.sin(teta);
        this.y = -x0 * Math.cos(teta) + y0 * Math.sin(teta) + z0 * Math.cos(teta);
        this.z = -x0 * Math.sin(teta) + y0 * Math.sin(teta) + z0 * Math.cos(teta);
    }

    public void pixel3D(double x0, double y0, double z0, BufferedImage I) {
        rotarx(x0, y0, z0);
        rotary(x, y, z);
        rotarz(x, y, z);
        ProcesoAxonometria(x0, y0, z0);
        pixel(Ax, Ay, I);
    }
}
