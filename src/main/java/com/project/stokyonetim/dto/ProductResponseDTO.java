package com.project.stokyonetim.dto;

import java.math.BigDecimal;

// Postman ekranina urun detaylarini basarken kullanacagimiz temiz yuzlu sinif
public class ProductResponseDTO {

    private Long id;
    private String sku;
    private String name;
    private String brand;
    private String model;
    private int stockQuantity;
    private BigDecimal price;

    // Veri tabanindaki karmasik Supplier tablosu yerine sadece sirket adini gosterecegiz
    private String supplierCompanyName;

    // Bos constructor
    public ProductResponseDTO() {}

    // Getter ve Setter metotlari
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public String getSupplierCompanyName() { return supplierCompanyName; }
    public void setSupplierCompanyName(String supplierCompanyName) { this.supplierCompanyName = supplierCompanyName; }
}
