package com.misael.ascan.microserviceschallenge.service;

import com.misael.ascan.microserviceschallenge.model.Subscription;
import com.misael.ascan.microserviceschallenge.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public Mono<Subscription> save(Subscription subscription) {
        return subscriptionRepository.insert(subscription);
    }

    public Mono<Subscription> update(Subscription subscription) {
        return subscriptionRepository.update(subscription);
    }

    public Flux<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    public Mono<Subscription> find(Long id) {
        return subscriptionRepository.getById(id);
    }

}
