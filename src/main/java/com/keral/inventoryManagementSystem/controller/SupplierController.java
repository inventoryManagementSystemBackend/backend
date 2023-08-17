package com.keral.inventoryManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keral.inventoryManagementSystem.model.Supplier;
import com.keral.inventoryManagementSystem.service.SupplierManagementService;

@RestController
@RequestMapping("/inventory") 
public class SupplierController {

    private final SupplierManagementService inService;

    @Autowired
    public SupplierController(SupplierManagementService inService) {
        this.inService = inService;
    }

    @PostMapping("/supplier")
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier savedSupplier = inService.save(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSupplier);
    }

    @GetMapping("/suppliers")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        try {
            List<Supplier> suppliers = inService.getAllSuppliers();
            return ResponseEntity.ok(suppliers);
        } catch (Exception e) {
            // Use a logging framework to log the exception
            // Log.error("Error while fetching suppliers", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/supplier/{id}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable("id") long id) {
        Supplier supplier = inService.getSupplierById(id);
        if (supplier != null) {
            return ResponseEntity.ok(supplier);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/supplier/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable("id") long id) {
        inService.deleteSupplierById(id);
        return ResponseEntity.ok("Supplier successfully deleted");
    }

    @PostMapping("/supplier/{id}")
    public ResponseEntity<String> updateSupplier(@PathVariable("id") long id, @RequestBody Supplier supplier) {
        Supplier updatedSupplier = inService.updateSupplier(id, supplier);
        if (updatedSupplier != null) {
            return ResponseEntity.ok("Supplier updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
