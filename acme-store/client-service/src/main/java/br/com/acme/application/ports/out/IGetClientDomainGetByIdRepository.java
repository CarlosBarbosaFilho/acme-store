package br.com.acme.application.ports.out;

import br.com.acme.application.domain.entity.ClientDomain;

public interface IGetClientDomainGetByIdRepository {

    ClientDomain execute(Long id);
}
