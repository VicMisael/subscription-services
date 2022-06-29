package com.misael.ascan.microserviceschallenge.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableR2dbcRepositories
@Slf4j
public class ApplicationConfiguration extends AbstractR2dbcConfiguration {
    @Value("${subscription.datasource.db.host}")
    String host;
    @Value("${subscription.datasource.db.port}")
    String port;
    @Value("${subscription.datasource.db.name}")
    String dbname;
    @Value("${subscription.datasource.db.username}")
    String username;
    @Value("${subscription.datasource.db.password}")
    String password;

    @Value("${spring.profiles.active:}")
    private String activeProfile;

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        log.error("Active Profile:" + activeProfile);
        return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration
                .builder()
                .applicationName("Subscriptions")
                .host(host)
                .port(Integer.parseInt(port))
                .database(dbname)
                .username(username)
                .password(password)
                .build()
        );
    }


}
