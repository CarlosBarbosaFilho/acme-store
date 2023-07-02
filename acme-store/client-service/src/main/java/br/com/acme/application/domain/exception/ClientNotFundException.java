package br.com.acme.application.domain.exception;

public class ClientNotFundException extends RuntimeException{

    public ClientNotFundException(Long id) {
        super(String.format("Client with %d not found", id));
    }
}
