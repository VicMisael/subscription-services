package com.misael.ascan.microserviceschallenge.model;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table("subscription.subscriptions")
public class Subscription {
    @Id
    @Column("subscription_id")
    Long id;

    @Column("user_id")
    @JsonIgnore
    Long userId;

    @With
    @Transient
    User user;

    @NonNull
    @Column("subscription_status")
    SubscriptionStatus subscriptionStatus;

    @NonNull
    @Column("created_at")
    LocalDate createdAt;

    @NonNull
    @Column("updated_at")
    LocalDate updatedAt;
}
