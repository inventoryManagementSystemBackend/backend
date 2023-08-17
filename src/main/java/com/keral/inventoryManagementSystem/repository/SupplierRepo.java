package com.keral.inventoryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.keral.inventoryManagementSystem.model.Supplier;
@Repository
public interface  SupplierRepo extends JpaRepository<Supplier, Long>{

}
