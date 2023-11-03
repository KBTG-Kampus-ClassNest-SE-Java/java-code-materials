package presentation;

import domain.Product;

public class ProductPresentation {
	public void present() {
		Product product = new Product(1, "iPhone");
		System.out.println("Product: " + product.getName());
	}
}
