package hellotvxlet;

import javax.microedition.xlet.Xlet;
import javax.microedition.xlet.XletContext;
import javax.microedition.xlet.XletStateChangeException;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;


public class HelloTVXlet implements Xlet, UserEventListener {

    MijnComponent mc;
    Ball ball;
  
    public void startXlet() throws XletStateChangeException {
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        
        mc = new MijnComponent();
        
        scene.add(mc);
        //mc.setBounds(200,200,400,400);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void initXlet(XletContext context) {
      
     
    }

    

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    

    public void userEventReceived(UserEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
