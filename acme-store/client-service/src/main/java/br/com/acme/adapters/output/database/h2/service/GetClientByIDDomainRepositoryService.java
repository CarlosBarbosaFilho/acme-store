package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.domain.exception.ClientNotFundException;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IGetClientDomainGetByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetClientByIDDomainRepositoryService implements IGetClientDomainGetByIdRepository {

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;
    @Override
    public ClientDomain execute(Long id) {
        return (ClientDomain) converterDTO
                .convertObject(this.clientRepository.findById(id), ClientDomain.class);
    }
}
