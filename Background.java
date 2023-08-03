/* This class contains an example of how to rotate an image in Java
   using just what we've learned + a little bit of trigonometry.
   
   To see it, make an image called myimg.png and put it in the same
   folder as this.
   
   There's a main method at the bottom so you don't need to use
   GraphicsMainExample
   
   You can copy the rotateImage method and use it freely, no new imports
   required.

   It's a bit slow, so if you need a faster method you should
   probably use a library. You can Google something like
   "Java Graphics2D rotate image" to see examples of doing it this way
   
   Based on the ImageLoadExample
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.util.Random;

// Imports for image reading
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Background extends JPanel
{ 
  BufferedImage image;
  BufferedImage card;
  BufferedImage rotated;
  BufferedImage rotated1;
  BufferedImage rotated2;
  BufferedImage rotated3;
  BufferedImage rotated4;
  BufferedImage rotated5;
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
  Font font;
  Font font1;
  Random rng = new Random();
  int a = 1;
  int x = rng.nextInt(13)+1; // 1st random number
  int x1 = x;
  int y = rng.nextInt(13)+1; // 2nd random number
  int y1 = y;
  int d; // other random number
  int c; // make sure only A gets subtracted by 10 once
  int sum = 0; // sum of the player
  int botx = rng.nextInt(13)+1; // 1st random number for dealer
  int botx1 = botx;
  int boty = rng.nextInt(13)+1; // 2nd random number for dealer
  int botc; // make sure only A gets subtracted by 10 once for dealer
  int boty1 = boty;
  int botsum; // sum of the dealer
  int y2;
  int boty2;
  int[] playerhand = new int[6];
  int[] dealerhand = new int[6];
  int boti=2;
  int i = 3;
  int j = 0;
  int botk = 3;
  int botj = 0;
  int botm = 0;
  int botd = rng.nextInt(13)+1;
  int again;
  
  public Background(String filename)
  {
    image = readImage(filename);
    card = readImage("backcard.png");
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
    rotated = rotateImage(card, 0.349066);
    rotated1 = rotateImage(card,0.20944);
    rotated2 = rotateImage(card, 0.0698132);
    rotated3 = rotateImage(card, 3.07178);
    rotated4 = rotateImage(card, 2.9147003674407998552);
    rotated5 = rotateImage(card, 2.77507); // change the number to rotate by a different amount
    playerhand[1]= x;
    playerhand[2]= y;
    dealerhand[1]= botx;
    dealerhand[2]= boty;
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    font = new Font("Arial", Font.PLAIN, 36);
    font1 = new Font("Arial", Font.BOLD, 60);
    g.drawImage(image, 0, 0, null);
    g.drawImage(rotated, 227, 592, null);
    g.drawImage(rotated1, 455, 650, null);
    g.drawImage(rotated2, 682, 691, null);
    g.drawImage(rotated3, 1120, 692, null);
    g.drawImage(rotated4, 1325, 647, null);
    g.drawImage(rotated5, 1535, 590, null);
    g.setColor(Color.WHITE);
    g.fillRect(500, 950, 150, 50);
    g.setColor(Color.BLACK);
    g.drawRect(500,950,150,50);
    g.setFont(font);
    drawCenteredText(g, "Hit", 570, 976);
    
    g.setColor(Color.WHITE);
    g.fillRect(1253, 950, 150, 50);
    g.setColor(Color.BLACK);
    g.drawRect(1253,950,150,50);
    g.setFont(font);
    drawCenteredText(g, "Stay", 1327, 975);
    
    g.setColor(Color.WHITE);
    g.setFont(font);
    drawCenteredText(g, "Dealer", 960, 275);
    
    if(j==2 || sum>21 || sum==21)
    {
       g.setColor(Color.WHITE);
       g.fillRect(1253, 500, 150, 50);
       g.setColor(Color.BLACK);
       g.drawRect(1253,500,150,50);
       g.setFont(font);
       drawCenteredText(g, "End", 1327, 525);
       
       g.setColor(Color.WHITE);
       g.fillRect(500, 500, 150, 50);
       g.setColor(Color.BLACK);
       g.drawRect(500,500,150,50);
       g.setFont(font);
       drawCenteredText(g, "Again", 575, 525);
    }

    
    y2 = 710;
    for(int i = 0; i<playerhand.length; i++)
    {
      if(playerhand[i]==1)
      {
         g.drawImage(cardA, 910, y2, null);
         y2 = y2 +33;
      }
      else if(playerhand[i]==2)
      {
         g.drawImage(card2, 910, y2, null);
         y2 = y2 +33;
      }
      else if(playerhand[i]==3)
      {
         g.drawImage(card3, 910, y2, null);
         y2 = y2 +33;
      }
      else if(playerhand[i]==4)
      {
         g.drawImage(card4, 910, y2, null);
         y2 = y2 +33;
      }
      else if(playerhand[i]==5)
      {
         g.drawImage(card5, 910, y2, null);
         y2 = y2 +33;
      }
      else if(playerhand[i]==6)
      {
         g.drawImage(card6, 910, y2, null);
         y2 = y2 +33;
      }
      else if(playerhand[i]==7)
      {
         g.drawImage(card7, 910, y2, null);
         y2 = y2 +33;
      }
      else if(playerhand[i]==8)
      {
         g.drawImage(card8, 910, y2, null);
         y2 = y2 +33;
      }
      else if(playerhand[i]==9)
      {
         g.drawImage(card9, 910, y2, null);
          
         y2 = y2 +33;
      }
      else if(playerhand[i]==10)
      {
         g.drawImage(card10, 910, y2, null);
          
         y2 = y2 +33;
      }
      else if(playerhand[i]==11)
      {
         g.drawImage(cardJ, 910, y2, null);
          
         y2 = y2 +33;
      }
      else if(playerhand[i]==12)
      {
         g.drawImage(cardQ, 910, y2, null);
          
         y2 = y2 +33;
      }
      else if(playerhand[i]==13)
      {
         g.drawImage(cardK, 910, y2, null);
          
         y2 = y2 +33;
      }
    }
    if(x>10)
    {
      sum = sum+10;
      x=0;
    }
    else if(x==1)
    {
      sum = sum+11;
      x=0;
      
      if(sum>21)
      {
         sum=sum-10;
      }
    }
    else
    {
      sum = sum+x;
      x=0;
    }
    if(y>10)
    {
      sum = sum+10;
      y=0;
    }
    else if(y==1)
    {
      sum = sum+11;
      y=0;
      if(sum>21)
      {
         sum=sum-10;
      }
    }
    else
    {
      sum = sum+y;
      y=0;
    }
    
    if(x1==1 && y1==1 && sum>21)
    {
       sum = sum-10;
       x1=0;
       y1=0;
    }
    else if(x1==1 && sum>21)
    {
       sum = sum-10;
       x=0;
    }
    else if(y1==1 && sum>21)
    {
       sum = sum-10;
       y1=0;
    }
      
    //bot----------------------------------------------------------------------------------
    boty2 = 300;
    if(botx>10)
    {
      botsum=botsum+10;
      botx=0;
    }
    else if(botx<=10)
    {
      botsum=botsum+botx;
      botx=0;
    }
    else if(botx==1)
    {
      botsum=botsum+ 11;
      botx=0;
      if(botsum>21)
      {
         botsum = botsum-10;
         botx=0;
      }
    }
    
    if(boty>10)
    {
      botsum=botsum+10;
      boty=0;
    }
    else if(boty<=10)
    {
      botsum=botsum+boty;
      boty=0;
    }
    else if(boty==1)
    {
      botsum=botsum+ 11;
      boty=0;
      if(botsum>21)
      {
         botsum = botsum-10;
         boty=0;
      }
    }
    
    if(a==1)
    {
      if(dealerhand[1]==1)
         {
            g.drawImage(cardA, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[0]==2)
         {
            g.drawImage(card2, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[1]==3)
         {
            g.drawImage(card3, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[1]==4)
         {
            g.drawImage(card4, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[1]==5)
         {
            g.drawImage(card5, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[1]==6)
         {
            g.drawImage(card6, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[1]==7)
         {
            g.drawImage(card7, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[1]==8)
         {
            g.drawImage(card8, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[1]==9)
         {
            g.drawImage(card9, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[1]==10)
         {
            g.drawImage(card10, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[1]==11)
         {
            g.drawImage(cardJ, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[1]==12)
         {
            g.drawImage(cardQ, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[1]==13)
         {
            g.drawImage(cardK, 910, boty2, null);
             
            boty2=boty2+33;
         }
    }
    
    if(a==1)
    {
      g.drawImage(card, 910, boty2, null);
       
    }
    
    
    while(botsum<17&&botm!=5&&j==2&&botsum<=sum&&botm!=5&&boti<5)
    {
      botd = rng.nextInt(13)+1;
      boti=boti+1;
      dealerhand[boti] = botd;
      if(botd>10)
      {
         botsum = botsum+10;
         botd=0;
       }
       else if (botd==1)
       {
         botc = botd;
         botsum=botsum+11;
         if(botsum>21)
         {
            botsum = botsum-10;
            botc=0;
         }
         botd=0;
       }
       else
       {
         botsum=botsum+botd;
         botd=0;
       }      
    }
    botm=boti;
    if(botx==1 && boty==1 && botsum>21)
    {
       botsum = sum-10;
       botx=0;
       boty=0;
         }
    else if(botx==1 && botsum>21)
    {
       sum = sum-10;
       x=0;
    }
    else if(y==1 && sum>21)
    {
       sum = sum-10;
       y=0;
    }
    
    while(botsum>21 && botc==1)
    {
       botsum = botsum-10;
       botc=0;
    }
    
    boty2 = 300;
    if(j==2 && sum<21)
    {
       for(boti = 0; boti<dealerhand.length; boti++)
       {
         if(dealerhand[boti]==1)
         {
            g.drawImage(cardA, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[boti]==2)
         {
            g.drawImage(card2, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[boti]==3)
         {
            g.drawImage(card3, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[boti]==4)
         {
            g.drawImage(card4, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[boti]==5)
         {
            g.drawImage(card5, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[boti]==6)
         {
            g.drawImage(card6, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[boti]==7)
         {
            g.drawImage(card7, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[boti]==8)
         {
            g.drawImage(card8, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[boti]==9)
         {
            g.drawImage(card9, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[boti]==10)
         {
            g.drawImage(card10, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[boti]==11)
         {
            g.drawImage(cardJ, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[boti]==12)
         {
            g.drawImage(cardQ, 910, boty2, null);
             
            boty2=boty2+33;
         }
         else if(dealerhand[boti]==13)
         {
            g.drawImage(cardK, 910, boty2, null);
             
            boty2=boty2+33;
         }
      }
    }

    
    
    // Win or Lose----------------------------------------------------------------
    g.setColor(Color.WHITE);
    g.setFont(font1);
    if(j==1 && sum<21)
    {
      drawCenteredText(g, "You won because you drew 5 cards without busting!", 960, 170);
    }
    else if(sum==21)
    {
      drawCenteredText(g, "You won with BlackJack!", 960, 170);
    }
    else if(sum>21)
    {
      drawCenteredText(g, "You busted with "+sum+"!", 960, 170);
    }
    if(j==2 && sum<21){
       if(botsum==21)
       {
         drawCenteredText(g, "The dealer won with BlackJack!", 960, 170);
       }
       else if(botm==5&&sum<21)
       {
         drawCenteredText(g, "The dealer won because the dealer drew 5 cards without busting!", 960, 170);
       }
       else if(botsum>21)
       {
         drawCenteredText(g, "The dealer busted with "+botsum+"!", 960, 170);
       }
       else if(j==2 && sum<botsum)
       {
         drawCenteredText(g, "You lost with a score of "+sum+" while the dealer had "+botsum+".", 960, 170);
       }
       else if(j==2 && botsum<sum)
       {
         drawCenteredText(g, "You won with a score of "+sum+" while the dealer had "+botsum+".", 960, 170);
       }
       else if(botsum==sum)
       {
         drawCenteredText(g, "You tied with the dealer with a score of "+sum+".", 960, 170);
       }
    }
  }

  /* Read the image with the specified file name and return it as a BufferedImage. */
  public static BufferedImage readImage(String infile)
  {
    try
    {
      BufferedImage ret = ImageIO.read(new File(infile));
      return ret;
    }
    catch(Exception e){System.out.println(e.getMessage()); return null;}
  }
  
  // input: original image, angle in degrees
  // returns: rotated image
  // don't worry about the details if too complicated, you can just use it
  public static BufferedImage rotateImage(BufferedImage original, double angle)
  {
    // define some variables we will be using a lot to simplify the math
    double PI2 = Math.PI*2;
    double sin = Math.abs(Math.sin(angle));
    double cos = Math.abs(Math.cos(angle));
    int ow = original.getWidth();
    int oh = original.getHeight();
    int w = (int)(ow*cos + oh*sin);
    int h = (int)(ow*sin + oh*cos);
    double xc = w/2.0;
    double yc = h/2.0;
    double oxc = ow/2.0;
    double oyc = oh/2.0;
    
    // Make the new image for the rotated version
    BufferedImage ret = new BufferedImage(w, h, original.getType()==0 ? BufferedImage.TYPE_INT_ARGB : original.getType());
    
    double xd, yd, r, ang;
    int sx, sy;
    
    // Loop over the rows and columns of the new image we're building
    for(int y = 0; y < h; y++)
    {
      yd = y - yc;
      for(int x = 0; x < w; x++)
      {
        xd = x - xc;
        r = Math.sqrt(xd*xd + yd*yd);
        ang = Math.acos(xd/r);
        if(yd < 0)
        {
          ang = PI2 - ang;
        }
        
        ang -= angle;
        
        sx = (int)Math.round(r*Math.cos(ang) + oxc);
        sy = (int)Math.round(r*Math.sin(ang) + oyc);
        
        if(sx >=0 && sx < ow && sy >= 0 && sy < oh)
        {
          ret.setRGB(x, y, original.getRGB(sx, sy));
        }
        else
        {
          ret.setRGB(x,y,0);
        }
      }
    }
    
    return ret;
  }
  public void drawBoxedText(Graphics g, String text, int x, int y, int border)
  { 
    Font f = g.getFont(); // get the actual font currently being used
    
    // The FontMetrics class gives us all sorts of information about how the
    // Font will be rendered in the current environment.
    // (getFontMetrics is a method provided by JPanel).
    FontMetrics metrics = getFontMetrics(f);
    
    // This gives the width in pixels of the specified String
    // Note how we add 2*border because the border is on the left and right
    int width = metrics.stringWidth(text) + 2*border;
    
    /* This gives the max height of any String in this font. For some reason
       probably having to do with Unicode support (e.g. accent marks), the
       height given by this method is generally too large for English text.
       So, I've found that multiplying by 4/5 often gives a height that is
       "just right". (Results may vary by font and character set.)
       
       (You can alternatively use getHeight, in which case multiplying by 2/3
        might work better.)
    */
    int height = metrics.getAscent()*4/5 + 2*border;
    
    // Finally we can draw the actual String!
    // Note how we have to add the height, since drawString y coordinate is
    // the bottom.
    g.drawString(text, x + border, y + height - border);
    
    // Note that we have to subtract the height here because the y coordinate
    // for drawString is the bottom not the top!
    g.drawRect(x, y, width, height);
  }
  
  /* The above method figures out how large the String is, then sizes the box
     to match. This is a slightly different approach: given a fixed point in
     the image, adjust the position of the String based on its size to ensure
     it is centered on that point.
   */
  public void drawCenteredText(Graphics g, String text, int xCenter, int yCenter)
  { 
    Font f = g.getFont();
    FontMetrics metrics = getFontMetrics(f);
    int width = metrics.stringWidth(text);
    int height = metrics.getAscent()*4/5;
    
    g.drawString(text, xCenter-width/2, yCenter+height/2);
  }
}