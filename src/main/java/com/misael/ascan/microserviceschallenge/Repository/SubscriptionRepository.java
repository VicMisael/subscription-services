package com.misael.ascan.microserviceschallenge.Repository;

import com.misael.ascan.microserviceschallenge.model.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
    @Override
    <S extends Subscription> S save(S entity);
    @Override
    Iterable<Subscription> findAll();
}
