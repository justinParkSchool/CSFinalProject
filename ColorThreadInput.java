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
public class ColorThreadInput extends Thread {
    private GameFrame f;
    private static boolean isRight;
    
    public ColorThreadInput(GameFrame gameFrame) {
        f = gameFrame;
    }
    
    public static void isRightTrue() {
        isRight = true;
    }
    
    public static void isRightFalse() {
        isRight = false;
    }
    
    public void run(){
        
        if (isRight==true) {
        f.changeUserInputGreen();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ColorThreadInput.class.getName()).log(Level.SEVERE, null, ex);
        }
       f.changeUserInputWhite ();
               }
        else {
            f.changeUserInputRed();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ColorThreadInput.class.getName()).log(Level.SEVERE, null, ex);
            }
            f.changeUserInputWhite();
        }
       return;
    }
}
