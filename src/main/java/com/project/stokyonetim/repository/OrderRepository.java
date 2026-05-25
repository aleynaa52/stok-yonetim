package com.project.stokyonetim.repository;

import com.project.stokyonetim.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Spring Data JPA sağ olsun, tüm ekleme, silme ve listeleme metotları otomatik hazır!
}