package com.project.stokyonetim.repository;

import com.project.stokyonetim.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // JpaRepository sayesinde ekleme, silme, guncelleme sorgulari otomatik olarak hazir gelir.
}