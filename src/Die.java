/**
 * This is a class that simulates a die.
 * This was copied from the example in the book, with a few abbreviations to improve text
 * efficiency.
 * @author Ryan Luchs
 * 
 */

import java.util.Random;

/**
 * This is a class that simulates a six-sided die.
 * This was copied from the example in the book, with a few abbreviations to improve text
 * efficiency.
 * @author Ryan Luchs
 *
 */
public class Die {
	private int sides; // Number of sides
	private int value; // The die's value
	
	/**
	 * Constructor performs initial roll of die.
	 * @param numSides The number of sides for this die.
	 */
	public Die(int numSides){
		sides = numSides;
		roll();
	}
	
	/**
	 * Simulates rolling of die.
	 */
	public void roll(){
		// Create Random object.
		Random rand = new Random();
		
		// Get random value for die.
		value = rand.nextInt(sides) + 1;
	}
	
	/**
	 * getSides method
	 * @return Number of sides of this die.
	 */
	public int getSides(){
		return sides;
	}
	
	/**
	 * getValue method
	 * @return Value of die.
	 */
	public int getValue(){
		return value;
	}
}
