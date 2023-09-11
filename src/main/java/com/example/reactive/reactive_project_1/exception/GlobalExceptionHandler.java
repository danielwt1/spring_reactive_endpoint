package com.example.reactive.reactive_project_1.exception;

import com.example.reactive.reactive_project_1.adapters.driven.r2dbcpersistence.exception.EntityFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler   extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityFoundException.class)
    public Mono<ResponseEntity<ErrorDetalles>> handleEntityFoundException(EntityFoundException e) {
        return Mono.just(ResponseEntity.badRequest().body(new ErrorDetalles(e.getMessage())));
    }

}
