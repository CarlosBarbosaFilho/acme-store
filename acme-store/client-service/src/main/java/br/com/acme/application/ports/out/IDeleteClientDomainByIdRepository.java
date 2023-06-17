package br.com.acme.application.ports.out;

public interface IDeleteClientDomainByIdRepository {

    void execute(Long id);
}
