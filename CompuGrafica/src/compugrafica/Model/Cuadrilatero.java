/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compugrafica.Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author herna
 */
public class Cuadrilatero extends Tsuperficie {

    double Px1, Py1, Qx, Qy, Rx, Ry, Tx, Ty;
   
    int SPx1, SPy1, SQx, SQy, SRx, SRy, STx, STy;

    public Cuadrilatero(double Px1, double Py1, double Qx, double Qy, double Rx, double Ry, double Tx, double Ty, int tipo) {
        super(tipo);
        this.Px1 = Px1;
        this.Py1 = Py1;
        this.Qx = Qx;
        this.Qy = Qy;
        this.Rx = Rx;
        this.Ry = Ry;
        this.Tx = Tx;
        this.Ty = Ty;
        this.tipo = tipo;
    }

    @Override
    public void encender(BufferedImage I) {
        Graphics g = I.getGraphics();
        int np = 4;
        procesoPantalla(Px1, Py1);
        SPx1 = Px;
        SPy1 = Py;
//        System.out.println(SPx1);
//        System.out.println(SPy1);
        procesoPantalla(Qx, Qy);
        SQx = Px;
        SQy = Py;
//        System.out.println("----------------");
//        System.out.println(SQx);
//        System.out.println(SQy);
        procesoPantalla(Rx, Ry);
        SRx = Px;
        SRy = Py;
//        System.out.println("----------------");
//        System.out.println(SRx);
//        System.out.println(SRy);
        procesoPantalla(Tx, Ty);
        STx = Px;
        STy = Py;
//        System.out.println("----------------");
//        System.out.println(STx);
//        System.out.println(STy);

        int xp[] = {SPx1, SQx, SRx, STx};
        int yp[] = {SPy1, SQy, SRy, STy};

        if (tipo == 1) {
            
            g.setColor(this.colorAf);
            g.drawPolygon(xp, yp, np);

        }
        if (tipo == 2) {
            
            g.setColor(this.colorAf);
            g.fillPolygon(xp, yp, np);
            
            g.setColor(Color.RED);
            g.drawPolygon(xp, yp, np);
        }

    }

}
