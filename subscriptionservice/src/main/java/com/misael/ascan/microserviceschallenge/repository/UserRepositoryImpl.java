package com.misael.ascan.microserviceschallenge.repository;

import com.misael.ascan.microserviceschallenge.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final R2dbcEntityTemplate template;

    @Override
    public Mono<User> insert(User user) {
        return template.insert(user);
    }

    @Override
    public Mono<User> update(User user) {
        return template.update(user);
    }

    @Override
    public Mono<User> getById(Long id) {
        return template.selectOne(Query
                .query(Criteria.where("user_id").is(id)), User.class);
    }

    @Override
    public Flux<User> findAll() {
        return template.select(Query.empty(), User.class);
    }
}
