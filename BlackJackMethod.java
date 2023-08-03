// Code made by Ayden
// feat. Kevin, Brayden, Vikram, and Mihir
import java.util.Random;
import java.util.Scanner;
public class BlackJackMethod
{
   public static void BlackJack()
   {
      Random rng = new Random();
      Scanner scan = new Scanner(System.in);
      
      // Credit Mihir for 6 problems
      // Credit Kevin and Brayden for 1 line of code
      // Credit Vikram for 2 problems
      // Record of most BlackJacks in a row: 3 - Ayden
      // Record of most wins/ties in a row: 5 - Ayden
      
      int x = rng.nextInt(13)+1;
      int y = rng.nextInt(13)+1;
      int c = 0;
      int botx = rng.nextInt(13)+1;
      int boty = rng.nextInt(13)+1;
      int botc = 0;
      int sum = 0;
      int botsum = 0;
      char z = ' ';
      char r = ' ';
      char botz = ' ';
      char botr = ' ';
   
      if(x==13)
      {
         z = (char)'K';
      }
      else if(x==12)
      {
         z = (char)'Q';
      }
      else if(x==11)
      {
         z = (char)'J';
      }
      else if(x==1)
      {
         z = (char)'A';
      }
      

      if(botx==13)
      {
         botz = (char)'K';
      }
      else if(botx==12)
      {
         botz = (char)'Q';
      }
      else if(botx==11)
      {
         botz = (char)'J';
      }
      else if(botx==1)
      {
         botz = (char)'A';
      }
      
      
      if(y==13)
      {
         r = (char)'K';
      }
      else if(y==12)
      {
         r = (char)'Q';
      }
      else if(y==11)
      {
         r = (char)'J';
      }
      else if(y==1)
      {
         r = (char)'A';
      }
      
      
      if(boty==13)
      {
         botr = (char)'K';
      }
      else if(boty==12)
      {
         botr = (char)'Q';
      }
      else if(boty==11)
      {
         botr = (char)'J';
      }
      else if(boty==1)
      {
         botr = (char)'A';
      }
      
      
      if(x==1 && y==1)
      {
         System.out.println("Your cards are "+z+" and "+r);
         sum = 1+11;
      }
      else if(x==1 && y>10)
      {
         System.out.println("Your cards are "+z+" and "+r);
         sum = 11+10;
      }
      else if(x>10 && y==1)
      {
         System.out.println("Your cards are "+ z +" and "+r);
         sum = 11+10;
      }
      else if(x<=10 && y==1)
      {
         System.out.println("Your cards are "+x+" and "+r);
         sum = x+11;
      }
      else if(x==1 && y<=10)
      {
         System.out.println("Your cards are "+z+" and "+y);
         sum = y+11;
      }
      else if(x>10 &&y>10)
      {
         System.out.println("Your cards are "+z+" and "+r);
         sum = 10+10;
      }
      else if(x>10&&y<=10)
      {
         System.out.println("Your cards are "+z+" and "+y);;
         sum = 10+y;
      }
      else if(x<=10&&y>10)
      {
         System.out.println("Your cards are "+x+" and "+r);
         sum = x+10;
      }
      else
      {
         System.out.println("Your cards are "+x+" and "+y);
         sum=x+y;
      }
      
      
      // bot
      if(botx==1 || botx>10)
      {
         System.out.println("The dealer's cards are "+botz+" and ?");
      }
      else if(botx<=10)
      {
         System.out.println("The dealer's cards are "+botx+" and ?");
         botsum = botx+10;
      }
      
      if(sum==21)
      {
         System.out.println("You won with a BlackJack!");
         char loop;
         System.out.println("Do you want to play again? (y/n)");
         String again = scan.nextLine();
         again = again.toLowerCase();
         loop = again.charAt(0);
         while(loop == 'y')
         {
            BlackJack();
         }
         System.out.println("Thanks for playing!");
         System.exit(0);
      }
          
      System.out.println("Would you like to hit or stay?");
      String hs = scan.nextLine();
      char h = hs.charAt(0); 
      
      for(int i=0; h == 'h' && sum<21; i++)
      {
         int d = rng.nextInt(13)+1;
         char f = ' ';
         if(d==13)
         {
            f = (char)'K';
            System.out.println("Your new card is "+f);
         }
         else if(d==12)
         {
            f = (char)'Q';
            System.out.println("Your new card is "+f);
         }
         else if(d==11)
         {
            f = (char)'J';
            System.out.println("Your new card is "+f);
         }
         else if(d==1)
         {
            f = (char)'A';
            System.out.println("Your new card is "+f);
         }
         else
         {
            System.out.println("Your new card is "+d);
         }
         
         if(d>10)
         {
            sum=sum+10;
         }
         else if (d==1)
         {
            c = d;
            sum=sum+11;
            if(sum>21)
            {
               sum = sum-10;
               c=0;
            }
         }
         else
         {
            sum=sum+d;
         }
         
         for(int k = 0; sum>21 && c==1;)
         {
            sum = sum-10;
            c=0;
         }
         
         if(x==1 && y==1 && sum>21)
         {
            sum = sum-10;
            x=0;
            y=0;
         }
         else if(x==1 && sum>21)
         {
            sum = sum-10;
            x=0;
         }
         else if(y==1 && sum>21)
         {
            sum = sum-10;
            y=0;
         }
         System.out.println("Your score is "+sum);
         if(i==2 && sum<21)
         {
            System.out.println("You won! You got 5 cards without busting.");
            char loop;
            System.out.println("Do you want to play again? (y/n)");
            String again = scan.nextLine();
            again = again.toLowerCase();
            loop = again.charAt(0);
            while(loop == 'y')
            {
               BlackJack();
            }
            System.out.println("Thanks for playing!");
            System.exit(0);
         }
         if(sum<21)
         {
            System.out.println("Would you like to hit or stay?");
            hs = scan.nextLine();
            hs = hs.toLowerCase();
            h = hs.charAt(0);
         }
         if(sum==21)
         {
            System.out.println("You won with a BlackJack!");
            char loop;
            System.out.println("Do you want to play again? (y/n)");
            String again = scan.nextLine();
            again = again.toLowerCase();
            loop = again.charAt(0);
            while(loop == 'y')
            {
               BlackJack();
            }
            System.out.println("Thanks for playing!");
            System.exit(0);
         }
      }
      
      if(sum>21)
      {
         System.out.println("The dealer won. You busted with a score of "+sum+".");
         char loop;
         System.out.println("Do you want to play again? (y/n)");
         String again = scan.nextLine();
         again = again.toLowerCase();
         loop = again.charAt(0);
         while(loop == 'y')
         {
            BlackJack();
         }
         System.out.println("Thanks for playing!");
         System.exit(0);
      }
     
      // bot
      if(botx==1 && boty==1)
      {
         System.out.println("The dealer's cards are "+botz+" and "+botr);
         botsum = 1+11;
      }
      else if(botx==1 && boty>10)
      {
         System.out.println("The dealer's cards are "+botz+" and "+botr);
         botsum = 11+10;
      }
      else if(botx>10 && boty==1)
      {
         System.out.println("The dealer's cards are "+botz+" and "+botr);
         botsum = 11+10;
      }
      else if(botx<=10 && boty==1)
      {
         System.out.println("The dealer's cards are "+botx+" and "+botr);
         botsum = botx+11;
      }
      else if(botx==1 && boty<=10)
      {
         System.out.println("The dealer's cards are "+botz+" and "+boty);
         botsum = boty+11;
      }
      else if(botx>10 && boty>10)
      {
         System.out.println("The dealer's cards are "+botz+" and "+botr);
         botsum = 10+10;
      }
      else if(botx>10 && boty<=10)
      {
         System.out.println("The dealer's cards are "+botz+" and "+boty);;
         botsum = 10+boty;
      }
      else if(botx<=10&&boty>10)
      {
         System.out.println("The dealer's cards are "+botx+" and "+botr);
         botsum = botx+10;
      }
      else
      {
         System.out.println("The dealer's cards are "+botx+" and "+boty);
         botsum=botx+boty;
      }
      
      if(sum==21)
      {
         System.out.println("You won with a BlackJack!");
         char loop;
         System.out.println("Do you want to play again? (y/n)");
         String again = scan.nextLine();
         again = again.toLowerCase();
         loop = again.charAt(0);
         while(loop == 'y')
         {
            BlackJack();
         }
         System.out.println("Thanks for playing!");
         System.exit(0);
      } 
      if(botsum==21)
      {
         System.out.println("The dealer won with a BlackJack!");
         char loop;
         System.out.println("Do you want to play again? (y/n)");
         String again = scan.nextLine();
         again = again.toLowerCase();
         loop = again.charAt(0);
         while(loop == 'y')
         {
            BlackJack();
         }
         System.out.println("Thanks for playing!");
         System.exit(0);
      }
     
      char both = 'h';
      if(sum>21)
      {
         System.out.println("The dealer won. You busted with a score of "+sum+".");
         both = 's';
         char loop;
         System.out.println("Do you want to play again? (y/n)");
         String again = scan.nextLine();
         again = again.toLowerCase();
         loop = again.charAt(0);
         while(loop == 'y')
         {
            BlackJack();
         }
         System.out.println("Thanks for playing!");
         System.exit(0);
      }
      for(int j=0; both=='h' && botsum<17; j++)
      {
         int botd = rng.nextInt(13)+1;
         char botf = ' ';
         if(botsum>sum)
         {
            both = 's';
            System.out.println("You lost with a score of "+sum+" while the dealer had "+botsum+".");
            char loop;
            System.out.println("Do you want to play again? (y/n)");
            String again = scan.nextLine();
            again = again.toLowerCase();
            loop = again.charAt(0);
            while(loop == 'y')
            {
               BlackJack();
            }
            System.out.println("Thanks for playing!");
            System.exit(0);
         }
         if(botd==13)
         {
            botf = (char)'K';
            System.out.println("The dealer's new card is "+botf);
         }
         else if(botd==12)
         {
            botf = (char)'Q';
            System.out.println("The dealer's new card is "+botf);
         }
         else if(botd==11)
         {
            botf = (char)'J';
            System.out.println("The dealer's new card is "+botf);
         }
         else if(botd==1)
         {
            botf = (char)'A';
            System.out.println("The dealer's new card is "+botf);
         }
         else
         {
            System.out.println("The dealer's new card is "+botd);
         }
         
         if(botd>10)
         {
            botsum=botsum+10;
         }
         else if (botd==1)
         {
            botsum=botsum+11;
            botd = botc;
            if(botsum>21)
            {
               botsum = botsum-10;
            }
         }
         else
         {
            botsum=botsum+botd;
         }
         
         if(botx==1 && botsum>21)
         {
            botsum = botsum-10;
            botx=0;
         }
         else if(boty==1 && botsum>21)
         {
            botsum = botsum-10;
            boty=0;
         }
         for(int botk = 0; botsum>21 && botc==1;)
         {
            botsum = botsum-10;
            botc=0;
         }
         System.out.println("The dealer's score is "+botsum);
         if(j==2 && botsum<21)
         {
            System.out.println("The dealer won! The dealer got 5 cards without busting.");
            char loop;
            System.out.println("Do you want to play again? (y/n)");
            String again = scan.nextLine();
            again = again.toLowerCase();
            loop = again.charAt(0);
            while(loop == 'y')
            {
               BlackJack();
            }
            System.out.println("Thanks for playing!");
            System.exit(0);
         }
         if(botsum==21)
         {
            System.out.println("The dealer won with a BlackJack!");
            char loop;
            System.out.println("Do you want to play again? (y/n)");
            String again = scan.nextLine();
            again = again.toLowerCase();
            loop = again.charAt(0);
            while(loop == 'y')
            {
               BlackJack();
            }
            System.out.println("Thanks for playing!");
            System.exit(0);
         }
      }
         
         
      if(sum>21)
      {
      
      }
      else if(botsum>21)
      {
         System.out.println("You won! The dealer busted with a score of "+botsum+".");
         char loop;
         System.out.println("Do you want to play again? (y/n)");
         String again = scan.nextLine();
         again = again.toLowerCase();
         loop = again.charAt(0);
         while(loop == 'y')
         {
            BlackJack();
         }
         System.out.println("Thanks for playing!");
         System.exit(0);
      }
      else if(sum==botsum)
      {
         System.out.println("You tied with a dealer with a score of "+sum+".");
         char loop;
         System.out.println("Do you want to play again? (y/n)");
         String again = scan.nextLine();
         again = again.toLowerCase();
         loop = again.charAt(0);
         while(loop == 'y')
         {
            BlackJack();
         }
         System.out.println("Thanks for playing!");
         System.exit(0);
      }
      else if(botsum==21)
      {
         System.out.println("The dealer won with a BlackJack!");
         char loop;
         System.out.println("Do you want to play again? (y/n)");
         String again = scan.nextLine();
         again = again.toLowerCase();
         loop = again.charAt(0);
         while(loop == 'y')
         {
            BlackJack();
         }
         System.out.println("Thanks for playing!");
         System.exit(0);
      }
      else if(sum==21)
      {
         System.out.println("You won with BlackJack!");
         char loop;
         System.out.println("Do you want to play again? (y/n)");
         String again = scan.nextLine();
         again = again.toLowerCase();
         loop = again.charAt(0);
         while(loop == 'y')
         {
            BlackJack();
         }
         System.out.println("Thanks for playing!");
         System.exit(0);
      }
      else if(sum>botsum)
      {
         System.out.println("You won with a score of "+sum+" while the dealer had "+botsum+".");
         char loop;
         System.out.println("Do you want to play again? (y/n)");
         String again = scan.nextLine();
         again = again.toLowerCase();
         loop = again.charAt(0);
         while(loop == 'y')
         {
            BlackJack();
         }
         System.out.println("Thanks for playing!");
         System.exit(0);
      }
      else if(sum<botsum)
      {
         System.out.println("You lost with a score of "+sum+" while the dealer had "+botsum+".");
         char loop;
         System.out.println("Do you want to play again? (y/n)");
         String again = scan.nextLine();
         again = again.toLowerCase();
         loop = again.charAt(0);
         while(loop == 'y')
         {
            BlackJack();
         }
         System.out.println("Thanks for playing!");
         System.exit(0);
      }
   }
}