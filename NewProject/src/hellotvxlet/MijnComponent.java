/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent {

    Image sterren;
    Image schip;
    
    public int sx = 350, sy = 450, ay = 0;
    /* transparante kleuren :  Geel=Rood+Groen
     * g.setColor(new DVBColor(R, G, B, alpha)); welke waarde : 0..255
     * g.drawString("tekst", x, y);
     * g.fillRoundRect(x, y, b, h, r1, r2);
     */
    public MijnComponent(int x, int y, int b, int h){
        this.setBounds(x, y, x+b, y+h);
        sterren = this.getToolkit().getImage("sterren.png");
        schip = this.getToolkit().getImage("spaceship.png");
        
        MediaTracker mt = new MediaTracker(this);
        
        mt.addImage(sterren, 0);
        mt.addImage(schip, 0);
        
        try{
            mt.waitForAll();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    public void paint(Graphics g){
        
        /*
        //g.fillRect(0,0,300,300); // tekent maar tot 200,200 vanwege setBounds
        g.setColor( new DVBColor(0,0,255,179));
        g.fillRoundRect(0,0,300,300, 10, 10);
        g.fillRoundRect(0,0,290,290, 10, 10);
        g.setColor(Color.YELLOW);
        //g.drawOval(0,0,100,100); //Cirkel
        g.drawString("tekst", 150, 100);
         */
        //TODO : zet 2de sterrenhemel op ay-570
        g.drawImage(sterren, 0, ay-570, this);
        g.drawImage(sterren, 0, ay, this); // public int ay
        
        g.drawImage(schip,sx,sy,this);
        
    }
    
    
    
}
