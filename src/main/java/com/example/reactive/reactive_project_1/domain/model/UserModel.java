package com.example.reactive.reactive_project_1.domain.model;

public class UserModel {
    private Long idUser;
    private String name;
    private String lastName;

    public UserModel() {
    }

    public UserModel(Long idUser, String name, String lastName) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
