import java.util.Scanner;

/**
 * @author Ryley
 *
 */
public class GameOfTwentyOne {

	/**
	 * @param args
	 * Main method for game of 21
	 * Computer and player scores are compared to find a winner 
	 */
//	public static void main(String[] args) {
		// TODO Auto-generated method stub

	public GameOfTwentyOne() {
		
		int playerScore = 0;
		int playDie1 = 0;
		int playDie2 = 0;
		int playerTotal = 0;
		int comScore = 0;
		int comTotal = 0;
		int comDie1 = 0;
		int comDie2 = 0;
		char choice;
		
		Scanner key = new Scanner(System.in);// create new scanner object
		
		Die roll = new Die(6);// create new die
		//Die comRoll = new Die(6);// create new die
		
		// The main game takes place in this loop
		
		do{
			
			System.out.println("Do you want to hit \n'y' (for yes) \n'n' (for no)");
			choice = key.next().charAt(0);
			
			roll.roll();
			comDie1 = roll.getValue();// uses Die class method
			roll.roll();
			comDie2 = roll.getValue();
			comScore = comDie1 + comDie2;
			comTotal = comTotal + comScore;
			
			// code is run every time the the user types y
			if(choice == 'y')
			{
			
				roll.roll();
				playDie1 = roll.getValue();// uses Die class method
				roll.roll();
				playDie2 = roll.getValue();
				playerScore = playDie1 + playDie2;
				playerTotal = playerTotal + playerScore;
				
			} else if (choice == 'n'){
				
				System.out.println("\nYou have " + playerTotal + " while the dealer has " + comTotal);
				
				
				if(playerTotal == comTotal){
					System.out.println("its a Draw");

					System.exit(0);// end program
				}
				
				else if(playerTotal < comTotal && (comTotal <= 21))
				{
					System.out.println("\nThe dealer won this game. You could have hit one more time.");
					
					System.exit(0);// end program
					
					// runs if the user doesn't type y or n, so don't be a cheater
				} else {
					
					System.out.println("\nYou win!");
					
					System.exit(0);// end program
				}
				
				if(comTotal < playerTotal && (playerTotal <= 21 )){
					
					System.out.println("\nYou win!");
					
					System.exit(0);// end program
					
				} else {
					
					System.out.println("\nThe dealer won this game. You exceded 21");
					
					System.exit(0);// end program
				}
			
				//code runs if player chooses not to hit
			}else if(choice != 'n' || choice != 'y'){
						System.out.println("\ninvalid input! You are a cheater!!! \nGAME OVER");
						
						System.exit(0);// end program
					}
			
			System.out.println("\nYou have " + playerTotal);
		}
			while(playerTotal <= 21 && comTotal <= 21);
		
		
			
		
		
		// runs code if the computer or player goes over 21 
		System.out.println("\nYou have " + playerTotal + " while the dealer has " + comTotal);
		
		if(playerTotal > 21 && comTotal <=21)
		{
			System.out.println("The dealer won this game. You exceded 21.");
			
			System.exit(0);// end program
		}
		
		else if( playerTotal <= 21 && comTotal > 21)
		{
			System.out.println("You win!");
			
			System.exit(0);// end program
		} 
		
		else if( playerTotal < comTotal && comTotal > 21 && playerTotal > 21) {
			System.out.println("You win by having the lower number over 21");
			
			System.exit(0);// end program
		}
		
		else if(playerTotal >  comTotal && comTotal > 21 && playerTotal > 21) {
			System.out.println("You loose. You were the furthest over 21");
			
			System.exit(0);// end program
		}
		
		else if(playerTotal == comTotal && comTotal > 21 && playerTotal > 21) {
			System.out.println("It's a DRAW!");
			
			System.exit(0);// end program
		}
	}
		
}



