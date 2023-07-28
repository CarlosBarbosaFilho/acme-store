package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IUpdateClientDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateClientDomainRepositoryService implements IUpdateClientDomainRepository {

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;

    @Override
    public void execute(ClientDomain clientDomain, Long id) {
        var entity = this.clientRepository.findById(id).get();
        entity.setDocument(clientDomain.getDocument());
        entity.setPhone(clientDomain.getPhone());
        entity.setEmail(clientDomain.getEmail());
        entity.setName(clientDomain.getName());
        entity.setIncome(clientDomain.getIncome());
        entity.setPassword(clientDomain.getPassword());
        entity.setId(id);
        this.clientRepository.saveAndFlush(entity);

    }
}
