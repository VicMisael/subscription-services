package com.misael.ascan.microserviceschallenge.model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Event {
    Long userId;
    String userName;
    SubscriptionStatus state;
    LocalDate alterDate;

    public static Event fromCompleteSubscription(Subscription subscription) {
        if (subscription.getUser() == null) {
            throw new NullPointerException("Subscription.user can not be null");
        }
        return Event.builder().userId(subscription.getUserId())
                .userName(subscription.getUser().getFullName())
                .state(subscription.getSubscriptionStatus())
                .alterDate(LocalDate.now())
                .build();
    }
}
