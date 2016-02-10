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
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;





/**
 * 
 */

/**
 * @author SJHSStudent
 *
 */

public class GameofTwentyOneGui {

	 	static JLabel myLabel;
	    static JButton myButton;
	    static JButton myButton2;
	    static JTextField myTextField;
	    static JButton textFieldUpdate;
	    static GridBagLayout layout;
	    static int drollcomp = 0; // variable for the computers score
		static int droll = 0; // variable for the users score
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Create a window for our app
        JFrame myFrame = new JFrame("Example 11.1");
        // Set it to quit the app when we close the window
        // NOTE that this is the default behavior--we could omit this here
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // make it visible (important!)
        myFrame.setVisible( true );
        //myFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        //myFrame.setLayout( new GridLayout( 2, 2, 50, 10 ) );
        layout = new GridBagLayout();
        myFrame.setLayout( layout );
        
        GridBagConstraints c = new GridBagConstraints();
        // general constraints
        c.fill = GridBagConstraints.BOTH;
        
        // label constraints
        c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.RELATIVE;
        // OK, now let's add a label
        myLabel = new JLabel("Welcome to twenty-one with dice! ");
        // let's set some properties
        // NOTE: These properties (font and color) come from AWT!!!!
        myLabel.setForeground(Color.BLUE);
        myLabel.setFont(new Font("TimesRoman", Font.BOLD, 24));
        layout.setConstraints( myLabel, c );
        // Now add it to the frame (ALSO IMPORTANT!!!!!!!)
        myFrame.add(myLabel);

        // button constraints
        c.gridwidth = GridBagConstraints.REMAINDER;
        // make button
        myButton = new JButton("Press to roll the dice");
        myButton2 = new JButton("Press to stop" );
        myButton.setFont(new Font("TimesRoman", Font.ITALIC, 12));
        myButton2.setFont(new Font("TimesRoman", Font.ITALIC, 12));

        ActionListener listener = new MyActionListener();
        myButton.addActionListener(listener);
        myButton2.addActionListener(listener);
        layout.setConstraints( myButton, c);
        myFrame.add(myButton);

        // text field setup
        // text field constraints
        c.gridwidth = GridBagConstraints.RELATIVE;
        myTextField = new JTextField(  );
        layout.setConstraints(myTextField, c);
        myFrame.add( myTextField );
        
        // text button add
        c.gridwidth = GridBagConstraints.REMAINDER;
        textFieldUpdate = new JButton("Update Label");
        textFieldUpdate.addActionListener(listener);
        layout.setConstraints(textFieldUpdate, c);
        myFrame.add( textFieldUpdate );
        
        
        myFrame.pack();
        myFrame.setSize( myFrame.getPreferredSize() );
        // Our size will be wrong, so let's fix it
        //myFrame.setSize(600, 200);
        // alternate: use pack
        //myFrame.pack();

        myFrame.setVisible(true);

   

				Scanner keyboard = new Scanner(System.in); // creates scanner object
				Random rnd = new Random(); // creates random object
				DieJava die  = new DieJava( 6 ); // creates a new variable die of the die java class
				DieJava die2 = new DieJava( 6 ); // creates a new variable die2 of the die java class
				char userInput; // variable for user input
			
				
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

			
		

	 
	 class MyActionListener implements ActionListener {
     
	        
	        public void actionPerformed(ActionEvent e) {
	            //JButton eventSource = (JButton) e.getSource();
	            //eventSource.setForeground(theColors[index++]);
	            JButton eventSource = (JButton)e.getSource();
	            if( eventSource.getText().equals("Roll Dice") ) {
	            	
	            } else {
	                if( droll < drollcomp ){
	                	System.out.println("Congratulations! You win!" );
	                
	          }
	            }
	        }
	    
	}
}
