package domain;

public class Order {
	private int id;
	private Cart cart;

	public Order(int id, Cart cart) {
		this.id = id;
		this.cart = cart;
	}
}
