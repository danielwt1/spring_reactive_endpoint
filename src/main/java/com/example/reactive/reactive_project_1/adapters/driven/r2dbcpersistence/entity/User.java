package com.example.reactive.reactive_project_1.adapters.driven.r2dbcpersistence.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("usuario")
public class User {

    @Id
    @Column(value = "idUser")
    private Long idUser;
    @Column(value = "nombre")
    private String name;
    @Column(value = "apellido")
    private String lastName;

    public User() {
    }

    public User(Long idUser, String name, String lastName) {
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
