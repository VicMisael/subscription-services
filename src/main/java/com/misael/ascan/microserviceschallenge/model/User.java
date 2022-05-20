package com.misael.ascan.microserviceschallenge.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Builder
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    Subscription subscription;

    @Column(name = "nm_full_name")
    String fullName;

    @Column(name = "dt_created")
    Date created;
}
