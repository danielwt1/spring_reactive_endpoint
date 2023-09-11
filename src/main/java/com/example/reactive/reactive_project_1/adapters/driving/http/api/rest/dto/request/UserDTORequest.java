package com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.dto.request;

public class UserDTORequest {
    private String name;
    private String lastName;

    public UserDTORequest() {
    }

    public UserDTORequest(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
