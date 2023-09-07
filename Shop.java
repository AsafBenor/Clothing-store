package Softwareengeeniring_finalproject;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Shop {
	
	private Boolean isManager = false;
	protected Stock shopStock;
	protected Orders shopOrders;
	protected Users shopUsers;
	protected int totalProfit;
	private Scanner input2 = new Scanner(System.in);
	private Scanner input3 = new Scanner(System.in);
	private Scanner scanner4 =new Scanner(System.in);
	private Scanner scanner6 =new Scanner(System.in);
	private static Scanner scanner5 = new Scanner(System.in);
	
	public Shop(){
		this.shopStock = new Stock();
		this.shopOrders = new Orders();
		this.shopUsers = new Users();
	}
	
	// open shop options only for an existing user - or create a new user
	public void handleChoice() {
		String userName;
		String newUser="adagskdodoienfnncidieneh";
		
		while (true) {
			while (true) {
				JOptionPane.showMessageDialog(null, "Please enter user name, \n'New' to create a new user, \nor Exit to exit shop.", "Welcome!", JOptionPane.PLAIN_MESSAGE);
				userName= JOptionPane.showInputDialog("Enter userName: ");
				
				//exit
				if (userName.equals("Exit")) {
					JOptionPane.showMessageDialog(null, "Thanks for using the Online Computer Geek store! Hope to see you again soon. ", "Bye Bye!", JOptionPane.PLAIN_MESSAGE);
					return;
				}
				
				//create a new user
				else if (userName.equals("New")) {
					 newUser= CreateUser();
					 break;
				}
				
				//user doesn't exist
				else if (! shopUsers.IsUsernameExists(userName) && (!(userName.equals("New")))) {
					JOptionPane.showMessageDialog(null, "User does not exist. ", "Error!", JOptionPane.PLAIN_MESSAGE);
					continue;
				}
				 
				//An existing user has been entered
				else if (shopUsers.IsUsernameExists(userName)) { 
				     newUser = userName;
				     break;
				    }
			}
			
			
			if (shopUsers.searchUser(newUser).IsManager()) {
				HandleManager(newUser);
			}
			else if (shopUsers.IsUsernameExists(newUser)) {
				HandleCostemer(newUser);
			}
				
			}
	}
	
	// ****************** handle all users options  **************************

	private String CreateUser() {
		String userName;
		String email, password, address;
		// TODO Auto-generated method stub
		userName= JOptionPane.showInputDialog("Enter userName: ");
		while(this.shopUsers.IsUsernameExists(userName)) {
			JOptionPane.showMessageDialog(null, "Username already exists. Enter new username: ", "Error!", JOptionPane.PLAIN_MESSAGE);
			userName= JOptionPane.showInputDialog("Enter userName: ");
		}
		password = JOptionPane.showInputDialog("Enter Password: ");
		email = JOptionPane.showInputDialog("Enter Email: ");
		while(this.shopUsers.IsEmailExists(email)) {
			JOptionPane.showMessageDialog(null, "Email already exists. Enter new Email: ", "Error!", JOptionPane.PLAIN_MESSAGE);
			email = JOptionPane.showInputDialog("Enter Email: ");
		}
		address=JOptionPane.showInputDialog("Enter Address: ");
		User u = new User(userName, password, email, address, false);
		this.shopUsers.addUser(u);
		return userName;
	}


	// Handle shop if the user is a manager
	private void HandleManager(String userName ) {
		boolean flag=true;
		while (true) {
			if (flag) {
				JOptionPane.showMessageDialog(null, "Hi " + userName +
						" Welcome to Online Computer Geek store! \nPlease enter your password. ", "Welcome!", JOptionPane.PLAIN_MESSAGE);
				
				String password = JOptionPane.showInputDialog("Enter Password: ");
				int counter = 0;
				while(!this.shopUsers.isPasswordCorrect(userName, password)) {
					JOptionPane.showMessageDialog(null, "Wrong password, Please try again ", "Error!", JOptionPane.PLAIN_MESSAGE);
					password = JOptionPane.showInputDialog("Enter Password: ");
					counter++;
					if (counter==4) {
						JOptionPane.showMessageDialog(null, "Please try again later ", "Error!", JOptionPane.PLAIN_MESSAGE);
						return;
					}
						
				}
			flag=false;
			}
			
			int choice;
			printManagerChoice();
			choice = input2.nextInt();
			switch (choice) {
			case 1:
				UseStock(true,userName);
				break;
			case 2:
				ManageAdminChoice();
				break;
			case 3:
				ManageOrders();
				break;
			case 4:
				System.out.println("total shop profit is currently: " + totalProfit);
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "You have successfully logged out. ", "Bye Bye!", JOptionPane.PLAIN_MESSAGE);
				return;
			}
		}
	}


	private void HandleCostemer(String userName) {
		JOptionPane.showMessageDialog(null, "Hi " + userName +
				" Welcome to Online Computer Geek store! \nPlease enter your password. ", "Welcome!", JOptionPane.PLAIN_MESSAGE);
		
		String password = JOptionPane.showInputDialog("Enter Password: ");
		int counter=0;
		while(!this.shopUsers.isPasswordCorrect(userName, password)) {
			JOptionPane.showMessageDialog(null, "Wrong password, Please try again: ", "Error!", JOptionPane.PLAIN_MESSAGE);
			password = JOptionPane.showInputDialog("Enter Password: ");
			counter++;
			if (counter==4) {
				JOptionPane.showMessageDialog(null, "Please try again later ", "Error!", JOptionPane.PLAIN_MESSAGE);
				return;
			}
		}
		
		while (true) {
		    try {
		        printUserChoice();
		        int choice = input2.nextInt(); // this can throw InputMismatchException if the input is not an integer
		        switch (choice) {
		        case 1:
		            useOrder(userName);
		            break;
		        case 2:
		            UseStock(false, userName);
		            break;
		        case 0:
		            return; // exit the method (and thus break the loop)
		        default:
		            System.out.println("It's not a valid click, please try again.");
		            break;
		        }
		    } catch (InputMismatchException e) {
		        System.out.println("It's not a valid click, please try again.");
		        input2.next(); // consume the non-integer input
		    }
		}

	}


	
	// ***************** Main handle functions for every shop department *************

	private void ManageOrders() {
            while (true) {
            System.out.println("\n--- Order Management Menu ---");
            System.out.println("1. Place an order");
            System.out.println("2. Remove an order");
            System.out.println("3. View user orders");
            System.out.println("4. Calculate profit");
            System.out.println("5. Search by order id");
            System.out.println("6. Print all orders");
            System.out.println("7. Exit\n");
            System.out.println("Please select an option:");

            int option;
            try {
                option = Integer.parseInt(scanner5.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println("Enter username:");
                    String userName = scanner5.nextLine();
                    if (userName.isEmpty()) {
                        System.out.println("Invalid input. Username cannot be empty.");
                        break;
                    }
                    Order order = new Order(userName);
                    Orders.placeOrder(order, userName);
                    break;
                case 2:
                    System.out.println("Enter username and order id to remove the order:");
                    String userToRemove = scanner5.nextLine();
                    if (userToRemove.isEmpty()) {
                        System.out.println("Invalid input. Username cannot be empty.");
                        break;
                    }
                    int orderToRemoveId;
                    try {
                        orderToRemoveId = Integer.parseInt(scanner5.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Order id must be a number.");
                        break;
                    }
                    Order orderToRemove = shopOrders.SearcheBvld(orderToRemoveId);
                    if (orderToRemove != null) {
                        Orders.removeOrder(orderToRemove, userToRemove);
                    }
                    break;
                case 3:
                    System.out.println("Enter username to view orders:");
                    String userToView = scanner5.nextLine();
                    if (userToView.isEmpty()) {
                        System.out.println("Invalid input. Username cannot be empty.");
                        break;
                    }
                    ArrayList<Order> orders = Orders.getUserOrders(userToView);
                    if (orders != null) {
                        orders.forEach(Order::printOrder);
                    } else {
                        System.out.println("No orders found for the user.");
                    }
                    break;
                case 4:
                	System.out.println("total shop profit is currently: " + totalProfit);
                    break;
                case 5:
                    System.out.println("Enter order id to search:");
                    int searchOrderId;
                    try {
                        searchOrderId = Integer.parseInt(scanner5.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Order id must be a number.");
                        break;
                    }
                    Order searchedOrder = shopOrders.SearcheBvld(searchOrderId);
                    if (searchedOrder != null) {
                        searchedOrder.printOrder();
                    } else {
                        System.out.println("Order not found.");
                    }
                    break;
                case 6:
                    Orders.printAllOrders();
                    break;
                case 7:
                    System.out.println("Exiting the Order Management Menu.");
                    return;
                default:
                    System.out.println("Invalid option. Please select between 1 and 7.");
                    break;
            }
        }
    }


	private void ManageAdminChoice() {
		String username,password, email, address;
		Scanner in = new Scanner(System.in);
		int choice;
		while (true) {
			printAdminMenu();
			choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter new username: ");
				username = in.next();
				while(this.shopUsers.IsUsernameExists(username)) {
					System.out.println("Username already exists. Enter new username: ");
					username = in.next();
				}
				System.out.println("Choose Password: ");
				password = in.next();
				System.out.println("Choose Email: ");
				email = in.next();
				while(this.shopUsers.IsEmailExists(email)) {
					System.out.println("Email already exists. Enter new Email: ");
					email = in.next();
				}
				System.out.println("Choose Address: ");
				address=in.next();
				User u = new User(username, password, email, address, true);
				this.shopUsers.addUser(u);
				break;
			case 2:
				System.out.println("Enter the username you want to remove: ");
				username = in.next();
				this.shopUsers.removeUser(username);
				break;
			case 3:
				this.shopUsers.printAllUsers();
				break;
			case 0:
                System.out.println("Exiting the users Management Menu.");
                return;
            default:
                System.out.println("Invalid option. Please select between 0 and 3.");
                break;
			}
		}
	}
	
	
	private void UseStock(Boolean isManager, String userName) {
		Order theOrder= new Order(userName);
		Orders.placeOrder(theOrder, userName);
		int choice;
		String name;
		String gender;
		int Price;
		int Quantity;
		String sleeveLen;
		int TempInteger;
		Boolean slimFit;
		Boolean buttons;
		Boolean collar;
		String productToSearch;
		int Size;
		String Brand;
		Boolean Slides;
		Boolean Heels;
		Boolean Laces;
		Boolean Jeans;
		Boolean Formal;
		int Pantslen;
		int x;
		while (true) {
			printChoicesInStock();
			if (isManager)
				printAdditionalManagerStock();
			choice = input3.nextInt();
			switch (choice) {
			case 1:
				shopStock.printStock();
				break;
				
			case 2:
				shopStock.printAllPants();
				break;
				
			case 3:
				shopStock.printAllShoes();
				break;
				
			case 4:
				shopStock.printAllShirts();
				break;
				
			case 5:
				shopStock.sortByPrice();
				shopStock.printStock();
				break;
				
			case 6:
				System.out.println("Enter product for searching : \n");
				productToSearch = input2.next();
				if (null != shopStock.isInStock(productToSearch))
					System.out.println(shopStock.searchItem(productToSearch).toString());
				else
					 System.out.println("Product is not in stock... ");
				break;
				
			case 7:
				System.out.println("Enter product name: \n");
				productToSearch = input2.next();
				if (null != shopStock.isInStock(productToSearch)) {
					theOrder.addToOrder(shopStock.searchItem(productToSearch));
					
				}
				else
					 System.out.println("Product is not in stock... ");
				break;
				
			case 11:
				if (isManager) {
					System.out.println("Enter product name : \n");
					name = input2.next();
					System.out.println("Enter product Gender : \n");
					gender = input2.next();
					System.out.println("Enter product price : \n");
					Price = input3.nextInt();
					System.out.println("Enter product quantety : \n");
					Quantity = input3.nextInt();
					System.out.println("Enter Shoe size : \n");
					Size = input3.nextInt();
					System.out.println("Enter Shoe brand : \n");
					Brand = input2.next();
					System.out.println("Are shoes Slides? 0 - no 1 - yes : \n");
					TempInteger = input3.nextInt();
					Slides = (TempInteger == 0) ? false : true;
					System.out.println("Do shoes have heels? 0 - no 1 - yes : \n");
					TempInteger = input3.nextInt();
					Heels = (TempInteger == 0) ? false : true;
					System.out.println("Do shoes have laces? 0 - no 1 - yes : \n");
					TempInteger = input3.nextInt();
					Laces = (TempInteger == 0) ? false : true;
					
					Shoe sho = new Shoe(name, gender, Price, Quantity, Size, Brand, Slides, Heels, Laces);
					shopStock.addItem(sho);
				} 
					break;
				

		
			case 12:
				if (isManager) {
					System.out.println("Enter product name : \n");
					name = input2.next();
					System.out.println("Enter product Gender : \n");
					gender = input2.next();
					System.out.println("Enter product price : \n");
					Price = input3.nextInt();
					System.out.println("Enter product quantety : \n");
					Quantity = input3.nextInt();
					System.out.println("Enter Shirt sleeve length : \n");
					sleeveLen = input2.next();
					System.out.println("Is the shirt slimfit? 0 - no 1 - yes : \n");
					TempInteger = input3.nextInt();
					slimFit = (TempInteger == 0) ? false : true;
					System.out.println("Does the shirt have buttens? 0 - no 1 - yes : \n");
					TempInteger = input3.nextInt();
					buttons = (TempInteger == 0) ? false : true;
					System.out.println("Does the shirt have a collar? 0 - no 1 - yes : \n");
					TempInteger = input3.nextInt();
					collar = (TempInteger == 0) ? false : true;
					
					Shirt sh = new Shirt(name, gender, Price, Quantity, sleeveLen, slimFit, buttons, collar);
					shopStock.addItem(sh);
				}

				break;
				
			case 13:
				if (isManager) {
					System.out.println("Enter product name : \n");
					name = input2.next();
					System.out.println("Enter product Gender : \n");
					gender = input2.next();
					System.out.println("Enter product price : \n");
					Price = input3.nextInt();
					System.out.println("Enter product quantety : \n");
					Quantity = input3.nextInt();
					System.out.println("Enter pants length : \n");
					Pantslen = input3.nextInt();
					System.out.println("Are pants jeans? 0 - no 1 - yes : \n");
					TempInteger = input3.nextInt();
					Jeans = (TempInteger == 0) ? false : true;
					System.out.println("Are pants formal? 0 - no 1 - yes : \n");
					TempInteger = input3.nextInt();
					Formal = (TempInteger == 0) ? false : true;
							
					Pants p = new Pants(name, gender, Price, Quantity, Pantslen, Jeans, Formal);
					shopStock.addItem(p);
				}

				break;
				
			case 14:
				if (isManager) {
					System.out.println("Enter product name you would like to set quantety : \n");
					name = input2.next();
					if ( null == shopStock.isInStock(name))
						System.out.println("product is not in stock \n");
					else {
						System.out.println("Current product quantety: " + shopStock.searchItem(name).getQuantity() + " Enter quantety to set to : \n");
						Quantity = input3.nextInt();
						shopStock.searchItem(name).setQuantity(Quantity);
						System.out.println(name + " quantety was succesfully set to" + Quantity +" \n");
					}
				}

				break;
				
			case 15:
				if (isManager) {
					System.out.println("Enter product name you would like to set price : \n");
					name = input2.next();
					if ( null == shopStock.isInStock(name))
						System.out.println("product is not in stock \n");
					else {
						System.out.println("Current product price: " + shopStock.searchItem(name).getPrice() + " Enter quantety to set to : \n");
						Price = input3.nextInt();
						shopStock.searchItem(name).setPrice(Price);
						System.out.println(name + " price was succesfully set to" + Price +" \n");
					}
				}

				break;
				
			case 16:
				if (isManager) {
					System.out.println("Enter product name you would like to remove : \n");
					name = input2.next();
					if ( null == shopStock.isInStock(name))
						System.out.println("product is not in stock \n");
					else {
						shopStock.RemoveItem(name);
					}
				}

				break;
				
			case 8:
				System.out.println("Please enter the product to remove:");
				input2.nextLine(); // This is to consume the newline after the nextInt()
                String productNameToRemove = input2.nextLine();
                theOrder.removeFromOrder(productNameToRemove);
                break;
                
			case 9:
				theOrder.printOrder();
                break;
                
			case 10:
				x=theOrder.closeOrder();
				if (x==1)
				{
					totalProfit+=theOrder.getOrderPrice();
					return;
				}
				break;
				
				
			
			case 0:
				Orders.removeOrder(theOrder, userName);
				return;
				
			}	
		}
	}

	private void useOrder(String username) {
	    ArrayList<Order> userOrderList = Orders.getUserOrders(username);

	    if(userOrderList == null || userOrderList.isEmpty()) {
	        System.out.println("You do not have any orders.");
	        return;
	    }

	    // Print all user orders.
	    //for(Order order : userOrderList) {
	        //System.out.println(order.toString());
	    	userOrderList.forEach(Order::printOrder);
	   // }

	   /* if(userOrderList.size() > 1) {
	        System.out.println("Please choose the order you want to see. Enter order number:");
	        for(int i=0; i<userOrderList.size(); i++) {
	            System.out.println((i+1) + ". " + userOrderList.get(i).getOrderNumber());
	        }

	        int selectedOrderIndex = scanner4.nextInt() - 1; // Adjusting the index to 0 based.
	        if(selectedOrderIndex < 0 || selectedOrderIndex >= userOrderList.size()) {
	            System.out.println("Invalid selection");
	            return;
	        }
	        Order selectedOrder = userOrderList.get(selectedOrderIndex);
	        
	        System.out.println(selectedOrder.toString());

	        
	    }
	    else {
	    	System.out.println(userOrderList.get(0).toString());
	    }*/
	}
	
	
	
	// *********** PRINT MENU FUNCTIONS ********************

	private void printManagerChoice() {
		  System.out.println("Welcome Manager! What would you like to do?");
		  System.out.println("Choose 	1	to Manage Stock");
		  System.out.println("Choose 	2	to Manage Users");
		  System.out.println("Choose 	3	to Manage Orders");
		  System.out.println("Choose 	4	to view total shop profit");
		  System.out.println("Choose 	0	to log out");
	}
	
	private void printUserChoice() {
		  System.out.println("Choose 	1	to view your orders");
		  System.out.println("Choose 	2	to make a new order and view our collection");
		  System.out.println("Choose 	0	to sign out");
	}
	
	private void printChoicesInStock() {
		  System.out.println("What would you like to do? ");
		  System.out.println("Choose 	1	to print all cloths in stock");
		  System.out.println("Choose 	2	to print all pants");
		  System.out.println("Choose 	3	to print all shoes");
		  System.out.println("Choose 	4	to print all shirts");
		  System.out.println("Choose 	5	to print collection sorted by price");
		  System.out.println("Choose 	6	to search for a certain product");
		  System.out.println("Choose 	7	to add a product to cart");
		  System.out.println("Choose 	8	to remove a product from the cart");
		  System.out.println("Choose 	9	to view the cart");
		  System.out.println("Choose 	10	to order and exit");
		  System.out.println("Choose 	0	to exit and cancle the carts");
	}
	
	private void printAdditionalManagerStock() {
		  System.out.println(" *****MANAGER ONLY***** ");
		  System.out.println("Choose 	11	to add a new shoe to the shop");
		  System.out.println("Choose 	12	to add a new shirt to the shop");
		  System.out.println("Choose 	13	to add new pants to the shop");
		  System.out.println("Choose 	14	to set quantety for a product");
		  System.out.println("Choose 	15	to set price for a product");
		  System.out.println("Choose 	16	to remove a product from shop");
	}
	
	private void printAdminMenu() {
		System.out.println(" *****MANAGER ONLY***** ");
		System.out.println("Choose 	1	to add a new user");
		System.out.println("Choose 	2	to remove a user");
		System.out.println("Choose 	3	to print all the users");
		System.out.println("Choose 	0	to exit users menu");
		
	}
		
    }

