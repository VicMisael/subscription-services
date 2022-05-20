package com.misael.ascan.microserviceschallenge.controller;

import com.misael.ascan.microserviceschallenge.model.Subscription;
import com.misael.ascan.microserviceschallenge.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    public Flux<Subscription> allSubscriptions() {
        return subscriptionService.findAll();
    }

    @PostMapping()
    public Mono<Subscription> addSubscription(Subscription subscription) {
        return subscriptionService.save(subscription);
    }
}
