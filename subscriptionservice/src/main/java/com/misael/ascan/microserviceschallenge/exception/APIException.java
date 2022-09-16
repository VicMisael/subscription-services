package com.misael.ascan.microserviceschallenge.exception;

import io.r2dbc.postgresql.message.backend.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
public class APIException extends RuntimeException {
    private final int status;
    private final String message;
    private final Optional<Throwable> reason;
    public APIException(){
        super();
        this.status=500;
        this.message="";
        this.reason=Optional.empty();
    }
    public APIException(String message,Optional<Throwable> reason)
    {
        super(message);
        this.status=500;
        this.message=message;
        this.reason=reason;
    }

    public APIException(int status, String message, Optional<Throwable> reason) {
        super(message);
        this.message=message;
        this.reason=reason;
        this.status=status;
    }


    public byte[] asBytes(){
        String response = "{ \"status\": " +
                status +
                ", \"message\": \"" +
                message +
                "\"}";

        return response.getBytes();
    }
}
