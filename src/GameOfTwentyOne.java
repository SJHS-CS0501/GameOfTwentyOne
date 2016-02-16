import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This program will allow a user to play a variation of the popular blackjack card game with the computer.
 * @author woytek
 * @author Julianna Nichols
 */
public class GameOfTwentyOne {
	
	static JLabel label;
<<<<<<< HEAD
<<<<<<< HEAD
	static ImageIcon firstDie;
	static ImageIcon secondDie;
	static JLabel die;
    static JButton roll;
    static JButton no;
    static GridBagLayout layout = new GridBagLayout();
    static JFrame frame = new JFrame("Game of Twenty-One"); //new JFrame
    static int userTotal = 0; //user's total
	static int compTotal = 0; //computer's total
	static Die rollDie = new Die(6); //creating new Die object
	static GridBagConstraints c = new GridBagConstraints();
	ImageIcon dieIcon = new ImageIcon();
=======
=======
>>>>>>> parent of 03eb231... YES
    static JButton button;
    static JTextField textField;
    static GridBagLayout layout;
    static JFrame frame = new JFrame("Game of Twenty-One"); //new JFrame; 
<<<<<<< HEAD
>>>>>>> parent of 03eb231... YES
=======
>>>>>>> parent of 03eb231... YES

	/**
	 * This is the main method for the GameOfTwentyOne program.
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		int userTotal = 0; //tally of user's total
		int compTotal = 0; //tally of computer's total
		
		ActionListener listener = new RollAgainListener();
		layout = new GridBagLayout();
	
		//JFrame frame = new JFrame("Game of Twenty-One"); //new JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< HEAD
		
		frame.setLayout( layout );
		
=======
		
		frame.setLayout( layout );
		
>>>>>>> parent of 03eb231... YES
		GridBagConstraints c = new GridBagConstraints();
	    
	    frame.setVisible(true);
		
	    textField = new JTextField("Let's play a game of blackjack--with dice! I just rolled, your turn!");
	    textField.setForeground(Color.BLUE);
	    textField.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        c.fill = GridBagConstraints.BOTH; //what to do when the component's display area is larger than the component's requested size
        c.weightx = 0.2; //resizing behavior (column)
		c.weighty = 0.2; //resizing behavior (row)
		c.gridx = 0; //second column
		c.gridy = 0; //first row
		c.gridwidth = 3;
        frame.add(textField, c);

        //c.gridwidth = GridBagConstraints.REMAINDER;
        
        //making roll button
        button = new JButton("Roll");
        //setting the font and font size of roll button
        button.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        c.fill = GridBagConstraints.BOTH; //what to do when the component's display area is larger than the component's requested size
        c.weightx = 0.2; //resizing behavior (column)
		c.weighty = 0.2; //resizing behavior (row)
		c.gridx = 2; //roll button in 
		c.gridy = 1;
		c.gridwidth = 1;
        frame.add(button, c);
        
        button.addActionListener(listener);
        
        
		for( int i = 1; i < 2; i-- ) {
			
			// making no button
			button = new JButton("No");
			// setting the font and font size of no button
			button.setFont(new Font("TimesRoman", Font.PLAIN, 12));
			// what to do when the component's display area is larger than the component's requested size
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.2; // resizing behavior (column)
			c.weighty = 0.2; // resizing behavior (row)
			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 1;
			frame.add(button, c);
			button.addActionListener(listener);
			
			if(button.getText().equals("No")) {
				i = 2;
			}
			
		}

        /*
        label = new JLabel("My total was " + compTotal + "!");
		label.setForeground(Color.BLACK);
		layout.setConstraints( label, c);
        
		//when both player's totals are under 21, but computer's total is closer to 21
		if(compTotal > userTotal && compTotal <= 21) {
			label = new JLabel("I win!");
			label.setForeground(Color.BLACK);
			layout.setConstraints( label, c);
		}
		
		//when user's total is over 21, but computer's total is under 21
		if(userTotal > 21 && compTotal <= 21) {			
			label = new JLabel("I win because you went over!");
			label.setForeground(Color.BLACK);
			layout.setConstraints( label, c);
		}
		
		//when both player's totals are under 21, but user's total is closer to 21
		if(userTotal > compTotal && userTotal <= 21) {
			label = new JLabel("Yay! You win!");
			label.setForeground(Color.BLACK);
			layout.setConstraints( label, c);
		}
		
		//when computer's total is over 21, but user's total is under 21
		if(compTotal > 21 && userTotal <= 21) {
			label = new JLabel("You win because I went over!");
			label.setForeground(Color.BLACK);
			layout.setConstraints( label, c);
		}
		
		//when both player's totals are over 21
		if(userTotal > 21 && compTotal > 21) {
			label = new JLabel("Boo :( We both lose!");
			label.setForeground(Color.BLACK);
			layout.setConstraints( label, c);
		}
		
		*/
		
