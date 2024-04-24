/*
 * Lab 7
 * Vincent Fealy
 * Cosc 117
 * This lab encodes or decodes messages for a user.
 *also prints if there is an error with the files.
 *creates new files to store.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Lab7 {
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		
		//establishing variables
		String input = "";
		String output = "";
		int change = 0;
		
		//printing first message for user
		System.out.println("Would you like to encode (E) or decode (D) a message?");
		input = sc.nextLine().toUpperCase();
		
		// This while loops runs while the user input is "D" and if it is "E"
		while(!input.equals("D") && !input.equals("E")){
			System.out.println("invalid try again!");
			input = sc.nextLine().toUpperCase();
		}
		
		if(input.equals("E")) {
			System.out.println("Great! Please enter your message below: ");
			output = sc.nextLine();
			System.out.println("Now enter your shift amount (an integer or a character relative to A): ");
			String temp = sc.nextLine().toUpperCase();
			char[] temp1 = temp.toCharArray();
	
			
// this part of the code was used over from the leet speak program.
// some parts got changed around but mostly remain similar.
			for(int i = 0; i < temp1.length; i++) {
				if(temp1[i] > 47 && temp1[i] < 58) {
					change = Integer.parseInt(String.valueOf(temp1));
					i = temp1.length;
				} else {
					change = (int) temp1[i] - 65; 
					i = temp1.length;
				}
			}
			
			char[] myString = output.toCharArray();
			for (int i = 0; i < myString.length; i++) {
				if (myString[i] >= 97 && myString[i] <= 122) {
					int combined = myString[i] + change;
					int diff = combined - 122;
					
					while (diff > 0) {
						combined = diff + 96;
						diff = combined - 122;
					}
					
					
					myString[i] = (char) combined;
				}
				if (myString[i] >= 65 && myString[i] <= 90) {
					int combined = myString[i] + change;
					int diff = combined - 90;
					
					while (diff > 0) {
						combined = diff + 64;
						diff = combined - 90;
						
					}
					myString[i] = (char) combined;
				}
			}			
			String cipher = new String(myString);
			//This code also comes from the example in class.
			System.out.println("Your encrypted message is: " + cipher);
			System.out.println("Please enter the file to store this message: ");
			String fileName = sc.nextLine();
			FileWriter file = new FileWriter(fileName);
			file.write(cipher);
			file.close();
			System.out.println("Saving...Done!");
		} else {
			System.out.println("Great! Please enter the file you want to decrypt: ");
			String fileName = sc.nextLine();
			try {
				Scanner sc2 = new Scanner(new File(fileName));
				System.out.println("Now enter your shift amount (an integer or a character relative to A): ");
				String temp = sc.nextLine().toUpperCase();
				char[] temp1 = temp.toCharArray();

				for(int i = 0; i < temp1.length; i++) {
					if(temp1[i] > 47 && temp1[i] < 58) {
						change = Integer.parseInt(String.valueOf(temp1));
						i = temp1.length;
					} else {
						change = (int) temp1[i] - 65; 
						i = temp1.length;
					}
				}
				String cipher = "";
				while(sc2.hasNextLine()) {
					String line = sc2.nextLine();
					
					char[] myStr = line.toCharArray();
					
					for (int i = 0; i < myStr.length; i++) {
						if (myStr[i] >= 97 && myStr[i] <= 122) {
							int combined = myStr[i] - change;
							int diff = combined - 97;
							
							while (diff < 0) {
								combined = 122 - Math.abs(diff);
								diff = combined - 97;
								
							}
							myStr[i] = (char) combined;
						}
						if (myStr[i] >= 65 && myStr[i] <= 90) {
							int combined = myStr[i] - change;
							int diff = combined - 65;
							
							while (diff < 0) {
								combined = 90 - Math.abs(diff);
								diff = combined - 65;
								
							}
							myStr[i] = (char) combined;
						}
					}			
					cipher = new String(myStr);
				}
				System.out.println(cipher);
			} 
			
// this was used from your example in class to find if there was an error with the file.
			//not totally sure if this works in the correct manner but I inserted it to see
catch (Exception e) {
System.out.println("There was an error opening the file!");
System.out.println(e.getMessage());
			}
				
		}
				
	}
}

