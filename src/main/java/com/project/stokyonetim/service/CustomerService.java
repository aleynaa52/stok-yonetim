package com.project.stokyonetim.service;

import com.project.stokyonetim.entity.Customer;
import com.project.stokyonetim.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// Bu sinifin is mantigini yürüten bir servis katmani oldugunu Spring Boot'a bildirir
@Service
public class CustomerService {

    // Veri tabani sorgularini yapabilmek icin repository katmanini iceriye bagliyoruz (Dependency Injection)
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Postman'den gelen yeni musteri verisini veri tabanina kaydeder
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Veri tabanindaki tum musterileri liste halinde Postman'e doner
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

}
