package com.project.stokyonetim.entity;


import jakarta.persistence.*;
import java.math.BigDecimal;

// Bu sinifin veri tabaninda 'products' tablosuna karsilik geldigini bildirir
@Entity
@Table(name = "products")
public class Product {

    // Otomatik artan benzersiz urun ID'si
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Urunun barkod numarasi (SKU). Bos birakilamaz ve her urunun barkodu benzersizdir
    @Column(nullable = false, unique = true)
    private String sku;

    // Urunun piyasa adi (Ornegin: Akilli Saat, Altin Kolye vb.)
    @Column(nullable = false)
    private String name;

    // Urunun markasi (Filtreleme islemlerinde Postman'de kullanacagiz)
    @Column(nullable = false)
    private String brand;

    // Urunun modeli (Urunleri ayirt etmek ve detayli arama yapmak icin)
    @Column(nullable = false)
    private String model;

    // Depoda bu urunden anlik olarak kac adet kaldigini tutan kritik stok miktari
    @Column(nullable = false)
    private int stockQuantity;

    // Kurumsal dunya standardina uygun sekilde urunun kuruslu fiyatini tutan alan
    @Column(nullable = false)
    private BigDecimal price;

    // 3N Normalizasyonu: Cok sayidaki urun tek bir tedarikciye baglidir iliskisi
    @ManyToOne
    // Veri tabaninda baglanti kurulacak yabanci anahtar (Foreign Key) kolonunun adi
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    // Bos constructor
    public Product() {}

    // Verilere guvenli erisim saglayan Getter ve Setter metotlari
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
    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
}