package com.example.demo.exception;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ErrorResponse {
    private LocalDateTime time;
    private int status;
    private Object error;
    private String path;

    public ErrorResponse(LocalDateTime time, int status, Object error, String path){
        this.time = time;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getStatus() {
        return status;
    }

    public Object getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
