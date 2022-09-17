package com.service;

import com.misael.ascan.microserviceschallenge.DemoApplication;
import com.misael.ascan.microserviceschallenge.repository.SubscriptionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;


@SpringBootTest(
        classes = DemoApplication.class)
public class SubscriptionTest {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Test
    public void getEmailByIdTest() {
        StepVerifier.create(subscriptionRepository.getCompleteSubscriptionById(1L)).expectComplete();

    }


}
