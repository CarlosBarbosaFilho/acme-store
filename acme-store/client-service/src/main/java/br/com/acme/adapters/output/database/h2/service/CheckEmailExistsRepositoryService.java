package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.ports.out.ICheckExistsEmailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckEmailExistsRepositoryService implements ICheckExistsEmailRepository {

    private final ClientRepository clientRepository;

    @Override
    public boolean execute(String email) {
        var client = this.clientRepository.findClientByEmail(email);
        return client != null;
    }
}
