package com.misael.ascan.microserviceschallenge.repository;

import com.misael.ascan.microserviceschallenge.model.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubscriptionRepository {


    public Mono<Subscription> insert(Subscription subscription);

    public Mono<Subscription> update(Subscription subscription);

    public Mono<Subscription> getById(Long id);

    public Flux<Subscription> findAll();

    public Mono<Subscription> getByUserId(Long id);
}
