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

    private int x = 10;
    private int y = 10;
    private int ballSize = 30;
    
    public Ball(int a, int b)
    {
        this.setBounds(a, b,100,100);
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, ballSize, ballSize);
        
    }
}
