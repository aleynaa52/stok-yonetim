package entity;

import jakarta.persistence.*;
import java.util.List;

// Bu sinifin veri tabaninda bir tabloya karsilik geldigini sisteme bildirir
@Entity
// Veri tabanindeki tablonun adini kucuk harflerle 'customers' olarak ayarlar
@Table(name = "customers")
public class Customer {

    // Altindaki alanin tablonun birincil anahtari (ID) oldugunu belirtir
    @Id
    // ID numarasinin veri tabani tarafindan otomatik olarak birer birer artirilmasini saglar
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Bu kolonun veri tabaninda bos birakilamaz (NOT NULL) olacagini belirtir
    @Column(nullable = false)
    private String firstName;

    // Musterinin soyadi alani (Bos birakilamaz)
    @Column(nullable = false)
    private String lastName;

    // Musteri e-posta alani hem bos birakilamaz hem de sistemde benzersiz (unique) olmak zorundadır
    @Column(nullable = false, unique = true)
    private String email;

    // Musterinin cinsiyetini tutan alan (Postman analitik sorgulari icin kullanacagiz)
    @Column(nullable = false)
    private String gender;

    // 3N kurali: Bir musterinin birden fazla odemesi olabilir iliskisi (One to Many)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Payment> payments;

    // Parametresiz bos constructor (Spring Boot'un arka planda calisabilmesi icin sarttir)
    public Customer() {}

    // Musteri verilerine disaridan erisebilmek ve guncellemek icin Getter ve Setter metotlari
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public List<Payment> getPayments() { return payments; }
    public void setPayments(List<Payment> payments) { this.payments = payments; }
}