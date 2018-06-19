/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Ball extends HComponent{

    public int x;
    public int y;
    private int ballSize = 30;
    public int yMoveSpeed = 1;
    public int xMoveSpeed = 1;
    public int a;
    public int b;
    public FieldAndScore score;
    private Random r = new Random();
    private Rectangle player;
    private Rectangle computer;
    
    public Ball(Rectangle p, Rectangle c, FieldAndScore fScore)
    {
        x = 720/2;
        y = 88 + r.nextInt(400);
        if(r.nextBoolean()){
            yMoveSpeed *= -1;
        }
        if(r.nextBoolean()){
            xMoveSpeed *= -1;
        }
        setBounds(0, 0, 720, 576);
        score = fScore;
        player = p;
        computer = c;
    }
    
    public void move(){
        x += xMoveSpeed;
        y += yMoveSpeed;
        
        if(x < 0-ballSize+10){
            reset();
            score.ScorePoint(false);
            score.repaint();
            //xMoveSpeed = 1;
        } else if(x > 720-10){
            reset();
            score.ScorePoint(true);
            score.repaint();
            //xMoveSpeed = -1;
        }
        if(y < 0 || y > 576-30 ){
            yMoveSpeed *= -1;
        } 
        
        if(x < player.Width && y > player.yPos-20 && y+30 < player.yPos + player.Height+20){
            
            if(r.nextBoolean()&& (xMoveSpeed > yMoveSpeed -2 && xMoveSpeed < yMoveSpeed + 2)){
                xMoveSpeed += xMoveSpeed/Math.abs(xMoveSpeed);
            }
            if(r.nextBoolean()&& (yMoveSpeed > xMoveSpeed -2 && yMoveSpeed < xMoveSpeed + 2)){
                yMoveSpeed += yMoveSpeed/Math.abs(yMoveSpeed);
            }
            xMoveSpeed = Math.abs(xMoveSpeed);
        }
        if(x > 720-computer.Width-ballSize && y > computer.yPos-20 && y+30 < computer.yPos + computer.Height+20){
            
            if(r.nextBoolean()&& (xMoveSpeed > yMoveSpeed -2 && xMoveSpeed < yMoveSpeed + 2)){
                xMoveSpeed += xMoveSpeed/Math.abs(xMoveSpeed);
            }
            if(r.nextBoolean()&& (yMoveSpeed > xMoveSpeed -2 && yMoveSpeed < xMoveSpeed + 2)){
                yMoveSpeed += yMoveSpeed/Math.abs(yMoveSpeed);
            }
            xMoveSpeed = -Math.abs(xMoveSpeed);
        }
    }
    
    public void reset(){
        
        x = 720/2;
        y = 88 + r.nextInt(400);
        yMoveSpeed = yMoveSpeed/Math.abs(yMoveSpeed);
        xMoveSpeed = xMoveSpeed/Math.abs(xMoveSpeed);
        if(r.nextBoolean()){
            yMoveSpeed *= -1;
        }
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, ballSize, ballSize);
        
    }
}
