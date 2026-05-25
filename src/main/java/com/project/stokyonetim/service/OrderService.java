package com.project.stokyonetim.service;

import com.project.stokyonetim.entity.Order;
import com.project.stokyonetim.entity.OrderItem;
import com.project.stokyonetim.entity.Product;
import com.project.stokyonetim.repository.OrderRepository;
import com.project.stokyonetim.repository.ProductRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    // @Transactional çok kritik! Sipariş esnasında bir hata çıkarsa (örneğin 2. ürünün stoğu yetmezse)
    // ilk yapılan tüm stok düşme işlemlerini geri alır (Rollback), veri tabanı asla çorba olmaz!
    @Transactional
    public Order createOrder(Order order) {
        BigDecimal totalAmount = BigDecimal.ZERO;

        // Faturanın içindeki sepet satırlarını tek tek dönüyoruz
        for (OrderItem item : order.getOrderItems()) {
            // Veri tabanından ürünün en güncel halini ve anlık stoğunu çekiyoruz
            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Ürün bulunamadı! ID: " + item.getProduct().getId()));

            // 🚨 STOK KONTROLÜ! Depoda istenen kadar mal var mı?
            if (product.getStockQuantity() < item.getQuantity()) {
                throw new RuntimeException("Yetersiz stok! Depoda olan: " + product.getStockQuantity() + ", İstenen: " + item.getQuantity());
            }

            // Stok yeterliyse, depodaki miktardan sipariş adedini düşüyoruz 👇
            product.setStockQuantity(product.getStockQuantity() - item.getQuantity());
            productRepository.save(product); // Yeni güncel stoğu veri tabanına yazıyoruz!

            // Satırın birim fiyatını, ürünün o anki güncel fiyatı yapıyoruz
            item.setPrice(product.getPrice());
            item.setOrder(order);

            // Satır toplam tutarını hesaplıyoruz (Adet * Fiyat)
            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            totalAmount = totalAmount.add(itemTotal);
        }

        // Hesaplanan genel toplam faturayı ana siparişe yazıyoruz
        order.setTotalAmount(totalAmount);

        // Hem siparişi hem de içindeki sepet satırlarını tek kalemde veri tabanına kalıcı yazıyoruz
        return orderRepository.save(order);
    }
}