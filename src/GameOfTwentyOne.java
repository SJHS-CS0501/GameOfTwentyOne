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
		Die roll = new Die(6);
		int userTotal = 0;
		int compTotal = 0;
		int result;
		
		
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
			
			result = JOptionPane.showConfirmDialog( null, "Do you want to roll again? Type 'Y' for yes, or 'N' for no." ,
												"roll?" , JOptionPane.YES_NO_OPTION);
			
		}
		while(result == JOptionPane.YES_OPTION);
		
		JOptionPane.showMessageDialog( null, "My total was " + compTotal + "!");
		
		if(compTotal > userTotal && compTotal <= 21) {
			JOptionPane.showMessageDialog( null, "I win!" );
		}
		
		if(userTotal > 21) {
			JOptionPane.showMessageDialog( null, "I win because you went over!" );
		}
		
		if(userTotal > compTotal && userTotal <= 21) {
			JOptionPane.showMessageDialog( null, "Yay! You win!" );
		}
		
		if(userTotal > 21 && compTotal > 21) {
			JOptionPane.showMessageDialog( null, "Boo :( We both lose!" );
		}

	}

}
