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
	 * @param args main arguments for the GameOfTwentyOne class
	 */
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		Dice DieOne = new Dice(6); // first roll
		Dice DieTwo = new Dice(6); // second roll
		String cont; // holds user's answer for continuing
		int total = 0; // user's total
		int computer = 0; // computer's total
		
		System.out.println( "Let's play a Game of 21!\nIt's like blackjack but with simulated dice!" );
		
		// user can choose to roll the dice until their score is over 21
		do { DieOne.roll();
			total += DieOne.getValue();
		
			DieTwo.roll();
			total += DieTwo.getValue(); // dice rolls for user
		
			DieOne.roll();
			computer += DieOne.getValue();
		
			DieTwo.roll();
			computer += DieTwo.getValue(); // secret dice rolls for computer
			
			// telling people their score
			System.out.print( "You're total is " + total +".\nWould you like to roll the dice again? (Enter y for yes and n for no)" );
			cont = keyboard.nextLine();
		
		} while(cont.equalsIgnoreCase( "y" ) && total <= 21 ); // will not let the user continue rolling even if they hit y
		
		System.out.println( "My total is " + computer + ". Yours is " + total + ".");// secret computer score revealed
		
		if( total > computer && total <= 21 ){
			System.out.println( "You win!!" ); // user winning when neither player goes over 21
			
		} else if( computer > total && computer <= 21 ){
			System.out.println( "I WIN!! Not like I cheated or anything.." ); // computer winning when neither player goes over 21
		
		} else if( total == computer && total <= 21 ){
			System.out.println( "We tied!" ); // Players tie, no one wins
		
		} else if( total > 21 && computer <= 21 ){
			System.out.println( "You went over 21! I win:P" ); // User goes over 21, computer automatically wins
		
		} else if( computer > 21 && total <= 21 ){
			System.out.println( "I went over 21! I guess you win." ); // user wins when computer goes over 21
		} else if( computer > 21 && total > 21 ){
			System.out.println( "We both lose!" ); // everyone is sad
		}
		
	}
	
}
