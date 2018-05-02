/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Pang;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author student
 */
public class Ball {

    private int x;
    private int y;
    private int ballSize = 4;
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, ballSize, ballSize);
        
    }
    
}
