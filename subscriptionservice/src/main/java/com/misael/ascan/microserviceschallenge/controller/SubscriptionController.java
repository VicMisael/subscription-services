package com.misael.ascan.microserviceschallenge.controller;

import com.misael.ascan.microserviceschallenge.exception.APIException;
import com.misael.ascan.microserviceschallenge.model.DTO.SubscriptionDTO;
import com.misael.ascan.microserviceschallenge.model.Subscription;
import com.misael.ascan.microserviceschallenge.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Subscription> allSubscriptions() {
        return subscriptionService.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Subscription> addSubscription(@RequestBody SubscriptionDTO subscription) {
        return subscriptionService.save(subscription.toSubscription());
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Subscription> updateSubscription(@RequestBody SubscriptionDTO subscription) {
        return subscriptionService.update(subscription.updatableSubscription());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Subscription> getById(@PathVariable Long id) {
        return subscriptionService.find(id)
                .switchIfEmpty(Mono.error(new APIException(HttpStatus.NOT_FOUND.value(), "Subscription not found",null)));
    }
}
