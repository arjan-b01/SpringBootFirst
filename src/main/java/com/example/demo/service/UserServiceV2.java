package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserV2;
import com.example.demo.repository.UserRepositoryV2;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceV2 {
    private final UserRepositoryV2 userRepository;
    public UserServiceV2(UserRepositoryV2 userRepository){
        this.userRepository = userRepository;
    }

//    public List<UserV2> getAllUsers(){
//        return userRepository.findAll();
//    }


    //THIS IS OLD SCHOOL -
//    public List<UserResponse> getAllUsers(){
//        List<UserV2> users = userRepository.findAll();
//
//        List<UserResponse> response = new ArrayList<>();
//        for(int i = 0; i<users.size(); i++){
//            UserV2 u = users.get(i);
//            response.add(
//                    new UserResponse(
//                            u.getId(),
//                            u.getName(),
//                            u.getEmail()
//                    )
//            );
//        }
//        return response;
//    }


    //THE NEW METHOD (USING STREAM)(WITHOUT PAGINATION)
//    public List<UserResponse> getAllUsers(){
//        return userRepository.findAll().stream()
//                .map(u -> new UserResponse(u.getId(), u.getName(), u.getEmail()))
//                .toList();
//    }

    public Page<UserResponse> getAllUsers(int page, int size){
        Pageable pageAble = PageRequest.of(page, size);
        Page<UserV2> userPage = userRepository.findAll(pageAble);

        return userPage.map(user -> new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getTasks()
        ));
    }

//    public UserV2 getUserById(Long id){
//        return userRepository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException("User not found with id: "+id));
//    }
    public UserResponse getUserById(Long id){
        UserV2 user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getTasks()
        );
    }

//    public UserV2 createUser(UserV2 user){
//        return userRepository.save(user);
//    }

    public UserResponse createUser(UserRequest request){
        UserV2 user = new UserV2();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        UserV2 savedUser = userRepository.save(user);
        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getTasks()
        );
    }

    public void deleteUser(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }

//    public UserV2 updateUser(Long id, UserV2 updatedUser){
//        UserV2 existingUser = getUserById(id);
//
//        existingUser.setName(updatedUser.getName());
//        existingUser.setEmail(updatedUser.getEmail());
//
//        return userRepository.save(existingUser);
//    }

    public UserResponse updateUser(Long id, UserRequest request){
        UserV2 existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        if(request.getName() != null){
            existingUser.setName(request.getName());
        }

        if(request.getEmail() != null){
            existingUser.setEmail(request.getEmail());
        }

        UserV2 updatedUser = userRepository.save(existingUser);
        return new UserResponse(
                updatedUser.getId(),
                updatedUser.getName(),
                updatedUser.getEmail(),
                updatedUser.getTasks()
        );
    }
}
