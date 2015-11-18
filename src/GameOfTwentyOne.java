import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Jack Protivnak
 *
 */
public class GameOfTwentyOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println( "Yo fam, let's play a game... BLACKJACK" );
		response();
		
		
		
		
		
		
		
	}

	public static void response() {
		String userInput = null;
		int userTotal = 0;
		int compTotal = 0;
		String yes = "y";
		Die dieRoll1 = new Die(6);
		Die dieRoll2 = new Die(6);
		Scanner keyboard = new Scanner(System.in);
		
		
		do {
			if (userTotal <= 21) {
				System.out.println( "Please enter 'y' if you'd like to roll the dice or -1 to exit: " );
				userInput = keyboard.nextLine();
				if (userInput.matches("^[Yy]$") ) {
					dieRoll1.roll();
					dieRoll2.roll();
					compTotal += dieRoll2.getValue() + dieRoll1.getValue();
					dieRoll1.roll();
					dieRoll2.roll();
					userTotal += dieRoll1.getValue();
					System.out.
					if (userTotal > 21) {
						break;
					}
				}
				} else if (userInput.matches("^-1$") ) {
					break;
				} else {
					System.out.println( "Invalid character entered. Please try again." );
				}
		} while( userInput.equalsIgnoreCase(yes));
		
		if (userTotal > 21 && compTotal > 21) {
			System.out.println( "Everyone LOOSES!!!\nComputer Total: " + compTotal + "\nYour total: " + userTotal );
			System.exit(0);
		} else if ( userTotal <= 21 && userTotal > compTotal) {
			System.out.println( "You win!\nComputer Total: " + compTotal + "\nYour total: " + userTotal);
			System.exit(0);
		} else if ( compTotal <= 21 && compTotal > userTotal ) {
			System.out.println( "COMPUTER WINS!!!!!!! YOU LOOSE\nComputer Total: " + compTotal + "\nYour total: " + userTotal);
			System.exit(0);
		} else if ( compTotal == userTotal ) {
			System.out.println( "You savage... you got the same total as the computer.\nComputer Total: " + compTotal + "\nYour total: " + userTotal);
			System.exit(0);
		} else {
			System.out.println( "Your total is: " + userTotal );
		}
		
	
	}
	
	
}
