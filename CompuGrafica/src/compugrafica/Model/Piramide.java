/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compugrafica.Model;

import com.sun.org.apache.bcel.internal.generic.D2F;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author herna
 */
public class Piramide extends Curva3D {

    public int nLados;
    public double altura;

    int tipoRotar;

    public int getTipoRotar() {
        return tipoRotar;
    }

    public void setTipoRotar(int tipoRotar) {
        this.tipoRotar = tipoRotar;
    }

    public Piramide(double x0, double y0, double z0, double Rd, double altura, int nLados) {
        super(x0, y0, z0, Rd);
        this.nLados = nLados;
        this.altura = altura;
    }

    public Piramide(double x0, double y0, double z0, double Rd, double altura, int nLados, Color color) {
        super(x0, y0, z0, Rd, color);
        this.nLados = nLados;
        this.altura = altura;
    }

    @Override
    public void encender(BufferedImage I) {
        double alfa;
        double beta;

        beta = (Math.PI * 2 / nLados);
        alfa = 0;
         

        for (int i = 1; i <= nLados; i++) {

            Segmento3D s = new Segmento3D(
                    x + Rd * Math.cos(alfa), y + Rd * Math.sin(alfa), z,
                    x + Rd * Math.cos(alfa + beta), y + Rd * Math.sin(alfa + beta), z);
            s.color = this.color;  //apagar
            s.teta = this.teta;
            rotarz(x, y, z);
            
            s.encender(I);
            Segmento3D t = new Segmento3D(
                    x + Rd * Math.cos(alfa), y + Rd * Math.sin(alfa), z,
                    x, y, -(z + altura));
            t.color = this.color; //apagar
//            rotarOpc(x, y, z, tipoRotar);
            t.teta = this.teta;
            rotarz(x, y, z);
            t.encender(I);

            alfa = alfa + beta;

        }

    }

}
