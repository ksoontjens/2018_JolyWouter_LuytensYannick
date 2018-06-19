/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Rectangle extends HComponent{
    

    public int Width = 20;
    public int Height = 100;
    //private int xPos = 0;
    public int yPos = 0;
    int xPos = 0;
    
   public Rectangle(int x)
    {
        this.setBounds(x,yPos,20,100);
        xPos = x;
    }
   
   public void moverel(int x, int y){
       this.xPos += x;
       this.yPos += y;
       this.setBounds(xPos, yPos, 20, 100);
   }

      public void paint (Graphics g)
  {
      g.setColor(Color.WHITE);
      g.fillRoundRect(0, 0, Width, Height, 20, 20);
  }
        
    }
