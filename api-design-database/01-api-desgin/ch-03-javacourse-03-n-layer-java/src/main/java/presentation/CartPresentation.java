package presentation;

import domain.Cart;
import domain.CartProduct;
import domain.Product;

public class CartPresentation {
	public void present() {
		Cart cart = new Cart();
		Product iPhone = new Product(1, "iPhone");

		CartProduct cartProduct = new CartProduct(1, 2, iPhone);
		cart.add(cartProduct);

		
	}
}
