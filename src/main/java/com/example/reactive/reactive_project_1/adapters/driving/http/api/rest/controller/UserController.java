package com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.controller;

import com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.dto.request.UserDTORequest;
import com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.handler.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Mono<String>> createUser(@Valid @RequestBody UserDTORequest userDTORequest){
            Mono<String> response = userService.createUser(userDTORequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



}
