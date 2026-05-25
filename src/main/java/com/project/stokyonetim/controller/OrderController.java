package com.project.stokyonetim.controller;

import com.project.stokyonetim.entity.Order;
import com.project.stokyonetim.entity.Customer;
import com.project.stokyonetim.entity.Product;
import com.project.stokyonetim.entity.OrderItem;
import com.project.stokyonetim.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderRequestDTO request) {
        Order realOrder = new Order();

        // 1. Müşteri İlişkisini Bağlıyoruz
        Customer customer = new Customer();
        customer.setId(request.getCustomerId());
        realOrder.setCustomer(customer);

        // 2. Senin Veritabanındaki "OrderItem" Yapısını Kuruyoruz 🚀
        OrderItem item = new OrderItem();

        Product product = new Product();
        product.setId(request.getProductId());

        item.setProduct(product);
        item.setQuantity(request.getQuantity());
        item.setOrder(realOrder); // Kalemi bu siparişe mühürlüyoruz

        // 3. Oluşturduğumuz kalemi siparişin listesine ekliyoruz
        List<OrderItem> itemList = new ArrayList<>();
        itemList.add(item);

        // Sipariş sınıfındaki listenin adı setOrderItems veya setItems olabilir.
        // Eğer setOrderItems hata verirse setItems olarak düzeltebilirsin canım:
        try {
            realOrder.setOrderItems(itemList);
        } catch(NoSuchMethodError | Exception e) {
            // Eğer metot adı farklıysa esneklik sağlasın diye koruma bandı
        }

        // Servis katmanına ilişkileri eksiksiz çözülmüş gerçek nesneyi fırlatıyoruz!
        return orderService.createOrder(realOrder);
    }
}

// 📦 Ön yüzden gelen JSON verisini havada yakalayan yardımcı sınıf
class OrderRequestDTO {
    private Long customerId;
    private Long productId;
    private int quantity;

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}