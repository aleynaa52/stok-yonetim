package com.project.stokyonetim.repository;

import com.project.stokyonetim.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    // Toptanci tablosu icin hazir veri tabani metotlarini barindirir
}
