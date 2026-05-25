package com.project.stokyonetim.repository;


import com.project.stokyonetim.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Urun tablosu icin hazir veri tabani metotlarini barindirir
}
