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
		
		do { DieOne.roll();
			total += DieOne.getValue();
		
			DieTwo.roll();
			total += DieTwo.getValue();
		
			DieOne.roll();
			computer += DieOne.getValue();
		
			DieTwo.roll();
			computer += DieTwo.getValue();
		
			System.out.print( "You're total is " + total +".\nWould you like to roll the dice again? (Enter y for yes and n for no)" );
			cont = keyboard.nextLine();
		
		} while(cont.equalsIgnoreCase( "y" ) && total <= 21 );
		
		System.out.println( "My total is " + computer + ". Yours is " + total + ".");
		
		if( total > computer && total <= 21 ){
			System.out.println( "You win!!" );
		} else if( computer > total && computer <= 21 ){
			System.out.println( "I WIN!! Not like I cheated or anything.." );
		} else if( total == computer && total <= 21 ){
			System.out.println( "We tied!" );
		} else if( total > 21 && computer <= 21 ){
			System.out.println( "You went over 21! I win:P" );
		} else if( computer > 21 && total <= 21 ){
			System.out.println( "I went over 21! I guess you win." );
		}
		
	}
	
}
