package Softwareengeeniring_finalproject;
import java.util.ArrayList;
import java.util.Iterator;

public class Stock {
	
	private ArrayList<Product> stock;
	
	public Stock(){
		this.stock = new ArrayList<Product>();
	}
	
	// add a new item
	public void addItem(Product p) {
		Product temp = searchItem(p.getName());
		if(temp == null) {
			this.stock.add(p);
			System.out.println("Item created successfully");
			System.out.println();
		}
		else {
			System.out.println("Item is already exist \n");
		}
	}
	
	// Search an item by name
	public Product searchItem(String name) {
		if (this.stock == null) {
			return null;
		}
		Iterator<Product> it = this.stock.iterator();
		while (it.hasNext()) {
			Product p = it.next();
			if (p.getName().equalsIgnoreCase(name)) {
				return p;
			}
		}
		return null;
	}
	
	//Check if the item is in stock
	public Product isInStock(String name) {
		Product p = searchItem(name);
		if (p==null) {
			System.out.println("The item "+ name + " is not in stock.");
			return null;
		}
		if (p.getQuantity() == 0) {
			this.RemoveItem(p.getName());
			System.out.println("The item "+ name + " is not in stock.");
			return null;
		}
		System.out.println("The item "+ name + " is in stock.");
		return p;		
	}
	
	// remove an item by name
	public void RemoveItem(String name) {
		Iterator<Product> it = this.stock.iterator();
		while (it.hasNext()) {
			Product p= it.next();
			if (p.getName().equals(name)) {
				it.remove();
				System.out.println("Item removed successfully.");
				System.out.println();
				return;
			}
		}
		System.out.println("Item doesn't exist.");
		System.out.println();
	}
	
	// print all shoes
	public void printAllShoes() {
		boolean flag = false;
		Iterator<Product> it = this.stock.iterator();
		System.out.println("**********Shoes list**********");
		while (it.hasNext()) {
			Product p= it.next();
			if (p instanceof Shoe) {
				if (p.getQuantity() == 0) {
					it.remove();
					continue;
				}
				System.out.println(p);
				flag=true;
			}
				
		}
		if (!flag)
			System.out.println("There are no shoes in stock. \n");
		System.out.println();
	}
	
	// print all shirts
	public void printAllShirts() {
		boolean flag = false;
		Iterator<Product> it = this.stock.iterator();
		System.out.println("**********Shirts list**********");
		while (it.hasNext()) {
			Product p= it.next();
			if (p instanceof Shirt) { 
				if (p.getQuantity() == 0) {
					it.remove();
					continue;
				}
				System.out.println(p);
				flag = true;
			}
		}
		if (!flag)
			System.out.println("There are no shirts in stock. \n");
		System.out.println();
	}
	
	// print all pants
	public void printAllPants() {
		boolean flag = false;
		Iterator<Product> it = this.stock.iterator();
		System.out.println("**********Pants list**********");
		while (it.hasNext()) {
			Product p= it.next();
			if (p instanceof Pants) {
				if (p.getQuantity() == 0) {
					it.remove();
					continue;
				}
				System.out.println(p);
				flag = true;
			}
		}
		if (!flag)
			System.out.println("There are no pants in stock. \n");
		System.out.println();
	}
	
	// print all stock
	public void printStock() {
		System.out.println("**********Our Stock**********");
		printAllShirts();
		printAllShoes();
		printAllPants();
		System.out.println();
	}
	
	
	//Sort stock by price
	public void sortByPrice() {
		quickSort(this.stock, 0, this.stock.size() - 1);
		System.out.println("Stock sorted successfully");
	}
	
	/*
	 * Internal functions:
	 */
	 static void quickSort(ArrayList<Product> itr, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int pi = partition(itr, firstIndex, lastIndex);
 
            quickSort(itr, firstIndex, pi - 1);
            quickSort(itr, pi + 1, lastIndex);
        }
	 }
	 
	 static int partition(ArrayList<Product> itr, int firstIndex, int lastIndex) {
		int pivot;
		int i = (firstIndex - 1);
		pivot = itr.get(lastIndex).getPrice();
        for (int j = firstIndex; j <= lastIndex - 1; j++) {
            if (itr.get(j).getPrice() < pivot) {
                i++;
                swap(itr, i, j);
            }
        }
        swap(itr, i + 1, lastIndex);
        return (i + 1);
    }
		 
	static void swap(ArrayList<Product> itr, int i, int j) {
		Product temp = itr.get(i);
		itr.set(i, itr.get(j));
		itr.set(j, temp);
    }
	

	
}