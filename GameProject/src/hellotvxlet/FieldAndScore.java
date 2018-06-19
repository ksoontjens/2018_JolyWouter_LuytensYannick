/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import org.havi.ui.HComponent;
import org.havi.ui.HStaticText;

/**
 *
 * @author student
 */
public class FieldAndScore extends HComponent{

    private int playerPoints = 0;
    private int computerPoints = 0;
    
    
    public Ball ball;
    
    public FieldAndScore (){
        setBounds(0,0,720,576);
    }
    
    public void ScorePoint(boolean playerScored){
        if(playerScored){
            playerPoints ++;
            System.out.println(playerPoints);
            
        } else{
            computerPoints ++;
            
            System.out.println(computerPoints);
            
        }
    }
    
    public void paint (Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,720,576);
        
        g.setColor(Color.WHITE);
        g.fillRect(720/2-10, 0, 10, 576);
        
        g.setColor(Color.WHITE);
        String pScore = "Player: " + playerPoints;
        g.drawString(pScore, 720/2 - g.getFontMetrics().stringWidth(pScore)-35, 25);
        
        g.setColor(Color.WHITE);
        String cScore = "Computer: " + computerPoints;
        g.drawString(cScore, 720/2+25, 25);
    }
}
