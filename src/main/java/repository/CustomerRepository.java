package repository;

import entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Bu arayuzun veri tabani sorgu merkezi oldugunu Spring Boot'a bildirir
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // JpaRepository sayesinde ekleme, silme, guncelleme sorgulari otomatik olarak hazir gelir.
    // Kutu icindeki 'Customer' hangi tabloya bakacagini, 'Long' ise o tablonun ID tipini gosterir.
}
