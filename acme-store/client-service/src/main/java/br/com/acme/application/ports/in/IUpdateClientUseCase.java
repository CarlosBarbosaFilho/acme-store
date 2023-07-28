package br.com.acme.application.ports.in;

import br.com.acme.application.domain.entity.ClientDomain;

public interface IUpdateClientUseCase {

    void execute(ClientDomain clientDomain, Long id);
}
