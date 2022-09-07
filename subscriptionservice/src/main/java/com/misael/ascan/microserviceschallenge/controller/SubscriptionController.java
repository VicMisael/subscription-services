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
        return subscriptionService.save(subscription.toSubscription()).onErrorMap(e -> {
            if (e instanceof APIException) {
                APIException exception = (APIException) e;
                assert HttpStatus.resolve(exception.getStatus()) != null;
                throw new ResponseStatusException(HttpStatus.resolve(exception.getStatus()), exception.getMessage());
            } else {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL SERVER ERROR");
            }

        });
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
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Subscription not found")));
    }
}
