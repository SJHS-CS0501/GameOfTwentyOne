import java.util.Scanner;
import javax.swing.*;

//import GameOfTwentyOne.MyListener;

import java.awt.*;
import java.awt.event.*;

/**
 * 
 */

/**
 * @author woytek
 * @author Isabelle Schroeder
 * 
 * This program plays a variation on the game blackjack using two six-sided dice 
 * instead of cards. No gambling though.
 *
 */
public class GameOfTwentyOne {

	static JLabel label;
	static JButton button;
	static JTextField textField;
	//static JButton textFieldUpdate;
	static GridBagLayout layout;
	
	static int total = 0; // user's total
	static Dice DieOne = new Dice(6); // first roll
	static Dice DieTwo = new Dice(6); // second roll
	
	/**
	 * This is the main class for GameOfTwentyOne program.
	 * @param args main arguments for the GameOfTwentyOne class
	 */
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		String cont; // holds user's answer for continuing
		int wins = 0; // user's wins
		int count = 0; // to count the number of games played
		int computer = 0; // computer's total
		
		JFrame frame = new JFrame( "Game of 21" );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		layout = new GridBagLayout();
	    frame.setLayout( layout );
	        
	    GridBagConstraints c = new GridBagConstraints();
	    c.fill = GridBagConstraints.BOTH;
	        
	    c.weightx = 0.0;
	    c.gridwidth = GridBagConstraints.RELATIVE;
		
	    label = new JLabel( "Let's play a Game of 21! It's like blackjack but with simulated dice!" );
	    
	    label.setFont( new Font("TimesRoman", Font.PLAIN, 18) );
        layout.setConstraints( label, c );
        // Now add it to the frame (ALSO IMPORTANT!!!!!!!)
        frame.add( label );
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        button = new JButton( "Roll again" );
        button.setFont(new Font("TimesRoman", Font.PLAIN, 12));

        ActionListener listener = new SuperListener();
        button.addActionListener(listener);

        layout.setConstraints( button, c );
        frame.add( button );

        frame.pack();
        frame.setSize( frame.getPreferredSize() );
        
        frame.setVisible( true );
		
		
		
		
		
		
		
		
		
		
		
		
		do{	do { DieOne.roll(); // user can choose to roll the dice until their score is over 21
			
			total += DieOne.getValue();
		
			DieTwo.roll();
			total += DieTwo.getValue(); // dice rolls for user
		
			DieOne.roll();
			computer += DieOne.getValue();
		
			DieTwo.roll();
			computer += DieTwo.getValue(); // secret dice rolls for computer
			
			
			System.out.print( "You're total is " + total +".\nWould you like to roll the dice again? "
					+ "(Enter y for yes and n for no)" ); // telling people their score
			cont = keyboard.nextLine();
		
			} while(cont.equalsIgnoreCase( "y" ) && total <= 21 ); 
			// will not let the user continue rolling even if they hit y
		
			System.out.println( "My total is " + computer + ". Yours is " + total + ".");
			// secret computer score revealed
		
			if( total > computer && total <= 21 ){
				System.out.println( "You win!!" ); 
				// user winning when neither player goes over 21
				wins ++; // user's wins
			
			} else if( computer > total && computer <= 21 ){
				System.out.println( "I WIN!! Not like I cheated or anything.." ); 
				// computer winning when neither player goes over 21
		
			} else if( total == computer && total <= 21 ){
				System.out.println( "We tied!" ); // Players tie, no one wins
		
			} else if( total > 21 && computer <= 21 ){
				System.out.println( "You went over 21! I win:P" );
				// User goes over 21, computer automatically wins
		
			} else if( computer > 21 && total <= 21 ){
				System.out.println( "I went over 21! I guess you win." ); 
				// user wins when computer goes over 21
				wins ++; // user's wins
			
			} else if( computer > 21 && total > 21 ){
				System.out.println( "We both lose!" ); // everyone is sad
			}
			
			System.out.print( "Would you like to play again?" );
			cont = keyboard.nextLine();
			
			total = 0;
			computer = 0; // resets total and computer for next game
			count ++; // games played
		
		} while ( cont.equalsIgnoreCase( "y" ));
		
		// displaying games won and played
		System.out.println( "You won " + wins + " out of " + count + " games!" );
		System.out.println( "Goodbye!" );
		
	}
	
	 static class SuperListener implements ActionListener {

	        int index = 0;

	        public void actionPerformed(ActionEvent e) {
	            JButton eventSource = (JButton)e.getSource();
	            if( eventSource.getText().equals( "Roll again" ) && total <= 21 ) {
	               // label.setText(  );
	            }
	        }
	    }
	
}
