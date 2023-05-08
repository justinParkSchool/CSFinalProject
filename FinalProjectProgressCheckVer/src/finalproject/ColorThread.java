/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ColorThread extends Thread {

    private GameFrame f;

    public ColorThread(GameFrame gameFrame) {
        f = gameFrame;
    }

    public void run() {
        f.changeLineColor();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ColorThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        f.changeLineColorBack();
        return;
    }
}
