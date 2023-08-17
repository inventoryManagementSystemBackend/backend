package com.keral.inventoryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keral.inventoryManagementSystem.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}