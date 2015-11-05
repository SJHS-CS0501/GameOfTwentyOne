/**
 * This program runs a horribly twisted variant of fake blackjack. With dice! Gambling!
 * @author Ryan Luchs 
 * 
 */

import java.util.Scanner;

/**
 * GameOfTwentyOne main class
 * @author Ryan Luchs
 *
 */
public class GameOfTwentyOne {

	/**
	 * GameOfTwentyOne main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		int playerScore = 0;
		int houseScore = 0;
		
		// String used to check if player will continue
		String con;
		
		int roll1 = 0;
		int roll2 = 0;
		
		// Scanner for reading keyboard input
		Scanner keyboard = new Scanner(System.in);
		
		// Die for getting random numbers
		Die rollMe = new Die(6);
		
		System.out.println("Welcome to Dice!Blackjack.\nGet the highest score under 21.\n...\n\n");
		
		/*
		 * This would be a lot simpler without using the 
		 * Die class as an unneeded fancy wrapper around the Random class
		 * 
		 * I could just do:
		 * houseScore = randObject.nextInt(6) + randObject.nextInt(6) + 1
		 * or
		 * houseScore = randObject.nextInt(12) + 1
		 */
		
		// Roll first time for house
		houseScore = rollMe.getValue();
		rollMe.roll();
		houseScore += rollMe.getValue();
		
		/*
		 * This pointless class being used to teach how to use classes is actually
		 * obstructing the programming process in this example.
		 */
		
		// Roll first time for player
		rollMe.roll();
		roll1 = rollMe.getValue();
		
		rollMe.roll();
		roll2 = rollMe.getValue();
		
		playerScore = roll1 + roll2;
		System.out.printf("You roll %d and %d.\nTotal: %d\n...\n\n", roll1, roll2, playerScore);
		
		// Ask player if they wish to roll again
		do {
			System.out.print("Enter y to roll again: ");
			con = keyboard.nextLine().toLowerCase();
			
			// Roll if player continues
			if (con.equals("y")){
				// Roll for house
				rollMe.roll();
				houseScore += rollMe.getValue();
				
				rollMe.roll();
				houseScore += rollMe.getValue();
				
				// Roll for player
				rollMe.roll();
				roll1 = rollMe.getValue();
				
				rollMe.roll();
				roll2 = rollMe.getValue();
				
				// Print player's score
				playerScore += roll1 + roll2;
				System.out.printf("You roll %d and %d.\nTotal: %d\n...\n\n", roll1, roll2, playerScore);
			}
			
			// If a player goes above 21, end the game
			if (playerScore > 21 || houseScore > 21){
				con = "n";
			}
						
		} while (con.equals("y"));
		
		// Print final scores
		System.out.printf("House: %d\nPlayer: %d\n\n", houseScore, playerScore);
		
		// Say who wins depending on win conditions
		if (playerScore > 21 && houseScore > 21) {
			System.out.println("Tie, you both lose.");
			System.out.println("House probably keeps your money though, that cheater!");
		} else if (playerScore > 21) {
			System.out.println("House wins.");
		} else if (houseScore > 21) {
			System.out.println("Player wins.");
		} else if (houseScore > playerScore) {
			System.out.println("House wins.");
		} else if (playerScore > houseScore) {
			System.out.println("Player wins.");
		} else {
			System.out.println("Tie, you both win.");
		}

	}

}
