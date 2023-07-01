package br.com.acme.application.usecase;

import br.com.acme.application.domain.CardDomain;
import br.com.acme.application.ports.in.ICreateCardDomainUseCase;
import br.com.acme.application.ports.out.ICreateCardRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@UseCase
@AllArgsConstructor
public class CreateCardDomainUseCase implements ICreateCardDomainUseCase {

    private final ICreateCardRepository iCreateCardRepository;

    @Override
    public CardDomain execute(CardDomain cardDomain) {
        return cardDomain.save(iCreateCardRepository);
    }
}
