package com.example.demo.dto;

import com.example.demo.model.Task;

import java.util.*;

public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private List<TaskResponse> tasks;

    public UserResponse(){}

    public UserResponse(Long id, String name, String email, List<TaskResponse> tasks){
        this.id = id;
        this.name = name;
        this.email = email;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<TaskResponse> getTasks() {
        return tasks;
    }
}
