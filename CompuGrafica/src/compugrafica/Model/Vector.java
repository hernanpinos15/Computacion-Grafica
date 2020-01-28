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
public class Vector extends Ventanas {

    public double x0;
    public double y0;
    public double teta;
    public Color color;
    public Color color1;
    public Color color2;
    public Color color3;
    public Color color4;
    public Color colorAd;
    public Color colorAf;

    public double x; //AUX
    public double y; //AUX

    protected double d; //VAR (NORMA EUCLIDEA)

     public Vector() {
        this.x0 = 0.0;
        this.y0 = 0.0;
        this.color = Color.BLACK;
    }

    public Vector(double x0, double y0) {
        this.x0 = x0;
        this.y0 = y0;
        this.color = Color.BLACK;
    }

    public Vector(double x0, double y0, Color color) {
        this.x0 = x0;
        this.y0 = y0;
        this.color = color;
    }

    //Proceso Carta Puntos Iniciales
    public Vector(int x0, int y0) {
        procesoCarta(x0, y0);
        this.x0 = Sx;
        this.y0 = Sy;
        this.color = Color.BLACK;
    }

    public void Vector(int x0, int y0) {
        procesoCarta(x0, y0);
        this.x0 = Sx;
        this.y0 = Sy;
        //this.color = Color.BLACK;
    }

    //Proceso Carta Puntos Iniciales  con color
    public Vector(int x0, int y0, Color color) {
        procesoCarta(x0, y0);
        this.x0 = Sx;
        this.y0 = Sy;
        this.color = color;
    }
    
    //ENCENDER PIXEL
    public void encender(BufferedImage buffImg) {
        pixel(x0, y0, buffImg);
    }

    //APAGAR PIXEL
    public void apagar(BufferedImage buffImg) {
        Color aux = color;
        Color aux1 = color1;
        Color aux2 = color2;
        Color aux3 = color3;
        Color aux4 = color4;
        Color aux5 = colorAd;
        Color aux6 = colorAf;
        color = Color.WHITE;
        color1 = Color.WHITE;
        color2 = Color.WHITE;
        color3 = Color.WHITE;
        color4 = Color.WHITE;
        colorAd = Color.WHITE;
        colorAf = Color.WHITE;
        encender(buffImg);
        color = aux;
        color1 = aux1;
        color2 = aux2;
        color3 = aux3;
        color4 = aux4;
        colorAd = aux5;
        colorAf = aux6;
    }

    //PINTAR PIXEL
//    public void pixel(double x, double y, BufferedImage buffImg) {
//        rotar1(x, y);
//        procesoPantalla(this.x, this.y);
//        if (Px >= 0 && Px < Px2 && Py >= 0 && Py < Py2) {
//            buffImg.setRGB(Px, Py, color.getRGB());
//        }
//        // System.out.println(color.getRGB());
//    }
    public void pixel(double x, double y, BufferedImage buffImg) {
        rotar(x, y);
        procesoPantalla(this.x, this.y);
        if (Px >= 0 && Px < Px2 && Py >= 0 && Py < Py2) {
            buffImg.setRGB(Px, Py, color.getRGB());
        }
        //System.out.println("1" +buffImg);
    }

    public void pixel(int x, int y, BufferedImage buffImg) {
        //rotar(x, y);
        if (x >= 0 && x < 600 && y >= 0 && y < 500) {
            buffImg.setRGB(x, y, color.getRGB());
        }
    }

    //ROTAR1
    public void rotar(double x0, double y0) {
        this.x = x0 * Math.cos(teta) - y0 * Math.sin(teta);
        this.y = x0 * Math.sin(teta) + y0 * Math.cos(teta);
    }

    public void rotar2(double x0, double y0) {
        this.x = x0 + (x0 * Math.cos(teta) - y0 * Math.sin(teta));
        this.y = y0 + (x0 * Math.sin(teta) + y0 * Math.cos(teta));
    }

    public void delay(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
