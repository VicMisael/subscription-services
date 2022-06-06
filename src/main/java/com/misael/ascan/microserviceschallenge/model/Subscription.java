package com.misael.ascan.microserviceschallenge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("subscriptions.subscriptions")
public class Subscription {
    @Id
    @Column("subscription_id")
    Long id;

    @Column("fk_user_id")
    User user;

    @NonNull
    @Column("subscription_status")
    SubscriptionStatus subscriptionStatus;

    @NonNull
    @Column("created_at")
    Date createdAt;

    @NonNull
    @Column("updated_at")
    Date updatedAt;
}
