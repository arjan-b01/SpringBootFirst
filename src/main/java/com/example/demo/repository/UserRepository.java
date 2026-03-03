package com.example.demo.repository;


import com.example.demo.model.User;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public List<User> findAll(){
        return users;
    }

    public Optional<User> findById(Integer id){
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public User save(User user){
        users.add(user);
        return user;
    }

    public void delete(User user){
        users.remove(user);
    }
}
