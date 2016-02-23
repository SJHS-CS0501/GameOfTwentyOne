import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Turn the game of 21 to a Gui application
//1.button for roll dice
//2.Button Dont roll dice
//3.Determine the Winner

public class GameofTwentyone
{
  public staic void main(String[] args)
  {
    //variables
    static JLabel myLabel1;                     //announces users roll sum
    static JLabel myLabel2;                     //announces computers roll sum
    static JLabel myLabel3;                     //announces when you lose to the computer
    static JLabel myLabel4;                     //announces when you beat the Computer
    static JLabel myLabel5;                     //announces amounts of victories
    static JButton myButton1;                    //upon click, add to users sum
    static JButton myButton2;                   //upon click, shows myLabel3 and myLabel4
    static JButton myButton3;
    static GridBagLayout layout;
    int pn = 0;                                 //users sum
    int cn = 0;                                 //computers sum
    short pw = 0;                               //amount of player wins
    short cw = 0;                               //amount of computer wins
    Random Ran = new Random();
    int x = Ran.nextInt(1, 2, 3, 4, 5, 6);
    
        JFrame myFrame = new JFrame("Game of 21");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible( true );
        myFrame.setLayout( new GridLayout( 2, 2, 50, 10 ) );
        layout = new GridBagLayout();
        myFrame.setLayout( layout );
        
        
        GridBagConstraints c = new GridBagConstraints();
        // general constraints
        c.fill = GridBagConstraints.BOTH;
        
        // label constraints
        c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.RELATIVE;
        
        
        
        //lable1
        myLabel1 = new JLabel("Your roll sum is:"+ pn);
        myLabel1.setForeground(Color.BLUE);
        myLabel1.setFont(new Font("TimesRoman", Font.BOLD, 24));
        layout.setConstraints( myLabel1, c );
        myFrame.add(myLabel1);
        System.out.println("Lable1 visible...");
        
        
        //label2
        myLabel2= new JLable("The computers roll sum is: " + cn);
        myLabel2.setForeground(Color.RED);
        myLabel2.setFont(new Font("TimesRoman", Font.BOLD, 24));
        layout.setConstraints( myLabel2, c );
        myFrame.add(myLabel2);
        System.out.println("Lable2 visible...");
        
        
        myLabel3= new JLable("Computer: " + cw + "         You: " + pw);
        myLabel3.setForeground(Color.GREEN);
        myLabel3.setFont(new Font("TimesRoman", Font.BOLD, 24));
        layout.setConstraints( myLabel3, c );
        myFrame.add(myLabel3);
        System.out.println("Lable3 visible");
        
        
        boolean Flag1 = false;
        while(Flag1==true)
        {
          //lable 4
          if(pn>21||cn==21)
          {
            myLable4 = new JLable("You lost to the computer");
            myLabel4.setForeground(Color.RED);
            myLabel4.setFont(new Font("TimesRoman", Font.BOLD, 24));
            layout.setConstraints( myLabel4, c );
            myFrame.add(myLabel4);
            System.out.println("Lable4 visible...");
            pn= 0;
            cn=0;
            cw++;
            Flag1 = false;
          }//myLable4 end
        
        
          //Lable5
          if(cn>21||pn==21)
          {
            myLabel5 = new JLable("You beat the computer");
            myLabel5.setForeground(Color.BLUE);
            myLabel5.setFont(new Font("TimesRoman", Font.BOLD, 24));
            layout.setConstraints( myLabel5, c );
            myFrame.add(myLabel5);
            System.out.println("Lable5 visible...");
            pn= 0;
            cn=0;
            pw++;
            Flag1 = false;
          }//myLabel5 end
        }//WHILE FLAG1 =TRUE  
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        
        
        // makes button1
        myButton1 = new JButton("Roll die");
        myButton1.setFont(new Font("TimesRoman", Font.ITALIC, 14));
        ActionListener listener1 = new MyListener();
        myButton1.addActionListener(listener1);
        layout.setConstraints( myButton1, c);
        myFrame.add(myButton1);
        System.out.println("Button1 visible...");
        
        
        
        //button2
        myButton2 = new JButton("Stay on current number");
        myButton2.setFont(new Font("TimesRoman", Font.ITALIC, 14));
        ActionListener listener2 = new MyListener();
        myButton2.addActionListener(listener2);
        layout.setConstraints( myButton2, c);
        myFrame.add(myButton2);
        System.out.println("Button2 visible...");
        
        
        
        
        //myButton3
        myButton3 = new JButton("Close Game");
        myButton3.setFont(new Font("TimesRoman", Font.ITALIC, 14));
        ActionListener listener3 = new MyListener();
        myButton3.addActionListener(listener3);
        layout.setConstraints( myButton3, c);
        myFrame.add(myButton3);
        System.out.println("Button3 visible...");
        
        
        //frame packs
        myFrame.setSize( myFrame.getPreferredSize() );
        myFrame.pack();
        
  }//main end
}//end of class


static class MyListener implements ActionListener 
{
   public void actionPerformed(ActionEvent e) 
   {
     JButton eventSource1 = (JButton1)e.getSource1();
     JButton eventSource2 = (JButton2)e.getSource2();
     JButton eventSource3 = (JButton3)e.getSource3();
     if( source1== myButton1)
     {
        System.out.println("Button1 Clicked...");
        pn = pn + x;
        if(cn<17)
        {
          cn= cn + x;
          System.out.println("Computer-Dice rolled " + x);
        }//computer number lower than 19
        if(cn>=19)
        {
          cn = cn+0;
          System.out.println("Computer did not roll dice");
        }computer number>19
     }//if myButton2 = source end
     if(source2 ==myButton2)
     {  
        System.out.println("Button2 Clicked...");
        Flag1=true;
     }//source == my button2 end
     if(source3==myButton3)
     {
      System.out.println("Button3 clicked");
      system.exit;
     }//end game
   }//end of action performed class
}//event class end
