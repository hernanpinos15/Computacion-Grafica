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
public class PaisajeFractal extends Circunferencia {

    public double alfa;  //tallo 
    public double beta;  //raices a mayor num se enconje 
    Vector v = new Vector();

    public PaisajeFractal() {
        this.x0 = 0.0;
        this.y0 = 0.0;
        this.Rd = 0.0;
        this.alfa = 0.0;
        this.beta = 0.0;

    }

    public PaisajeFractal(double alfa, double beta, double x0, double y0, double Rd) {
        super(x0, y0, Rd);
        this.alfa = alfa;
        this.beta = beta;
    }

    public PaisajeFractal(double alfa, double beta, double x0, double y0, double Rd, Color color) {
        super(x0, y0, Rd, color);
        this.alfa = alfa;
        this.beta = beta;
    }

    public PaisajeFractal(double d, double d0, double d1, double z0, double w0, double d2, Color colorCafe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void encender(BufferedImage I) {

        degradado(I);
        //relenoCir(I);
        //mediaCir(I);
    }

    public void degradado(BufferedImage I) {
        for (int i = 0; i < 600; i++) {

            for (int j = 0; j < 500; j++) {
                //color = new Color(0, (int) (1.02 * (j - 250)), (int) (1.02 * (j - 250)));
                color = Color.BLACK;

                pixel(i, j, I);
            }
        }
    }

    public void mediaCir(BufferedImage I) {

        double x = -6;
        double y = 4;
        do {
            do {
                v.x0 = x;
                v.y0 = -Math.pow(x / 6, 2) - y;
                v.encender(I);
                x += 0.02;
            } while (x < 6);
            x = -6;
            y += 0.05;
        } while (y < 5);
    }

    public void relenoCir(BufferedImage I) {

        double y = 6.57;
        for (int i = 0; i <= 88; i++) {
            double x = -6;
            do {
                v.x0 = x;
                v.y0 = (((10 - x) * (10 + x)) / 40) - y;
                v.color = new Color(0, 0, 0);
                v.encender(I);
                x += 0.02;
            } while (x < 6);
            y += 0.028;
        }
    }

    public void procesoArbol(BufferedImage I) {

        double rx, ry, Rd1, alfa1;
        Rd1 = Rd;
        alfa1 = alfa;
        if (Rd >= 0.1) {
            rx = x0 + Rd * Math.cos(alfa);
            ry = y0 + Rd * Math.sin(alfa);

            color = new Color(255, (int) ((255 / 3.9) * (Rd - 0.1)), (int) ((200 / 3.9) * (Rd - 0.1)));
            Segmento s = new Segmento(x0, y0, rx, ry, color);
            s.encender(I);

            color = new Color(255, (int) ((255 / 3.9) * (Rd - 0.1)), (int) ((200 / 3.9) * (Rd - 0.1)));

            x0 = rx;
            y0 = ry;
            Rd = Rd1 / 1.8;
            alfa = alfa1 - beta;
            procesoArbol(I);

            x0 = rx;
            y0 = ry;
            Rd = Rd1 / 1.8;
            alfa = alfa1 + beta;
            procesoArbol(I);

            x0 = rx;
            y0 = ry;
            Rd = Rd1 / 1.6;
            alfa = alfa1;
            procesoArbol(I);

        }
    }

    public void encederLuna(BufferedImage I) {

        double lx = 0.02;
        Circunferencia C = new Circunferencia(x0, y0, Rd, color);

//        d = 2 * Math.PI * Rd * r;
//        double dt = (1 / (r * d));
//        double t = 0.0;
//        do {
//
//            x = x0 + Rd * Math.cos(t);
//            y = y0 + Rd * Math.sin(t);
//
//            pixel(x, y, I);
//
//            t += dt;
//        } while (t <= Math.PI * 2);
        //luna
        do {
            /*C.radio = C.radio - 0.03;
                C.color = Color.FromArgb();
                C.Encender(lienzo);*/
            // solo rellenaado

            C.Rd = lx;
            // C.color = Color.FromArgb((int)((15.03759 * (1.3 - rx)) + (191.7293233 * (rx))), (int)((15.03759 * (1.3 - rx)) + (191.7293233 * (rx))), (int)((15.03759 * (1.3 - rx)) + (191.7293233 * (rx))));   // con 30 
            //C.color = Color.FromArgb((int)((37.59398496 * (1.3 - rx)) + (191.7293233 * (rx))), (int)((37.59398496 * (1.3 - rx)) + (191.7293233 * (rx))), (int)((37.59398496 * (1.3 - rx)) + (191.7293233 * (rx))));  // con 50
            C.color = new Color((int) ((75.18796992 * (1.3 - lx)) + (191.7293233 * (lx))), (int) ((75.18796992 * (1.3 - lx)) + (191.7293233 * (lx))), (int) ((75.18796992 * (1.3 - lx)) + (191.7293233 * (lx))));   // con 100
            C.encender(I);
            lx = lx + 0.003;

        } while (lx <= 1.3);

        //destello de luna
        do {
            C.Rd = lx;
            //C.color = Color.FromArgb((int)(285.7142 * (2 - rx)), (int)(364.28 * (2 - rx)), (int)(364.28 * (2 - rx)));
            C.color = new Color((int) (350 * (lx - 1.3)), (int) (225.71 * (2 - lx) + 50 * (lx - 1.3)), (int) (175.71 * (2 - lx) + 1.492 * (lx - 1.3)));
            C.encender(I);
            lx = lx + 0.01;
        } while (lx <= 2);

    }

    public void encenderSol(BufferedImage I) {

        double sx = 0.02;
        Circunferencia C = new Circunferencia(x0, y0, Rd, color);
        //sol
        do {
            C.Rd = sx;
            //C.color = Color.FromArgb((int)((196.15 * (1.3 - sx)) + (189.23 * (sx))), (int)((88.46 * (1.3 - sx)) + (153.84 * (sx))), (int)((5.38 * (1.3 - sx)) + (56.92 * (sx))));   // con 100
            //C.color = Color.FromArgb((int)((189.23 * (1.3 - sx)) + (196.15 * (sx))), (int)((153.84 * (1.3 - sx)) + (88.46 * (sx))), (int)((56.92 * (1.3 - sx)) + (5.38 * (sx))));   // con 100
            C.color = new Color(255, (int) ((90 * (1.3 - sx)) + (196.153 * (sx))), (int) ((5.38 * (1.3 - sx))));   // con 100
            C.encender(I);
            sx = sx + 0.003;
        } while (sx <= 1.3);

        //destello 
        do {
            C.Rd = sx;
            //C.color = Color.FromArgb((int)(285.7142 * (2 - sx)), (int)(364.28 * (2 - sx)), (int)(364.28 * (2 - sx)));
            //C.color = Color.FromArgb((int)(350 * (sx - 1.3)), (int)(225.71 * (2 - sx) + 50 * (sx - 1.3)), (int)(175.71 * (2 - sx) + 1.492 * (sx - 1.3)));
            //C.color = Color.FromArgb((int)((54.255 * (6- sx)) + (30.635* (sx-1.3))), (int)((54.255 * (6 - sx)) + (51.914 * (sx-1.3))), (int)((51.914 * (sx-1.3))));   // con 100
            C.color = new Color((int) (364.28 * (2 - sx) + 205.71 * (sx - 1.3)), (int) (364.28 * (2 - sx) + 348.57 * (sx - 1.3)), (int) (348.57 * (sx - 1.3)));   // con 100
            //C.color = Color.FromArgb((int)((94.44 * (4 - sx)) + (53.33 * (sx - 1.3))), (int)((94.44 * (4 - sx)) + (90.37 * (sx - 1.3))), (int)((90.37 * (sx - 1.3))));   // con 4
            //C.color = Color.FromArgb((int)(350 * (sx - 1.3)), (int)(225.71 * (2 - sx) + 50 * (sx - 1.3)), (int)(175.71 * (2 - sx) + 1.492 * (sx - 1.3)));

            C.encender(I);
            sx = sx + 0.01;
        } while (sx <= 2);

    }

    public void encenderEstrella(BufferedImage I) {

        double w = 0;
        double xf, yf;
        do {
            xf = x0 + Rd * Math.cos(w);
            yf = y0 + Rd * Math.sin(w);
            Segmento s = new Segmento(x0, y0, xf, yf, color);
            s.encender(I);
            w += Math.PI / 8;
        } while (w <= 2 * Math.PI);
    }

    public void Luna(BufferedImage I) {
        double r = 0.01;
        Circunferencia C = new Circunferencia(x0, y0, Rd, color);
        //sol
        do {
            C.Rd = r;
            C.color = Color.WHITE;
            C.encender(I);
            r = r + 0.02;
        } while (r <= 0.6);

        //destello 
        do {
            C.Rd = r;
            C.color = new Color(
                    (int) (-637.5 * (r - 1) + 125 * (r - 0.6)),
                    (int) (-637.5 * (r - 1) + 125 * (r - 0.6)),
                    (int) (-637.5 * (r - 1) + 125 * (r - 0.6))
            );

            C.encender(I);
            r = r + 0.02;
        } while (r <= 1);

        do {
            C.Rd = r;
            C.color = new Color(
                    (int) (-40 * (r - 2)),
                    (int) (-40 * (r - 2)),
                    (int) (-40 * (r - 2))
            );
            C.encender(I);
            r = r + 0.02;

        } while (r <= 2);

    }

    public void Luna1(BufferedImage I) {
        double lx = 0.02;
        Circunferencia C = new Circunferencia(x0, y0, Rd, color);
        do {
            /*C.radio = C.radio - 0.03;
                C.color = Color.FromArgb();
                C.Encender(lienzo);*/
            // solo rellenaado

            C.Rd = lx;
            // C.color = Color.FromArgb((int)((15.03759 * (1.3 - rx)) + (191.7293233 * (rx))), (int)((15.03759 * (1.3 - rx)) + (191.7293233 * (rx))), (int)((15.03759 * (1.3 - rx)) + (191.7293233 * (rx))));   // con 30 
            //C.color = Color.FromArgb((int)((37.59398496 * (1.3 - rx)) + (191.7293233 * (rx))), (int)((37.59398496 * (1.3 - rx)) + (191.7293233 * (rx))), (int)((37.59398496 * (1.3 - rx)) + (191.7293233 * (rx))));  // con 50
            C.color = new Color((int) ((75.18796992 * (1.3 - lx)) + (191.7293233 * (lx))), (int) ((75.18796992 * (1.3 - lx)) + (191.7293233 * (lx))), (int) ((75.18796992 * (1.3 - lx)) + (191.7293233 * (lx))));   // con 100
            C.encender(I);
            lx = lx + 0.003;

        } while (lx <= 0.9);

    }

    public void Estrellas(BufferedImage I) {
        pixel(x0, y0, I);
    }
}
