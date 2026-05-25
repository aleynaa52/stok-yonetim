package com.project.stokyonetim.service;

import com.project.stokyonetim.dto.PaymentRequestDTO;
import com.project.stokyonetim.entity.Customer;
import com.project.stokyonetim.entity.Payment;
import com.project.stokyonetim.repository.CustomerRepository;
import com.project.stokyonetim.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final CustomerRepository customerRepository;

    public PaymentService(PaymentRepository paymentRepository, CustomerRepository customerRepository) {
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
    }

    // Postman'den gelen DTO'yu alip veri tabanina gerçek bir odeme kaydi olarak atan akilli metot
    public Payment processPayment(PaymentRequestDTO requestDTO) {
        // Postman'den gelen ID ile veri tabaninda oyle bir musteri var mi diye bakiyoruz, yoksa hata donuyoruz
        Customer customer = customerRepository.findById(requestDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Musteri bulunamadi!"));

        Payment payment = new Payment();
        payment.setCustomer(customer);
        payment.setAmount(requestDTO.getAmount());
        payment.setPaymentMethod(requestDTO.getPaymentMethod());
        // Sistem o anki saati ve tarihi otomatik olarak ekler, elle girilmesine gerek kalmaz
        payment.setPaymentDate(LocalDateTime.now());

        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
