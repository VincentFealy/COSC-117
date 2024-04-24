/*
 * second class build fro the rolls
 */
public class Roll {
	private Dice[] diceArr;

	public Roll () throws IllegalArgumentException { 
		diceArr = new Dice[2];
		diceArr[0] = new Dice();
		diceArr[0].setSides(6);
		diceArr[1] = new Dice();
		diceArr[1].setSides(6);

	}
	public Roll(int numDice, int sides) throws IllegalArgumentException {
		diceArr = new Dice[numDice];
		if (sides < 0) {
			throw new IllegalArgumentException("No negative value for sides");
			
		}else {
			for(int i = 0; i < diceArr.length; i++) {
				diceArr[i] = new Dice();
				diceArr[i].setSides(sides);
				
			}
		}
}
	public void roll () {
		
	
		for(int i = 0; i < diceArr.length; i++) {
			diceArr[i].roll();
			System.out.println("roll " + (i+1) + ": " + diceArr[i].getValue());
			
		}
		
	}
	public int getTotal () {
		int sum = 0;
		for(int i = 0; i < diceArr.length; i++) {
			sum += diceArr[i].getValue();
			//returing sum values of rolls through  for loop
		}
		return sum;
	}
}
