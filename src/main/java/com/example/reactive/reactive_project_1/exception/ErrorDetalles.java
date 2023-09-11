package com.example.reactive.reactive_project_1.exception;

public class ErrorDetalles {
    private String message;

    public ErrorDetalles(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
