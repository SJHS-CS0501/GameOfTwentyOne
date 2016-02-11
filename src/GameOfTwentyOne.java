import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Ex11_1.MyListener;

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
		
		Scanner keyboard = new Scanner( System.in );
		Die roll = new Die(6); //creating new Die object
		int userTotal = 0; //tally of user's total
		int compTotal = 0; //tally of computer's total
		int result; //yes or no response if user wants to roll again
		ActionListener listener = new Listener();
		layout = new GridBagLayout();
		
		JFrame frame = new JFrame("Game of Twenty-One");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout( layout );
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.0;
	    c.gridwidth = GridBagConstraints.RELATIVE;
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
        
        do {
			roll.roll(); //first die
			compTotal += roll.getValue();
			roll.roll(); //second die
			compTotal += roll.getValue();
			
			roll.roll(); //first die
			userTotal += roll.getValue();
			label = new JLabel("You rolled an " + roll.getValue() + "!");
			label.setForeground(Color.BLACK);
			
			roll.roll(); //second die
			userTotal += roll.getValue();
			label = new JLabel("You rolled an " + roll.getValue() + "!");
			label.setForeground(Color.BLACK);
			
			label = new JLabel("Do you want to roll again?");
			label.setForeground(Color.BLACK);
			
			//making yes button
	        button = new JButton("Yes");
	        //setting the font and font size of yes button
	        button.setFont(new Font("TimesRoman", Font.PLAIN, 12));
	        
	        //making no button
	        button = new JButton("No");
	        //setting the font and font size of no button
	        button.setFont(new Font("TimesRoman", Font.PLAIN, 12));
	        
	        
	        button.addActionListener(listener);
	        //actionlistener for button
	        
        } while();

        label = new JLabel("My total was " + compTotal + "!");
		label.setForeground(Color.BLACK);
		
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
			JOptionPane.showMessageDialog( null, "I win!" );
		}
		
		//when user's total is over 21, but computer's total is under 21
		if(userTotal > 21 && compTotal <= 21) {
			JOptionPane.showMessageDialog( null, "I win because you went over!" );
		}
		
		//when both player's totals are under 21, but user's total is closer to 21
		if(userTotal > compTotal && userTotal <= 21) {
			JOptionPane.showMessageDialog( null, "Yay! You win!" );
		}
		
		//when computer's total is over 21, but user's total is under 21
		if(compTotal > 21 && userTotal <= 21) {
			JOptionPane.showMessageDialog( null, "You win because I went over!" );
		}
		
		//when both player's totals are over 21
		if(userTotal > 21 && compTotal > 21) {
			JOptionPane.showMessageDialog( null, "Boo :( We both lose!" );
		}
		
		frame.pack();
        frame.setSize( frame.getPreferredSize() );
        
        frame.setVisible(true);

	}
	
	static class Listener implements ActionListener {

        Color theColors[] = {Color.BLUE, Color.RED, Color.GREEN, Color.BLACK, Color.WHITE};
        int index = 0;

        public void actionPerformed(ActionEvent e) {
            //JButton eventSource = (JButton) e.getSource();
            //eventSource.setForeground(theColors[index++]);
            JButton eventSource = (JButton)e.getSource();
            if( eventSource.getText().equals("Update Label") ) {
                label.setText( textField.getText() );
            } else {
                label.setForeground( theColors[++index] );
                if (index >= theColors.length - 1) {
                    index = -1;
                }
            }
        }
    }
}
