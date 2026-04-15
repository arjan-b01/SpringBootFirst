package com.example.demo.repository;
import com.example.demo.model.UserV2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface UserRepositoryV2 extends JpaRepository<UserV2, Long> {
    Optional<UserV2> findByEmail(String email);
}
