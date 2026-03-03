package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Integer id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Integer id){
        User user = getUserById(id);
        userRepository.delete(user);
    }

    public void updateUser(Integer id, User updatedUser){
        User existingUser = getUserById(id);

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
    }

    public void swapUser(Integer id1, Integer id2){
        User user1 = getUserById(id1);
        User user2 = getUserById(id2);

        String tempName = user1.getName();
        String tempEmail = user1.getEmail();

        user1.setName(user2.getName());
        user1.setEmail(user2.getEmail());

        user2.setName(tempName);
        user2.setEmail(tempEmail);
    }
}
