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
    public Rectangle rectangle1;
    public Rectangle rectangle2;

    public void run() {
        //System.out.println("tick");
     

    //ball.repaint();
    rectangle1.repaint();
    rectangle2.repaint();
    }
}
