/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compugrafica.Model;

/**
 *
 * @author herna
 */
public class Ventanas {

    private final int Px1 = 0;
    private final int Py1 = 0;

    protected final int Px2 = 600; //WIDTH
    protected final int Py2 = 500; //HEIGHT

    public double Rx1 = -6;
    public double Ry1 = -5;

    
    //guardar la proporcion a 1.2   en x tenemos 12/1.2 = y
    //por ejemplo  700/450 1.45 20/1.45=13.7...
    
    public double Rx2 = 6;
    public double Ry2 = 5;

    //RAZON
    protected double r = Py2 / (2 * Ry2);

    //VAR PROCESO PANTALLA (A PIXELES)
    protected int Px;
    protected int Py;

    //VER PROCESO CARTA (A DOUBLE)
    protected double Sx;
    protected double Sy;

    public double getRx1() {
        return Rx1;
    }

    public void setRx1(double Rx1) {
        this.Rx1 = Rx1;
    }

    public double getRy1() {
        return Ry1;
    }

    public void setRy1(double Ry1) {
        this.Ry1 = Ry1;
    }

    public double getRx2() {
        return Rx2;
    }

    public void setRx2(double Rx2) {
        this.Rx2 = Rx2;
    }

    public double getRy2() {
        return Ry2;
    }

    public void setRy2(double Ry2) {
        this.Ry2 = Ry2;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public int getPx() {
        return Px;
    }

    public void setPx(int Px) {
        this.Px = Px;
    }

    public int getPy() {
        return Py;
    }

    public void setPy(int Py) {
        this.Py = Py;
    }

    public double getSx() {
        return Sx;
    }

    public void setSx(double Sx) {
        this.Sx = Sx;
    }

    public double getSy() {
        return Sy;
    }

    public void setSy(double Sy) {
        this.Sy = Sy;
    }

    //PROCESO PANTALLA
    public void procesoPantalla(double sx, double sy) {
        Px = (int) ((Px1 - Px2) / (Rx1 - Rx2) * (sx - Rx1)) + Px1;
        Py = (int) ((Py1 - Py2) / (Ry2 - Ry1) * (sy - Ry2)) + Py1;

    }

    //PROCESO CARTA
    public void procesoCarta(int Px, int Py) {
        Sx = (Rx1 - Rx2) * (Px - Px1) / (Px1 - Px2) + Rx1;
        Sy = (Ry2 - Ry1) * (Py - Py1) / (Py1 - Py2) + Ry2;
    }
}
