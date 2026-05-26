package com.project.stokyonetim.service;

import com.project.stokyonetim.dto.ProductResponseDTO;
import com.project.stokyonetim.entity.Product;
import com.project.stokyonetim.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<ProductResponseDTO> getAllProductsDTO() {
        return productRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    private ProductResponseDTO convertToResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setSku(product.getSku());
        dto.setName(product.getName());
        dto.setBrand(product.getBrand());
        dto.setModel(product.getModel());
        dto.setStockQuantity(product.getStockQuantity());
        dto.setPrice(product.getPrice());

        if (product.getSupplier() != null) {
            dto.setSupplierCompanyName(product.getSupplier().getName());  // DEĞİŞTİ
            dto.setSupplierId(product.getSupplier().getId());             // YENİ
        }
        return dto;
    }

    @org.springframework.transaction.annotation.Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}