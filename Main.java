package Softwareengeeniring_finalproject;

public class Main {
	
public static void main(String[] args) {
	
	Shop shop=new Shop();
	
	User u= new User("Admin", "1234", "admin@gmail.com", "Bar-Ilan", true);
	shop.shopUsers.addUser(u);
	Shirt shirt= new Shirt("ShirtOra", "female", 100, 50, "long", false, false, true);
	shop.shopStock.addItem(shirt);
	Shoe shoe= new Shoe("ShoeAmir", "male", 150, 30, 40, "nike", true, false, false);
	shop.shopStock.addItem(shoe);
	Pants pants= new Pants("PantsAsaf", "male", 200, 10, 50, false, true);
	shop.shopStock.addItem(pants);
	User user= new User("Maya", "1234", "maya@gmail.com", "Bar-Ilan", false);
	shop.shopUsers.addUser(user);
	shop.handleChoice();
		
}

}