import java.awt.*;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



/**
 * 
 */

/**
 * @author Ryan Smith
 *
 */
public class GameOfTwentyOneGUI {
	
	//declarations and instantiations
	static JLabel myLabel;
    static JButton myButton;
    static JTextField myTextField;
    static JButton freeze;
    static GridBagLayout layout;
    static Die d1 = new Die( 6 );//Creating object d1
	static Die d2 = new Die( 6 );//Creating object d2
	static char decision;//Declaring character decision
	static int dieRoll = 0;//Declaring integer dieRoll
	static int computerDieRoll = 0;//Declaring integer computerDieRoll
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);//This allows user to type information
		

		JFrame myFrame = new JFrame("A Game of Twenty One");
		//myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layout = new GridBagLayout();
        myFrame.setLayout( layout );
        myFrame.pack();
        myFrame.setSize( myFrame.getPreferredSize() );
        myFrame.setVisible(true); //Makes the JFrame visible
        
        myLabel = new JLabel("Welcome to a Game of Twenty One.  Can you beat me, the computer?");
        myLabel.setForeground(Color.BLUE); //Sets the color of the JLabel to blue.
        myLabel.setFont(new Font("TimesRoman", Font.BOLD, 24)); //Sets the font of the JLabel to Times New Roman, bold, and 24 point size.
        GridBagConstraints c = new GridBagConstraints(); //Instantiating GridBagConstrainsts
        layout.setConstraints( myLabel, c ); //Applies the GridBagConstrainsts to the JLabel
        c.fill = GridBagConstraints.BOTH;
        myFrame.add(myLabel);
        
        myButton = new JButton("HIT ME"); //Creates new JButton that displays "HIT ME"
        myButton.setFont(new Font("TimesRoman", Font.ITALIC, 12)); //Sets the font of the text inside the JButton to Times New Roman, italicized, and 12 point size.
        ActionListener listener = new MyListener(); //Creates listener MyListener.
        myButton.addActionListener(listener);//Adds the listener.
        layout.setConstraints( myButton, c);
        myFrame.add(myButton);//Adds the JButton to myFrame
        
		freeze = new JButton("FREEZE");//Creates new JButton that displays "FREEZE"
		freeze.setFont(new Font("TimesRoman", Font.ITALIC, 12));//Sets font of text inside JButton to Times New Roman, italicized, 12 point.
		freeze.addActionListener(listener);//Adds the listener.
		layout.setConstraints(freeze, c);
		myFrame.add(freeze);//Adds JButton to myFrame
		
		
		System.out.println("Welcome to a game of 21! You will be playing against the computer in a dice game.");
		
		
		do{//do...while loop
			System.out.println("Would you like to roll the dice? (y to keep playing, anything else to quit)");
			decision = keyboard.nextLine().toLowerCase().charAt(0);
			if( decision != 'y') {
				break;
			}
			d1.roll();
			d2.roll();
			computerDieRoll += d1.getDieValue();
			dieRoll += d2.getDieValue();
			d1.roll();
			d2.roll();
			computerDieRoll += d1.getDieValue();
			dieRoll += d2.getDieValue();
			System.out.println("Your current score is: " + dieRoll);
			//if statements
			if( dieRoll == 21 && computerDieRoll != 21 ) {
				System.out.println("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll );
				System.exit(0);
			}
			if( dieRoll != 21 && computerDieRoll == 21 ) {
				System.out.println("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll);
				System.exit(0);
			}
			if( dieRoll == 21 && computerDieRoll == 21 ) {
				System.out.println("Good game! It was a draw.  You both had: " + dieRoll);
				System.exit(0);
			}
			if( dieRoll < 21 && computerDieRoll > 21 ) {
				System.out.println("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll );
				System.exit(0);
			}
			if( dieRoll > 21 && computerDieRoll < 21 ) {
				System.out.println("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll);
				System.exit(0);
			}
			
			if( dieRoll > 21 && computerDieRoll > 21 && dieRoll > computerDieRoll ) {
				System.out.println("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll);
				System.exit(0);
			}
			if( dieRoll > 21 && computerDieRoll > 21 && computerDieRoll > dieRoll ) {
				System.out.println("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll);
				System.exit(0);
			}
			if( dieRoll > 21 && computerDieRoll > 21 && computerDieRoll == dieRoll ) {
				System.out.println("Good game! It was a draw.  You both had: " + dieRoll);
				System.exit(0);
			}
		} while( dieRoll < 21 && computerDieRoll < 21);
		
		if( dieRoll == 21 && computerDieRoll != 21 ) {
			System.out.println("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll );
			System.exit(0);
		}
		if( dieRoll != 21 && computerDieRoll == 21 ) {
			System.out.println("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll);
			System.exit(0);
		}
		if( dieRoll == 21 && computerDieRoll == 21 ) {
			System.out.println("Good game! It was a draw.  You both had: " + dieRoll);
			System.exit(0);
		}
		if( dieRoll < 21 && computerDieRoll > 21 ) {
			System.out.println("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll );
			System.exit(0);
		}
		
		if( dieRoll > 21 && computerDieRoll < 21 ) {
			System.out.println("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll);
			System.exit(0);
		}
		if( dieRoll > 21 && computerDieRoll > 21 && dieRoll > computerDieRoll ) {
			System.out.println("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll);
			System.exit(0);
		}
		if( dieRoll > 21 && computerDieRoll > 21 && computerDieRoll > dieRoll ) {
			System.out.println("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll);
			System.exit(0);
		}
		if( dieRoll < computerDieRoll && computerDieRoll < 21 ) {
			System.out.println("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll);
			System.exit(0);
		}
		if( computerDieRoll < dieRoll && dieRoll < 21 ) {
			System.out.println("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll );
			System.exit(0);
		}
		keyboard.close();

	}
	
	/**
	 * Constructor (performs initial roll)
	 * @author Ryan Smith
	 *
	 */
	public static class Die {
		private int dieFaces;
		private int dieValue;
		
		/**
		 * @param numDieFaces
		 */
		public Die(int numDieFaces ) {
			dieFaces = numDieFaces;
			roll();
		}
		/**
		 * This method rolls the dice.
		 */
		public void roll() {
			Random random = new Random();
			
			dieValue = random.nextInt(dieFaces) + 1;
		}
		
		/**
		 * Accessor method
		 * @return dieFaces
		 */
		public int getDieFaces() {
			return dieFaces;
		}
		
		/**
		 * Accessor method
		 * @return dieValue
		 */
		public int getDieValue() {
			return dieValue;
		}
	}
	
	/**
	 * This class rolls the dice when the JButton "HIT ME" is pressed and updates the JLabel to display a running score.
	 * @author Ryan Smith
	 *
	 */
	static class MyListener implements ActionListener {
		
		/**
		 * Void method.  Allows actions to be performed as prescribed in the MyListener class comment.
		 */
		public void actionPerformed(ActionEvent e) {
			//Die d1 = new Die( 6 );
			//Die d2 = new Die( 6 );
			//int dieRoll = 0;
			//int computerDieRoll = 0;
			JButton eventSource = (JButton)e.getSource();
			if(eventSource.getText().equals("HIT ME")) {
				d1.roll();
				d2.roll();
				computerDieRoll += d1.getDieValue();
				dieRoll += d2.getDieValue();
				d1.roll();
				d2.roll();
				computerDieRoll += d1.getDieValue();
				dieRoll += d2.getDieValue();
				myLabel.setText("Your current score is: " + dieRoll);
				//These "if" statements stop the game if the user and/or computer reach or exceed 21.
				if( dieRoll == 21 && computerDieRoll != 21 ) {
					myLabel.setText("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				if( dieRoll != 21 && computerDieRoll == 21 ) {
					myLabel.setText("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				if( dieRoll == 21 && computerDieRoll == 21 ) {
					myLabel.setText("Good game! It was a draw.  You both had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				if( dieRoll < 21 && computerDieRoll > 21 ) {
					myLabel.setText("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				if( dieRoll > 21 && computerDieRoll < 21 ) {
					myLabel.setText("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				
				if( dieRoll > 21 && computerDieRoll > 21 && dieRoll > computerDieRoll ) {
					myLabel.setText("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				if( dieRoll > 21 && computerDieRoll > 21 && computerDieRoll > dieRoll ) {
					myLabel.setText("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				if( dieRoll > 21 && computerDieRoll > 21 && computerDieRoll == dieRoll ) {
					myLabel.setText("Good game! It was a draw.  You both had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
			} else if (eventSource.getText().equals("FREEZE")) {
				//These "if" statements are used after the user freezes to determine who is closer to 21 at that point without going over.
				if( dieRoll == 21 && computerDieRoll != 21 ) {
					myLabel.setText("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				if( dieRoll != 21 && computerDieRoll == 21 ) {
					ctrTwo++;
					myLabel.setText("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				if( dieRoll == 21 && computerDieRoll == 21 ) {
					myLabel.setText("Good game! It was a draw.  You both had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				if( dieRoll < 21 && computerDieRoll > 21 ) {
					myLabel.setText("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				
				if( dieRoll > 21 && computerDieRoll < 21 ) {
					myLabel.setText("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				if( dieRoll > 21 && computerDieRoll > 21 && dieRoll > computerDieRoll ) {
					myLabel.setText("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				if( dieRoll > 21 && computerDieRoll > 21 && computerDieRoll > dieRoll ) {
					myLabel.setText("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				if( dieRoll < computerDieRoll && computerDieRoll < 21 ) {
					myLabel.setText("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
				if( computerDieRoll < dieRoll && dieRoll < 21 ) {
					myLabel.setText("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll + " Would you like to play again? If so, press HIT ME");
					//System.exit(0);
					dieRoll = 0;
					computerDieRoll = 0;
				}
			}
		}
	}//static class MyListener end

}//public class GameOfTwentyOneGUI end




