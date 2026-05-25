package com.project.stokyonetim.entity;

import com.fasterxml.jackson.annotation.JsonBackReference; // Döngüyü tamamen bitiren sihirli kütüphanemiz!
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Bu urun satirinin hangi ana siparise bagli oldugunu belirtir
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonBackReference // 🚀 Döngüyü kırmak için bu alanı arkaya gizledik, veriyi pürüzsüzleştirdik!
    private Order order;

    // Siparis edilen urun (Product) baglantisi
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Bu urunden kac adet siparis verildigi (Stoktan dusecek miktar!)
    @Column(nullable = false)
    private int quantity;

    // Siparis anindaki urun fiyati (Gelecekte urun fiyati degisse bile gecmis fatura bozulmasin diye)
    @Column(nullable = false)
    private BigDecimal price;

    // Bos constructor
    public OrderItem() {}

    // Getter ve Setter Metotlari
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}