package domain;

public class Checkout {

	public Order checkout(Cart cart) {
		return new Order(1, cart);
	}
}
