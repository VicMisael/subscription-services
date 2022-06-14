package com.misael.ascan.microserviceschallenge.exception;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class APIException extends RuntimeException {
    private int status;
    private String message;
    private ErrorResponse response;
    Optional<Throwable> reason;


    public APIException(int status, String message) {
        this.status = status;
        this.message = message;
        this.response = new ErrorResponse(status, message);
        this.reason = Optional.empty();
    }

    @Data
    public static class ErrorResponse{
        HttpStatus status;
        String mensagem;

        public ErrorResponse(HttpStatus status, String mensagem){
            this.status = status;
            this.mensagem = mensagem;
        }

        public ErrorResponse(int status, String mensagem){
            this.status = HttpStatus.valueOf(status);
            this.mensagem = mensagem;
        }

        public ResponseEntity<ErrorResponse> asEntity(){
            return new ResponseEntity<>(this, status);
        }

        public HttpStatus getStatus(){return status;}

        public String jsonString() {
            return "{\"status\": \"" + status.toString().split(" ")[1] + "\", \"mensagem\": \"" + mensagem + "\"}";
        }
    }
}
