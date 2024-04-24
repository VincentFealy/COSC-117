/*
 * The private instance variables
 * along with the 6 public functions ( getters and setters)
 */
public class Inventory {
private String name;
private int stock;
private double price;
//private boolean available;	

	public void setName(String name) {
		this.name = name;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public int getStock() {
		return stock;
	}
	
	public double getPrice() { 
		return price;
	}
}
