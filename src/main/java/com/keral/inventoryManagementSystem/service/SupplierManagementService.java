package com.keral.inventoryManagementSystem.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keral.inventoryManagementSystem.model.Supplier;
import com.keral.inventoryManagementSystem.repository.SupplierRepo;

@Service
public class SupplierManagementService {
    private final SupplierRepo repo;

    @Autowired
    public SupplierManagementService(SupplierRepo repo) {
        this.repo = repo;
    }

    public Supplier save(Supplier supplier) {
        return repo.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return repo.findAll(); 
    }

    public Supplier getSupplierById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("Supplier with ID " + id + " not found"));
    }

    public void deleteSupplierById(long id) {
        repo.deleteById(id);
    }

    public Supplier updateSupplier(Long id, Supplier supplier) {
        Optional<Supplier> existingSupplier = repo.findById(id);
        if (existingSupplier.isPresent()) {
            supplier.setSupplier_id(id);
            return repo.save(supplier);
        }
        throw new NoSuchElementException("Supplier with ID " + id + " not found");
    }
}
