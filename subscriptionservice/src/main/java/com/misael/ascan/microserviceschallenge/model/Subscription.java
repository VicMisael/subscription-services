package com.misael.ascan.microserviceschallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("subscription.subscriptions")
@JsonIgnoreProperties("userId")
public class Subscription {
    @Id
    @Column("subscription_id")
    Long id;

    @Column("user_id")
    Long userId;

    @With
    @Transient
    User user;

    @NonNull
    @Column("subscription_status")
    SubscriptionStatus subscriptionStatus;

    @Column("created_at")
    LocalDate createdAt;

    @Column("updated_at")
    LocalDate updatedAt;

}
