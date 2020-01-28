/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compugrafica.Model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author herna
 */
public class Proyecto extends Vector3D {

    private double[][] Mx = new double[100][100];
    private double[][] My = new double[100][100];
    private ArrayList<Double> VxPro;
    private ArrayList<Double> VyPro;

    public int EjeSuperficie;
    public int TipoRotar;
    Color colorPro;
    
    public int OpcionRelleno;

    public Proyecto() {
    }

    public Proyecto(ArrayList<Double> VxPro, ArrayList<Double> VyPro) {
        this.VxPro = VxPro;
        this.VyPro = VyPro;
    }

    public int getTipoRotar() {
        return TipoRotar;
    }

    public void setTipoRotar(int TipoRotar) {
        this.TipoRotar = TipoRotar;
    }

    @Override
    public void encender(BufferedImage I) {
        int i = 0, j, Ni, Nj;
        Vector3D sr = new Vector3D();
        sr.color = this.color;
        double h = 0;
        double dh = 0.1;  //Distancia entre los puntos de bezier ver
        do {
            j = 0;
            for (int t = 0; t < VxPro.size(); t++) {

                if (EjeSuperficie == 1) {
                    sr.teta1 = h;
//                    sr.tetaSR = h;
                }
                if (EjeSuperficie == 2) {
                    sr.teta2 = h;
//                    sr.tetaSR = h;
                }
                if (EjeSuperficie == 3) {
                    sr.teta3 = h;
//                    sr.tetaSR = h;
                }

                sr.rotarOpc(0, VxPro.get(t), VyPro.get(t), 1);
                sr.rotarOpc(sr.x, sr.y, sr.z, 2);
                sr.rotarOpc(sr.x, sr.y, sr.z, 3);

                x = sr.x;
                y = sr.y;
                z = sr.z;
                pixel3D(x, y, z, I);
//                ProcesoAxonometria(x, y, z);
                Mx[i][j] = Ax;
                My[i][j] = Ay;
                j++;
            }
            h += dh;
            i++;
        } while (h <= Math.PI * 2);
        Relleno(i, j);
        i++;
        Ni = i;
        Nj = j;
        procesoMallado(Ni - 1, Nj - 1, Mx, My, I);
//        Mx = null;
//        My = null;

    }

    public void procesoMallado(int Ni, int Nj, double Mx[][], double My[][], BufferedImage I) {
        double xx, yy;

//         color1 = new Color(15, 100, 255);
//         color2 = new Color(35, 239, 0);
//         color3 = new Color(192, 187, 187);
//         color4 = new Color(248, 10, 172);
        for (int i = 0; i < Ni; i++) {
            for (int j = 0; j < Nj; j++) {

//                xx = (Mx[i + 1][j] - Mx[i][j]) * (My[i + 1][j + 1] - My[i + 1][j]);
//                yy = (Mx[i + 1][j + 1] - Mx[i + 1][j]) * (My[i + 1][j] - My[i][j]);
                Cuadrilatero c1 = new Cuadrilatero(
                        Mx[i][j], My[i][j],
                        Mx[i + 1][j], My[i + 1][j],
                        Mx[i + 1][j + 1], My[i + 1][j + 1],
                        Mx[i][j + 1], My[i][j + 1],
                        OpcionRelleno);
//                    c1.colorAd = this.color3;
                c1.colorAf = this.color;
                c1.colorAd = this.colorPro;
                c1.encender(I);

//                if ((xx - yy) > 0) {
//                    Cuadrilatero c1 = new Cuadrilatero(
//                            Mx[i][j], My[i][j],
//                            Mx[i + 1][j], My[i + 1][j],
//                            Mx[i + 1][j + 1], My[i + 1][j + 1],
//                            Mx[i][j + 1], My[i][j + 1],
//                            1);
//                    c1.colorAd = this.color3;
//                    c1.colorAf = this.color4;
//                    c1.encender(I);
//                } else {
//                    Cuadrilatero c = new Cuadrilatero(
//                            Mx[i][j], My[i][j],
//                            Mx[i + 1][j], My[i + 1][j],
//                            Mx[i + 1][j + 1], My[i + 1][j + 1],
//                            Mx[i][j + 1], My[i][j + 1],
//                            1);
//                    c.colorAd = this.color1;
//                    c.colorAf = this.color2;
//                    c.encender(I);
//                }
            }
        }

    }

    private void Relleno(int i, int j) {
        for (int k = 0; k < j; k++) {
            Mx[i][k] = Mx[0][k];
            My[i][k] = My[0][k];
        }
    }

}
