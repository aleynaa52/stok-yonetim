package com.project.stokyonetim.repository;

import com.project.stokyonetim.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // 🚀 ÇÖZÜM: Veritabanında mükerrer e-posta kontrolü yapıp projeyi çöküşten kurtaran akıllı metot!
    Optional<Customer> findByEmail(String email);
}