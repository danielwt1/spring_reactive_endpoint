package com.example.reactive.reactive_project_1.configuration;

import com.example.reactive.reactive_project_1.adapters.driven.r2dbcpersistence.mappers.UserEntityMapper;
import com.example.reactive.reactive_project_1.adapters.driven.r2dbcpersistence.repository.UserRepository;
import com.example.reactive.reactive_project_1.adapters.driven.r2dbcpersistence.service.UserPersistrenceAdapter;
import com.example.reactive.reactive_project_1.domain.ports.driven.UserPersistencePort;
import com.example.reactive.reactive_project_1.domain.ports.driving.UserApi;
import com.example.reactive.reactive_project_1.domain.usecase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {
    private final UserEntityMapper userEntityMapper;
    private final UserRepository userPersistencePort;

    public BeansConfiguration(UserEntityMapper userEntityMapper, UserRepository userPersistencePort) {
        this.userEntityMapper = userEntityMapper;
        this.userPersistencePort = userPersistencePort;
    }

    @Bean
    public UserPersistencePort userPersistencePort() {
        return new UserPersistrenceAdapter(userPersistencePort,userEntityMapper);
    }
    @Bean
    public UserApi userApi(){
        return new UserUseCase(userPersistencePort());
    }
}
