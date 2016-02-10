/**
 * This program runs a horribly twisted variant of fake blackjack. With dice! Gambling! Now with pretty pictures!
 * @author Ryan Luchs 
 * 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * GameOfTwentyOneGUI main class
 * @author Ryan Luchs
 *
 */
public class GameOfTwentyOneGUI {
	
	static final char[] DICE_CHARS = {'⚀', '⚁', '⚂', '⚃', '⚄', '⚅'};

	static JLabel message;
	static JLabel scoreBox;
    static JButton rollButton;
    static JButton newGameButton;
    static GridBagLayout layout;
    
    static int playerScore = 0;
	static int houseScore = 0;
	
	static int roll1 = 0;
	static int roll2 = 0;
	
	static Die rollMe = new Die(6);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ActionListener listener = new MyListener();
		
		// Create a window for our app
        JFrame myFrame = new JFrame("Game of Twenty One");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layout = new GridBagLayout();
        myFrame.setLayout(layout);
        
        GridBagConstraints c = new GridBagConstraints();
        // general constraints
        c.fill = GridBagConstraints.BOTH;
        
        // label constraints
        c.weightx = 0.0;
        
        c.gridwidth = GridBagConstraints.RELATIVE;
        // OK, now let's add a label
        message = new JLabel("Welcome to Game of 21! Get the highest score <= 21!");
        message.setForeground(Color.BLACK);
        message.setFont(new Font("Segoe UI Symbol", Font.BOLD, 24));
        layout.setConstraints( message, c );
        myFrame.add(message);
        
        // button constraints
        c.gridwidth = GridBagConstraints.REMAINDER;
        // make button
        newGameButton = new JButton("End");
        newGameButton.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
        newGameButton.addActionListener(listener);
        layout.setConstraints( newGameButton, c);
        myFrame.add(newGameButton);
        
        c.gridwidth = GridBagConstraints.RELATIVE;
        // OK, now let's add a label
        scoreBox = new JLabel("[New Game]");
        scoreBox.setForeground(Color.BLACK);
        scoreBox.setFont(new Font("Segoe UI Symbol", Font.BOLD, 24));
        layout.setConstraints( scoreBox, c );
        myFrame.add(scoreBox);
        
        // text button add
        c.gridwidth = GridBagConstraints.REMAINDER;
        rollButton = new JButton("Roll");
        rollButton.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
        rollButton.addActionListener(listener);
        layout.setConstraints(rollButton, c);
        myFrame.add(rollButton);
        
        myFrame.pack();
        myFrame.setSize( myFrame.getPreferredSize() );
        myFrame.setVisible(true);

	}
	
	static void endGame() {
		scoreBox.setText("House: " + houseScore + " Player: " + playerScore);
		
		// FIX WIN CONDITIONS
		
		if (playerScore > 21 && houseScore > 21) {
			message.setText("Tie, you both lose.");
		} else if (playerScore > 21 || (houseScore > playerScore && houseScore < 21)) {
			message.setText("House wins.");
		} else if (houseScore > 21 || (playerScore > houseScore && playerScore < 21)) {
			message.setText("Player wins.");
		} else {
			message.setText("Tie, you both win.");
		}
		
//		// Say who wins depending on win conditions
//		if (playerScore > 21 && houseScore > 21) {
//			message.setText("Tie, you both lose.");
//			//System.out.println("House probably keeps your money though, that cheater!");
//		} else if (playerScore > 21) {
//			message.setText("House wins.");
//		} else if (houseScore > 21) {
//			System.out.println("Player wins.");
//		} else if (houseScore > playerScore) {
//			message.setText("House wins.");
//		} else if (playerScore > houseScore) {
//			message.setText("Player wins.");
//		} else {
//			message.setText("Tie, you both win.");
//		}
				
		playerScore = 0;
		houseScore = 0;
	}
	
	static class MyListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JButton eventSource = (JButton)e.getSource();
			
			if(eventSource.getText().equals("Roll")) {
				// Set Text
				message.setText("Welcome to Game of 21! Get the highest score <= 21!");
				
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
				
				scoreBox.setText("You roll " + DICE_CHARS[roll1 - 1] + " and " + DICE_CHARS[roll2 - 1] + ". Total: " + playerScore);
				
				if (playerScore > 21 || houseScore > 21){
					endGame();
				}
			} else {
				endGame();
			}
		}

	}

}
