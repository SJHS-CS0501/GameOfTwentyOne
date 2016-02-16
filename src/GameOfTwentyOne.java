import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This program will allow a user to play a variation of the popular blackjack card game with the computer.
 * @author Woytek
 * @author Julianna Nichols
 */
public class GameOfTwentyOne {
	
	static JLabel label;
	static JLabel die;
    static JButton roll;
    static JButton no;
    static GridBagLayout layout = new GridBagLayout();
    static JFrame frame = new JFrame("Game of Twenty-One"); //new JFrame
    static int userTotal = 0; //user's total
	static int compTotal = 0; //computer's total
	static Die rollDie = new Die(6); //creating new Die object
	static GridBagConstraints c = new GridBagConstraints();

	/**
	 * This is the main method for the GameOfTwentyOne program.
	 * @param args
	 */
	public static void main(String[] args) {
		
		ActionListener listener = new Listener();
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //default close operation
		
		frame.setLayout( layout ); //giving the frame the designated layout
	    
	    frame.setVisible(true); //making the frame visible to the screen
		
	    label = new JLabel("Let's play a game of blackjack--with dice! I just rolled, your turn!");
	    label.setForeground(Color.BLACK);
	    label.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        c.fill = GridBagConstraints.BOTH; //what to do when the component's display area is larger than the component's requested size
        c.weightx = 0.2; //resizing behavior (column)
		c.weighty = 0.2; //resizing behavior (row)
		c.gridx = 0; //second column
		c.gridy = 0; //first row
		c.gridwidth = 3; //take up three columns
        frame.add(label, c);

        /*
         * This label holds space.
         * 
         * Before this was added, my first roll statement (You rolled an _!) would write over itself..this is to fix that.
         * In the actionReader, I have "label.setVisible(false);" this is making the second roll statement (You rolled an _ !)
         * disappear before it prints the next one.
         * 
         * So this label is holding that space for the first roll statement..so I could write "die.setVisible(false)" so before
         * prints the next roll statement the previous one disappears
         * 
         * I understand this is confusing, and bad programming..
         * I can go back and change it later and make it more efficient
         */
        die = new JLabel("");
        frame.add(die, c);
        
        roll = new JButton("Roll");
        roll.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        c.fill = GridBagConstraints.BOTH; //what to do when the component's display area is larger than the component's requested size
        c.weightx = 0.2; //resizing behavior (column)
		c.weighty = 0.2; //resizing behavior (row)
		c.gridx = 2; //third column
		c.gridy = 1; //second row
		c.gridwidth = 1; //take up one column
		frame.add(roll, c);
		roll.addActionListener(listener); //actionListener listening for roll button

		no = new JButton("No");
		no.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		c.fill = GridBagConstraints.BOTH; //what to do when the component's display area is larger than the component's requested size
		c.weightx = 0.2; //resizing behavior (column)
		c.weighty = 0.2; //resizing behavior (row)
		c.gridx = 1; //second column
		c.gridy = 1; //second row
		c.gridwidth = 1; //take up one column
		frame.add(no, c);
		no.addActionListener(listener); //actionListener listening for no button
		
		frame.pack();
        frame.setSize( frame.getPreferredSize() );

	}
	
	/**
	 * ActionListener will react to each button click
	 * @author Julianna Nichols
	 */
	static class Listener implements ActionListener {
		
