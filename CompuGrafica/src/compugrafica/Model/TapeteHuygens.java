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
 * @author Herna
 */
public class TapeteHuygens extends Vector implements Runnable {

    private static int tipo;
    private static int paleta;

    double d1;
    double k;
    double z = 0, z1;
    double W = 1.5;
    double v = 9.3;
    Integer color0;
    double dt = 0.5;
    double tp = 0;

    public BufferedImage[] BuffImage;
    public double t;
    public int i;

    public TapeteHuygens(BufferedImage[] BuffImage, double t, int i) {
        this.BuffImage = BuffImage;
        this.t = t;
        this.i = i;

        this.Pl = new ArrayList<>();
        this.Paletas = new ArrayList<>();

        Pl.add(Color.BLACK);
        Pl.add(new Color(0, 0, 128));
        Pl.add(Color.GREEN);
        Pl.add(new Color(0, 255, 255));
        Pl.add(Color.RED);
        Pl.add(new Color(128, 0, 128));
        Pl.add(new Color(165, 42, 42));
        Pl.add(Color.LIGHT_GRAY);
        Pl.add(Color.DARK_GRAY);
        Pl.add(Color.BLUE);
        Pl.add(new Color(191, 255, 0));
        Pl.add(new Color(192, 192, 192));
        Pl.add(new Color(0, 128, 128));
        Pl.add(new Color(255, 0, 255));
        Pl.add(Color.YELLOW);
        Pl.add(Color.WHITE);

        this.P2 = new ArrayList<>(); //azul/ morado
        for (int x = 0; x < 16; x++) {
            P2.add(new Color(17 * x, 0, 255));
        }

        Paletas.add(Pl);
        Paletas.add(P2);

    }

    private final ArrayList Pl;
    private final ArrayList P2;

    private final ArrayList Paletas;

    public static int getTipo() {
        return tipo;
    }

    public static void setTipo(int tipo) {
        TapeteHuygens.tipo = tipo;
    }

    public double getTp() {
        return tp;
    }

    public void setTp(double tp) {
        this.tp = tp;
    }

    public static int getPaleta() {
        return paleta;
    }

    public static void setPaleta(int paleta) {
        TapeteHuygens.paleta = paleta;
    }

    @Override
    public void run() {
        int inc = (int) (dt * 10);
        for (int k = i; k < 100; k += inc) {
            BuffImage[k] = threadEncender(t);
            t += dt;
        }
    }

    public BufferedImage threadEncender(double tp) {
        BufferedImage BuffImage = new BufferedImage(600, 500, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < 600; i++) {
            for (int j = 0; j < 500; j++) {
                procesoCarta(i, j);
                for (int x = -10; x <= 10; x++) {
                    d1 = Math.sqrt(Math.pow(Sx + x, 2) + Math.pow(Sy - 0, 2));  //0 con 0 xq la fuente sera en el origin
                    k = W * (d1 - tp * v);
                    z1 = Math.sin(k) + 1;
                    z += z1;
                }
                color0 = (int) (z * 0.38);
                color = (Color) Pl.get(color0);
                pixel(i, j, BuffImage);
                z = 0;
            }
        }
        return BuffImage;
    }

}
