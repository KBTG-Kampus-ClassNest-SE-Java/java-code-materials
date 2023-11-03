package cart;

import product.Product;

public class CartProduct {
	private int id;
	private int quantity;
	private Product product;

	public CartProduct(int id, int quantity, Product product) {
		this.id = id;
		this.quantity = quantity;
		this.product = product;
	}
}
