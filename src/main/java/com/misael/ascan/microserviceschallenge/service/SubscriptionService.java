package com.misael.ascan.microserviceschallenge.service;

import com.misael.ascan.microserviceschallenge.Repository.SubscriptionRepository;
import com.misael.ascan.microserviceschallenge.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Service
public class SubscriptionService {

    SubscriptionRepository subscriptionRepository;

    public Mono<Subscription> save(Subscription subscription) {
        return Mono.just(subscriptionRepository.save(subscription));
    }

    public Flux<Subscription> findAll() {
        return Flux.fromIterable(subscriptionRepository.findAll());
    }

}
