package br.com.acme.application.ports.out;

public interface ICheckExistsEmailRepository {
    boolean execute(String email);
}
