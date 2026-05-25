package com.project.stokyonetim.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference; // Sihirli kütüphanemizi buraya da ekledik!
import jakarta.persistence.*;
import java.util.List;

// Bu sinifin veri tabaninda bir tablo oldugunu belirtir
@Entity
// Tablo adini 'suppliers' (tedarikciler) yapar
@Table(name = "suppliers")
public class Supplier {

    // Otomatik artan birincil anahtar (ID) tanimlamasi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Toptanci firmanin adi (Bos birakilamaz ve sistemde ayni isimden iki firma olamaz)
    @Column(nullable = false, unique = true)
    private String companyName;

    // Toptanci firmaya ulasilacak resmi e-posta adresi
    @Column(nullable = false)
    private String contactEmail;

    // Bir tedarikcinin depomuza getirdigi bircok urun olabilir iliskisi
    @OneToMany(mappedBy = "supplier")
    @JsonManagedReference // 🚀 Döngüyü yöneten ana taraf burası dedik, pürüzleri temizledik!
    private List<Product> products;

    // Bos constructor
    public Supplier() {}

    // Standart Getter ve Setter kapsulleme (Encapsulation) metotlari
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}