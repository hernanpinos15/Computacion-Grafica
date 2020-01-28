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
public class Numero2 extends Circunferencia{

    public Numero2(int x0, int y0, double Rd) {
        super(x0, y0, Rd);
    }
    
    @Override
    public void encender(BufferedImage buffImg) {
        super.encenderNum2(buffImg);
        Segmento s1 = new Segmento(x0 + Rd * Math.sqrt(3) / 2, y0 - Rd * 0.5, x0 - Rd, y0 - (2.5 * Rd));
        s1.encender(buffImg);
         Segmento s2 = new Segmento(x0-Rd, y0 - 2.5 * Rd, x0+Rd, y0 - 2.5 * Rd);
        s2.encender(buffImg);
    }
    
}
