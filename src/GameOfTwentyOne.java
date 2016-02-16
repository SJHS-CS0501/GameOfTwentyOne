import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Jack Protivnak
 */
public class GameOfTwentyOne {
	/**
	 * This program is designed to simulate a game of BlackJack using dice
	 * instead of cards. The user will be paired against the computer and will
	 * have the option of rolling until they tell the program to stop. It will
	 * then compare the scores and share the results.
	 * 
	 * @param args
	 */

	// All variables are declared
	static JLabel myLabel;
	static JButton die1Pic = new JButton();
	static JButton die2Pic = new JButton();
	static JButton myButton;
	static JTextField myTextField;
	static JButton finalCount;
	static JButton exit;
	static GridBagLayout layout;
	static JTextArea myTextArea = new JTextArea(5, 20);
	static JFrame myFrame = new JFrame("Black Jack");
	static ImageIcon die1;
	static ImageIcon die2;
	static String userInput = null;
	static int userTotal = 0;
	static int compTotal = 0;
	static int i = 0;
	static Die dieRoll1 = new Die(6);
	static Die dieRoll2 = new Die(6);
	static Scanner keyboard = new Scanner(System.in);

	// This creates the frame and all of the elements inside of it.
	public static void main(String[] args) {

		myTextArea.setEditable(false);

		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		layout = new GridBagLayout();
		myFrame.setLayout(layout);
		myFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
		myFrame.setLayout(new GridLayout(2, 2, 50, 10));

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		c.weightx = 0.0;
		c.gridwidth = GridBagConstraints.RELATIVE;
		myLabel = new JLabel("Click 'Roll Die' to begin");
		myLabel.setForeground(Color.BLACK);
		myLabel.setFont(new Font("TimesRoman", Font.BOLD, 22));
		layout.setConstraints(myLabel, c);
		myFrame.add(myLabel);

		c.gridwidth = GridBagConstraints.REMAINDER;
		myButton = new JButton("Roll Dice");
		myButton.setFont(new Font("TimesRoman", Font.BOLD, 22));

		ActionListener listener = new MyListener();
		myButton.addActionListener(listener);

		myFrame.add(myTextArea);
		layout.setConstraints(myButton, c);
		myFrame.add(myButton);

		c.gridwidth = GridBagConstraints.REMAINDER;
		finalCount = new JButton("Final Count/End");
		finalCount.setFont(new Font("TimesRoman", Font.BOLD, 22));
		finalCount.addActionListener(listener);
		layout.setConstraints(finalCount, c);
		myFrame.add(finalCount);

		c.gridwidth = GridBagConstraints.REMAINDER;
		exit = new JButton("Exit");
		exit.setFont(new Font("TimesRoman", Font.BOLD, 22));
		exit.addActionListener(listener);
		layout.setConstraints(exit, c);
		myFrame.add(exit);
		myFrame.add(die1Pic);
		myFrame.add(die2Pic);

		// myFrame.pack();
		myFrame.setSize(1750, 350);

		myFrame.setVisible(true);

	}

	/**
	 * This method will not return anything, but will allow the user to roll the
	 * dice in the game. It will then check if the score for the user or
	 * computer is under 21. If not, then it will got to the final check.
	 */
	public static void response() {

		// A while loop to determine the next step for the user.
		// If their score is below 21, they will have the option of
		// rolling again or exiting and get the results.

		myFrame.remove(die1Pic);
		myFrame.remove(die2Pic);
		dieRoll1.roll();
		dieRoll2.roll();
		compTotal += dieRoll2.getValue() + dieRoll1.getValue();
		dieRoll1.roll();
		dieRoll2.roll();
		userTotal += dieRoll1.getValue() + dieRoll2.getValue();
		DicePictures();
		die1Pic = new JButton(die1);
		die2Pic = new JButton(die2);
		myFrame.add(die1Pic);
		myFrame.add(die2Pic);
		myTextArea.setText(null);
		myTextArea.append("Your total is: " + userTotal);
		if (userTotal >= 21 || compTotal >= 21) {
			myTextArea.setText(null);
			while (i < 1) {
				FinalCount();
				i++;
			}
		}
	}

