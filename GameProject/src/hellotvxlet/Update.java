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
     

    ball.move();
    
    if(rectangle2.yPos > ball.y + 15){
        rectangle2.moverel(0, -5);
    }
    if(rectangle2.yPos + rectangle2.Height < ball.y - 15){
        rectangle2.moverel(0,5);
    }
    
    ball.repaint();
    //rectangle1.repaint();
    rectangle2.repaint();
    }
}
