package com.example.reactive.reactive_project_1.adapters.driven.r2dbcpersistence.repository;

import com.example.reactive.reactive_project_1.adapters.driven.r2dbcpersistence.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    Mono<User> findByName(String name);

}
