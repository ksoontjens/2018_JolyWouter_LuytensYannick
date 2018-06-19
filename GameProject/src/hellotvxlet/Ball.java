/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Ball extends HComponent{

    private int x;
    private int y;
    private int ballSize = 30;
    public int yMoveSpeed = 1;
    public int xMoveSpeed = 1;
    public int a;
    public int b;
    public FieldAndScore score;
    
    public Ball(int startX, int startY, FieldAndScore fScore)
    {
        x = startX;
        y = startY;
        setBounds(0, 0, 720, 576);
        score = fScore;
    }
    
    public void move(){
        x += xMoveSpeed;
        y += yMoveSpeed;
        
        if(x < 0){
            reset();
            score.ScorePoint(true);
            score.repaint();
            //xMoveSpeed = 1;
        } else if(x > 720-30){
            reset();
            score.ScorePoint(false);
            score.repaint();
            //xMoveSpeed = -1;
        }
        if(y < 0){
            yMoveSpeed = 1;
        } else if(y > 576-30){
            yMoveSpeed = -1;
        }
    }
    
    public void reset(){
        x = 720/2;
        y = 576/2;
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, ballSize, ballSize);
        
    }
}
