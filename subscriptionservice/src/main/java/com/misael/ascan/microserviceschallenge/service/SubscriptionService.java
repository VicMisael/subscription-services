package com.misael.ascan.microserviceschallenge.service;

import com.misael.ascan.microserviceschallenge.model.Event;
import com.misael.ascan.microserviceschallenge.model.Subscription;
import com.misael.ascan.microserviceschallenge.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final EventService eventService;
    private final SubscriptionRepository subscriptionRepository;
    private final UserService userService;

    public Mono<Subscription> save(Subscription subscription) {
        return subscriptionRepository.insert(subscription).flatMap(subs ->
                userService.getById(subs.getId()).map(subs::withUser)).map(completeSubscription -> {
            eventService.createEvent(Event.fromCompleteSubscription(completeSubscription));
            return completeSubscription;
        });
    }

    public Mono<Subscription> update(Subscription subscription) {
        return this.find(subscription.getId()).flatMap(subs1 -> {
            subs1.setSubscriptionStatus(subscription.getSubscriptionStatus());
            subs1.setUpdatedAt(subscription.getUpdatedAt());
            return subscriptionRepository.update(subs1).flatMap(subs2 ->
                    userService.getById(subs2.getId()).map(subs2::withUser)).map(completeSubscription -> {
                eventService.createEvent(Event.fromCompleteSubscription(completeSubscription));

                return completeSubscription;
            });
        });
    }

    public Flux<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    public Mono<Subscription> find(Long id) {
        return subscriptionRepository.getById(id).flatMap(subs ->
                        userService.getById(subs.getId()).map(subs::withUser))
                .switchIfEmpty(Mono.empty());
    }

}
