package br.com.acme.application.ports.in;

import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.domain.exception.EmailClientExistsException;

public interface ICreateClientDomainUseCase {
    ClientDomain execute(ClientDomain clientDomain) throws EmailClientExistsException;
}
