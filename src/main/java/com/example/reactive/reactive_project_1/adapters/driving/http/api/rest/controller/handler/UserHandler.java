package com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.controller.handler;

import com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.dto.request.UserDTORequest;
import com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.handler.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {
    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> createUser(ServerRequest request) {
        Mono<UserDTORequest> req = request.bodyToMono(UserDTORequest.class);

        return req.flatMap(userDTORequest -> {
            return userService.createUser(userDTORequest)
                    .flatMap(createdUser -> ServerResponse
                            .status(HttpStatus.CREATED) // Establecer el código de estado 201 Created
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(createdUser))
                    .switchIfEmpty(ServerResponse.notFound().build()); // Manejo de errores si el usuario no se crea
        });
    }
}
