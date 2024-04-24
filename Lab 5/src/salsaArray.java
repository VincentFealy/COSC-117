/* Vincent Fealy
 * COSC 117
 * This array prints out the sales of salsa over the course of multiple sales!
 * Then counts the sales out each sale
 * 
 */
import java.util.Scanner;
	public class salsaArray {
		public static void main(String[] args)_{
		String[] salsas = {"Mild", "Medium","Sweet","Hot","Zesty"};
		int[] num = new int[5];
		double[] prices = {2.25, 3.00, 3.50, 4.00, 4.50};
		
		System.out.println("Welcome to your salsa profit Calculator\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many" + salsas[0] + "salsas were sold(at $2.25 each): ");
		num[0] = sc.nextInt();
		System.out.println("Enter how many" + salsas[1] + "salsas were sold(at $3.00 each): ");
		num[1] = sc.nextInt();
		System.out.println("Enter how many" + salsas[2] + "salsas were sold(at $3.50 each): ");
		num[2] = sc.nextInt();
		System.out.println("Enter how many" + salsas[3] + "salsas were sold(at $4.00 each): ");
		num[3] = sc.nextInt();
		System.out.println("Enter how many" + salsas[4] + "salsas were sold(at $4.50 each): ");
		num[4] = sc.nextInt();
		
		System.out.println("\nProcesssing...\n");
		System.out.println("Here is your monthlthy sales report: \n");
		
		double mildNum = num[0] = prices[0];
		System.out.print(salsas[0] + ":    " + num[0] + " x " + prices[0] + " = ");
		System.out.format("%.2f", mildNum);
		
		double mediumNum = num[1] = prices[1];
		System.out.print(salsas[0] + ":    " + num[1] + " x " + prices[1] + " = ");
		System.out.format("%.2f", mediumNum);
		
		double sweetNum = num[2] = prices[2];
		System.out.print(salsas[2] + ":    " + num[2] + " x " + prices[2] + " = ");
		System.out.format("%.2f", sweetNum);
		
		double hotNum = num[3] = prices[3];
		System.out.print(salsas[3] + ":    " + num[3] + " x " + prices[3] + " = ");
		System.out.format("%.2f", hotNum);
		
		double zestyNum = num[4] = prices[4];
		System.out.print(salsas[4] + ":    " + num[4] + " x " + prices[4] + " = ");
		System.out.format("%.2f", zestyNum);
		
		System.out.println(\n---------------------);
		
		double totalNum = mildNum + mediumNum + sweetNum + hotNum + zestyNum + zestyNum;
		tax = tax =totalNum;
		System.out.print("\nTax: ");
		System.o
		
		
		
			
	}
}
