package com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.handler;

import com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.dto.request.UserDTORequest;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<String> createUser(UserDTORequest user);
}
