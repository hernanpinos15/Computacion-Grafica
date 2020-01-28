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
public class Tapete1 extends Vector {

    private static int tipo;
    private static int paleta;
    public int tp;

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public static int getPaleta() {
        return paleta;
    }

    public static void setPaleta(int paleta) {
        Tapete1.paleta = paleta;
    }
    private ArrayList Pl;
    private ArrayList P2;
    private ArrayList P3;
    private ArrayList P4;
    private ArrayList P5;
    private ArrayList Paletas;

    public static int getTipo() {
        return tipo;
    }

    public static void setTipo(int tipo) {
        Tapete1.tipo = tipo;
    }

    public Tapete1() {
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

        this.P3 = new ArrayList<>();//rojo azul

        for (int x = 0; x < 15; x++) {
            if (x == 0) {
                P3.add(Color.BLACK);
            }
            P3.add(new Color(17 * x, 0, 255));
        }
        this.P4 = new ArrayList<>();//amarillo rojo

        for (int x = 0; x < 15; x++) {
            if (x == 0) {
                P3.add(Color.BLACK);
            }
            P4.add(new Color(255, 17 * x, 0));
        }
        this.P5 = new ArrayList<>();//amarillo azul

        for (int x = 0; x < 15; x++) {
            if (x == 0) {
                P5.add(Color.BLACK);
            }
            P5.add(new Color(17 * x, 17 * x, 0));
        }
        Paletas.add(Pl);
        Paletas.add(P2);
        Paletas.add(P3);
    }

    @Override
    public void encender(BufferedImage I) {
        Integer colorT;
        double d1, d2, d3;
        double k1, k2, k3;
        double z1, z2, z = 0, z3;
        double W = 1.5;
        double v = 9.3;
        //double tp = 4;
        Integer color0;

        switch (tipo) {
            case 0:
                for (Sx = 0; Sx < 600; Sx++) {
                    for (Sy = 0; Sy < 500; Sy++) {
                        pixel(Sx, Sy, I);
                    }
                }
                break;
            //Onda 1 tapete 1
            case 1:

                for (int i = 0; i < 600; i++) {
                    for (int j = 0; j < 500; j++) {
                        procesoCarta(i, j);
                        d1 = Math.sqrt(Math.pow(Sx - 0, 2) + Math.pow(Sy - 0, 2));  //0 con 0 xq la fuente sera en el origin
                        k1 = (1.5) * (d1 - tp * v);
                        z1 = Math.sin(k1) + 1;
                        color0 = (int) (z1 * 8);
                        color = (Color) Pl.get(color0);
                        pixel(i, j, I);

                    }
                }
                break;
            //Onda 1 tapete 2
            case 2:
                for (int i = 0; i < 600; i++) {
                    for (int j = 0; j < 500; j++) {
                        procesoCarta(i, j);
                        d1 = Math.sqrt(Math.pow(Sx - 0, 2) + Math.pow(Sy - 0, 2));  //0 con 0 xq la fuente sera en el origin
                        k1 = (1.5) * (d1 - tp * v);
                        z1 = Math.sin(k1) + 1;
                        color0 = (int) (z1 * 8);
                        color = (Color) P2.get(color0);
                        pixel(i, j, I);

                    }
                }
                break;
            //Onda 2 tapete 1
            case 3:
                for (int i = 0; i < 600; i++) {
                    for (int j = 0; j < 500; j++) {
                        procesoCarta(i, j);
                        d1 = Math.sqrt(Math.pow(Sx - 3, 2) + Math.pow(Sy - 0, 2));  //0 con 0 xq la fuente sera en el origin
                        d2 = Math.sqrt(Math.pow(Sx + 3, 2) + Math.pow(Sy - 0, 2));
                        k1 = (1.5) * (d1 - tp * v);
                        k2 = (1.5) * (d2 - tp * v);
                        z1 = Math.sin(k1) + 1;
                        z2 = Math.sin(k2) + 1;
                        z = z1 + z2;
                        color0 = (int) (z * 4);
                        color = (Color) P3.get(color0);
                        pixel(i, j, I);

                    }
                }
                break;
            //Onda 2 tapete 2
            case 4:
                for (int i = 0; i < 600; i++) {
                    for (int j = 0; j < 500; j++) {
                        procesoCarta(i, j);
                        d1 = Math.sqrt(Math.pow(Sx - 3, 2) + Math.pow(Sy - 0, 2));  //0 con 0 xq la fuente sera en el origin
                        d2 = Math.sqrt(Math.pow(Sx + 3, 2) + Math.pow(Sy - 0, 2));
                        k1 = (1.5) * (d1 - tp * v);
                        k2 = (1.5) * (d2 - tp * v);
                        z1 = Math.sin(k1) + 1;
                        z2 = Math.sin(k2) + 1;
                        z = z1 + z2;
                        color0 = (int) (z * 4);
                        color = (Color) P2.get(color0);
                        pixel(i, j, I);

                    }
                }
                break;
            //Onda 3 tapete 1
            case 5:
                for (int i = 0; i < 600; i++) {
                    for (int j = 0; j < 500; j++) {
                        procesoCarta(i, j);
                        d1 = Math.sqrt(Math.pow(Sx - 5, 2) + Math.pow(Sy - 0, 2));  //0 con 0 xq la fuente sera en el origin
                        d2 = Math.sqrt(Math.pow(Sx + 0, 2) + Math.pow(Sy - 0, 2));
                        d3 = Math.sqrt(Math.pow(Sx + 5, 2) + Math.pow(Sy - 0, 2));
                        k1 = (1.5) * (d1 - tp * v);
                        k2 = (1.5) * (d2 - tp * v);
                        k3 = (1.5) * (d3 - tp * v);
                        z1 = Math.sin(k1) + 1;
                        z2 = Math.sin(k2) + 1;
                        z3 = Math.sin(k3) + 1;
                        z = z1 + z2 + z3;
                        color0 = (int) (z * 5 / 2);
                        color = (Color) Pl.get(color0);
                        pixel(i, j, I);

                    }
                }
                break;
            //Onda 3 tapete 2    
            case 6:
                for (int i = 0; i < 600; i++) {
                    for (int j = 0; j < 500; j++) {
                        procesoCarta(i, j);
                        d1 = Math.sqrt(Math.pow(Sx - 5, 2) + Math.pow(Sy - 0, 2));  //0 con 0 xq la fuente sera en el origin
                        d2 = Math.sqrt(Math.pow(Sx + 0, 2) + Math.pow(Sy - 0, 2));
                        d3 = Math.sqrt(Math.pow(Sx + 5, 2) + Math.pow(Sy - 0, 2));
                        k1 = (1.5) * (d1 - tp * v);
                        k2 = (1.5) * (d2 - tp * v);
                        k3 = (1.5) * (d3 - tp * v);
                        z1 = Math.sin(k1) + 1;
                        z2 = Math.sin(k2) + 1;
                        z3 = Math.sin(k3) + 1;
                        z = z1 + z2 + z3;
                        color0 = (int) (z * 5 / 2);
                        color = (Color) P4.get(color0);
                        pixel(i, j, I);

                    }
                }
                break;

            case 7:
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
                break;
        }

    }

}