	/**
	 * This method will tell the user how they did compared to the computer.
	 */
	public static void FinalCount() {
		if (userTotal > 21 && compTotal > 21) {
			myTextArea.append("\n\nEveryone LOOSES!!!\nComputer Total: " + compTotal + "\nYour total: " + userTotal);
		} else if (userTotal <= 21 && userTotal > compTotal) {
			myTextArea.append("\n\nYou win!\nComputer Total: " + compTotal + "\nYour total: " + userTotal);
		} else if (compTotal <= 21 && compTotal > userTotal) {
			myTextArea.append(
					"\n\nCOMPUTER WINS!!!!!!! YOU LOOSE\nComputer Total: " + compTotal + "\nYour total: " + userTotal);
		} else if (compTotal == userTotal) {
			myTextArea.append("\n\nYou savage... you got the same total as the computer.\nComputer Total: " + compTotal
					+ "\nYour total: " + userTotal);
		} else if (userTotal == 21 && compTotal > 21) {
			myTextArea.append(
					"\n\nBro... You beat the comptuer.\nComputer Total: " + compTotal + "\nYour total: " + userTotal);
		} else if (userTotal > 21 && compTotal <= 21) {
			myTextArea.append("\n\nSo... you loose and the computer WINS!!!\nComputer Total: " + compTotal
					+ "\nYour total: " + userTotal);
		} else if (userTotal <= 21 && compTotal > 21) {
			myTextArea.append("\n\nYou win!\nComputer Total: " + compTotal + "\nYour total: " + userTotal);
		} else {
			myTextArea.append("\n\nYour total is: " + userTotal + "\nComputer Total: " + compTotal);
		}
	}

	/**
	 * This method is to retrieve the pictures for the different possible dice
	 * combinations.
	 */
	public static void DicePictures() {
		if (dieRoll1.getValue() == 0) {
			die1 = new ImageIcon("blank-dice-clip-art.png");
		}
		if (dieRoll1.getValue() == 1) {
			die1 = new ImageIcon("dice1.gif");
		}
		if (dieRoll1.getValue() == 2) {
			die1 = new ImageIcon("dice2.gif");
		}
		if (dieRoll1.getValue() == 3) {
			die1 = new ImageIcon("dice3.gif");
		}
		if (dieRoll1.getValue() == 4) {
			die1 = new ImageIcon("dice4.gif");
		}
		if (dieRoll1.getValue() == 5) {
			die1 = new ImageIcon("dice5.gif");
		}
		if (dieRoll1.getValue() == 6) {
			die1 = new ImageIcon("dice6.gif");
		}
		if (dieRoll2.getValue() == 0) {
			die2 = new ImageIcon("blank-dice-clip-art.png");
		}
		if (dieRoll2.getValue() == 1) {
			die2 = new ImageIcon("dice1.gif");
		}
		if (dieRoll2.getValue() == 2) {
			die2 = new ImageIcon("dice2.gif");
		}
		if (dieRoll2.getValue() == 3) {
			die2 = new ImageIcon("dice3.gif");
		}
		if (dieRoll2.getValue() == 4) {
			die2 = new ImageIcon("dice4.gif");
		}
		if (dieRoll2.getValue() == 5) {
			die2 = new ImageIcon("dice5.gif");
		}
		if (dieRoll2.getValue() == 6) {
			die2 = new ImageIcon("dice6.gif");
		}
	}

	/**
	 * This action listener will decide what actions will be taken when each
	 * button is pushed.
	 * 
	 * @author Jack
	 *
	 */
	static class MyListener implements ActionListener {

		int index = 0;

		public void actionPerformed(ActionEvent e) {
			JButton eventSource = (JButton) e.getSource();
			if (eventSource.getText().equals("Roll Dice")) {
				if (userTotal < 21) {
					response();
				}
			}
			if (eventSource.getText().equals("Final Count/End")) {
				while (i < 1) {
					FinalCount();
					i++;
				}
			}
			if (eventSource.getText().equals("Exit")) {
				System.exit(0);
			}
		}
	}
}