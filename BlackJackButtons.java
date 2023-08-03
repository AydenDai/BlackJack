/* Demonstrates how to detect a click within a rectangular region (essentially
   a button).
   
   In practical applications, you're probably better off using Java's built-in
   GUI system via JButton etc.. But, the ideas here roughly indicate what the
   Java developers did to make that system!
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class BlackJackButtons extends JPanel implements MouseListener
{
  Random rng = new Random();
  Button hit; //NEW
  Button stay;
  Button end;
  Button again;
  BufferedImage cardA;
  BufferedImage card2;
  BufferedImage card3;
  BufferedImage card4;
  BufferedImage card5;
  BufferedImage card6;
  BufferedImage card7;
  BufferedImage card8;
  BufferedImage card9;
  BufferedImage card10;
  BufferedImage cardJ;
  BufferedImage cardQ;
  BufferedImage cardK;
  Background background;

  public BlackJackButtons(Background b)
  {
    // left, top, right, bottom
    background = b;
    hit = new Button(500, 950, 650, 1000); //NEW
    stay = new Button(1253, 950, 1403, 1000); //NEW
    cardA = readImage("ace.png");
    card2 = readImage("2.png");
    card3 = readImage("3.png");
    card4 = readImage("4.png");
    card5 = readImage("5.png");
    card6 = readImage("6.png");
    card7 = readImage("7.png");
    card8 = readImage("8.png");
    card9 = readImage("9.png");
    card10 = readImage("10.png");
    cardJ = readImage("jack.png");
    cardQ = readImage("queen.png");
    cardK = readImage("king.png");
    
    again = new Button(500, 500, 650, 550); //NEW
    end = new Button(1253, 500, 1403, 550); //NEW
  
    // MouseListener instead of KeyListener
    addMouseListener(this);
    setFocusable(true);
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Random rng = new Random();

    hit.drawTo(g); //NEW
    stay.drawTo(g);
    
    if(background.j==2 || background.sum>21 || background.sum==21)
    {
      again.drawTo(g);
      end.drawTo(g);
    }
  }
  
  public static BufferedImage readImage(String infile)
  {
    try
    {
      BufferedImage ret = ImageIO.read(new File(infile));
      return ret;
    }
    catch(Exception e){System.out.println(e.getMessage()); return null;}
  }

  
  /* Required methods for MouseListener */
  public void mousePressed(MouseEvent e)
  {
    // getButton tells us which button was clicked.
    int button = e.getButton();
    
    // BUTTON1 = left click
    if(button == MouseEvent.BUTTON1)
    {
      int x1 = e.getX();
      int y1 = e.getY();
      int y2 = 707;
      int d;
      if( hit.clicked(x1,y1) && background.sum<21 && background.i<6)
      {
         if(background.j != 2)
         {
            if(background.i==5)
            {
               background.j=1;
            }
            background.d = rng.nextInt(13)+1;
            background.playerhand[background.i] = background.d;
            background.i=background.i+1;
            if(background.d>10)
            {
               background.sum = background.sum+10;
            }
            else if (background.d==1)
            {
               background.c = background.d;
               background.sum=background.sum+11;
            if(background.sum>21)
            {
               background.sum = background.sum-10;
               background.c=0;
            }
            }
            else
            {
               background.sum=background.sum+background.d;
            }
            
            for(int k = 0; background.sum>21 && background.c==1;)
            {
               background.sum = background.sum-10;
               background.c=0;
            }
         }
      }
      if( stay.clicked(x1,y1)&& background.sum<21 && background.i<6)
      {  
         background.j=2;
      }
      if( again.clicked(x1,y1))
      {  
         background.again = 1;
      }
      if( end.clicked(x1,y1))
      {  
         System.exit(0);
      }
      background.repaint();
  }
}
  public void mouseReleased(MouseEvent e)
  {
  }
  public void mouseClicked(MouseEvent e)
  {
  }  
  public void mouseEntered(MouseEvent e)
  { 
  } 
  public void mouseExited(MouseEvent e)
  { 
  } 
}

class Button
{
  public int left;
  public int right;
  public int top;
  public int bottom;
  
  public Button(int l, int t, int r, int b)
  {
    left = l;
    top = t;
    right = r;
    bottom = b;
  }
  
  public void drawTo(Graphics g)
  {
    g.fillRect(left, top, right-left, bottom-top);
  }
  
  public boolean clicked(int x, int y)
  {
    return x > left && x < right && y > top && y < bottom;
  }
}