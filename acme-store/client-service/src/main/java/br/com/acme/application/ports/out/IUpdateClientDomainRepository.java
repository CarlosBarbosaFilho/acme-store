package br.com.acme.application.ports.out;

import br.com.acme.application.domain.entity.ClientDomain;

public interface IUpdateClientDomainRepository {
    void execute(ClientDomain clientDomain, Long id);
}
