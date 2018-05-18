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
public class MijnTimerTask extends TimerTask{
    
    public MijnComponent mc;
    
    public void run(){
        // TODO: als ay>570 --> ay = 0;
        mc.ay++;
        if(mc.ay>570){
            mc.ay=0;
        }
        mc.repaint();
        
    }

}
