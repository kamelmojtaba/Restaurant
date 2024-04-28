/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinerestaurant;

import Frames.JF_Login;
import Frames.JF_Welcome;
import javax.swing.JFrame;

/**
 *
 * @author Hanas
 */
public class OnlineRestaurant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       JF_Welcome welcoeme=new JF_Welcome();
       welcoeme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       welcoeme.setVisible(true);
    }
    
}
