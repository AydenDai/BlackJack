import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import java.applet.*;
import java.awt.*;

public class BlackJackGraphicsMain
{
   public static void main(String args[])
   {
      BlackJackGraphicsMain();
   }

   public static void BlackJackGraphicsMain()
   {
      // background
      JFrame frame = new JFrame("BlackJack");
      frame.setSize(1920,1080);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Background panel = new Background("table.png");
      frame.add(panel);
      frame.setVisible(true);

      BlackJackButtons hitstay = new BlackJackButtons(panel);
      frame.add(hitstay);
      frame.setVisible(true);
      
      if(panel.again==1)
      {
         BlackJackGraphicsMain();
      }
   }
}