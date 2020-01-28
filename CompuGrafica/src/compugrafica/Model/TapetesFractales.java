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
 * @author herna
 */
public class TapetesFractales extends Vector{
    
    private static int tipo;
    private static int paleta;

    public static int getPaleta() {
        return paleta;
    }

    public static void setPaleta(int paleta) {
        TapetesFractales.paleta = paleta;
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
        TapetesFractales.tipo = tipo;
    }

    public TapetesFractales() {
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
        Mandelbort mn = new Mandelbort();
        Integer colorT;
        
        switch (tipo) {
            case 0:
                for (Sx = 0; Sx < 600; Sx++) {
                    for (Sy = 0; Sy < 500; Sy++) {
                        pixel(Sx, Sy, I);
                    }
                }
                break;
            case 1:
                for (int i = 0; i < 600; i++) {
                    for (int j = 0; j < 500; j++) {
                        procesoCarta(i, j);
                        colorT = mn.Julia(Sx, Sy) % 15;
                        color = (Color) P4.get(colorT);
                        pixel(i, j, I);
                    }
                }
                break;

            case 2:
                for (int i = 0; i < 600; i++) {
                    for (int j = 0; j < 500; j++) {
                        procesoCarta(i, j);
                        colorT = mn.Mandelbrot(Sx, Sy) % 15;
                        color = (Color) P2.get(colorT);
                        pixel(i, j, I);
                    }
                }
                break;

            case 3:
                for (int i = 0; i < 600; i++) {
                    for (int j = 0; j < 500; j++) {
                        procesoCarta(i, j);
                        colorT = mn.Julia(Sx, Sy) % 15;
                        color = (Color) P3.get(colorT);
                        pixel(i, j, I);
                    }
                }
                break;

            case 4:
                for (int i = 0; i < 600; i++) {
                    for (int j = 0; j < 500; j++) {
                        procesoCarta(i, j);
                        colorT = mn.Mandelbrot(Sx, Sy) % 15;
                        color = (Color) P5.get(colorT);
                        pixel(i, j, I);
                    }
                }
                break;

        }

    }
}
