package dto;

import java.math.BigDecimal;

// Postman'den yeni bir odeme kaydi alirken kullanacagimiz guvenlik kalkanı sinifi
public class PaymentRequestDTO {

    // Musterinin veri tabanindaki benzersiz numarasi
    private Long customerId;

    // Postman'den gonderilecek odeme tutari (Kuruslu kurumsal format)
    private BigDecimal amount;

    // Odemenin hangi yontemle yapildigi (Ornegin: CASH, CREDIT_CARD)
    private String paymentMethod;

    // Bos constructor
    public PaymentRequestDTO() {}

    // Verilerin aktarilmasini saglayan standart Getter ve Setter metotlari
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}
