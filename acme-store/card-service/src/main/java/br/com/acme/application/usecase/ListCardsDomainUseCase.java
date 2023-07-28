package br.com.acme.application.usecase;

import br.com.acme.application.domain.CardDomain;
import br.com.acme.application.ports.in.IListCardRepositoryUseCase;
import br.com.acme.application.ports.out.IListCardRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@UseCase
@AllArgsConstructor
public class ListCardsDomainUseCase implements IListCardRepositoryUseCase {

    private final IListCardRepository iListCardRepository;

    @Override
    public List<CardDomain> execute() {
        return CardDomain.builder().build().list(iListCardRepository);
    }
}
