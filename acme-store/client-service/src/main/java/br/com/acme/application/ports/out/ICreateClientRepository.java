package br.com.acme.application.ports.out;

import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.domain.exception.EmailClientExistsException;

public interface ICreateClientRepository {
    ClientDomain execute(ClientDomain clientDomain) throws EmailClientExistsException;
}
