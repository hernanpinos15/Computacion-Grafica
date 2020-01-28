/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compugrafica.Model;

import java.awt.Color;

/**
 *
 * @author herna
 */
public class AnimacionHilos extends Vector implements Runnable {

    public AnimacionHilos(AreaTrabajo buffImg) {
        bI = buffImg;
        //System.out.println(buffImg);
    }
    private static int tipo;
    private final AreaTrabajo bI;
    
    public static int getTipo() {
        return tipo;
    }

    public static void setTipo(int tipo) {
        AnimacionHilos.tipo = tipo;
    }

    @Override
    public void run() {
        switch (tipo) {
            case 1:
                double dt = 0.2;
                double t = Math.PI;
                Vector s = new Astroide(3.0, 1.0, 1.3);
                System.out.println("Estado del Hilo al comezar: " + Thread.currentThread().isInterrupted());
                //while (!Thread.interrupted()){
                //while (!Thread.currentThread().isInterrupted()) {   //Interruccion del hilo en ese instante solo ese hilo en ejecucion
                    do {
                        timer(100);
                        s.teta = t;
                        s.encender(bI.getLienzo());
                        bI.pintar();
                        s.apagar(bI.getLienzo());
                        t -= dt;
                    } while (!Thread.currentThread().isInterrupted() && t >= 0);
                //}
                System.out.println("Estado del Hilo al finalizar: " + Thread.currentThread().isInterrupted());
                s.color = Color.BLUE;
                s.encender(bI.getLienzo());
                bI.pintar();
                break;
            case 2:
                dt = 0.02;
                t = 0;
                //Diagonal 1
                Vector sd = new Margarita(6.0, -5.0, 0.8);
                Vector sd1 = new Lazo(-6.0, -5.0, 0.8);
                Vector sd2 = new Astroide(-6.0, 5.0, 0.8);
                Vector sd3 = new Circunferencia(6.0, 5.0, 0.8);
                //while (!Thread.currentThread().isInterrupted()) {
                    do {

                        timer(10);

                        //Diagonal 1
                        //sd.teta = t;
                        sd.x0 = 6.0 * (1 - t) - 6.0 * t;
                        sd.y0 = -5.0 * (1 - t) + 5.0 * t;
                        sd.encender(bI.getLienzo());

                        //Diagonal 2
                        //sd.teta = t;
                        sd1.x0 = -6.0 * (1 - t) + 6.0 * t;
                        sd1.y0 = -5.0 * (1 - t) + 5.0 * t;
                        sd1.encender(bI.getLienzo());

                        //Diagonal 2
                        //sd.teta = t;
                        sd2.x0 = -6.0 * (1 - t) + 6.0 * t;
                        sd2.y0 = 5.0 * (1 - t) - 5.0 * t;
                        sd2.encender(bI.getLienzo());

                        //Diagonal 2
                        //sd.teta = t;
                        sd3.x0 = 6.0 * (1 - t) - 6.0 * t;
                        sd3.y0 = 5.0 * (1 - t) - 5.0 * t;
                        sd3.encender(bI.getLienzo());

                        bI.pintar();
                        sd.apagar(bI.getLienzo());
                        sd1.apagar(bI.getLienzo());
                        sd2.apagar(bI.getLienzo());
                        sd3.apagar(bI.getLienzo());

                        t += dt;
                    } while (!Thread.currentThread().isInterrupted() && t <= 1.0);
                //}
                sd.color = Color.BLUE;
                sd.encender(bI.getLienzo());
                sd1.color = Color.BLUE;
                sd1.encender(bI.getLienzo());
                sd2.color = Color.BLUE;
                sd2.encender(bI.getLienzo());
                sd3.color = Color.BLUE;
                sd3.encender(bI.getLienzo());
                bI.pintar();
                break;

            case 3:
                dt = 0.02;
                t = 0;
                //Diagonal 1
                Circunferencia sdc = new Circunferencia(-6.0, -5.0, 1.1);
                while (!Thread.currentThread().isInterrupted()) {
                    do {
                        timer(100);
                        //sd.teta = t;
                        sdc.x0 = -6.0 * (1 - t) + 3.0 * t;
                        sdc.y0 = -5.0 * (1 - t) + 4.0 * t;
                        sdc.Rd = 2 * t;
                        sdc.encender(bI.getLienzo());

                        bI.pintar();
                        sdc.apagar(bI.getLienzo());

                        t += dt;
                    } while (t <= 1);
                }
                sdc.color = Color.BLUE;
                sdc.encender(bI.getLienzo());
                bI.pintar();
                break;
            case 4:
                dt = 0.02;
                t = 0;
                //Diagonal 1
                Circunferencia sdci = new Circunferencia(-6.0, 0.0, 1.1);
                Circunferencia sdc1 = new Circunferencia(0.0, 5.0, 1.1);
                do {
                    timer(100);
                    //sd.teta = t;
                    sdci.x0 = -6.0 * (1 - t);
                    sdci.y0 = 5.0 * t;
                    sdci.encender(bI.getLienzo());
                    bI.pintar();
                    sdci.apagar(bI.getLienzo());
                    t += dt;
                } while (t <= 1);
                t = 0;
                do {
                    timer(100);
                    //sd.teta = t;
                    sdc1.x0 = 6.0 * t;
                    sdc1.y0 = 5.0 * (1 - t);
                    sdc1.encender(bI.getLienzo());
                    bI.pintar();
                    sdc1.apagar(bI.getLienzo());
                    t += dt;
                } while (t <= 1);

                sdc1.color = Color.BLUE;
                sdc1.encender(bI.getLienzo());
                bI.pintar();
                break;
            case 5:
                dt = 0.2;
                t = 0;
                //Diagonal 1
                Circunferencia sc = new Circunferencia(4.0, 0.0, 0.5);
                //Circunferencia sd1 = new Circunferencia(0.0, 5.0, 1.1);
                while (!Thread.currentThread().isInterrupted()) {
                    do {
                        timer(100);
                        sc.teta = t;
//            sd.x0 = Math.cos(t);
//            sd.y0 = Math.sin(t);
//            sd.Rd = 0.5;
                        sc.encender(bI.getLienzo());
                        bI.pintar();
                        sc.apagar(bI.getLienzo());
                        t += dt;
                    } while (t <= 2 * Math.PI);
                    t = 2 * Math.PI;
                    do {
                        timer(100);
                        sc.teta = t;
//            sd.x0 = 6.0 * t;
//            sd.y0 = 5.0 * (1 - t);
                        sc.encender(bI.getLienzo());
                        bI.pintar();
                        sc.apagar(bI.getLienzo());
                        t -= dt;
                    } while (t >= 0);
                }
                sc.color = Color.BLUE;
                sc.encender(bI.getLienzo());
                bI.pintar();
                break;
            case 6:
                dt = 0.2;
                t = 0;
                //Diagonal 1
                Circunferencia c = new Circunferencia();
                c.Rd = 0.5;

                do {
                    timer(100);
                    //sd.teta = t;
                    c.x0 = -4.0 + Math.cos(t);
                    c.y0 = 2.0 + Math.sin(t);

                    c.encender(bI.getLienzo());
                    bI.pintar();
                    c.apagar(bI.getLienzo());
                    t += dt;
                } while (t <= 2 * Math.PI);
                t = 2 * Math.PI;
                do {
                    timer(100);
//            sd.teta = t;
                    c.x0 = -4.0 + Math.cos(t);
                    c.y0 = 2.0 + Math.sin(t);
                    c.encender(bI.getLienzo());
                    bI.pintar();
                    c.apagar(bI.getLienzo());
                    t -= dt;
                } while (t >= 0);

                c.color = Color.BLUE;
                c.encender(bI.getLienzo());
                bI.pintar();

                break;

            case 7:
                dt = 0.2;
                t = 0;
                Circunferencia c1 = new Circunferencia();
                c1.Rd = 1.2;
                Circunferencia c2 = new Circunferencia();
                c2.Rd = 1.2;
                do {
                    timer(100);
                    //sd.teta = t;
                    c1.x0 = -4.0 + Math.cos(t);
                    c1.y0 = 2.0 + Math.sin(t / 6);
                    c1.encender(bI.getLienzo());

//            sd1.x0 = -1.6 + Math.cos(t);
//            sd1.y0 = 2.0 + Math.sin(t);
//            sd1.encender(bI.getLienzo());
                    bI.pintar();
                    c1.apagar(bI.getLienzo());
//            sd1.apagar(bI.getLienzo());
                    t += dt;
                } while (t <= 2 * Math.PI);

//        t = 2 * Math.PI;
//        do {
//            timer(100);
//            sd.teta = t;
//            sd.x0 = -1.6 + Math.cos(t);
//            sd.y0 = 2.0 + Math.sin(t);
//            sd.encender(bI.getLienzo());
//            
//            sd1.x0 = -4.0 + Math.cos(t);
//            sd1.y0 = 2.0 + Math.sin(t);
//            sd1.encender(bI.getLienzo());
//            
//            bI.pintar();
//            sd.apagar(bI.getLienzo());
//            sd1.apagar(bI.getLienzo());
//            t -= dt;
//        } while (t >= 0);
                c1.color = Color.BLUE;
                c1.encender(bI.getLienzo());

//        sd1.color = Color.BLUE;
//        sd1.encender(bI.getLienzo());
                bI.pintar();

                break;
        }

    }

    //TIMER
    private void timer(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            //Thread.currentThread().interrupt();
            //ex.printStackTrace();
            //System.out.println("Hilo bloqueado imposible su interruccion");
            //System.exit(0);
            //Esto resuelve lo de la interrupcion de lo shilo cuando el hilo no se puede interrupir con sleep
            Thread.currentThread().interrupt();
        }
    }

}
