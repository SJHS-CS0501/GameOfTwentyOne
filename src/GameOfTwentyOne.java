import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Ryan Smith
 *
 */
public class GameOfTwentyOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);//This allows user to type information
		Die d1 = new Die( 6 );//Creating object d1
		Die d2 = new Die( 6 );//Creating object d2
		char decision;//Declaring character decision
		int dieRoll = 0;//Declaring integer dieRoll
		int computerDieRoll = 0;//Declaring integer computerDieRoll
		
		System.out.println("Welcome to a game of 21! You will be playing against the computer in a dice game.");
		
		do{//do...while loop
			System.out.println("Would you like to roll the dice? (y to keep playing, anything else to quit)");
			decision = keyboard.nextLine().toLowerCase().charAt(0);
			if( decision != 'y') {
				break;
			}
			d1.roll();
			d2.roll();
			computerDieRoll += d1.getDieValue();
			dieRoll += d2.getDieValue();
			d1.roll();
			d2.roll();
			computerDieRoll += d1.getDieValue();
			dieRoll += d2.getDieValue();
			System.out.println("Your current score is: " + dieRoll);
			
			//if statements
			if( dieRoll == 21 && computerDieRoll != 21 ) {
				System.out.println("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll );
				System.exit(0);
			}
			if( dieRoll != 21 && computerDieRoll != 21 ) {
				System.out.println("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll);
				System.exit(0);
			}
			if( dieRoll == 21 && computerDieRoll == 21 ) {
				System.out.println("Good game! It was a draw.  You both had: " + dieRoll);
				System.exit(0);
			}
			if( dieRoll < 21 && computerDieRoll > 21 ) {
				System.out.println("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll );
				System.exit(0);
			}
			if( dieRoll > 21 && computerDieRoll < 21 ) {
				System.out.println("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll);
				System.exit(0);
			}
			
			if( dieRoll > 21 && computerDieRoll > 21 && dieRoll > computerDieRoll ) {
				System.out.println("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll);
				System.exit(0);
			}
			if( dieRoll > 21 && computerDieRoll > 21 && computerDieRoll > dieRoll ) {
				System.out.println("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll);
				System.exit(0);
			}
			if( dieRoll > 21 && computerDieRoll > 21 && computerDieRoll == dieRoll ) {
				System.out.println("Good game! It was a draw.  You both had: " + dieRoll);
				System.exit(0);
			}
		} while( dieRoll < 21 && computerDieRoll < 21);
		
		if( dieRoll == 21 && computerDieRoll != 21 ) {
			System.out.println("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll );
			System.exit(0);
		}
		if( dieRoll != 21 && computerDieRoll != 21 ) {
			System.out.println("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll);
			System.exit(0);
		}
		if( dieRoll == 21 && computerDieRoll == 21 ) {
			System.out.println("Good game! It was a draw.  You both had: " + dieRoll);
			System.exit(0);
		}
		if( dieRoll < 21 && computerDieRoll > 21 ) {
			System.out.println("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll );
			System.exit(0);
		}
		
		if( dieRoll > 21 && computerDieRoll < 21 ) {
			System.out.println("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll);
			System.exit(0);
		}
		if( dieRoll > 21 && computerDieRoll > 21 && dieRoll > computerDieRoll ) {
			System.out.println("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll);
			System.exit(0);
		}
		if( dieRoll > 21 && computerDieRoll > 21 && computerDieRoll > dieRoll ) {
			System.out.println("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll);
			System.exit(0);
		}
		if( dieRoll < computerDieRoll && computerDieRoll < 21 ) {
			System.out.println("Better luck next time! The computer had: " + computerDieRoll + " You had: " + dieRoll);
			System.exit(0);
		}
		if( computerDieRoll < dieRoll && dieRoll < 21 ) {
			System.out.println("YOU WIN!!!!!!! The computer had: " + computerDieRoll + " You had: " + dieRoll );
			System.exit(0);
		}

	}
	
	/**
	 * Constructor (performs initial roll)
	 * @author Ryan Smith
	 *
	 */
	public static class Die {
		private int dieFaces;
		private int dieValue;
		
		/**
		 * @param numDieFaces
		 */
		public Die(int numDieFaces ) {
			dieFaces = numDieFaces;
			roll();
		}
		
		public void roll() {
			Random random = new Random();
			
			dieValue = random.nextInt(dieFaces) + 1;
		}
		
		public int getDieFaces() {
			return dieFaces;
		}
		
		public int getDieValue() {
			return dieValue;
		}
	}

}

