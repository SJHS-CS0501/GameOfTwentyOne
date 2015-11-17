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
		Scanner keyboard = new Scanner(System.in);
		Die dieRoll1 = new Die(6);
		Die dieRoll2 = new Die(6);
		String dog = "y";
		dieRoll1.roll();
		userTotal += dieRoll1.getValue();
		dieRoll1.roll();
		userTotal += dieRoll1.getValue();
		
		System.out.println( "Please enter 'y' if you'd like to roll the dice or -1 to exit: " );
		userInput = keyboard.nextLine();
		
		do {
			System.out.println( "Please enter 'y' if you'd like to roll the dice or -1 to exit: " );
			userInput = keyboard.nextLine();
			
			if (userInput.matches("^[Yy]$") ) {
				System.out.println( "Your total is: " + userTotal );
			} else if (userInput.matches("^-1$") ) {
				System.out.println( "Your total is: " + userTotal + "\n Thank you for playing!" );
			} else {
				System.out.println( "Invalid character entered. Please try again." );
			}
		} while( userInput.equalsIgnoreCase(dog))
		
		
	
	}
	
	
}
