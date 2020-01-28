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
public class Tapete extends Vector {

    private static int tipo;
    public ArrayList Pl;
    private ArrayList Pl2;
    private ArrayList Pl3;
    private ArrayList Pl4;
    private ArrayList Pl5;
    private ArrayList Pl6;


    public static int getTipo() {
        return tipo;
    }

    public static void setTipo(int tipo) {
        Tapete.tipo = tipo;
    }

    public Tapete() {
        this.Pl = new ArrayList<>();

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

        this.Pl2 = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Pl2.add(new Color(17 * i, 0, 255));
        }
        this.Pl3 = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Pl3.add(new Color(17 * i, 17 * i, 255));
        }
        this.Pl4 = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Pl4.add(new Color(17 * i, 17 * i, 17 * i));
        }
        
        this.Pl5 = new ArrayList<>();
        
            Pl5.add(Color.BLACK);
        
        
        
        

    }

    @Override
    public void encender(BufferedImage I) {
        Integer Sx, Sy;
        Integer colorT;
        switch (tipo) {
            case 1:
                for (Sx = 0; Sx < 600; Sx++) {
                    for (Sy = 0; Sy < 500; Sy++) {
                        colorT = (int) Math.abs((((Math.log(Sy) + Math.log(Sx))) % 16));
                        color = (Color) Pl.get(colorT);
                        pixel(Sx, Sy, I);
                    }
                }
                break;
            case 2:
                for (Sx = 0; Sx < 600; Sx++) {
                    for (Sy = 0; Sy < 500; Sy++) {
                        colorT = (int) ((Math.pow(Sx, 2) + Math.pow(Sy, 2)) % 16);
                        color = (Color) Pl.get(colorT);
                        pixel(Sx, Sy, I);
                    }
                }
                break;
            case 3:
                for (Sx = 0; Sx < 600; Sx++) {
                    for (Sy = 0; Sy < 500; Sy++) {
                        colorT = (int) ((Math.E * Sx * Sx + Math.E * Sy * Sy) % 16);
                        color = (Color) Pl.get(colorT);
                        pixel(Sx, Sy, I);
                    }
                }
                break;
            case 4:
                for (Sx = 0; Sx < 600; Sx++) {
                    for (Sy = 0; Sy < 500; Sy++) {
                        colorT = (int) (Math.sqrt((2.5 * Sx * Sx * Sy)) + Math.sqrt(2.5 * Sy * Sy * Sx)) % 16;
                        color = (Color) Pl.get(colorT);
                        pixel(Sx, Sy, I);
                    }
                }
                break;

            case 5:
                for (Sx = 0; Sx < 600; Sx++) {
                    for (Sy = 0; Sy < 500; Sy++) {
                        colorT = (int) ((Sx * Sx + Sy * Sy) % 16);
                        color = (Color) Pl2.get(colorT);
                        pixel(Sx, Sy, I);
                    }
                }
                break;
            case 6:
                for (Sx = 0; Sx < 200; Sx++) {
                    for (Sy = 0; Sy < 500; Sy++) {
                        colorT = (int) ((Math.pow(Sx, 2) + Math.pow(Sy, 2)) % 16);
                        color = (Color) Pl2.get(colorT);
                        pixel(Sx, Sy, I);
                    }
                }
                for (Sx = 200; Sx < 400; Sx++) {
                    for (Sy = 0; Sy < 500; Sy++) {
                        colorT = (int) ((Math.pow(Sx, 2) + Math.pow(Sy, 2)) % 16);
                        color = (Color) Pl3.get(colorT);
                        pixel(Sx, Sy, I);
                    }
                }
                for (Sx = 400; Sx < 600; Sx++) {
                    for (Sy = 0; Sy < 500; Sy++) {
                        colorT = (int) ((Math.pow(Sx, 2) + Math.pow(Sy, 2)) % 16);
                        color = (Color) Pl4.get(colorT);
                        pixel(Sx, Sy, I);
                    }
                }
                break;
                case 7:
                for (Sx = 0; Sx < 600; Sx++) {
                    for (Sy = 0; Sy < 500; Sy++) {
                        colorT = (int) ((Sx * Sx + Sy * Sy) % 16);
                        color = (Color) Pl2.get(colorT);
                        pixel(Sx, Sy, I);
                    }
                    for (Sy = 0; Sy < 500; Sy++) {
                        colorT = (int) ((Sx * Sx + Sy * Sy) % 16);
                        color = (Color) Pl2.get(colorT);
                        pixel(Sx, Sy, I);
                    }
                }
                break;
            default:
                break;
        }

    }

    //colorT =(int) (Math.PI * (Math.pow(Sx, 2))+((Sx*Sx + Sy * Sy) / 80)) % 16;
    //colorT = (int) ((5 * Sx + 0.5 * Sy * Sy) / 40) % 16;
    //colorT = (int)((Math.log((Sx+Sy)/2)) % 16);
    //colorT = (int) ((Sx * Sx + Sy * Sy) % 16);
    //ColorT = (int)Math.Abs((((Math.Cos(Sx) + Math.Sin(Sy))) % 15));
    //ColorT = ((Sx * Sy + Sy * Sy - 4) / 30) % 15;
// ColorT = ((Sx + Sy * Sy) / 30) % 15;
}
