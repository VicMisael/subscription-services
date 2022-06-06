package com.misael.ascan.microserviceschallenge.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableR2dbcRepositories
public class ApplicationConfiguration extends AbstractR2dbcConfiguration {
    final String host = AppPropertiesWrapper.getProperty("subscription.datasource.db.host");
    final String port = AppPropertiesWrapper.getProperty("subscription.datasource.db.port");
    final String dbname = AppPropertiesWrapper.getProperty("subscription.datasource.db.name");
    final String username = AppPropertiesWrapper.getProperty("subscription.datasource.db.username");
    final String password = AppPropertiesWrapper.getProperty("subscription.datasource.db.password");
    final String schema = AppPropertiesWrapper.getProperty("subscription.datasource.db.schema");

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration
                .builder()
                .applicationName("Subscriptions")
                .host(host)
                .port(Integer.parseInt(port))
                .database(dbname)
                .username(username)
                .password(password)
                .schema(schema)
                .build()
        );
    }


}
