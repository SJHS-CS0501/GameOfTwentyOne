import java.util.Random;

/**
 * The Dice Class simulates a six-sided die roll.
 * @author Tony Gaddis
 *
 */
public class Dice {

	private int sides; // number of sides
	private int value; // die's value

	/**
	 * The constructor performs an initial roll of the die.
	 * @param numSides The number of sides for this die
	 */
	public Dice( int numSides ){
		sides = numSides;
		roll();
	}
	
	/**
	 * The roll method simulates the rolling of the die.
	 */
	public void roll() {
		Random rand = new Random(); // Create a random object
		
		value = rand.nextInt( sides ) +1; // Get a random value for the die.
	}
	
	/**
	 * getSides method
	 * @return The number of sides for this die.
	 */
	public int getSides() {
		return sides;
	}
	
	/**
	 * getValue method
	 * @return the value of the die.
	 */
	public int getValue() {
		return value;
	}
}
