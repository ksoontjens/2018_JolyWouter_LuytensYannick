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
    

    private int Width = 20;
    private int Height = 100;
    
   public Rectangle(int x, int y)
    {
        this.setBounds(x,y,20,100);
    }

      public void paint (Graphics g)
  {
      g.setColor(Color.WHITE);
      g.fillRoundRect(0, 0, Width, Height, 20, 20);
  }
        
    }
