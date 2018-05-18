package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {

  
    HScene scene;
    HStaticText feedback;
    HTextButton button1;
    HTextButton button2;
    HTextButton button3;
    HTextButton button4;
    HTextButton hulplijn;
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      scene = HSceneFactory.getInstance().getDefaultHScene();
      
      HStaticText hst = new HStaticText("What beats lizard?", 20, 300, 680, 100);
      hst.setBackgroundMode(HVisible.BACKGROUND_FILL);
      hst.setBackground(Color.blue);
      scene.add(hst);
      
      button1 = new HTextButton("Spock", 20, 420, 200, 50);
      button1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      button1.setBackground(Color.blue);
      scene.add(button1);
      
      button2 = new HTextButton("Rock", 20, 490, 200, 50);
      button2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      button2.setBackground(Color.blue);
      scene.add(button2);
      
      button3 = new HTextButton("Paper", 370, 420, 200, 50);
      button3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      button3.setBackground(Color.blue);
      scene.add(button3);
      
      button4 = new HTextButton("Scissors", 370, 490, 200, 50);
      button4.setBackgroundMode(HVisible.BACKGROUND_FILL);
      button4.setBackground(Color.blue);
      scene.add(button4);
      
      hulplijn = new HTextButton("Hulplijn", 370, 50, 320, 50);
      hulplijn.setBackgroundMode(HVisible.BACKGROUND_FILL);
      hulplijn.setBackground(Color.blue);
      scene.add(hulplijn);
      
      button1.setFocusTraversal(null, button2, null, button3); //up, down, left, right
      button2.setFocusTraversal(button1, null, null, button4);
      button3.setFocusTraversal(hulplijn, button4, button1, null);
      button4.setFocusTraversal(button3, null, button2, null);
      hulplijn.setFocusTraversal(null, button3, null, null);
      
      button1.setActionCommand("knop1");
      button2.setActionCommand("knop2");
      button3.setActionCommand("knop3");
      button4.setActionCommand("knop4");
      hulplijn.setActionCommand("hulpknop");
      
      button1.addHActionListener(this); // bovenaan bij implements HActionListener toevoegen
                                        // +add impprt +add all abstract methods
      button2.addHActionListener(this);
      button3.addHActionListener(this);
      button4.addHActionListener(this);
      hulplijn.addHActionListener(this);
      
      
      scene.validate();
      scene.setVisible(true);
      button1.requestFocus();
     
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent arg0) {
        System.out.println(arg0.getActionCommand());
        
        if (arg0.getActionCommand().equals("knop2") || arg0.getActionCommand().equals("knop4"))
        {
            feedback = new HStaticText("Proficiat, dit is het juiste antwoord", 20, 200, 680, 100);
            
            feedback.setBackground(Color.GREEN);
            
        } else if (arg0.getActionCommand().equals("hulpknop")){
            scene.remove(button1);
            scene.repaint();
            button4.requestFocus();
            return; // verlaat de methode zonder de volgende if's nog te doen
        }
            else {
        
            feedback = new HStaticText("Helaas, dit is niet het juiste antwoord", 20, 200, 680, 100);
            feedback.setBackground(Color.RED);
        }
        feedback.setBackgroundMode(HVisible.BACKGROUND_FILL);
        if(feedback != null) scene.remove(feedback);
        scene.add(feedback);
        scene.popToFront(feedback);
        scene.repaint();
        
    }
}
