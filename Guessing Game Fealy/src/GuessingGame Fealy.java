/*/
 * Vincent Fealy
 * Project 1 Guessing Game
 * COSC 117
 * 10/1/20
 * Project 4 uses user input to create a game where a user inputs two numbers.
 * Then we use math.random to pick a random number between those two numbers.
 * In the console the user then gets 10 attempts to guess that random number.
 * WHen an incorrect number is entered it will display a hint whether that number is higher or lower than the correct number.
 */
import java.util.Scanner;

public class GuessGame {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int numberOfGuesses = 10;
	int i;
	int max = 0;
	int min = 0;
	int guess = 0;
	
	System.out.println("Enter 2 positive integers");
	do {
		System.out.println("Enter a minimun:");
		if(sc.hasNextInt()) {
			min = sc.nextInt();
		}else {
			sc.next();
		}
	}
	while(0 >= min);
	do {
		System.out.println("Enter a maximum:");
		if(sc.hasNextInt()) {
			max = sc.nextInt();
		}else {
			sc.next();
		}
	}
	while(min >= max);
	
	int range = max - min;
	
	int correctNum = min + (int)(range * Math.random());
	
	for(i = 0; i < numberOfGuesses; i++) {
	
		
		do {
			System.out.println("Guess a number between " + min + " and " + max);
			System.out.print("Enter guess " + (i +1) + ": ");
			if(sc.hasNextInt()) {
				guess = sc.nextInt();
			}else {
				sc.next();
			}
		}
		while(guess < min || guess > max);
	
		if (correctNum == guess) { 
	        System.out.println("Congratulations!" + " You guessed the number in " + (i + 1) + " attempts!"); 
	        break; 
	    } 
	    else if (correctNum > guess ) { 
	        System.out.println("The number is greater than " + guess); 
	    } 
	    else if (correctNum < guess ) { 
	        System.out.println( "The number is less than " + guess);
	    }
	}
	if(i >= numberOfGuesses) {
		System.out.println("You have run out of guesses... You should have guessed " + correctNum);
	}
	sc.close();
}
}