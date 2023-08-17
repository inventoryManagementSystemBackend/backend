package com.keral.inventoryManagementSystem.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keral.inventoryManagementSystem.model.User;
import com.keral.inventoryManagementSystem.repository.UserRepository;

@Service
public class UserManagementService {

    private final UserRepository userRepository;

    @Autowired
    public UserManagementService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(long userId, User newUser) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            // Update user properties as needed
            existingUser.setUser_id(newUser.getUser_id());
            existingUser.setFirstName(newUser.getFirstName());
            existingUser.setLastName(newUser.getLastName());
            existingUser.setEmail(newUser.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public boolean deleteUser(long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
