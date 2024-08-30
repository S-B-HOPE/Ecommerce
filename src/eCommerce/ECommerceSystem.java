package eCommerce;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class ECommerceSystem {
	 private Map<String, Product> products;
	    private ShoppingCart cart;

	    public ECommerceSystem() {
	        products = new HashMap<>();
	        cart = new ShoppingCart();
	        initializeProducts();
	    }

	    private void initializeProducts() {
	        products.put("1", new Product("1", "Laptop", 999.99));
	        products.put("2", new Product("2", "Smartphone", 499.99));
	        products.put("3", new Product("3", "Headphones", 89.99));
	    }

	    public void start() {
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.println("\nWelcome to the E-Commerce System");
	            System.out.println("1. View Products");
	            System.out.println("2. Add to Cart");
	            System.out.println("3. View Cart");
	            System.out.println("4. Checkout");
	            System.out.println("5. Exit");
	            System.out.print("Select an option: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine();  // Consume newline

	            switch (choice) {
	                case 1:
	                    viewProducts();
	                    break;
	                case 2:
	                    addToCart(scanner);
	                    break;
	                case 3:
	                    viewCart();
	                    break;
	                case 4:
	                    checkout();
	                    break;
	                case 5:
	                    System.out.println("Thank you for shopping with us!");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        }
	    }

	    private void viewProducts() {
	        System.out.println("\nAvailable Products:");
	        for (Product product : products.values()) {
	            System.out.println(product);
	        }
	    }

	    private void addToCart(Scanner scanner) {
	        viewProducts();
	        System.out.print("Enter the product ID to add to cart: ");
	        String productId = scanner.nextLine();
	        System.out.print("Enter the quantity: ");
	        int quantity = scanner.nextInt();
	        scanner.nextLine();  // Consume newline

	        Product product = products.get(productId);
	        if (product != null) {
	            cart.addItem(product, quantity);
	            System.out.println("Product added to cart.");
	        } else {
	            System.out.println("Invalid product ID.");
	        }
	    }

	    private void viewCart() {
	        System.out.println("\nYour Shopping Cart:");
	        cart.viewCart();
	    }

	    private void checkout() {
	        System.out.println("\nCheckout:");
	        cart.viewCart();
	        System.out.printf("Total Price: $%.2f\n", cart.getTotalPrice());
	        cart = new ShoppingCart();  // Empty the cart after checkout
	    }

	    public static void main(String[] args) {
	        ECommerceSystem system = new ECommerceSystem();
	        system.start();
	    }
}
