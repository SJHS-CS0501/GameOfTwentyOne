import java.util.Scanner;

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

	/**
	 * This is the main class for GameOfTwentyOne program.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		Dice DieOne = new Dice(6);
		Dice DieTwo = new Dice(6);
		String cont;
		int total = 0;
		int computer = 0;
		
		System.out.println( "Let's play a Game of 21!\nIt's like blackjack but with simulated dice!" );

		// put a loop thing in here
		
		DieOne.roll();
		total += DieOne.getValue();
		
		DieTwo.roll();
		total += DieTwo.getValue();
		
		System.out.print( "You're total is " + total + ". Would you like to roll the dice again?\n(Enter y for yes and n for no)" );
		cont = keyboard.nextLine();
		
		if( cont.equalsIgnoreCase( "y" )) {
			DieOne.roll();
			total += DieOne.getValue();
			
			DieTwo.roll();
			total += DieTwo.getValue();
			
			System.out.println( "Your new total is " + total + "." );
		} else if( cont.equalsIgnoreCase( "n" )) {
			System.out.print( "You're total is still " + total + "." );
		}
		
		

		
		
	}
	
}
