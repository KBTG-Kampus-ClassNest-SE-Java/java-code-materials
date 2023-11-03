package data;

import domain.Product;

public class ProductRepository {
	public Product getProduct(int id) {
		return new Product(1, "iPhone");
	}
}
