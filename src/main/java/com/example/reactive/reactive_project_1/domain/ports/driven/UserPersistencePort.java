package com.example.reactive.reactive_project_1.domain.ports.driven;

import com.example.reactive.reactive_project_1.domain.model.UserModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface UserPersistencePort {

    Mono<UserModel> create(UserModel userModel);
    Mono<UserModel> findById(Long id);
    Flux<UserModel> findAll();


}
