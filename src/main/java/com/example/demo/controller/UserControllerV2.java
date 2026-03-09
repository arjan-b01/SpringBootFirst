package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.model.UserV2;
import com.example.demo.service.UserServiceV2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/_users")
public class UserControllerV2 {
    private final UserServiceV2 userService;

    public UserControllerV2(UserServiceV2 userService){
        this.userService = userService;
    }

    @GetMapping()
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        //HERE WE COULD'VE USED "ResponseEntity<UserResponse>", BUT SINCE WE ARE RETURNING AN EMPTY BOX IN ALL CASES, IT CAUSES
        // CONFUSION AND CAN BE CONSIDERED A LITTLE UNPROFESSIONAL IN ENTERPRISE LEVEL WORK.
        // IT IS BASICALLY USED FOR DEV TO DEV COMMUNICATION. JUST TO INFORM THE NEXT PERSON WORKING ON THIS CODE.
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();

    }

    // THIS ONE USES RESPONSE ENTITY INBUILT CLASS WHICH GIVES MORE CONTROL TO US OVER THE HTTP ENVELOPE.(ACCORDING TO GEMINI)
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String id, @RequestBody UserRequest request){
        return ResponseEntity.ok(userService.updateUser(id, request));
    }
    // THIS ONE IS ALSO CORRECT BUT SIMPLER. AND SINCE WE ALREADY CREATED A CUSTOM EXCEPTION,
    // THIS ONE WILL WORK JUST FINE WITHOUT ANY EDGE CASES.(ACCORDING TO GEMINI)
//    @PutMapping("/{id}")
//    public UserResponse updateUser(@PathVariable String id, @RequestBody UserRequest request){
//        return userService.updateUser(id, request);
//    }

    @PostMapping()
    public ResponseEntity<UserResponse> createUser( @RequestBody UserRequest request){
        UserResponse createdUser = userService.createUser(request);
         return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
