package com.misael.ascan.microserviceschallenge.repository;

import com.misael.ascan.microserviceschallenge.model.Subscription;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

    private final R2dbcEntityTemplate template;
    private final UserRepository userRepository;

    @Override
    public Mono<Subscription> insert(Subscription subscription) {
        return template.insert(subscription);
    }

    @Override
    public Mono<Subscription> update(Subscription subscription) {
        return template.update(subscription);
    }

    @Override
    public Mono<Subscription> getById(Long id) {
        return template.selectOne(Query.query(Criteria.where("subscription_id").is(id)), Subscription.class);
    }

    @Override
    public Mono<Subscription> getByUserId(Long id) {
        return template.selectOne(Query.query(Criteria.where("user_id").is(id)), Subscription.class);
    }

    @Override
    public Flux<Subscription> findAll() {
        return template.getDatabaseClient().sql("select * " +
                "from subscription.subscriptions " +
                "NATURAL JOIN subscription.users").map(Subscription::fromRow).all();
//        return template.select(Query.empty(), Subscription.class).flatMap(subscription ->
//                userRepository.getById(subscription.getId()).map(subscription::withUser));
    }
}
