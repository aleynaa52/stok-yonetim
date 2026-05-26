package com.project.stokyonetim.service;

import com.project.stokyonetim.entity.Supplier;
import com.project.stokyonetim.repository.SupplierRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// Bu sinifin tedarikci is mantigini yürüten bir servis katmani oldugunu bildirir
@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    // Postman'den gelen yeni toptanci/tedarikci sirketi veri tabanina kaydeder
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    // Sistemdeki tum tedarikci sirketleri liste halinde doner
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
    public void deleteById(Long id) {
        supplierRepository.deleteById(id);
    }
}
