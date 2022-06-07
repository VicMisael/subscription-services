package com.misael.ascan.microserviceschallenge.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.misael.ascan.microserviceschallenge.model.User;
import lombok.*;

import javax.management.RuntimeMBeanException;
import java.time.LocalDate;
import java.util.Calendar;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class UserDTO {

    @NonNull
    @JsonProperty("fullname")
    String fullName;

    public User toUser() {
        System.out.println(fullName);
        if(!fullName.isBlank())
            return User.builder().fullName(fullName).created(LocalDate.now()).build();
        else
            throw new RuntimeException("Name is empty");
    }

    ;
}
