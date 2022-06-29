package com.misael.ascan.microserviceschallenge.exception;

import io.r2dbc.postgresql.message.backend.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class APIException extends RuntimeException {
    private int status;
    private String message;
    Optional<Throwable> reason;

    public byte[] asBytes(){
        String response = "{ \"status\": " +
                status +
                ", \"message\": \"" +
                message +
                "\"}";

        return response.getBytes();
    }
}
