package br.com.acme.application.usecase;

import br.com.acme.application.domain.CardDomain;
import br.com.acme.application.ports.in.IUpdateCardDomainUseCase;
import br.com.acme.application.ports.out.ICreateCardRepository;
import br.com.acme.application.ports.out.IGetCardByIdRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class UpdateCardDomainUseCase implements IUpdateCardDomainUseCase {

    private final ICreateCardRepository iCreateCardRepository;
    private final IGetCardByIdRepository iGetCardByIdRepository;

    @Override
    public void execute(CardDomain cardDomain, Long id) {
        cardDomain.setId(id);
        cardDomain.update(iGetCardByIdRepository, iCreateCardRepository);
    }
}
