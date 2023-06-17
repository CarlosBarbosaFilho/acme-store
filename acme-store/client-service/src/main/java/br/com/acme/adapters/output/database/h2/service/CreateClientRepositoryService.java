package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.entity.Client;
import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.ports.out.ICreateClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateClientRepositoryService implements ICreateClientRepository {

    private final ClientRepository clientRepository;
    @Override
    public ClientDomain execute(ClientDomain clientDomain) {


        return domain;
    }
}
