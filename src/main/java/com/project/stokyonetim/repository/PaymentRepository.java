package com.project.stokyonetim.repository;

import com.project.stokyonetim.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Odeme ve satis tablosu icin hazir veri tabani metotlarini barindirir
}
