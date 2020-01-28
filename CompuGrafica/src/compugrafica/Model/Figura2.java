/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compugrafica.Model;

import java.awt.image.BufferedImage;

/**
 *
 * @author herna
 */
public class Figura2 extends Circunferencia {

    public Figura2(int x0, int y0, double Rd) {
        super(x0, y0, Rd);
    }
    
    @Override
    public void encender(BufferedImage buffImg) {
        super.encenderLd(buffImg);
        Segmento s = new Segmento(x0+Rd*0.866, y0-Rd*1.15, x0+Rd*0.866, y0+Rd*2.30);
        s.encender(buffImg);
    }
}
