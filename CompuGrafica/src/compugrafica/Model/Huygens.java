/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compugrafica.Model;

import java.awt.Color;

import java.awt.image.BufferedImage;
//import javafx.scene.paint.Color;
import java.util.ArrayList;

/**
 *
 * @author Herna
 */
public class Huygens extends Vector {

    private static int tipo;
    private static int paleta;
    public double tp;

    public Huygens() {
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
        for (int i = 0; i < 16; i++) {
            P2.add(new Color(17 * i, 0, 255));
        }

        Paletas.add(Pl);
        Paletas.add(P2);

    }

    private ArrayList Pl;
    private ArrayList P2;

    private ArrayList Paletas;

    public static int getTipo() {
        return tipo;
    }

    public static void setTipo(int tipo) {
        Huygens.tipo = tipo;
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
        Huygens.paleta = paleta;
    }

    @Override
    public void encender(BufferedImage I) {
        //System.out.println(I);
        double d1, d2, d3;
        double k1, k2, k3;
        double z1, z2, z = 0, z3;
        double W = 1.5;
        double v = 9.3;
        //double tp = 4;
        Integer color0;
        for (int i = 0; i < 600; i++) {
            for (int j = 0; j < 500; j++) {
                procesoCarta(i, j);
                for (int x = -10; x <= 10; x++) {
                    d1 = Math.sqrt(Math.pow(Sx + x, 2) + Math.pow(Sy - 0, 2));  //0 con 0 xq la fuente sera en el origin
                    k1 = W * (d1 - tp * v);
                    z1 = Math.sin(k1) + 1;
                    z += z1;
                }
                color0 = (int) (z * 0.38);
                color = (Color) Pl.get(color0);
                pixel(i, j, I);
                z = 0;

            }
        }

    }

}
