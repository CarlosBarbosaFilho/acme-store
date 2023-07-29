package br.com.acme.application.usecase;

import br.com.acme.application.domain.CardDomain;
import br.com.acme.application.ports.in.IListCardsAvailableClientUseCase;
import br.com.acme.application.ports.out.IListCardAvailableClientRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@UseCase
@AllArgsConstructor
public class ListCardsAvailableClientUseCase implements IListCardsAvailableClientUseCase {

    private final IListCardAvailableClientRepository iListCardAvailableClientRepository;
    @Override
    public List<CardDomain> execute(String income) {
        return CardDomain.builder().income(new BigDecimal(income))
                .build().listAvailableCardsClient(iListCardAvailableClientRepository);
    }
}
