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
public class Figura1 extends Circunferencia {

    public Figura1(int x0, int y0, double Rd) {
        super(x0, y0, Rd);
    }

    @Override
    public void encender(BufferedImage buffImg) {
        super.encenderD2(buffImg);
        Segmento s = new Segmento(x0-Rd, y0-Rd, x0+Rd, y0+Rd);
        s.encender(buffImg);
    }
}
