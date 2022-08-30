package com.misael.ascan.microserviceschallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.r2dbc.spi.Row;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Objects;

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

    public static Subscription fromRow(Row row) {
        return Subscription.builder()
                .id(row.get("susbcription_id", Long.class))
                .subscriptionStatus(Objects.requireNonNull(row.get("subscription_status", SubscriptionStatus.class)))
                .createdAt(row.get("created_at", LocalDate.class))
                .updatedAt(row.get("updated_at", LocalDate.class))
                .user(User.builder()
                        .id(row.get("user_id", Long.class))
                        .fullName(row.get("full_name", String.class))
                        .created(row.get("dt_created", LocalDate.class)).build())
                .build();
    }
}
