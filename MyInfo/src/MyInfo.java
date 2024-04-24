/**
 * Lab 1
 * @author vincentfealy
 *COSC 117
 *9/4/2020
 *
 *The program properly shows use of different variables such as integers and double all printed
 *to the console with information about my self. 
 */
public class MyInfo {
	public static void main( String[] args) {
		String name = "Vincent Fealy";
		String address = "Wicomico 307";
		int age = 18;
		double GPA = 3.5;
		
		System.out.println("My name is " + name);
		System.out.println("My address is " + address);
		System.out.println("I am years " + age + " old");
		System.out.println("My GPA is " + GPA);
		//using "print" instead of "printLn" will print each call on the same line instead of a new one.
		
		//I chose to display an int, double, and and string to display an integer a decimal number and words for strings.
		//these are appropriate choices to display the correct form of each variable.
	}
}
