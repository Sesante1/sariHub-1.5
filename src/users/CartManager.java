
package users;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CartManager {
    
    static class CartItem {
        String productId;
        String productName;
        int quantity;
        double price;
        double totalAmount;

        CartItem(String productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
            this.totalAmount = quantity * price;
        }
    }
    
    ArrayList<CartItem> cart = new ArrayList<>();
    
    public void addToCart(String productId, String productName, int quantity, double price) {
        CartItem item = new CartItem(productId, productName, quantity, price);
        cart.add(item);
        JOptionPane.showMessageDialog(null, "Product added to cart!");
    }
    
    public void checkout() {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cart is empty!");
            return;
        }

        double totalPrice = 0;
        StringBuilder receipt = new StringBuilder("Checkout Summary:\n");

        for (CartItem item : cart) {
            receipt.append("Product: ").append(item.productName)
                    .append(", Quantity: ").append(item.quantity)
                    .append(", Price: ").append(item.price)
                    .append(", Total: ").append(item.totalAmount).append("\n");
            totalPrice += item.totalAmount;
        }

        receipt.append("Grand Total: ").append(totalPrice);
        JOptionPane.showMessageDialog(null, receipt.toString());
    }
    
    public void printAllOrders() {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cart is empty!");
            return;
        }

        System.out.println("All Orders:");
    for (CartItem item : cart) {
        System.out.println("Product ID: " + item.productId +
                           ", Product Name: " + item.productName +
                           ", Quantity: " + item.quantity +
                           ", Price: " + item.price +
                           ", Total: " + item.totalAmount);
    }
    }
}
