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
public class Formas3D extends Segmento3D{
    
    public double a,x1,y1,z1;

    public Formas3D() {
    }

    public Formas3D(double a, double x1, double y1, double z1) {
        this.a = a;
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
    }

    
    public void piramide(BufferedImage I){
        Segmento3D s3d1 = new Segmento3D(x1,y1,z1,x1,y1+4,z1);
        s3d1.encender(I);
        
        Segmento3D s3d2 = new Segmento3D(x1,y1,z1,x1-4,y1,z1);
        s3d2.encender(I);
        
        Segmento3D s3d3 = new Segmento3D(x1,y1+4,z1,x1-4,y1+4,z1);
        s3d3.encender(I);
        
        Segmento3D s3d4 = new Segmento3D(x1-4,y1+4,z1,x1-4,y1,z1);
        s3d4.encender(I);
       
        
        Segmento3D s3d5 = new Segmento3D((x1-4)/2,(y1+2)/2,z1+2,x1,y1,z1);
        s3d5.encender(I);
        
        Segmento3D s3d6 = new Segmento3D((x1-4)/2,(y1+2)/2,z1+2,x1,y1+2,z1);
        s3d6.encender(I);
        
        Segmento3D s3d7 = new Segmento3D((x1-4)/2,(y1+2)/2,z1+2,x1-4,y1+2,z1);
        s3d7.encender(I);
        
        Segmento3D s3d8 = new Segmento3D((x1-4)/2,(y1+2)/2,z1+2,x1-4,y1,z1);
        s3d8.encender(I);
        
    }
}
