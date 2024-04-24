/*
 * Lab 6
 * Vincent Fealy
 * 10/13/20
 * COSC 117
 * This lab uses "char" to let users tansform some words into "leet Speak"
 * Alomg with 2 other forms of encrypted code, with help from the ASCII table.
 */
import java.util.Scanner;
public class lab6Array {
	public static void main(String[] args) {
		char[] letters = {'a','e','l','o','s','t'};
		char[] symbols = {'@','3','1','0','$','7'};
		String conversion = "";
		
		// prompts the user to enter their first sentence then converts.
		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like to be translated into leetspeak: ");
		String translation = sc.nextLine();
		
		translation = translation.toLowerCase();
		char[] userString = translation.toCharArray();
		
		for(int i = 0; i < userString.length; i++) {
			for(int k = 0; k < letters.length; k++) {
				if (userString[i] == letters[k]) {
					userString[i] = symbols[k];
				}
			}
		}
		String leetSpeak = new String(userString);
		System.out.println(leetSpeak);
		
		userString = translation.toCharArray();
		//using the ASCII table now converts an integer.
		System.out.println("Now enter an integer:");
		int numChange = sc.nextInt();
		
		for (int i = 0; i < userString.length; i++) {
			if(userString[i] >= 97 && userString[i] <= 122) {
				int leet = userString[i] + numChange;
				int min = leet - 122;
				if (min > 0) {
					leet = min + 96;
				}
				userString[i] = (char) leet;
			}
		}
		String newTrans = new String (userString);
		System.out.println(newTrans);
		
	}
}
