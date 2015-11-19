import java.util.Random;// needed for Random object
import java.util.Scanner; // needed for Scanner object

/**
 * 
 */

/**
 * @author David Herr
 * This program is game of twenty one played against the computer
 */
public class GameOfTwentyOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in); // creates scanner object
		Random rnd = new Random(); // creates random object
		DieJava die  = new DieJava( 6 ); // creates a new variable die of the die java class
		DieJava die2 = new DieJava( 6 ); // creates a new variable die2 of the die java class
		char userInput; // variable for user input
		int drollcomp = 0; // variable for the computers score
		int droll = 0; // variable for the users score
		
		System.out.println( "Welcome to twenty-one with dice! " );
		
		do{ 
			System.out.print( "Press 'y' if you want to roll dice, press anything else if you want to quit." ); //asks user if they want to quit or play another round
			userInput = keyboard.nextLine().toLowerCase().charAt(0); // takes whatever the user inputed for user input, puts it in lower case, and only accepts the first character
			if( userInput != 'y'){ // if user inputed anything other than y, the program jumps out of the loop
				break; 
			}
			die.roll(); // rolls die for computer
			die2.roll(); // rolls die for user
			drollcomp += die.getValue(); // sets value of computers score to die roll
			droll += die2.getValue(); // sets value of users score equal to die roll
			die.roll();// rolls die for computer
			die2.roll();// rolls die for user
			drollcomp += die.getValue();// sets value of computers score to die roll
			droll += die2.getValue();// sets value of users score equal to die roll
			System.out.println( "Your current score is: " + droll ); // tells user their score
			
			// All if loops below in this do while loop, determine who wins the game using various cases
			if( droll == 21 ){ 
				System.out.println( " Congratulations! You Win! " + " The computer had : " + drollcomp + " Your score is: " + droll );
				System.exit(0);
			}
			if( drollcomp == 21){
				System.out.println( " Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll  );
				System.exit(0);
			}
			if( drollcomp == 21 && droll == 21 ){
				System.out.println( " Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll  );
				System.exit(0);
			}
			if( droll > 21 && drollcomp > 21 && droll < drollcomp ){
				System.out.println( " Congratulations! You Win! " + " The computer had : " + drollcomp + " Your score is: " + droll  );
				System.exit(0);
			}
			if( droll > 21 && drollcomp > 21 && droll > drollcomp ){
				System.out.println( " Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll  );
				System.exit(0);
			}
			if(droll == 21 && drollcomp == 21){
				System.out.println(  " Both scores are 21, it's a draw! " );
				System.exit(0);
			}
		}while( droll < 21 && drollcomp < 21 );
			
		// All if loops below to the beginning of the DieJava class also determine who wins
		if( droll > 21 && drollcomp < 21 ){
			System.out.println( " Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll  );
			System.exit(0);
		}
		if( drollcomp > 21 && droll < 21 ){
			System.out.println( " Congratulations! You Win! " + " The computer had : " + drollcomp + " Your score is: " + droll  );
		System.exit(0);
		}
		if( droll > 21 && drollcomp > 21 && droll < drollcomp ){
			System.out.println( " Congratulations! You Win! " + " The computer had : " + drollcomp + " Your score is: " + droll  );
			System.exit(0);
		}
		if( droll > 21 && drollcomp > 21 && drollcomp > droll ){
			System.out.println( " Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll  );
			System.exit(0);
		}
		if( droll > drollcomp && droll < 21){
			System.out.println( " Congratulations! You Win! " + " The computer had : " + drollcomp + " Your score is: " + droll  );
			System.exit(0);
		}
		if( droll < drollcomp && droll < 21){
			System.out.println( " Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll  );
			System.exit(0);
		}
		if( droll < 21 && drollcomp > 21 ){
			System.out.println( " Congratulations! You Win! " + " The computer had : " + drollcomp + " Your score is: " + droll  );
			System.exit(0);
		}
		if( droll > 21 && drollcomp > 21 && droll == drollcomp ){
			System.out.println(  " Both scores are " + droll + " it's a draw! " );
			System.exit(0);
		}
	}	
	
	public static class DieJava {
		private int sides; // Number of sides
		private int value; //The die's value
		
		/**
		 * The constructor performs an initial roll of the die.
		 * @param numSides The number of sides for this die
		 */
		public DieJava( int numSides ){
			sides = numSides;
			roll();
		}
		
		/**
		 * The roll method simulates the rolling of the die
		 */
		
		public void roll(){
			Random rnd = new Random(); // creates random object
			
			// Get a random value for the die
			value = rnd.nextInt( sides ) + 1;
		}
		
		/**
		 * getSides method
		 * @return The number of sides for for this dice
		 */
		
		public int getSides(){
			return sides;
		}
		
		/**
		 * getValue method
		 * @return The value of the die
		 */
		
		public int getValue(){
			return value;			
		}
}

	
}
