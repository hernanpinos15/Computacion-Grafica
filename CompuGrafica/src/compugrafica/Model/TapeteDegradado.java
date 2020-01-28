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
public class TapeteDegradado extends Vector {

    private static int tipo;
    private ArrayList Pl;
    private ArrayList Pl2;

    public static int getTipo() {
        return tipo;
    }

    public static void setTipo(int tipo) {
        TapeteDegradado.tipo = tipo;
    }

    public TapeteDegradado() {
        this.Pl = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            Pl.add(new Color(0, 255, (int) (51 * (i - 1))));
        }

        for (int i = 7; i <= 16; i++) {
            Pl.add(new Color((int) (28.33 * (16 - i)), 0, (int) (28.33 * (i - 7))));
        }

//        Pl.add(Color.BLACK);
//        Pl.add(new Color(0, 0, 128));
//        Pl.add(Color.GREEN);
//        Pl.add(new Color(0, 255, 255));
//        Pl.add(Color.RED);
//        Pl.add(new Color(128, 0, 128));
//        Pl.add(new Color(165, 42, 42));
//        Pl.add(Color.LIGHT_GRAY);
//        Pl.add(Color.DARK_GRAY);
//        Pl.add(Color.BLUE);
//        Pl.add(new Color(191, 255, 0));
//        Pl.add(new Color(192, 192, 192));
//        Pl.add(new Color(0, 128, 128));
//        Pl.add(new Color(255, 0, 255));
//        Pl.add(Color.YELLOW);
//        Pl.add(Color.WHITE);
//
//        this.Pl2 = new ArrayList<>();
//        for (int i = 0; i < 15; i++) {
//            Pl2.add(new Color(17 * i, 0, 255));
//        }
    }

    @Override
    public void encender(BufferedImage I) {
        Integer Sx, Sy;
        Integer colorT;
        
        switch (tipo) {
            
            case 1:
                for (Sx = 0; Sx < 600; Sx++) {
                    for (Sy = 0; Sy < 500; Sy++) {
                        colorT = (int) ((Sx*Sx+Sy*Sy) % 16);
                        color = (Color) Pl.get(colorT);
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
