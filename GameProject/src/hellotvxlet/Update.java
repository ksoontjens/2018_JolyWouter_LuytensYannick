/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.TimerTask;

/**
 *
 * @author student
 */
public class Update extends TimerTask{

    public Ball ball;

    public void run() {
        //System.out.println("tick");
     

    ball.repaint();
    }
}
