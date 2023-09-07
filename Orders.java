package Softwareengeeniring_finalproject;
import java.util.*;

public class Orders {
    private static ArrayList<Order> orderList = new ArrayList<Order>();
    private static Map<String, ArrayList<Order>> userOrders = new HashMap<>();

    public static void placeOrder(Order order, String userName) {
        orderList.add(order);
        userOrders.putIfAbsent(userName, new ArrayList<>());
        userOrders.get(userName).add(order);
    }

    public static void removeOrder(Order order, String userName) {
        if (!orderList.contains(order)) {
            System.out.println("Order not found.");
            return;
        }
        orderList.remove(order);
        userOrders.get(userName).remove(order);
        System.out.println("Order removed successfully.");
    }

    public static ArrayList<Order> getUserOrders(String username) {
        return userOrders.get(username);
    }

    public Order SearcheBvld(Object obj) {
        if (!(obj instanceof Integer)) {
            System.out.println("Invalid operation. Input is not an Integer.");
            return null;
        }
        int orderId = (Integer) obj;
        for (Order order : this.orderList) {
            if (order.getOrderNumber() == orderId) {
                return order;
            }
        }
        System.out.println("Order not found.");
        return null;
    }
    
    
    public static void printAllOrders() {
        if (orderList.isEmpty()) {
            System.out.println("No orders to display.");
        } else {
            for (Order order : orderList) {
                order.printOrder();
            }
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orderList) {
            sb.append(order.toString()).append("\n");
        }
        return sb.toString();
    }
}
