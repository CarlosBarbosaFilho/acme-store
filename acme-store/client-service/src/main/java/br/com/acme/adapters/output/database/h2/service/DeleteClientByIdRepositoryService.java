package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.ports.out.IDeleteClientDomainByIdRepository;
import lombok.AllArgsConstructor;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteClientByIdRepositoryService implements IDeleteClientDomainByIdRepository {
    private final ClientRepository clientRepository;
    @Override
    public void execute(Long id) {
        this.clientRepository.deleteById(id);
    }
}
