package com.example.reactive.reactive_project_1.domain.usecase;

import com.example.reactive.reactive_project_1.domain.model.UserModel;
import com.example.reactive.reactive_project_1.domain.ports.driven.UserPersistencePort;
import com.example.reactive.reactive_project_1.domain.ports.driving.UserApi;
import reactor.core.publisher.Mono;

public class UserUseCase implements UserApi {
    private final UserPersistencePort userPersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public Mono<UserModel> createUser(UserModel userModel) {
        //
        this.userPersistencePort.findAll();
        return this.userPersistencePort.create(userModel);
    }
}
