package Softwareengeeniring_finalproject;
public abstract class Product{
	protected String name;
	protected String gender;
	protected int price;
	protected int quantity;
	
	// Constructor 
	public Product(String Name, String Gender, int Price, int Quantity) {
		this.name = Name;
		this.gender = Gender;
		this.price = Price;
		this.quantity = Quantity;
	}
	
	/*
	 *    Getters 
	 */
	public String getName() {
		return this.name;
	}

	public String getGender() {
		return this.gender;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	/*
	 *    setters
	 */
	
	public void setName(String Name) {
		this.name = Name;
	}

	public void setGender(String Gender) {
		this.gender = Gender;
	}
	
	public void setPrice(int Price) {
		this.price = Price;
	}
	
	public void setQuantity(int Quantity) {
		if (Quantity < 0)
			this.quantity= 0;
		else
			this.quantity= Quantity;
	}
	
	
	
	public String toString() {
		return "Name: " + this.name +"\nGender: " + this.gender + "\nPrice: " + this.price + "\nQuantity: " + this.quantity;
	}
}