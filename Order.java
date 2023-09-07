package Softwareengeeniring_finalproject;

import java.util.*;

import javax.swing.JOptionPane;

public class Order {
    private static int nextOrderId = 1; // Class-level variable for automatic order ID generation

    private ArrayList<Product> productList;
    private String user;
    private int orderId;
    private int price;
    private String status;
    private static Scanner scanner = new Scanner(System.in);

    public Order(String user) {
        this.productList = new ArrayList<Product>();
        this.user = user;
        this.orderId = nextOrderId++; // Assigns the current ID then increments the counter for the next order
        this.price = 0;
        this.status = "open"; // Default status
    }

    public String getUser() {
        return this.user;
    }

    public int getOrderNumber() {
        return this.orderId;
    }

    public int getOrderPrice() {
        return this.price;
    }

    public String getStatus() {
        return this.status;
    }

    public void addToOrder(Object obj) {
        if (!(obj instanceof Product)) {
            System.out.println("Invalid operation. Input is not a Product.");
            return;
        }
        Product product = (Product) obj;
        this.productList.add(product);
        this.price += product.getPrice();
        System.out.println("The item "+ product.getName()+ " has been added to the cart successfully.\n");
    }

    public void removeFromOrder(Object obj) {
        if (!(obj instanceof String)) {
            System.out.println("Invalid operation. Input is not a String.");
            return;
        }
        String productName = (String) obj;
        Product productToRemove = null;
        for (Product product : this.productList) {
            if (product.getName().equals(productName)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove == null) {
            System.out.println("Product not found in order.");
            return;
        }
        this.productList.remove(productToRemove);
        this.price -= productToRemove.getPrice();
        System.out.println("Product removed from order successfully.");
    }

    public void printOrder() {
        System.out.println("Order ID: " + this.orderId);
        System.out.println("User: " + this.user);
        System.out.println("Status: " + this.status);
        System.out.println("Total Price: " + this.price);
        System.out.println("Products:");

        // Create a map to consolidate product count and total price
        Map<Product, Integer> productCountMap = new HashMap<>();
        for (Product product : productList) {
            productCountMap.put(product, productCountMap.getOrDefault(product, 0) + 1);
        }

        // Print consolidated product information
        for (Map.Entry<Product, Integer> entry : productCountMap.entrySet()) {
            Product product = entry.getKey();
            int count = entry.getValue();
            System.out.println("- x" + count + " " + product.getName() + " " + (product.getPrice() * count) + "$ (" + product.getPrice() + "$ per each)");
        }
    }
    

        public int closeOrder() {
        	String answer = JOptionPane.showInputDialog("Are you sure you want to close the order? (yes/no)");
            if (answer.equalsIgnoreCase("yes")) {
                this.status = "Closed";
                JOptionPane.showMessageDialog(null, "Order closed successfully.", null, JOptionPane.PLAIN_MESSAGE);
                return 1;
            } else {
            	JOptionPane.showMessageDialog(null, "Order closure aborted", null, JOptionPane.PLAIN_MESSAGE);
                return 0;
            }
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Order ID: ").append(orderId).append("\n");
            sb.append("User: ").append(user).append("\n");
            sb.append("Status: ").append(status).append("\n");
            sb.append("Total Price: ").append(price).append("\n");
            sb.append("Products:\n");
            for (Product product : productList) {
                sb.append("- ").append(product.getName()).append("\n");
            }
            return sb.toString();
        }
    }
    
    


