package com.misael.ascan.microserviceschallenge.controller;

import com.misael.ascan.microserviceschallenge.exception.APIException;
import com.misael.ascan.microserviceschallenge.model.DTO.UserDTO;
import com.misael.ascan.microserviceschallenge.model.User;
import com.misael.ascan.microserviceschallenge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<User> addUser(@RequestBody UserDTO user){
        return userService.addUser(user.toUser());
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<User> getById(@PathVariable Long id) {
        return userService.getById(id)
                .switchIfEmpty(Mono.error(new APIException(HttpStatus.NOT_FOUND.value(), "User not found", Optional.empty())));
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<User> findAll(){
        return userService.findAll();
    }
}
