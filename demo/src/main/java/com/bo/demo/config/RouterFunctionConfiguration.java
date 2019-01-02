package com.bo.demo.config;

import com.bo.demo.domain.User;
import com.bo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

@Configuration
public class RouterFunctionConfiguration {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request->{
                    //返回所有用户对象
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    Mono<ServerResponse> body = ServerResponse.ok().body(userFlux, User.class);
                    return body;
                });
    }
}
