package com.misael.ascan.microserviceschallenge.controller;

import com.misael.ascan.microserviceschallenge.model.Subscription;
import com.misael.ascan.microserviceschallenge.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping
    public Flux<Subscription> allSubscriptions() {
        return subscriptionService.findAll();
    }

    @PostMapping()
    public Mono<Subscription> addSubscription(Subscription subscription) {
        return subscriptionService.save(subscription);
    }

    @PutMapping()
    public Mono<Subscription> updateSubscription(Subscription subscription) {
        return subscriptionService.update(subscription);
    }
}