		frame.pack();
        frame.setSize( frame.getPreferredSize() );

	}
	
	static class RollAgainListener implements ActionListener {
		
		/**
		 * The actionPerformed method executes when the user clicks on the yes or no button in
		 * response to the question if they want to roll again
		 * @param e the event object
		 * @return 
		 */
		public void actionPerformed(ActionEvent e) {
			Die roll = new Die(6); //creating new Die object
			int userTotal = 0; //tally of user's total
			int compTotal = 0; //tally of computer's total
			GridBagConstraints c = new GridBagConstraints();
			ActionListener listener = new RollAgainListener();
			
<<<<<<< HEAD
<<<<<<< HEAD
			if (eventSource.getText().equals("Roll")) {
				label.setVisible(false);
				die.setVisible(false);
				
				rollDie.roll(); // first die for computer
				compTotal += rollDie.getValue();
				rollDie.roll(); // second die for computer
				compTotal += rollDie.getValue();

				rollDie.roll(); // first die for user
				userTotal += rollDie.getValue();
				
				switch (rollDie.getValue()) {
				case 1:
					firstDie = new ImageIcon("dice1.jpg");
					break;
				case 2:
					firstDie = new ImageIcon("dice2.jpg");
					break;
				case 3:
					firstDie = new ImageIcon("dice3.jpg");
					break;
				case 4:
					firstDie = new ImageIcon("dice4.jpg");
					break;
				case 5:
					firstDie = new ImageIcon("dice5.jpg");
					break;
				case 6:
					firstDie = new ImageIcon("dice6.jpg");
					break;
				}
				
				die = new JLabel(new ImageIcon( "dice1.jpg" ));
				frame.add(die);

				rollDie.roll(); // second die for user
				userTotal += rollDie.getValue();				
				
				switch (rollDie.getValue()) {
				case 1:
					secondDie = new ImageIcon("dice1.jpg");
					break;
				case 2:
					secondDie = new ImageIcon("dice2.jpg");
					break;
				case 3:
					secondDie = new ImageIcon("dice3.jpg");
					break;
				case 4:
					secondDie = new ImageIcon("dice4.jpg");
					break;
				case 5:
					secondDie = new ImageIcon("dice5.jpg");
					break;
				case 6:
					secondDie = new ImageIcon("dice6.jpg");
					break;
				}
				
				
				label.setIcon(secondDie);
				
			}
			
			if(eventSource.getText().equals("No")) {
				
				die.setVisible(false);
				label.setVisible(false);
				roll.setVisible(false);
				no.setVisible(false);
				
				label = new JLabel("My total was " + compTotal + "!");
				label.setForeground(Color.BLACK);
				label.setFont(new Font("TimesRoman", Font.PLAIN, 24));
				c.weightx = 0.2; // resizing behavior (column)
    			c.weighty = 0.2; // resizing behavior (row)
    			c.gridx = 0; //first column
    			c.gridy = 0; // first row
				layout.setConstraints( label, c);
				frame.add(label, c);
=======
			JButton eventSource = (JButton)e.getSource();
			if(eventSource.getText().equals("Roll")) {
        			roll.roll(); //first die
        			compTotal += roll.getValue();
        			roll.roll(); //second die
        			compTotal += roll.getValue();
        			
        			roll.roll(); //first die
        			userTotal += roll.getValue();
        			//what to do when the component's display area is larger than the component's requested size
        			c.fill = GridBagConstraints.BOTH;
        			c.gridx = 2;
        			c.gridy = 0;
        			c.weightx = 0.2; //resizing behavior (column)
        			c.weighty = 0.2; //resizing behavior (row)
        			c.gridwidth = 1;
        			textField.setText("You rolled an " + roll.getValue() + "!");
        			textField.setForeground(Color.BLACK);
        			frame.add(textField, c);
        			
        			roll.roll(); //second die
        			userTotal += roll.getValue();
        			//what to do when the component's display area is larger than the component's requested size
        			c.fill = GridBagConstraints.BOTH;
        			c.gridx = 2;
        			c.gridy = 0;
        			c.weightx = 0.2; //resizing behavior (column)
        			c.weighty = 0.2; //resizing behavior (row)
        			c.gridwidth = 1;
        			textField.setText("You rolled an " + roll.getValue() + "!");
        			textField.setForeground(Color.BLACK);
        			frame.add(textField, c);
        			
        			textField = new JTextField("Do you want to roll again?");
        			textField.setForeground(Color.BLACK);
        			textField.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        			// what to do when the component's display area is larger than the component's requested size
        			c.fill = GridBagConstraints.BOTH;
        			c.weightx = 0.2; // resizing behavior (column)
        			c.weighty = 0.2; // resizing behavior (row)
        			c.gridx = 1;
        			c.gridy = 1; // first row
        			frame.add(textField, c);
			}
			
			if(eventSource.getText().equals("No")) {
				textField = new JTextField("My total was " + compTotal + "!");
				textField.setForeground(Color.BLACK);
				layout.setConstraints( textField, c);
>>>>>>> parent of 03eb231... YES
=======
			JButton eventSource = (JButton)e.getSource();
			if(eventSource.getText().equals("Roll")) {
        			roll.roll(); //first die
        			compTotal += roll.getValue();
        			roll.roll(); //second die
        			compTotal += roll.getValue();
        			
        			roll.roll(); //first die
        			userTotal += roll.getValue();
        			//what to do when the component's display area is larger than the component's requested size
        			c.fill = GridBagConstraints.BOTH;
        			c.gridx = 2;
        			c.gridy = 0;
        			c.weightx = 0.2; //resizing behavior (column)
        			c.weighty = 0.2; //resizing behavior (row)
        			c.gridwidth = 1;
        			textField.setText("You rolled an " + roll.getValue() + "!");
        			textField.setForeground(Color.BLACK);
        			frame.add(textField, c);
        			
        			roll.roll(); //second die
        			userTotal += roll.getValue();
        			//what to do when the component's display area is larger than the component's requested size
        			c.fill = GridBagConstraints.BOTH;
        			c.gridx = 2;
        			c.gridy = 0;
        			c.weightx = 0.2; //resizing behavior (column)
        			c.weighty = 0.2; //resizing behavior (row)
        			c.gridwidth = 1;
        			textField.setText("You rolled an " + roll.getValue() + "!");
        			textField.setForeground(Color.BLACK);
        			frame.add(textField, c);
        			
        			textField = new JTextField("Do you want to roll again?");
        			textField.setForeground(Color.BLACK);
        			textField.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        			// what to do when the component's display area is larger than the component's requested size
        			c.fill = GridBagConstraints.BOTH;
        			c.weightx = 0.2; // resizing behavior (column)
        			c.weighty = 0.2; // resizing behavior (row)
        			c.gridx = 1;
        			c.gridy = 1; // first row
        			frame.add(textField, c);
			}
			
			if(eventSource.getText().equals("No")) {
				textField = new JTextField("My total was " + compTotal + "!");
				textField.setForeground(Color.BLACK);
				layout.setConstraints( textField, c);
>>>>>>> parent of 03eb231... YES
		        
				//when both player's totals are under 21, but computer's total is closer to 21
				if(compTotal > userTotal && compTotal <= 21) {
					textField = new JTextField("I win!");
					textField.setForeground(Color.BLACK);
					layout.setConstraints( textField, c);
				}
				
				//when user's total is over 21, but computer's total is under 21
				if(userTotal > 21 && compTotal <= 21) {			
					textField = new JTextField("I win because you went over!");
					textField.setForeground(Color.BLACK);
					layout.setConstraints( textField, c);
				}
				
				//when both player's totals are under 21, but user's total is closer to 21
				if(userTotal > compTotal && userTotal <= 21) {
					textField = new JTextField("Yay! You win!");
					textField.setForeground(Color.BLACK);
					layout.setConstraints( textField, c);
				}
				
				//when computer's total is over 21, but user's total is under 21
				if(compTotal > 21 && userTotal <= 21) {
					textField = new JTextField("You win because I went over!");
					textField.setForeground(Color.BLACK);
					layout.setConstraints( textField, c);
				}
				
				//when both player's totals are over 21
				if(userTotal > 21 && compTotal > 21) {
					textField = new JTextField("Boo :( We both lose!");
					textField.setForeground(Color.BLACK);
					layout.setConstraints( textField, c);
				}
			}
        }
	}
}