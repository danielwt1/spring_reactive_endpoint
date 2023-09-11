package com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.handler.impl;

import com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.dto.request.UserDTORequest;
import com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.handler.UserService;
import com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.mapper.UserModelMapper;
import com.example.reactive.reactive_project_1.domain.ports.driving.UserApi;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
    private final UserApi userApi;
    private final UserModelMapper userModelMapper;

    public UserServiceImpl(UserApi userApi, UserModelMapper userModelMapper) {
        this.userApi = userApi;
        this.userModelMapper = userModelMapper;
    }

    @Override
    public Mono<String> createUser(UserDTORequest user) {
        return this.userApi.createUser(this.userModelMapper.toModel(user))
                .map( x->"Registro Creado con exito!");
        //return Mono.just("Registro Creado con exito!");

    }
}
