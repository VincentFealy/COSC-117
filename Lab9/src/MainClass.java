/*
 * Vincent Fealy
 * Lab 9
 * This lab controls stock prices using 2 separate classes within the same program
 * This is the main class while the other is for the inventory
 * classes with subroutines
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class MainClass {

	public static void main(String[] args) {
		Inventory[] inventory = new Inventory[5];
		Scanner sc = new Scanner (System.in);
		
		for(int i = 0; i < inventory.length; i++) {
			inventory[i] = new Inventory();
		}
		
		System.out.println("Enter stock inventory details Info \n");
		System.out.println("---------------------------------- \n");
		
		for(int i = 0; i < inventory.length; i++) {
			System.out.println("Item " + (i+1) + ": ");
			
			System.out.print("Enter name of item: ");
			String name = sc.nextLine();
			inventory[i].setName(name);
			System.out.println();
			
			System.out.print("Enter stock of this item: ");
			int stock = Integer.parseInt(sc.nextLine());
			inventory[i].setStock(stock);
			System.out.println();
			
			System.out.print("Enter price of this item: ");
			double price = Double.parseDouble(sc.nextLine());
			inventory[i].setPrice(price);
			System.out.println();
		}
		showInventory(inventory);
		System.out.println();
		printInventory(inventory);

	}
	//stores the 3 values inside the inventory class
	public static void showInventory(Inventory[] inventory) {
		for(int i = 0; i < inventory.length; i++) {
			
			System.out.println("Item "+ (i+1) + ": ");
			System.out.println("Name: " + inventory[i].getName());
			System.out.println("Stock: " + inventory[i].getStock());
			System.out.println("Price: " + inventory[i].getPrice());
		}
	}
	//while this static void functions actually prints to the console what the user inputs
	public static void printInventory(Inventory[] inventory) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Which file do u want to write this?: ");
		String fileName = sc.nextLine();
		
		try {
			FileWriter file = new FileWriter(fileName);
			for(int i = 0; i < inventory.length; i++) {
				file.write("Item " + (i+1) + ": \n");
				file.write("Name: " + inventory[i].getName() + "\n");
				file.write("Stock: " + inventory[i].getStock() + "\n");
				file.write("Price: " + inventory[i].getPrice() + "\n");
			}
			file.close();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}



