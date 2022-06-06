package com.misael.ascan.microserviceschallenge.repository;

import com.misael.ascan.microserviceschallenge.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {

    public Mono<User> insert(User user);

    public Mono<User> update(User user);

    public Mono<User> getById(Long id);

    public Flux<User> findAll();

}
