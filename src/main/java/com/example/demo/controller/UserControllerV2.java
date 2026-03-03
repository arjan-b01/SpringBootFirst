package com.example.demo.controller;

import com.example.demo.model.UserV2;
import com.example.demo.service.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/_users")
public class UserControllerV2 {
    private final UserServiceV2 userService;

    public UserControllerV2(UserServiceV2 userService){
        this.userService = userService;
    }

    @GetMapping()
    public List<UserV2> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserV2 getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody UserV2 user){
        userService.updateUser(id, user);
    }

    @PostMapping()
    public boolean createUser( @RequestBody UserV2 user){
         userService.createUser(user);
         return true;
    }
}
