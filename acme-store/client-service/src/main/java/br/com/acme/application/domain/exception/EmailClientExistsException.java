package br.com.acme.application.domain.exception;

public class EmailClientExistsException extends RuntimeException{

    public EmailClientExistsException(String email) {
        super(String.format("The e-mail %s already exists", email));
    }
}
