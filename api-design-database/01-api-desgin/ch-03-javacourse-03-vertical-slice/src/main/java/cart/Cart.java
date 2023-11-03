package cart;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {

	private UUID id = UUID.randomUUID();

	private List<CartProduct> cartProducts = new ArrayList<>();

	public void add(CartProduct cartProduct) {
		cartProducts.add(cartProduct);
	}
}
