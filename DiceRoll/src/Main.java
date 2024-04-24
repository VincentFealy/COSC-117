/*
 * Lab 11 Main function for the Die roll program.
 * Vincent Fealy
 * 11/20/20
 */
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		System.out.println("This is an example of a two six-sided die");
		Roll example = new Roll();
		example.roll();
		
		boolean loop = true;
		int numDice;
		int sides;
		
		while(loop) {
			Scanner sc = new Scanner (System.in);
			
			System.out.println("Enter the number of die: ");
			numDice = sc.nextInt();
			
			System.out.println("Enter # of sides of dice: ");
			sides = sc.nextInt();
			
			Roll user = new Roll(numDice, sides);
			System.out.println("Output: ");
			user.roll();
			System.out.println("Total sum: " + user.getTotal());
			
			System.out.println("Enter 0 to end or exit the program!");
			int end = sc.nextInt();
			if (end == 0 ) {
				loop = false;
			}
			
			
			
		}
		
		
	}

}
