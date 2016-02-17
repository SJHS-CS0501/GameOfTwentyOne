import java.util.Random;

/**
 * This class simulates a six sided die
 * @author ryley
 *
 */

public class Die {

		private int sides; // number of sides
		private int value; // the die's value
		
		/**
		 * The constructor performs an initial roll of the die
		 * @param numSides
		 */
		
		public Die(int numSides)
		{
			sides = numSides;
			roll();
		}


		/**
		 * The roll method simulates the rolling of the die
		 */
		
		public void roll()
		{
			//create random object
			Random roll = new Random();
			
			//get a random value for the die
			value = roll.nextInt(sides)+1;
		}
		
		/**
		 * getSides method
		 * @return The number of sides for this die
		 */
		
		public int getSides()
		{
			return sides;
		}
		
		/**
		 * getValue method
		 * @return The value of the die
		 */
		
		public int getValue()
		{
			return value;
		}
}
