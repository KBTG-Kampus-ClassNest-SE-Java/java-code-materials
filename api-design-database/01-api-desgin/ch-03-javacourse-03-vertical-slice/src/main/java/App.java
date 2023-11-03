import cart.Cart;
import cart.CartProduct;
import domain.*;
import order.Order;
import product.Product;

public class App {
	public static void main(String[] args) {
		System.out.println("eCommerce App");

		Product iPhone = new Product(1, "iPhone");
		CartProduct cartProduct = new CartProduct(1, 2, iPhone);

		Cart cart = new Cart();
		cart.add(cartProduct);

		Checkout checkout = new Checkout();
		Order order = checkout.checkout(cart);

		System.out.println(order);
	}
}
