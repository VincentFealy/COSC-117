/*
 * Vincent Fealy
 * Lab11
 * Class to conroll the dice in its own separate class.
 */
import java.util.Random;
public class Dice {
	private int value;
	private int sides;
	//public void classes that count and set each side of the die!
	public Dice () {
		value = 1;
		sides = 1;
	}
	public void setSides (int sides) {
		if (sides == 4 || sides == 6 || sides== 8 || sides == 10 || sides == 12 || sides == 20) {
			this.sides = sides;
		} else {
			throw new IllegalArgumentException("sides are not 4, 6, 8, 10, 12, or 20");
		}
		
		}
		public int getValue () {
			return value;
		}
		public void roll () {
			Random rand = new Random();
			int randNum = rand.nextInt(sides);
			//Increment once because 0 is inclusive and upper bound is exclusive
			randNum++;
			value = randNum;	
	}
}
