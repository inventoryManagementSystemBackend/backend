package com.keral.inventoryManagementSystem.repository;

import com.keral.inventoryManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{

    User findByEmail(String email);
}