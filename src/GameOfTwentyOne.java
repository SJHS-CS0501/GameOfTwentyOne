import java.util.Scanner;
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
    static JButton button;
    static JTextField textField;
    static GridBagLayout layout;

	/**
	 * This is the main method for the GameOfTwentyOne program.
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		int userTotal = 0; //tally of user's total
		int compTotal = 0; //tally of computer's total
		
		ActionListener listener = new RollAgainListener();
		layout = new GridBagLayout();
		
		JFrame frame = new JFrame("Game of Twenty-One");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout( layout );
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.0;
	    c.gridwidth = GridBagConstraints.RELATIVE;
	    
	    frame.setVisible(true);
		
	    label = new JLabel("Let's play a game of blackjack--with dice! I just rolled, your turn!");
	    label.setForeground(Color.BLUE);
        label.setFont(new Font("TimesRoman", Font.BOLD, 24));
        layout.setConstraints( label, c );
        frame.add(label);

        c.gridwidth = GridBagConstraints.REMAINDER;
        
        //making roll button
        button = new JButton("Roll");
        //setting the font and font size of roll button
        button.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		
        layout.setConstraints( button, c);
        frame.add(button);
        
        button.addActionListener(listener);
        
        do {
        label = new JLabel("Do you want to roll again?");
		label.setForeground(Color.BLACK);
		layout.setConstraints( label, c);
		
        //making no button
        button = new JButton("No");
        //setting the font and font size of no button
        button.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		layout.setConstraints( label, c);
        
        button.addActionListener(listener);
        } while(button.equals(true));
        
        label = new JLabel("My total was " + compTotal + "!");
		label.setForeground(Color.BLACK);
		layout.setConstraints( label, c);

       
		
        /*
		JOptionPane.showMessageDialog( null, "Let's play a game of blackjack--with dice!\nI just rolled, your turn!" );
		
			
		do {
			roll.roll(); //first die
			compTotal += roll.getValue();
			roll.roll(); //second die
			compTotal += roll.getValue();
			
			roll.roll(); //first die
			userTotal += roll.getValue();
			JOptionPane.showMessageDialog( null, "You rolled an " + roll.getValue() + "!" );
			
			roll.roll(); //second die
			userTotal += roll.getValue();
			JOptionPane.showMessageDialog( null, "You rolled an " + roll.getValue() + "!" );
			
			
			result = JOptionPane.showConfirmDialog( null, "Do you want to roll again?" ,
												"Roll Again?" , JOptionPane.YES_NO_OPTION);
		}
		while(result == JOptionPane.YES_OPTION);
		
		JOptionPane.showMessageDialog( null, "My total was " + compTotal + "!" );
		*/
		
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
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.0;
		    c.gridwidth = GridBagConstraints.RELATIVE;
			
			JButton eventSource = (JButton)e.getSource();
            if( eventSource.equals( "Roll" ) ) {
        			roll.roll(); //first die
        			compTotal += roll.getValue();
        			roll.roll(); //second die
        			compTotal += roll.getValue();
        			
        			roll.roll(); //first die
        			userTotal += roll.getValue();
        			label = new JLabel("You rolled an " + roll.getValue() + "!");
        			label.setForeground(Color.BLACK);
        			layout.setConstraints( label, c);
        			
        			roll.roll(); //second die
        			userTotal += roll.getValue();
        			label = new JLabel("You rolled an " + roll.getValue() + "!");
        			label.setForeground(Color.BLACK);	
        			layout.setConstraints( label, c);
            }
        }
	}
}