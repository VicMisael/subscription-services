package com.misael.ascan.microserviceschallenge.config;

import com.misael.ascan.microserviceschallenge.exception.APIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@Component
@Slf4j
public class ExceptionFilter implements WebFilter {

    public static Mono<Void> answerWithException(APIException e, ServerWebExchange exchange) {
        DataBufferFactory buffer = new DefaultDataBufferFactory();
        exchange.getResponse().getHeaders().set(CONTENT_TYPE, "application/json");
        exchange.getResponse().setRawStatusCode(e.getStatus());
        return exchange.getResponse()
                .writeWith(Flux.just(buffer.wrap(e.asBytes())));
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return chain.filter(exchange)
                .onErrorResume(e -> {
                    if (e instanceof APIException) {
                        return answerWithException((APIException) e, exchange);
                    } else {
                        log.error("Internal Server Error: ", e);
                        return answerWithException(new APIException(500, "Erro de servidor", Optional.of(e)), exchange);
                    }
                });
    }
}
