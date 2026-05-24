package entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

// Bu sinifin veri tabaninda bir tabloya karsilik geldigini sisteme bildirir
@Entity
// Veri tabanindaki tablonun adini kucuk harflerle 'payments' olarak ayarlar
@Table(name = "payments")
public class Payment {

    // Otomatik artan birincil anahtar (ID) tanimlamasi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Odeme tutari alani. Kurumsal dunya standardina uygun sekilde kuruslu fiyatlari tutar (Bos birakilamaz)
    @Column(nullable = false)
    private BigDecimal amount;

    // Odemenin yapildigi tam tarihi ve saati tutar (Postman'de tarihe gore ciro sorgularken kullanacagiz)
    @Column(nullable = false)
    private LocalDateTime paymentDate;

    // Odemenin hangi yontemle yapildigini tutar (Ornegin: 'CREDIT_CARD', 'CASH')
    @Column(nullable = false)
    private String paymentMethod;

    // 3N Normalizasyonu: Cok sayidaki odeme tek bir musteriye baglidir iliskisi
    @ManyToOne
    // Veri tabaninda baglanti kurulacak yabanci anahtar (Foreign Key) kolonunun adi
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // Bos constructor (Spring Boot'un arka planda calisabilmesi icin sarttir)
    public Payment() {}

    // Verilere disaridan guvenli erisim saglayan Getter ve Setter metotlari
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
