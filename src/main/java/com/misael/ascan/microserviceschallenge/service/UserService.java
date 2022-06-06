package com.misael.ascan.microserviceschallenge.service;

import com.misael.ascan.microserviceschallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
}
