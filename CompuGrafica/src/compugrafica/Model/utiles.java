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
public class utiles {
    public static double factorial(double num){
        double fact=1;
        for (int i=1; i<=num;i++)
        {
            fact=fact*i;
        }
        return fact;
    }
}
