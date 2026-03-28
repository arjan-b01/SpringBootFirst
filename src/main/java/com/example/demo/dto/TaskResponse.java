package com.example.demo.dto;

public class TaskResponse {
    private Long id;
    private String title;
    private boolean completed;
    private Long userId;

    public TaskResponse(){}

    public TaskResponse(Long id, String title, boolean completed, Long userId){
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Long getUserId() {
        return userId;
    }
}
