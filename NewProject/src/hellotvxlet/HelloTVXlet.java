package hellotvxlet;


import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;


public class HelloTVXlet implements Xlet, UserEventListener {

    MijnComponent mc;
  
    public void startXlet() throws XletStateChangeException {
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        
        mc = new MijnComponent(0, 0, 720, 576);
        
        scene.add(mc);
        //mc.setBounds(200,200,400,400);
        
        scene.validate();
        scene.setVisible(true);
        
        UserEventRepository repo = new UserEventRepository("Naam");
        repo.addAllArrowKeys();
        
        EventManager manager = EventManager.getInstance();
        manager.addUserEventListener(this, repo);
        
        //niet oplossen met bolletje, maar:
        // bovenaan UserEventListener (interface) toevoegen
        // + import + implement all abstract methods
        
        
        MijnTimerTask mtt = new MijnTimerTask();
        mtt.mc = mc; // zet de link naar mc
        
        Timer t = new Timer(); //java.util.Timer
        t.scheduleAtFixedRate(mtt, 0, 20); // start op 0 ms, elke 20 ms
    }


    

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional)throws XletStateChangeException {
     
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
       
    }

    public void userEventReceived(UserEvent e) {
        System.out.println(e.getCode());
        if(e.getType()== HRcEvent.KEY_PRESSED){
            if(e.getCode()==HRcEvent.VK_LEFT){
            mc.sx-=5; // mc moet een globale variabele worden!!;
            if(mc.sx<0){mc.sx=0;}
            mc.repaint(); // component laten hertekenen
        }
        if(e.getCode()==HRcEvent.VK_RIGHT){
            mc.sx+=5; // mc moet een globale variabele worden!!;
            if(mc.sx+50>720){mc.sx=720-50;}
            mc.repaint(); // component laten hertekenen
        }
        if(e.getCode()==HRcEvent.VK_UP){
            mc.sy-=5; // mc moet een globale variabele worden!!;
            if(mc.sy<0){mc.sy=0;}
            mc.repaint(); // component laten hertekenen
        }
        if(e.getCode()==HRcEvent.VK_DOWN){
            mc.sy+=5; // mc moet een globale variabele worden!!;
            if(mc.sy+50>570){mc.sy=570-50;}
            mc.repaint(); // component laten hertekenen
        }
        }
        
    }

    
}
