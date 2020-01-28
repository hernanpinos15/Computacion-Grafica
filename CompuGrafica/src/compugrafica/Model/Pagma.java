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
public class Pagma extends Circunferencia {

    public Pagma(Integer x0, Integer y0, Double Rd) {
        super(x0, y0, Rd);
    }

    public void encender(BufferedImage buffImg) {
        super.encenderPag(buffImg);
        Segmento s1 = new Segmento(x0, y0, x0 + Rd * 0.707, y0 + Rd * 0.707);
        s1.encender(buffImg);
        Segmento s2 = new Segmento(x0 , y0, x0 + Rd * 0.707, y0 - Rd  * 0.707);
        s2.encender(buffImg);
    }

}
