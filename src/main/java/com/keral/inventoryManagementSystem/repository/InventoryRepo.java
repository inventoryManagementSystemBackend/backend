package com.keral.inventoryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keral.inventoryManagementSystem.model.Product;

@Repository
public interface InventoryRepo extends JpaRepository<Product, Long> {

}
