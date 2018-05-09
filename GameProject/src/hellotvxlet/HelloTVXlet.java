package hellotvxlet;

import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;


public class HelloTVXlet implements Xlet {
    
    

  
 
    
    public HelloTVXlet() {

        
    }

    public void initXlet(XletContext arg0) throws XletStateChangeException {
     HScene scene;      
        
     scene = HSceneFactory.getInstance().getDefaultHScene();
     // SCHERM = 720 x 576 
     
     Ball ball = new Ball(20, 20);
     int playerYPos = 0;
     Rectangle rectangle1 = new Rectangle(0, playerYPos);
     
     int AIYPos = 0;
     Rectangle rectangle2 = new Rectangle(50, AIYPos);
     
     //rectangle1.paint(g);
     
     scene.add(ball);
     scene.add(rectangle1);
     scene.add(rectangle2);
     
     scene.validate();
     scene.setVisible(true); 
    }

    public void startlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void startXlet() throws XletStateChangeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
