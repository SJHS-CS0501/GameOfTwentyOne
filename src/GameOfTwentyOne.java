import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * This class creates the window for the game of twenty one
 */

/**
 * @author David Herr
 *
 */

public class GameOfTwentyOne {

	static JLabel myLabel; // variable for label 
	static JButton myButton; // variable for roll dice button
	static JButton myButton2; // variable for stop button
	static JTextField myTextField; // variable for text box
	static JButton textFieldUpdate; // variable to update text bow
	static GridBagLayout layout; // variable for the gridbag layout
	static int drollcomp = 0; // variable for the computers score
	static int droll = 0; // variable for the users score
	static DieJava die = new DieJava(6); // creates a new variable die of the
										 // die java class
	static DieJava die2 = new DieJava(6); // creates a new variable die2 of the
										// die java class
	/**
	 * Main method that creates the window for the game of twenty one
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame myFrame = new JFrame("Game of Twenty One"); // creates the frame to hold all components
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// sets it to close as default
		myFrame.setVisible(true); // makes the frame visible
		layout = new GridBagLayout(); // creates a new GridBagLayout
		myFrame.setLayout(layout); // sets the layout of myFrame according to GridBagLayout
		GridBagConstraints c = new GridBagConstraints(); // creates a new GridBagRestraint 
		// general constraints
		c.fill = GridBagConstraints.BOTH;

		// label constraints
		c.weightx = .5; // changes weight of label to receive less space
		c.gridwidth = GridBagConstraints.RELATIVE; // sets the label to be in the second to last column
		myLabel = new JLabel("Welcome to twenty-one with dice! "); // creates new label
		myLabel.setForeground(Color.BLUE); // sets text color
		myLabel.setFont(new Font("TimesRoman", Font.BOLD, 24)); // sets font, makes font bold, and text size
		layout.setConstraints(myLabel, c); // sets restraints of the label 
		myFrame.add(myLabel); // adds label to frame

		
		c.gridwidth = GridBagConstraints.REMAINDER; // button constraints
		myButton = new JButton("Press to roll the dice"); // creates new button to roll dice
		myButton2 = new JButton("Press to stop"); // creates new button to stop rolling dice
		myButton.setFont(new Font("TimesRoman", Font.ITALIC, 12)); // sets font, makes font italicized and font size
		myButton2.setFont(new Font("TimesRoman", Font.ITALIC, 12)); // sets font, makes font italicized and font size

		ActionListener listener = new MyActionListener(); // creates new ActionListener
		myButton.addActionListener(listener); //adds ActionListener to button to roll dice
		myButton2.addActionListener(listener);// adds ActionListener to button to stop rolling dice
		layout.setConstraints(myButton, c); // more button constraints
		layout.setConstraints(myButton2, c); // more button constraints
		myFrame.add(myButton); // adds button to frame
		myFrame.add(myButton2); // adds button to frame

		// text field setup
		myTextField = new JTextField("Your current score is: " + droll); // creates new text field and sets text in textfield
		c.weightx = 1.0; // sets weight for text field to have more weight
		c.gridwidth = 5; // allocates 5 cells for text field
		layout.setConstraints(myTextField, c); // text field constraints
		myFrame.add(myTextField); // adds text field to frame
		myTextField.setEditable(false); // makes the text field not editable 
		c.gridwidth = GridBagConstraints.REMAINDER; // text field restraints

		myFrame.pack(); // makes the window to be a certain size
		myFrame.setSize(myFrame.getPreferredSize()); // sets the size of the window to the proffered size
		// Our size will be wrong, so let's fix it
		 myFrame.setSize(500, 150); // resets size of the window to be the desired size
		// alternate: use pack
		// myFrame.pack();

		myFrame.setVisible(true); // makes the frame visable

		Random rnd = new Random(); // creates random object

	}
/**
 * This class simulates all of the dice movements, etc. 
 * @author David Herr
 *
 */
	public static class DieJava {
		private int sides; // Number of sides
		private int value; // The die's value

		/**
		 * The constructor performs an initial roll of the die.
		 * 
		 * @param numSides
		 * The number of sides for this die
		 * @return
		 */

		public DieJava(int numSides) {
			sides = numSides;
			roll();
		}

		/**
		 * The roll method simulates the rolling of the die
		 */

