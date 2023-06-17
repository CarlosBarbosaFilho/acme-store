package br.com.acme.application.ports.in;

import br.com.acme.application.domain.entity.ClientDomain;

public interface ICreateClientDomainUseCase {
    ClientDomain execute(ClientDomain clientDomain);
}
