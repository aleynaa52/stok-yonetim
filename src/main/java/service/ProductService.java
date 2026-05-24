package service;

import dto.ProductResponseDTO;
import entity.Product;
import repository.ProductRepository;
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

    // Veri tabanindan gelen urun listesini DTO listesine donusturen profesyonel metot
    public List<ProductResponseDTO> getAllProductsDTO() {
        return productRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    // Ham urun verisini alip sadece ihtiyacimiz olan alanlari kalkan arkasina alan yardimci metot
    private ProductResponseDTO convertToResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setSku(product.getSku());
        dto.setName(product.getName());
        dto.setBrand(product.getBrand());
        dto.setModel(product.getModel());
        dto.setStockQuantity(product.getStockQuantity());
        dto.setPrice(product.getPrice());

        // Eger urunun bir tedarikcisi varsa sadece sirket adini DTO'ya setle
        if (product.getSupplier() != null) {
            dto.setSupplierCompanyName(product.getSupplier().getCompanyName());
        }
        return dto;
    }
}
