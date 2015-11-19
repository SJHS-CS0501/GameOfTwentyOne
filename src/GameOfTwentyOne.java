import java.util.Random;
import java.util.Scanner;
/**
 * @author Jack Protivnak
 */
public class GameOfTwentyOne {
	/**
	 * This program is designed to simulate a game of BlackJack
	 * using dice instead of cards. The user will be paired against
	 * the computer and will have the option of rolling until they tell
	 * the program to stop. It will then compare the scores and share
	 * the results.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( "Yo fam, let's play a game of... BLACKJACK" ); // Introduction
		response(); // Method 'response'
	}
	/**
	 * This method will not return anything, but will allow the user
	 * to roll the dice in the game and will give them options based on 
	 * their current score in the game. It will then present their score 
	 * compared to the computer's score and will then tell them
	 * if they win or not.
	 */
	public static void response() {
		String userInput = null; // Object for user's input
		int userTotal = 0; // Declaring variable userTotal
		int compTotal = 0; // Declaring variable compTotal
		Die dieRoll1 = new Die(6); // Creating new object for Die Class
		Die dieRoll2 = new Die(6); // Creating new object for die Class
		Scanner keyboard = new Scanner(System.in); // Notifying the system that the keyboard will be used as input
		
		// A while loop to determine the next step for the user.
		// If their score is below 21, they will have the option of
		// rolling again or exiting and get the results.
		while (true) {
			if (userTotal < 21) {
				System.out.println( "Please enter 'y' if you'd like to roll the dice or -1 to exit: " );
				userInput = keyboard.nextLine();
				if (userInput.matches("^[Yy]{1}$") ) {
					dieRoll1.roll();
					dieRoll2.roll();
					compTotal += dieRoll2.getValue() + dieRoll1.getValue();
					dieRoll1.roll();
					dieRoll2.roll();
					userTotal += dieRoll1.getValue() + dieRoll2.getValue();
					System.out.println( "Your total is: " + userTotal );
					if (userTotal >= 21 || compTotal >= 21) {
						break;
					}
				} else if (userInput.matches("^-1$") ) {
					break;
				} else {
					System.out.println( "Invalid character entered. Please try again." );
				}
			}
		}
		// A set of if and else if statements to determine the outcome
		// of the game and will then tell the user the results based on 
		// their score and the computer's score.
		if (userTotal > 21 && compTotal > 21) {
			System.out.println( "\nEveryone LOOSES!!!\nComputer Total: " + compTotal + "\nYour total: " + userTotal );
			System.exit(0);
		} else if ( userTotal <= 21 && userTotal > compTotal) {
			System.out.println( "\nYou win!\nComputer Total: " + compTotal + "\nYour total: " + userTotal);
			System.exit(0);
		} else if ( compTotal <= 21 && compTotal > userTotal ) {
			System.out.println( "\nCOMPUTER WINS!!!!!!! YOU LOOSE\nComputer Total: " + compTotal + "\nYour total: " + userTotal);
			System.exit(0);
		} else if ( compTotal == userTotal ) {
			System.out.println( "\nYou savage... you got the same total as the computer.\nComputer Total: " + compTotal + "\nYour total: " + userTotal);
			System.exit(0);
		} else if ( userTotal == 21 && compTotal > 21 ) {
			System.out.println( "\nBro... You beat the comptuer.\nComputer Total: " + compTotal + "\nYour total: " + userTotal);
		} else if ( userTotal > 21 && compTotal <= 21) {
			System.out.println( "\nSo... you loose and the computer WINS!!!\nComputer Total: " + compTotal + "\nYour total: " + userTotal);
		} else if ( userTotal <= 21 && compTotal > 21) {
			System.out.println( "\nYou win!\nComputer Total: " + compTotal + "\nYour total: " + userTotal);
		}
		else {
			System.out.println( "Your total is: " + userTotal + "\nComputer Total: " + compTotal );
		}
	}
}