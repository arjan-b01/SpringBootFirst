package com.example.demo.service;

import com.example.demo.dto.TaskRequest;
import com.example.demo.dto.TaskResponse;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Task;
import com.example.demo.model.UserV2;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepositoryV2;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TaskService {
    private UserRepositoryV2 userRepository;
    private TaskRepository taskRepository;

    public TaskService(UserRepositoryV2 userRepository, TaskRepository taskRepository){
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Transactional
    public TaskResponse createTask(Long id, TaskRequest request){
        UserV2 user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user not found with id: " + id));

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setUser(user);

        Task saved = taskRepository.save(task);

        return new TaskResponse(
                saved.getId(),
                saved.getTitle(),
                saved.isCompleted(),
                user.getId()
        );
    }

    public List<TaskResponse> getTaskByUser(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException("User doesn't exist with id: " + id);
        }
        return taskRepository.findByUserId(id).stream()
                .map(task -> new TaskResponse(
                        task.getId(),
                        task.getTitle(),
                        task.isCompleted(),
                        task.getUser().getId()
                ))
                .toList();
    }
}
