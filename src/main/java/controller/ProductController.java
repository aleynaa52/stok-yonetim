package controller;

import dto.ProductResponseDTO;
import entity.Product;
import service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Postman'den GET istegi gelince urunleri DTO formatinda temizce doner
    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProductsDTO();
    }
}
