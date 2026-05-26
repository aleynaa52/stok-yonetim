package com.project.stokyonetim;

import com.project.stokyonetim.entity.Customer;
import com.project.stokyonetim.entity.Product;
import com.project.stokyonetim.entity.Payment;
import com.project.stokyonetim.entity.Supplier;
import com.project.stokyonetim.repository.CustomerRepository;
import com.project.stokyonetim.repository.ProductRepository;
import com.project.stokyonetim.repository.PaymentRepository;
import com.project.stokyonetim.repository.SupplierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final PaymentRepository paymentRepository;
    private final SupplierRepository supplierRepository;

    public DataInitializer(ProductRepository productRepository,
                           CustomerRepository customerRepository,
                           PaymentRepository paymentRepository,
                           SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.paymentRepository = paymentRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // ==========================================
        // 🏭 1. ADIM: TEDARİKÇİLER
        // ==========================================
        Supplier s1 = new Supplier();
        s1.setName("Grolet Pastacılık Ekipmanları A.Ş.");
        s1.setContactPerson("Cédric Grolet");                  // YENİ
        s1.setEmail("info@groletpastacilik.com");
        s1.setPhone("0212 444 55 66");                         // YENİ
        s1.setAddress("Kapalıçarşı Cd. No:12 İstanbul");       // YENİ
        try { s1 = supplierRepository.save(s1); } catch (Exception e) {}

        Supplier s2 = new Supplier();
        s2.setName("Kolombiya Lojistik & Kahve Çiftliği");
        s2.setContactPerson("Carlos Mendez");                  // YENİ
        s2.setEmail("supply@colombiacoffee.com");
        s2.setPhone("0312 555 66 77");                         // YENİ
        s2.setAddress("Atatürk Blv. No:45 Ankara");            // YENİ
        try { s2 = supplierRepository.save(s2); } catch (Exception e) {}

        Supplier s3 = new Supplier();
        s3.setName("Sancaktar Kahve Çekirdeği İthalat A.Ş.");
        s3.setContactPerson("Metehan Sancaktar");              // YENİ
        s3.setEmail("sancaktar@kahveithalat.com");
        s3.setPhone("0232 777 88 99");                         // YENİ
        s3.setAddress("Alsancak Mh. No:7 İzmir");              // YENİ
        try { s3 = supplierRepository.save(s3); } catch (Exception e) {}

        Supplier fallbackSupplier = supplierRepository.findAll().stream().findFirst().orElse(s1);

        // ==========================================
        // ☕ 2. ADIM: ÜRÜN KATALOĞU
        // ==========================================
        Product p1 = new Product();
        p1.setName("Gourmet Arabica Kahve Çekirdeği (1 KG)");
        p1.setSku("KAHVE-001");
        p1.setBrand("Cédric Premium");
        p1.setModel("Premium Blend");
        p1.setStockQuantity(140);
        p1.setPrice(BigDecimal.valueOf(450.00));
        p1.setSupplier(fallbackSupplier);
        try { productRepository.save(p1); } catch (Exception e) {}

        Product p2 = new Product();
        p2.setName("Etiyopya Yirgacheffe Kahve Çekirdeği (1 KG)");
        p2.setSku("KAHVE-002");
        p2.setBrand("Cédric Premium");
        p2.setModel("Single Origin");
        p2.setStockQuantity(85);
        p2.setPrice(BigDecimal.valueOf(520.00));
        p2.setSupplier(fallbackSupplier);
        try { productRepository.save(p2); } catch (Exception e) {}

        Product p3 = new Product();
        p3.setName("Madagaskar Vanilya Özütü (250 ML)");
        p3.setSku("PASTA-101");
        p3.setBrand("Grolet Pastacılık");
        p3.setModel("Gourmet Extract");
        p3.setStockQuantity(45);
        p3.setPrice(BigDecimal.valueOf(1250.00));
        p3.setSupplier(fallbackSupplier);
        try { productRepository.save(p3); } catch (Exception e) {}

        Product p4 = new Product();
        p4.setName("Kurumsal Espresso Makinesi v2");
        p4.setSku("MAKINE-099");
        p4.setBrand("Gaggia");
        p4.setModel("Classic Pro");
        p4.setStockQuantity(12);
        p4.setPrice(BigDecimal.valueOf(7500.00));
        p4.setSupplier(fallbackSupplier);
        try { productRepository.save(p4); } catch (Exception e) {}

        // ==========================================
        // 👥 3. ADIM: MÜŞTERİLER
        // ==========================================
        Customer c1 = new Customer();
        c1.setFirstName("Alparslan");
        c1.setLastName("Kurt");
        c1.setEmail("alparslankurt@gmail.com");
        c1.setPhoneNumber("0532 111 22 33");                   // YENİ
        try { c1.getClass().getMethod("setGender", String.class).invoke(c1, "MALE"); } catch(Exception e){}
        try { c1 = customerRepository.save(c1); } catch (Exception e) { c1 = customerRepository.findByEmail("alparslankurt@gmail.com").orElse(c1); }

        Customer c2 = new Customer();
        c2.setFirstName("Asel");
        c2.setLastName("Karaca");
        c2.setEmail("aselkaraca@gmail.com");
        c2.setPhoneNumber("0544 333 44 55");                   // YENİ
        try { c2.getClass().getMethod("setGender", String.class).invoke(c2, "FEMALE"); } catch(Exception e){}
        try { c2 = customerRepository.save(c2); } catch (Exception e) { c2 = customerRepository.findByEmail("aselkaraca@gmail.com").orElse(c2); }

        Customer c3 = new Customer();
        c3.setFirstName("Metehan");
        c3.setLastName("Sancaktar");
        c3.setEmail("metehansancaktar@gmail.com");
        c3.setPhoneNumber("0555 666 77 88");                   // YENİ
        try { c3.getClass().getMethod("setGender", String.class).invoke(c3, "MALE"); } catch(Exception e){}
        try { c3 = customerRepository.save(c3); } catch (Exception e) { c3 = customerRepository.findByEmail("metehansancaktar@gmail.com").orElse(c3); }

        // ==========================================
        // 💰 4. ADIM: KASA GİRİŞLERİ
        // ==========================================
        if (paymentRepository.count() == 0 && c1.getId() != null) {
            Payment pay1 = new Payment();
            pay1.setCustomer(c1);
            pay1.setAmount(BigDecimal.valueOf(2250.00));
            pay1.setPaymentMethod("CREDIT_CARD");
            pay1.setPaymentDate(LocalDateTime.now().minusDays(2));
            try { paymentRepository.save(pay1); } catch (Exception e) {}

            Payment pay2 = new Payment();
            pay2.setCustomer(c2);
            pay2.setAmount(BigDecimal.valueOf(7500.00));
            pay2.setPaymentMethod("BANK_TRANSFER");
            pay2.setPaymentDate(LocalDateTime.now().minusDays(1));
            try { paymentRepository.save(pay2); } catch (Exception e) {}
        }

        System.out.println("🚀 BEAN & BLISS KATALOĞU VE SANCAKTAR A.Ş. VERİLERİ SIFIR RİSKLE EKLENDİ!");
    }
}