package domain;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Cart {

	private UUID id = UUID.randomUUID();

	private List<CartProduct> cartProducts = List.of();

	public void add(CartProduct cartProduct) {
		cartProducts.add(cartProduct);
	}
}