		public void roll() {
			Random rnd = new Random(); // creates random object

			// Get a random value for the die
			value = rnd.nextInt(sides) + 1;
		}

		/**
		 * getSides method
		 * 
		 * @return The number of sides for for this dice
		 */

		public int getSides() {
			return sides;
		}

		/**
		 * getValue method
		 * 
		 * @return The value of the die
		 */

		public int getValue() {
			return value;
		}

	}
/**
 * This class is for the Action Lister and tells the buttons what to do
 * @author Owner
 *
 */
	static class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton eventSource = (JButton) e.getSource();

			if (eventSource.getText().equals("Press to roll the dice")) {
				die.roll(); // rolls die for computer
				die2.roll(); // rolls die for user
				drollcomp += die.getValue(); // sets value of computers score to
												// die roll
				droll += die2.getValue(); // sets value of users score equal to
											// die roll
				die.roll();// rolls die for computer
				die2.roll();// rolls die for user
				drollcomp += die.getValue();// sets value of computers score to
											// die roll
				droll += die2.getValue();// sets value of users score equal to
											// die roll
				myTextField.setText("Your current score is: " + droll); // tells user their score

				// All if loops below for this button determine who wins
				// the game using various cases and resets value to zero 
				if (droll == 21) {
					myTextField.setText(" Congratulations! You Win! " + " The computer had : " + drollcomp
							+ " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;

				}
				if (drollcomp == 21) {
					myTextField.setText(
							" Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
				if (drollcomp == 21 && droll == 21) {
					myTextField.setText(
							" Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
				if (droll > 21 && drollcomp > 21 && droll < drollcomp) {
					myTextField.setText(" Congratulations! You Win! " + " The computer had : " + drollcomp
							+ " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
				if (droll > 21 && drollcomp > 21 && droll > drollcomp) {
					myTextField.setText(
							" Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
				if (droll == 21 && drollcomp == 21) {
					myTextField.setText(" Both scores are 21, it's a draw! ");
					droll = 0;
					drollcomp = 0;
				}
				if (droll > 21 && drollcomp < 21 ) {
					myTextField.setText(
							" Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
				if (droll > 21 && drollcomp < 21) {
					myTextField.setText(
							" Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
				if (drollcomp > 21 && droll < 21) {
					myTextField.setText(" Congratulations! You Win! " + " The computer had : " + drollcomp
							+ " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
				if (droll > 21 && drollcomp > 21 && droll < drollcomp) {
					myTextField.setText(" Congratulations! You Win! " + " The computer had : " + drollcomp
							+ " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
				if (droll > 21 && drollcomp > 21 && drollcomp > droll) {
					myTextField.setName(
							" Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}

			} else {
				if (droll > drollcomp && droll < 21) {
					myTextField.setText(" Congratulations! You Win! " + " The computer had : " + drollcomp
							+ " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
				if (droll < drollcomp && droll < 21) {
					myTextField.setText(
							" Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
				if (droll < 21 && drollcomp > 21) {
					myTextField.setText(" Congratulations! You Win! " + " The computer had : " + drollcomp
							+ " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
				if (droll > 21 && drollcomp > 21 && droll == drollcomp) {
					myTextField.setText(" Both scores are " + droll + " it's a draw! ");
					droll = 0;
					drollcomp = 0;
					if (droll < drollcomp) {
						myTextField.setText("Congratulations! You win!");
						droll = 0;
						drollcomp = 0;
					}
				}
			}
			// All if loops below determine the winner if the user presses the "Press to stop" button
			if (eventSource.getText().equals("Press to stop")) {
				if (droll > drollcomp && droll < 21) {
					myTextField.setText(" Congratulations! You Win! " + " The computer had : " + drollcomp
							+ " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
				if (droll < drollcomp && droll < 21) {
					myTextField.setText(
							" Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
				if (droll > drollcomp && droll < 21 && drollcomp < 21) {
					myTextField.setText(" Congratulations! You Win! " + " The computer had : " + drollcomp
							+ " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
				if (droll < drollcomp && droll < 21 && drollcomp < 21) {
					myTextField.setText(
							" Sorry! You lose! " + " The computer had : " + drollcomp + " Your score is: " + droll);
					droll = 0;
					drollcomp = 0;
				}
			}
		}
	}
}
