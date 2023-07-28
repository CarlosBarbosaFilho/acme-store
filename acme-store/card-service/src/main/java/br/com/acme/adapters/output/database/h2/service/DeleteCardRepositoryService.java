package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.CardRepository;
import br.com.acme.application.ports.out.IDeleteCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteCardRepositoryService implements IDeleteCardRepository {

    private final CardRepository cardRepository;

    @Override
    public void execute(Long id) {
        this.cardRepository.deleteById(id);
    }
}
