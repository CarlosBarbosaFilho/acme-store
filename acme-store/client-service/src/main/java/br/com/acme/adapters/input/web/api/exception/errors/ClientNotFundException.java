package br.com.acme.adapters.input.web.api.exception.errors;

public class ClientNotFundException extends RuntimeException{

    public ClientNotFundException(Long id) {
        super(String.format("Client with %d not found", id));
    }
}
