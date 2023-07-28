package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.CardRepository;
import br.com.acme.application.domain.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IListCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListCardRepositoryService implements IListCardRepository {

    private final ConverterDTO converterDTO;
    private final CardRepository cardRepository;

    @Override
    public List<CardDomain> execute() {
        return (List<CardDomain>) converterDTO.convertLIstObjects(cardRepository.findAll(), CardDomain.class);
    }
}
