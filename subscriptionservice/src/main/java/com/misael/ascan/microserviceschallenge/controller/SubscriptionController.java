package com.misael.ascan.microserviceschallenge.controller;

import com.misael.ascan.microserviceschallenge.model.DTO.SubscriptionDTO;
import com.misael.ascan.microserviceschallenge.model.Subscription;
import com.misael.ascan.microserviceschallenge.service.SubscriptionService;
import com.misael.ascan.microserviceschallenge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Subscription> allSubscriptions() {
        return subscriptionService.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Subscription> addSubscription(@RequestBody SubscriptionDTO subscription) {
        return subscriptionService.save(subscription.toSubscription()).flatMap(subs ->
                userService.getById(subs.getId()).map(s -> subs.withUser(s))).switchIfEmpty(Mono.empty());
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Subscription> updateSubscription(@RequestBody SubscriptionDTO subscription) {
        return subscriptionService.update(subscription.toSubscription());
    }

    @GetMapping("/single")
    @ResponseStatus(HttpStatus.FOUND)
    public Mono<Subscription> getById(@RequestParam Long id) {
        return subscriptionService.find(id);
    }
}
