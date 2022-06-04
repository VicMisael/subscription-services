package com.misael.ascan.microserviceschallenge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("subscription.users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @Id
    @Column("user_id")
    Integer id;

    @Column("full_name")
    String fullName;

    @Column("dt_created")
    Date created;
}
