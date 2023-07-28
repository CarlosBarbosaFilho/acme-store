package br.com.acme.application.domain.exception;

public class ErrorLoginClientException extends RuntimeException{

    public ErrorLoginClientException(String email) {
        super(String.format("Client with %s not found", email));
    }
}
