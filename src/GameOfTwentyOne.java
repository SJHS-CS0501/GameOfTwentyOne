import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * This program will allow a user to play a variation of the popular blackjack card game with the computer.
 * @author woytek
 * @author Julianna Nichols
 */
public class GameOfTwentyOne {

	/**
	 * This is the main method for the GameOfTwentyOne program.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner( System.in );
		Die roll = new Die(6); //creating new Die object
		int userTotal = 0; //tally of user's total
		int compTotal = 0; //tally of computer's total
		int result; //yes or no response if user wants to roll again
		
		
		JOptionPane.showMessageDialog( null, "Let's play a game of blackjack--with dice!\nI just rolled, your turn!" );
		
		do {
			roll.roll(); //first die
			compTotal += roll.getValue();
			roll.roll(); //second die
			compTotal += roll.getValue();
			
			roll.roll(); //first die
			userTotal += roll.getValue();
			JOptionPane.showMessageDialog( null, "You rolled an " + roll.getValue() + "!" );
			
			roll.roll(); //second die
			userTotal += roll.getValue();
			JOptionPane.showMessageDialog( null, "You rolled an " + roll.getValue() + "!" );
			
			result = JOptionPane.showConfirmDialog( null, "Do you want to roll again?" ,
												"Roll Again?" , JOptionPane.YES_NO_OPTION);
			
		}
		while(result == JOptionPane.YES_OPTION);
		
		JOptionPane.showMessageDialog( null, "My total was " + compTotal + "!" );
		
		if(compTotal <= 21 && compTotal > userTotal) {
			//when both player's totals are under 21, but computer's total is closer to 21
			JOptionPane.showMessageDialog( null, "I win!" );
		} else if(userTotal <= 21 && userTotal > compTotal) {
			//when both player's totals are under 21, but user's total is closer to 21  	
			JOptionPane.showMessageDialog( null, "Yay! You win!" );
		} else if(compTotal <= 21 && userTotal > 21) {
			//when computer's total is equal to or under 21, and user's total is over 21 
			JOptionPane.showMessageDialog( null, "I win because you went over!" );
		} else if(compTotal > 21 && userTotal <= 21) {
			//when computer's total is over 21, but user's total is under 21	
			JOptionPane.showMessageDialog( null, "You win because I went over!" );
		} else if(compTotal <= 21 && userTotal <= 21 && compTotal == userTotal) {
			//when both player's totals are equal to or under 21, and equal
			JOptionPane.showMessageDialog( null, "We tied!" );
		} else if(userTotal > 21 && compTotal > 21 ) {
			//when both player's totals are over 21
			JOptionPane.showMessageDialog( null, "Boo :( We both lose!" );
		}

	}

}
