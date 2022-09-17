package com.misael.ascan.microserviceschallenge.service;

import com.misael.ascan.microserviceschallenge.exception.APIException;
import com.misael.ascan.microserviceschallenge.model.Event;
import com.misael.ascan.microserviceschallenge.model.Subscription;
import com.misael.ascan.microserviceschallenge.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final EventService eventService;
    private final SubscriptionRepository subscriptionRepository;

    public Mono<Subscription> save(Subscription subscription) {
        return subscriptionRepository.insert(subscription).flatMap(subs ->
                find(subs.getId()).map(completeSubscription -> {
            eventService.createEvent(Event.fromCompleteSubscription(completeSubscription));
            return completeSubscription;
        }).onErrorMap(e -> e));
    }

    public Mono<Subscription> update(Subscription subscription) {
        return this.findSimple(subscription.getId())
                .flatMap(subs -> {
                            subs.setUpdatedAt(subscription.getUpdatedAt());
                            subs.setSubscriptionStatus(subscription.getSubscriptionStatus());
                            return subscriptionRepository.update(subs).flatMap(result -> this.find(result.getId()).map(subscription1 -> {
                                eventService.createEvent(Event.fromCompleteSubscription(subscription1));
                                return subscription1;
                            })).onErrorMap(e -> e);
                        }
                ).switchIfEmpty(Mono.empty());
    }

    public Flux<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    public Mono<Subscription> findSimple(Long id) {
        return subscriptionRepository.getById(id)
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Subscription> find(Long id) {
        return subscriptionRepository.getCompleteSubscriptionById(id);
    }

}
