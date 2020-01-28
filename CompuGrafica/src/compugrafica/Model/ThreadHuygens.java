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
public class ThreadHuygens extends Thread {

    public AreaTrabajo AreaTrabajo;
    public BufferedImage[] BuffImage;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (BuffImage[i] == null) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                i--;
            } else {
                AreaTrabajo.setLienzo(BuffImage[i]);
                AreaTrabajo.pintar();
            }
        }
    }

}
