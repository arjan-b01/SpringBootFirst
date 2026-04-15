package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserV2;
import com.example.demo.repository.UserRepositoryV2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepositoryV2 userRepositoryV2;

    public CustomUserDetailsService(UserRepositoryV2 userRepositoryV2){
        this.userRepositoryV2 = userRepositoryV2;
    }

    @Override
    public UserDetails loadUserByUsername(String email){
        UserV2 user = userRepositoryV2.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));

        return User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
