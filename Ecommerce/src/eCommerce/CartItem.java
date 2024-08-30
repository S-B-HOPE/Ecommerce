package eCommerce;

public class CartItem {
	 private Product product;
	    private int quantity;

	    public CartItem(Product product, int quantity) {
	        this.product = product;
	        this.quantity = quantity;
	    }

	    public Product getProduct() {
	        return product;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public double getTotalPrice() {
	        return product.getPrice() * quantity;
	    }

	    @Override
	    public String toString() {
	        return String.format("%s, Quantity: %d, Total Price: $%.2f", product, quantity, getTotalPrice());
	    }
}
