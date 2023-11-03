package order;

import cart.Cart;

public class Order {
	private int id;
	private Cart cart;

	public Order(int id, Cart cart) {
		this.id = id;
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Order{" +
			"id=" + id +
			", cart=" + cart +
			'}';
	}
}
