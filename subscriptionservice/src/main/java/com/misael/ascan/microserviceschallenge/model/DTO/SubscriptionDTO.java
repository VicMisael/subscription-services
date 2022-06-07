package com.misael.ascan.microserviceschallenge.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.misael.ascan.microserviceschallenge.model.Subscription;
import com.misael.ascan.microserviceschallenge.model.SubscriptionStatus;
import com.misael.ascan.microserviceschallenge.model.User;
import lombok.NonNull;
import org.apache.tomcat.jni.Local;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.Calendar;

public class SubscriptionDTO {

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
}
