package com.project.stokyonetim.controller;

import com.project.stokyonetim.entity.Order;
import com.project.stokyonetim.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Postman'den sipariş fırlatma kapısı (POST)
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
}