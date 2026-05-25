package com.project.stokyonetim.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference; // Döngüyü kıran sihirli kütüphanemiz!
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Siparişin verildiği anlık tarih ve saat
    @Column(nullable = false)
    private LocalDateTime orderDate;

    // Siparişteki tüm ürünlerin toplam fatura tutarı
    @Column(nullable = false)
    private BigDecimal totalAmount;

    // Her sipariş mutlaka sistemdeki bir müşteriye (Customer) ait olmalıdır
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // Bir siparişin içinde birden fazla ürün kalemi (satırı) bulunabilir
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference // 🚀 Postman'deki o iç içe geçen yılan döngüsünü kıran yönetim etiketi!
    private List<OrderItem> orderItems;

    // Sipariş veri tabanına ilk kez yazılırken tarihi otomatik olarak o anki zaman yapar
    @PrePersist
    protected void onCreate() {
        this.orderDate = LocalDateTime.now();
    }

    // Boş constructor
    public Order() {}

    // Getter ve Setter Metotları
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }
}