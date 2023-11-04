### Product API

```java
@RestController
public class ProductController {

    @GetMapping("api/products")
    public List<Product> getProducts() {
        return List.of(new Product("iPhone"), new Product("Apple Watch"));
    }
}

class Product {

    private UUID id = UUID.randomUUID();
    @JsonProperty("name222")
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
```