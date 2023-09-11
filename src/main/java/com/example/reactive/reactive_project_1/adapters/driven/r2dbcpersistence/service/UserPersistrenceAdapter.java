package com.example.reactive.reactive_project_1.adapters.driven.r2dbcpersistence.service;

import com.example.reactive.reactive_project_1.adapters.driven.r2dbcpersistence.exception.EntityFoundException;
import com.example.reactive.reactive_project_1.adapters.driven.r2dbcpersistence.mappers.UserEntityMapper;
import com.example.reactive.reactive_project_1.adapters.driven.r2dbcpersistence.repository.UserRepository;
import com.example.reactive.reactive_project_1.domain.model.UserModel;
import com.example.reactive.reactive_project_1.domain.ports.driven.UserPersistencePort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserPersistrenceAdapter implements UserPersistencePort {

    private final UserRepository  userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserPersistrenceAdapter(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }
// usar Mono o Flux darle el permiso alñ domionio
@Override
public Mono<UserModel> create(UserModel userModel) {
    Mono<Boolean> existElement = this.userRepository.findByName(userModel.getName()).hasElement();
    return existElement.flatMap(exist -> exist ? Mono.error(new EntityFoundException("User already exist"))
            : this.userRepository.save(this.userEntityMapper.toEntity(userModel))
            .map(this.userEntityMapper::toModel));
}




    @Override
    public Mono<UserModel> findById(Long id) {
        return this.userRepository.findById(id)
                //Manera  de laznar un error si esta vacio
                .switchIfEmpty(Mono.error(new Exception("ERROR")))
                .map(this.userEntityMapper::toModel);
    }

    @Override
    public Flux<UserModel> findAll() {
        return this.userRepository.findAll()
                .map(this.userEntityMapper::toModel);
    }
}
