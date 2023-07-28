package br.com.acme.application.ports.in;


public interface ILoginUseCase {

    String execute(String email, String password);
}
