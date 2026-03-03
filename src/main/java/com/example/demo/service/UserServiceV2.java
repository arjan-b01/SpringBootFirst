package com.example.demo.service;

import com.example.demo.model.UserV2;
import com.example.demo.repository.UserRepositoryV2;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceV2 {
    private final UserRepositoryV2 userRepository;
    public UserServiceV2(UserRepositoryV2 userRepository){
        this.userRepository = userRepository;
    }

    public List<UserV2> getAllUsers(){
        return userRepository.findAll();
    }
    public UserV2 getUserById(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserV2 createUser(UserV2 user){
        return userRepository.save(user);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

    public UserV2 updateUser(String id, UserV2 updatedUser){
        UserV2 existingUser = getUserById(id);

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());

        return userRepository.save(existingUser);
    }
}
