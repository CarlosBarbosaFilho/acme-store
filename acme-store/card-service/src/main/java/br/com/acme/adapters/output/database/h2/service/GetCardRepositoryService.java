package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.CardRepository;
import br.com.acme.application.domain.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IGetCardByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetCardRepositoryService implements IGetCardByIdRepository {

    private final ConverterDTO converterDTO;
    private final CardRepository cardRepository;

    @Override
    public CardDomain execute(Long id) {
        return (CardDomain) converterDTO.convertObject(this.cardRepository.findById(id), CardDomain.class);
    }
}
