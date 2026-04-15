package com.example.demo.config;

import com.example.demo.model.UserV2;
import com.example.demo.repository.UserRepositoryV2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initAdmin(UserRepositoryV2 userRepository, PasswordEncoder passwordEncoder){
        return args -> {
            if(userRepository.count() == 0){
                UserV2 admin = new UserV2();
                admin.setName("Tywin Lannister");
                admin.setEmail("handofking@gmail.com");
                admin.setPassword(passwordEncoder.encode("IhateTyrion123"));
                admin.setRole("ADMIN");

                userRepository.save(admin);

                System.out.println("DEFAULT ADMIN CREATED");
            }
        };
    }
}
