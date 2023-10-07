package com.example.javacourse;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> listProduct() {
        return productService.getProductList();
    }

}

@Service
class ProductService {

    public List<Product> getProductList() {
        return List.of(new Product("Phone"));
    }
}

record Product(String name) {}