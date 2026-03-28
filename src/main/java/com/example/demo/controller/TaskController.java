package com.example.demo.controller;

import com.example.demo.dto.TaskRequest;
import com.example.demo.dto.TaskResponse;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Task;
import com.example.demo.model.UserV2;
import com.example.demo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/{userId}/tasks")
    public TaskResponse createTask (@PathVariable Long userId, @RequestBody TaskRequest request){
        return taskService.createTask(userId, request);
    }
}
