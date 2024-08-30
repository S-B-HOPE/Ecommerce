package eCommerce;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	 private List<CartItem> items;

	    public ShoppingCart() {
	        this.items = new ArrayList<>();
	    }

	    public void addItem(Product product, int quantity) {
	        for (CartItem item : items) {
	            if (item.getProduct().getId().equals(product.getId())) {
	                item.setQuantity(item.getQuantity() + quantity);
	                return;
	            }
	        }
	        items.add(new CartItem(product, quantity));
	    }

	    public void removeItem(String productId) {
	        items.removeIf(item -> item.getProduct().getId().equals(productId));
	    }

	    public void viewCart() {
	        if (items.isEmpty()) {
	            System.out.println("Your cart is empty.");
	        } else {
	            for (CartItem item : items) {
	                System.out.println(item);
	            }
	        }
	    }

	    public double getTotalPrice() {
	        double total = 0;
	        for (CartItem item : items) {
	            total += item.getTotalPrice();
	        }
	        return total;
	    }

}
