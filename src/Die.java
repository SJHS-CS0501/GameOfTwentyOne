import java.util.Random;

/**
 * The Die class simulates a six-sided die.
 * @author Java Book
 */

public class Die {
	
	private int sides; //number of sides
	private int value; //die's value
	
	/**
	 * The constructor performs an initial roll of the die.
	 * @param numSides...the number of sides for this die
	 */
	
	public Die(int numSides) {
		
		sides = numSides;
		roll();
	}
	
	/**
	 * The roll method simulates the rolling of the die.
	 * @author Java Book
	 */
	
	public void roll() {
		
		Random rand = new Random(); //create a Random object
		value = rand.nextInt( sides ) + 1; //get a random value for the die
	}
	
	/**
	 * getSides method
	 * @return number of sides for this die
	 */
	
	public int getSides() {
		return sides;
	}
	
	/**
	 * getValue method
	 * @return value of the die
	 */
	
	public int getValue() {
		return value;
	}
}
