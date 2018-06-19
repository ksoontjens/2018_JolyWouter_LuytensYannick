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
public class Rectangle extends HComponent{
    

    public int Width = 20;
    public int Height = 100;
    //private int xPos = 0;
    public int yPos = 0;
    int xPos = 0;
    
    public boolean buttonPressed = false;;
    public boolean buttonUp = true;
    
   public Rectangle(int x)
    {
       xPos = x;
       this.setBounds(0,yPos,720,576);
        
    }
   
   public void movePlayer(){
       if(yPos >= 0 && yPos <= 576-Height){
           if(buttonPressed){
        if(buttonUp){
            yPos -= 2;
        } else{
            yPos += 2;
        }
    }
       }
       
       if(yPos < 0){
            yPos = 0;
       } else if (yPos > 576-Height){
            yPos = 576-Height;
       }
   }
   
   public void moverel(int y){
       if(yPos >= 0 && yPos <= 576-Height){
           this.yPos += y;
       }
       
       if(yPos < 0){
            yPos = 0;
       } else if (yPos > 576-Height){
            yPos = 576-Height;
       }
   }

      public void paint (Graphics g)
  {
      g.setColor(Color.WHITE);
      g.fillRoundRect(xPos, yPos, Width, Height, 20, 20);
  }
        
    }
