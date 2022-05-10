package com.misael.ascan.microserviceschallenge.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Data
public class User {
    @Id
    Integer id;

    @Column(name = "nm_full_name")
    String fullName;

    @Column(name = "dt_created")
    Date created;
}
