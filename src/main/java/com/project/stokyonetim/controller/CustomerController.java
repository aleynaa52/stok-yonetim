package com.project.stokyonetim.controller;

import com.project.stokyonetim.entity.Customer;
import com.project.stokyonetim.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Bu sinifin dis dunyaya acilan bir API kapisi (REST Controller) oldugunu bildirir
@RestController
// Postman'den bu kapıya ulasmak icin kullanacagimiz ana istek adresini belirler
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Postman'den POST istegiyle gelen musteri verisini servise gonderip kaydeder
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    // Postman'den GET istegi atildiginda tum musterileri ekrana listeler
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
