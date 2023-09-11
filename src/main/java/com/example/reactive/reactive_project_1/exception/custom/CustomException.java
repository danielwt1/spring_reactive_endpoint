package com.example.reactive.reactive_project_1.exception.custom;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{
    private HttpStatus status;

    public CustomException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
