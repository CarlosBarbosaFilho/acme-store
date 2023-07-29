package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.CardRepository;
import br.com.acme.application.domain.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IListCardAvailableClientRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ListCardsAvailableClientRepositoryService implements IListCardAvailableClientRepository {

    private final CardRepository cardRepository;
    private final ConverterDTO converterDTO;
    @Override
    public List<CardDomain> execute(String income) {
        var cards = this.cardRepository.returnListCardsByIncome(income);
        return (List<CardDomain>)
                converterDTO.convertLIstObjects(cards, CardDomain.class);
    }
}
