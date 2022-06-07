package com.misael.ascan.microserviceschallenge.service;

import com.misael.ascan.microserviceschallenge.model.User;
import com.misael.ascan.microserviceschallenge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Mono<User> addUser(User user) {
        return userRepository.insert(user);
    }

    public Mono<User> getById(Long id) {
        return userRepository.getById(id);
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }
}
