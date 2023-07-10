package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.FraudRepository;
import br.com.acme.application.ports.out.IDeleteFraudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteRepositoryService implements IDeleteFraudRepository {

    private final FraudRepository fraudRepository;

    @Override
    public void execute(Long id) {
        this.fraudRepository.deleteById(id);
    }
}
