package com.service;

import com.misael.ascan.microserviceschallenge.subscriptionService;
import com.misael.ascan.microserviceschallenge.repository.SubscriptionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;


@SpringBootTest(
        classes = subscriptionService.class)
public class SubscriptionTest {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Test
    public void getEmailByIdTest() {
        StepVerifier.create(subscriptionRepository.getById(1L)).expectComplete();

    }


}
