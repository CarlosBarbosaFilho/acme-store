package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.entity.Card;
import br.com.acme.adapters.output.database.h2.repository.CardRepository;
import br.com.acme.application.domain.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.ICreateCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCardRepositoryService implements ICreateCardRepository {
    private final CardRepository cardRepository;
    private final ConverterDTO converterDTO;
    @Override
    public CardDomain execute(CardDomain cardDomain) {
        var entity = (Card)  converterDTO.convertObject(cardDomain, Card.class);
        return (CardDomain) converterDTO.convertObject(this.cardRepository.save(entity), CardDomain.class);
    }
}