		/**
		 * If "Roll" button is clicked, rolls die
		 * If "No" button is clicked, compares computer's total to user's total
		 * @return 
		 */
		public void actionPerformed(ActionEvent e) {
			JButton eventSource = (JButton)e.getSource();
			
			if (eventSource.getText().equals("Roll")) {
				label.setVisible(false);
				die.setVisible(false);
				
				rollDie.roll(); // first die for computer
				compTotal += rollDie.getValue();
				rollDie.roll(); // second die for computer
				compTotal += rollDie.getValue();

				rollDie.roll(); // first die for user
				userTotal += rollDie.getValue();
				c.fill = GridBagConstraints.BOTH;
				c.weightx = 0.2; // resizing behavior (column)
				c.weighty = 0.2; // resizing behavior (row)
				c.gridx = 1; // second column
				c.gridy = 0; // first row
				c.gridwidth = 1; // take up one column
				die = new JLabel("You rolled an " + rollDie.getValue() + "!");
				die.setForeground(Color.BLACK);
				die.setFont(new Font("TimesRoman", Font.PLAIN, 24));
				frame.add(die, c);

				rollDie.roll(); // second die for user
				userTotal += rollDie.getValue();
				c.fill = GridBagConstraints.BOTH;
				c.weightx = 0.2; // resizing behavior (column)
				c.weighty = 0.2; // resizing behavior (row)
				c.gridx = 2; // third column
				c.gridy = 0; // first row
				c.gridwidth = 1; // take up one column
				label = new JLabel("You rolled an " + rollDie.getValue() + "! Roll again?");
				label.setForeground(Color.BLACK);
				label.setFont(new Font("TimesRoman", Font.PLAIN, 24));
				frame.add(label, c);
			}
			
			if(eventSource.getText().equals("No")) {
				
				label.setVisible(false);
				die.setVisible(false);
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
		        
				//both player's totals < 21, but computer's total is closer to 21
				if(compTotal > userTotal && compTotal <= 21) {
					label = new JLabel("I win!");
					label.setForeground(Color.BLACK);
					label.setFont(new Font("TimesRoman", Font.PLAIN, 24));
					c.weightx = 0.2; // resizing behavior (column)
        			c.weighty = 0.2; // resizing behavior (row)
        			c.gridx = 2; //first column
        			c.gridy = 0; // first row
					layout.setConstraints( label, c);
					frame.add(label, c);
				}
				
				//user's total > 21, but computer's total < 21
				if(userTotal > 21 && compTotal <= 21) {			
					label = new JLabel("I win because you went over!");
					label.setForeground(Color.BLACK);
					label.setFont(new Font("TimesRoman", Font.PLAIN, 24));
					c.weightx = 0.2; // resizing behavior (column)
        			c.weighty = 0.2; // resizing behavior (row)
        			c.gridx = 2; //first column
        			c.gridy = 0; // first row
					layout.setConstraints( label, c);
					frame.add(label, c);
				}
				
				//both player's totals < 21, but user's total is closer to 21
				if(userTotal > compTotal && userTotal <= 21) {
					label = new JLabel("Yay! You win!");
					label.setForeground(Color.BLACK);
					label.setFont(new Font("TimesRoman", Font.PLAIN, 24));
					c.weightx = 0.2; // resizing behavior (column)
        			c.weighty = 0.2; // resizing behavior (row)
        			c.gridx = 2; //first column
        			c.gridy = 0; // first row
					layout.setConstraints( label, c);
					frame.add(label, c);
				}
				//computer's total > 21, but user's total < 21
				if(compTotal > 21 && userTotal <= 21) {
					label = new JLabel("You win because I went over!");
					label.setForeground(Color.BLACK);
					label.setFont(new Font("TimesRoman", Font.PLAIN, 24));
					c.weightx = 0.2; // resizing behavior (column)
        			c.weighty = 0.2; // resizing behavior (row)
        			c.gridx = 2; //first column
        			c.gridy = 0; // first row
					layout.setConstraints( label, c);
					frame.add(label, c);
				}
				
				//when both player's totals > 21
				if(userTotal > 21 && compTotal > 21) {
					label = new JLabel("Boo :( We both lose!");
					label.setForeground(Color.BLACK);
					label.setFont(new Font("TimesRoman", Font.PLAIN, 24));
					c.weightx = 0.2; // resizing behavior (column)
        			c.weighty = 0.2; // resizing behavior (row)
        			c.gridx = 2; //first column
        			c.gridy = 0; // first row
					layout.setConstraints( label, c);
					frame.add(label, c);
				}
			}
        }
	}
}