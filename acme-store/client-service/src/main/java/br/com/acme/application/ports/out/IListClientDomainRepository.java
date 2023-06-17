package br.com.acme.application.ports.out;

import br.com.acme.application.domain.entity.ClientDomain;

import java.util.List;

public interface IListClientDomainRepository {
    List<ClientDomain> execute();
}
