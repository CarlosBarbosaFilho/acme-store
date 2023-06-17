package br.com.acme.application.ports.in;

import br.com.acme.application.domain.entity.ClientDomain;

import java.util.List;

public interface IListClientDomainUseCase {

    List<ClientDomain> execute();
}
