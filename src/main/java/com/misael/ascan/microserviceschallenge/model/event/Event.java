package com.misael.ascan.microserviceschallenge.model.event;

import com.misael.ascan.microserviceschallenge.model.SubscriptionStatus;

public class Event {
    Integer subscription_id;
    SubscriptionStatus oldStatus;
    SubscriptionStatus newStatus;

}
