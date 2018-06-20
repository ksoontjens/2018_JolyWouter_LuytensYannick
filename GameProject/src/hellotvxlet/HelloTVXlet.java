package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Timer;
import javax.tv.xlet.*;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet , UserEventListener, HActionListener {
    
    FieldAndScore background;
    Ball ball;
    Rectangle rectangle1;
    Rectangle rectangle2;
    
    private HScene scene;
    private HTextButton startButton;
    
    public HelloTVXlet() {

        
    }

    public void initXlet(XletContext arg0) throws XletStateChangeException {
     
     
     
    }

    public void startlet() {
        

    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException{
     
    }

    public void startXlet() throws XletStateChangeException {
     
        scene = HSceneFactory.getInstance().getDefaultHScene(); // scene geinitialiseerd in HellotvXlet
     // SCHERM = 720 x 576 
     
     startButton  = new HTextButton("Start Game",360-150,440,300,50);
     
     background = new FieldAndScore();
     
     rectangle1 = new Rectangle(0);
     
     rectangle2 = new Rectangle(720-20);
     
     ball = new Ball(rectangle1, rectangle2, background);
     
     //rectangle1.paint(g);
     
      if(!Ball.start){
      startButton.setBackgroundMode(HVisible.BACKGROUND_FILL);
      startButton.setBackground(Color.GRAY);
      scene.add(startButton);
      
      startButton.requestFocus();
      startButton.setActionCommand("startGame");
      startButton.addHActionListener(this);
      
      scene.add(background);
     }
     
     scene.validate();
     scene.setVisible(true); 
        
        //Controls**************************
     // Eventmanager aanvragen
     EventManager manager = EventManager.getInstance();
     
     //Repository
     UserEventRepository repository = new UserEventRepository("Voorbeeld");
     repository.addAllArrowKeys();
     
     //Events toevoegen
     repository.addKey(org.havi.ui.event.HRcEvent.VK_UP);
     repository.addKey(org.havi.ui.event.HRcEvent.VK_DOWN);
     repository.addKey(org.havi.ui.event.HRcEvent.VK_Z);
     repository.addKey(org.havi.ui.event.HRcEvent.VK_S);
     
     manager.addUserEventListener(this, repository);
     
     
     
     Update update = new Update();
     
     update.rectangle1 = rectangle1;
     update.rectangle2 = rectangle2;
     update.ball = ball;
     
     Timer t = new Timer();
     t.scheduleAtFixedRate(update, 0, 7);
    }
    
    public void userEventReceived(UserEvent e) {
        if(e.getType()==KeyEvent.KEY_PRESSED){
            rectangle1.buttonPressed = true;
            System.out.println("Pushed Button");
            switch(e.getCode()){
                case HRcEvent.VK_UP:
                    rectangle1.buttonUp = true;
                    System.out.println(rectangle1.yPos);
                    rectangle1.repaint();
                    break;
                case HRcEvent.VK_DOWN:
                    rectangle1.buttonUp = false;
                    //System.out.println("Down");
                    rectangle1.repaint();
                    break;   
            }
            
        } else{
            rectangle1.buttonPressed = false;
        }
    }
    
    public void actionPerformed(ActionEvent arg0) {
    //throw new UnsupportedOperationException("Not supported yet.");
            System.out.println(arg0.getActionCommand());
        
    if(arg0.getActionCommand().equals("startGame"))
    {
        Ball.start = true;
        scene.remove(startButton);
        scene.add(ball);
        scene.add(rectangle1);
        scene.add(rectangle2);
        scene.add(background);
        }
    }
}
