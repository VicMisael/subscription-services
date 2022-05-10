package com.misael.ascan.microserviceschallenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Subscription {

    @Id
    Integer id;

    SubscriptionStatus subscriptionStatus;

    @Column(name="dt_created_at")
    Date createdAt;

    @Column(name="dt_updated_at")
    Date updatedAt;
}
