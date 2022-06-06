package com.misael.ascan.microserviceschallenge.service;

import com.misael.ascan.microserviceschallenge.model.Subscription;
import com.misael.ascan.microserviceschallenge.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public Mono<Subscription> save(Subscription subscription) {
        return subscriptionRepository.insert(subscription);
    }

    public Mono<Subscription> update(Subscription subscription) {
        return subscriptionRepository.update(subscription);
    }

    public Flux<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

}
