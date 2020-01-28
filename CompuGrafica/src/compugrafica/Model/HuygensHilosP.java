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
public class HuygensHilosP extends Vector implements Runnable{

    private double Sx;
    private double Sy;
    private AreaTrabajo bI;
    double d;
        double k;
        double z = 0;
        double W = 1.5;
        double v = 9.3;
        Integer color0;
        double dt = 0.01;
        double tp = 0;
    
    public HuygensHilosP(AreaTrabajo buffImg, double Sx, double Sy) {
        bI = buffImg;
        this.Sx = Sx;
        this.Sy = Sy;
    }
    public void run() {
        
        for (int x = -10; x <= 10; x++) {
            d = Math.sqrt(Math.pow(Sx + x, 2) + Math.pow(Sy - 0, 2));  //0 con 0 xq la fuente sera en el origin
            k = W * (d - tp * v);
            z = Math.sin(k) + 1;
            z += z;
        }
    }
}
