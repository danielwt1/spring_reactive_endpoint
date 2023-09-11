package com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.controller.router;

import com.example.reactive.reactive_project_1.adapters.driving.http.api.rest.controller.handler.UserHandler;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRouter {
    // SERIA COMO EL REQUESTMAPPING
    private static final  String PATH = "/api/v1/user";
    //Se usa como configuracion
    @Bean
    public WebProperties.Resources resources(){
        return new WebProperties.Resources();
    }

    @Bean
    RouterFunction<ServerResponse> router(UserHandler handler){
        return RouterFunctions.route()
                .POST(PATH,handler::createUser).build();
    }
}
