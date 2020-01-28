/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compugrafica.Model;

/**
 *
 * @author MIMI
 */
public class SplineData {
    private Double a;// constante
    private Double b;// 1er coheficiente
    private Double c;// 2do coheficiente
    private Double d;// 3er coheficiente
    private Double x;//valor inicial  x

    public SplineData() {
        this.a = 0.0;
        this.b = 0.0;
        this.b = 0.0;
        this.d = 0.0;
        this.x = 0.0;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }
}