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
		Die firstRoll = new Die(6);
		Die secondRoll = new Die(6);
		String answer;
		int userTotal;
		int compTotal;
		int valueU;
		int valueC;
		
		JOptionPane.showMessageDialog( null, "Let's play a game of blackjack--with dice!\nI just rolled, your turn!" );
		
		valueU = new Die();
		valueC = new Die(numSides);
		
		do {
			userTotal += valueU;
			compTotal += valueC;
			System.out.print( "Do you want to roll again? Type 'Y' for yes, or 'N' for no." );
			answer = keyboard.nextLine();
		}
		while(answer.equalsIgnoreCase( "y" ));
		
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
