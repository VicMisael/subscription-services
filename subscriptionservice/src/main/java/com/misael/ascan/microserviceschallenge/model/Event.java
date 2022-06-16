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
}
