package br.com.acme.application.ports.out;

public interface ILoginRepository {
    String execute(String email, String password);
}
