package com.example.reactive.reactive_project_1.domain.ports.driving;

import com.example.reactive.reactive_project_1.domain.model.UserModel;
import reactor.core.publisher.Mono;

public interface UserApi {
    Mono<UserModel> createUser(UserModel userModel);

}
