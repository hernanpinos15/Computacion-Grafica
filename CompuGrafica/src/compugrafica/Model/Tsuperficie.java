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
 * @author Mayu
 */
public class Tsuperficie extends Vector3D {

    int tipo;
    double factor;
    Color color1;
    Color color2;
    Color color3;
    Color color4;
    Color colorAd;
    Color colorAf;

    private static int tipoRotar;
    private static int tipoC;
    private static int tipoOpcion;

    public Color getColor4() {
        return color4;
    }

    public void setColor4(Color color4) {
        this.color4 = color4;
    }

    public Color getColor3() {
        return color3;
    }

    public void setColor3(Color color3) {
        this.color3 = color3;
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public static int getTipoC() {
        return tipoC;
    }

    public static void setTipoC(int tipoC) {
        Tsuperficie.tipoC = tipoC;
    }

    public int getTipoRotar() {
        return tipoRotar;
    }

    public void setTipoRotar(int tipoRotar) {
        Tsuperficie.tipoRotar = tipoRotar;
    }

    public static int getTipoOpcion() {
        return tipoOpcion;
    }

    public static void setTipoOpcion(int tipoOpcion) {
        Tsuperficie.tipoOpcion = tipoOpcion;
    }

    public Tsuperficie(double factor) {
        this.factor = factor;
    }

    //
    @Override
    public void encender(BufferedImage I) {
        double t1 = -6, t2 = 6;
        double h1 = -4.5, h2 = 4.5;

        double dt = 0.3;
        double t = t1;

        int i, j, Ni, Nj;

        double[][] Mx = new double[9999][9999];
        double[][] My = new double[9999][9999];

        switch (tipoC) {
            case 1:
                i = 0;
                do {
                    double h = h1;
                    double dh = 0.3;
                    j = 0;
                    do {
                        x = t;
                        y = h;
                        z = (t * t + h * h) * factor - 2;
                        rotarOpc(x, y, z, tipoRotar);
                        pixel3D(x, y, z, I);
                        Mx[i][j] = x;
                        My[i][j] = y;
                        j += 1;
                        h += dh;
                    } while (h <= h2);
                    i += 1;
                    t += dt;
                } while (t <= t2);
                Ni = i;
                Nj = j;
                procesoMallado(Ni - 1, Nj - 1, Mx, My, I);
                Mx = null;
                My = null;

                break;
            case 2:
                i = 0;
                do {
                    double h = h1;
                    double dh = 0.15;
                    j = 0;
                    do {
                        x = t;
                        y = h;
                        z = (t * t - h * h) * (factor) - 2;
                        rotarOpc(x, y, z, tipoRotar);
                        pixel3D(x, y, z, I);
                        Mx[i][j] = x;
                        My[i][j] = y;
                        j += 1;
                        h += dh;
                    } while (h <= h2);
                    i += 1;
                    t += dt;
                } while (t <= t2);
                Ni = i;
                Nj = j;
                procesoMallado(Ni - 1, Nj - 1, Mx, My, I);
                Mx = null;
                My = null;
                break;

            case 3:
                i = 0;
                do {
                    double h = h1;
                    double dh = 0.15;
                    j = 0;
                    do {
                        x = t;
                        y = h;
                        z = (t * Math.sin(h)) * (factor) - 2;
                        rotarOpc(x, y, z, tipoRotar);
                        pixel3D(x, y, z, I);
                        Mx[i][j] = x;
                        My[i][j] = y;
                        j += 1;
                        h += dh;
                    } while (h <= h2);
                    i += 1;
                    t += dt;
                } while (t <= t2);
                Ni = i;
                Nj = j;
                procesoMallado(Ni - 1, Nj - 1, Mx, My, I);
                Mx = null;
                My = null;
                break;

            case 4:
                i = 0;
                do {
                    double h = h1;
                    double dh = 0.15;
                    j = 0;
                    do {
                        x = t;
                        y = h;
                        z = (t * Math.cos(h) + h * Math.sin(t)) * (factor) - 2;
                        rotarOpc(x, y, z, tipoRotar);
                        pixel3D(x, y, z, I);
                        Mx[i][j] = x;
                        My[i][j] = y;
                        j += 1;
                        h += dh;
                    } while (h <= h2);
                    i += 1;
                    t += dt;
                } while (t <= t2);
                Ni = i;
                Nj = j;
                procesoMallado(Ni - 1, Nj - 1, Mx, My, I);
                Mx = null;
                My = null;
                break;

            case 5:
                i = 0;
                do {
                    double h = h1;
                    double dh = 0.15;
                    j = 0;
                    do {
                        x = t;
                        y = h;
                        z = (Math.sin(h + t)) * (factor) - 2;
                        rotarOpc(x, y, z, tipoRotar);
                        pixel3D(x, y, z, I);
                        Mx[i][j] = x;
                        My[i][j] = y;
                        j += 1;
                        h += dh;
                    } while (h <= h2);
                    i += 1;
                    t += dt;
                } while (t <= t2);
                Ni = i;
                Nj = j;
                procesoMallado(Ni - 1, Nj - 1, Mx, My, I);
                Mx = null;
                My = null;
                break;

            case 6:
                i = 0;
                do {
                    double h = h1;
                    double dh = 0.15;
                    j = 0;
                    do {
                        x = t;
                        y = h;
                        z = (Math.pow(t, 3) - Math.pow(h, 2)) * (factor) - 2;
                        rotarOpc(x, y, z, tipoRotar);
                        pixel3D(x, y, z, I);
                        Mx[i][j] = x;
                        My[i][j] = y;
                        j += 1;
                        h += dh;
                    } while (h <= h2);
                    i += 1;
                    t += dt;
                } while (t <= t2);
                Ni = i;
                Nj = j;
                procesoMallado(Ni - 1, Nj - 1, Mx, My, I);
                Mx = null;
                My = null;
                break;

        }

    }

    public void procesoMallado(int Ni, int Nj, double Mx[][], double My[][], BufferedImage I) {
        double xx, yy;
//         color1 = new Color(15, 100, 255);
//         color2 = new Color(35, 239, 0);
//         color3 = new Color(192, 187, 187);
//         color4 = new Color(248, 10, 172);

        for (int i = 0; i < Ni; i++) {
            for (int j = 0; j < Nj; j++) {
                xx = (Mx[i + 1][j] - Mx[i][j]) * (My[i + 1][j + 1] - My[i + 1][j]);
                yy = (Mx[i + 1][j + 1] - Mx[i + 1][j]) * (My[i + 1][j] - My[i][j]);

                if ((xx - yy) > 0) {
                    Cuadrilatero c1 = new Cuadrilatero(
                            Mx[i][j], My[i][j],
                            Mx[i + 1][j], My[i + 1][j],
                            Mx[i + 1][j + 1], My[i + 1][j + 1],
                            Mx[i][j + 1], My[i][j + 1],
                            tipoOpcion);
                    c1.colorAd = this.color3;
                    c1.colorAf = this.color4;
                    c1.encender(I);
                } else {
                    Cuadrilatero c = new Cuadrilatero(
                            Mx[i][j], My[i][j],
                            Mx[i + 1][j], My[i + 1][j],
                            Mx[i + 1][j + 1], My[i + 1][j + 1],
                            Mx[i][j + 1], My[i][j + 1],
                            tipoOpcion);
                    c.colorAd = this.color1;
                    c.colorAf = this.color2;
                    c.encender(I);
                }

            }
        }

    }

}
