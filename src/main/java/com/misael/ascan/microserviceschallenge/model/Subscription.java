package com.misael.ascan.microserviceschallenge.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @NonNull
    @Column(name = "subscription_status")
    @Enumerated(EnumType.STRING)
    SubscriptionStatus subscriptionStatus;

    @NonNull
    @Column(name = "dt_created_at")
    Date createdAt;

    @NonNull
    @Column(name = "dt_updated_at")
    Date updatedAt;
}
