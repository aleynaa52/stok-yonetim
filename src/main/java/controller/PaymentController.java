package controller;

import dto.PaymentRequestDTO;
import entity.Payment;
import service.PaymentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Postman'den gelen DTO verisini alip satisi gerceklestiren POST kapisi
    @PostMapping
    public Payment makePayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        return paymentService.processPayment(paymentRequestDTO);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }
}
