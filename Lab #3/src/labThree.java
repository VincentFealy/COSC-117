
 * Comp Sci
 * 
 * Q1: With for loops take a number of dice and create a systematic way to control the rolls.
 * 
 * Q2: You can always go back into the for else statement to add or change more die values.
 *  You also want to use the number of statements and divide accounted by the number of sides on the dice.
 */
public class labThree {
	public static void main(String [] args) {
		
	int generator = 0;
	int die1 = 0;
	int die2 = 0;
	boolean num = false;
		
		while(!num){
			double firstRoll = Math.random();
			double secondRoll = Math.random();
			generator++;
			
//set die rolls to one			
		if (firstRoll <= 1.0/6.0) 
		{
			die1 = 1; 
		}
			else if (firstRoll > 1.0/6.0 && firstRoll <= 2.0/6.0) {
				die1 = 2;
			}
			else if (firstRoll > 2.0/6.0 && firstRoll <= 3.0/6.0) {
				die1 = 3;
			}
			else if (firstRoll > 3.0/6.0 && firstRoll <= 4.0/6.0) {
				die1 = 4;
			}
			else if (firstRoll > 4.0/6.0 && firstRoll <= 5.0/6.0) {
				die1 = 5;
			}
			else { 
				die1 = 6;
			}
		
		
				if(secondRoll <= 1.0/6.0)
					{
						die2 = 1;}
					else if(secondRoll > 1.0/6.0 && secondRoll <= 2.0/6.0) 
					{
						die2 = 2;}
					else if(secondRoll > 2.0/6.0 && secondRoll <= 3.0/6.0) 
					{
						die2 = 3;}
					else if(secondRoll > 3.0/6.0 && secondRoll <= 4.0/6.0) 
					{
						die2 = 4;}
					else if(secondRoll > 4.0/6.0 && secondRoll <= 5.0/6.0) 
					{
						die2 = 5;}
					else {
						die2 = 6;
					}
		
		System.out.println("The first roll is: " + die1);
		System.out.println("The second roll is: " + die2);
		
		if(die1 == 6 && die2 == 6)
		{
			System.out.println("You have rolled Boxcars.");
		}
		
			if(die1 == 5 && die2 == 6 || die1 == 6 && die2 == 5)
			{
				System.out.print("You have rolled Yo-leven.`");
			}
		
//Then to find if you roll snake eyes.
					if(die1 == 1 && die2 == 1)
					{
						num = true;
					}
// close the while loop
		     }
		System.out.println("you have rolled snake eyes and it took " + generator + " rolls.");
	}
}
