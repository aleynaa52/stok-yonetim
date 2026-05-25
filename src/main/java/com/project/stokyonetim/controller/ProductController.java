package com.project.stokyonetim.controller;

import com.project.stokyonetim.dto.ProductResponseDTO;
import com.project.stokyonetim.entity.Product;
import com.project.stokyonetim.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 1. Yeni Ürün Ekleme Kapısı (POST)
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // 2. Tüm Ürünleri Listeleme Kapısı (GET)
    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProductsDTO();
    }

    // 3. JİLET GİBİ YENİ GÜNCELLEME KAPISI (PUT) 🚀
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        // Hata veren satırı sildik tatlım! Doğrudan gelen veriye ID'yi enjekte ediyoruz.
        // Spring Data JPA bu ID'yi görünce sıfırdan eklemek yerine otomatik GÜNCELLEME (Update) yapar.
        productDetails.setId(id);

        // Mevcut kayıt metodun üzerinden pürüzsüzce veri tabanına işliyoruz
        return productService.saveProduct(productDetails);
    }
}