
import java.util.Scanner;

public class labfive {
	public static void main(String[] args) {
		String[] salsa = {"Mild", "Medium", "Sweet", "Hot", "Zesty"};
		int[] number = new int[5];
		double[] price = {2.25, 3.00, 3.50, 4.00, 4.50};
		
		System.out.println("Welcome to your salsa profit calculator!\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many " + salsa[0] + " salsas were sold (at $2.25 each): ");
		number[0] = sc.nextInt();
		System.out.println("Enter how many " + salsa[1] + " salsas were sold (at $3.00 each): ");
		number[1] = sc.nextInt();
		System.out.println("Enter how many " + salsa[2] + " salsas were sold (at $3.50 each): ");
		number[2] = sc.nextInt();
		System.out.println("Enter how many " + salsa[3] + " salsas were sold (at $4.00 each): ");
		number[3] = sc.nextInt();
		System.out.println("Enter how many " + salsa[4] + " salsas were sold (at $4.50 each): ");
		number[4] = sc.nextInt();
		
		System.out.println("\nProcessing...\n");
		
		System.out.println("Here is your monthly sales report: \n");
		
		double grossMild = number[0] * price[0];
		System.out.print(salsa[0] + ":    " + number[0] + " x " + price[0] + " = ");
		System.out.format("%.2f", grossMild);
		
		double grossMedium = number[1] * price[1];
		System.out.print("\n" + salsa[1] + ":  " + number[1] + " x " + price[1] + " = ");
		System.out.format("%.2f", grossMedium);
		
		double grossSweet = number[2] * price[2];
		System.out.print("\n" + salsa[2] + ":   " + number[2] + " x " + price[2] + " = ");
		System.out.format("%.2f", grossSweet);
		
		double grossHot = number[3] * price[3];
		System.out.print("\n" + salsa[3] + ":     " + number[3] + " x " + price[3] + " = ");
		System.out.format("%.2f", grossHot);
		
		double grossZesty = number[4] * price[4];
		System.out.print("\n" + salsa[4] + ":   " + number[4] + " x " + price[4] + " = ");
		System.out.format("%.2f", grossZesty);
		
		System.out.println("\n-------------------------");
		
		double grossTotal = grossMild + grossMedium + grossSweet + grossHot + grossZesty;
		System.out.print("Gross:             ");
		System.out.format("%.2f", grossTotal);
		
		double tax = 0.06;
		tax = tax * grossTotal;
		System.out.print("\nTax:               (");
		System.out.format("%.2f", tax);
		System.out.print(")");
		
		System.out.println("\n-------------------------");
		
		double net = grossTotal - tax;
		System.out.println("Net:               " + net);
		
		System.out.println("\nYou made $" + net + " this month!");
	}
}
