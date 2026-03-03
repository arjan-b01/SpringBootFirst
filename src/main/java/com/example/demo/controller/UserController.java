package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody User user){
        userService.updateUser(id, user);
    }

    @PutMapping("/{id1}/{id2}")
    public void swapUser(@PathVariable Integer id1, @PathVariable Integer id2){
        userService.swapUser(id1, id2);
    }

    @PostMapping()
    public User createUser( @RequestBody User user){
        return userService.createUser(user);
    }
}
