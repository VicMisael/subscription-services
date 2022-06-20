package com.misael.ascan.microserviceschallenge.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.misael.ascan.microserviceschallenge.model.Subscription;
import com.misael.ascan.microserviceschallenge.model.SubscriptionStatus;
import lombok.NonNull;

import java.time.LocalDate;

public class SubscriptionDTO {

    @JsonProperty("id")
    Long id;

    @JsonProperty("status")
    SubscriptionStatus subscriptionStatus;

    @JsonProperty("userid")
    @NonNull
    Long userId;


    public Subscription toSubscription() {
        return Subscription.builder().id(null)
                .userId(userId)
                .subscriptionStatus(subscriptionStatus == null ? SubscriptionStatus.SUBSCRIPTION_CANCELED : subscriptionStatus)
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();
    }

    public Subscription updatableSubscription() {
        return Subscription.builder().id(id).updatedAt(LocalDate.now()).subscriptionStatus(subscriptionStatus).build();
    }
}
