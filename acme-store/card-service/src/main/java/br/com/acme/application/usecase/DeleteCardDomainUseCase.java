package br.com.acme.application.usecase;

import br.com.acme.application.domain.CardDomain;
import br.com.acme.application.ports.in.IDeleteCardDomainUseCase;
import br.com.acme.application.ports.out.IDeleteCardRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class DeleteCardDomainUseCase implements IDeleteCardDomainUseCase {

    private final IDeleteCardRepository iDeleteCardRepository;

    @Override
    public void execute(Long id) {
        CardDomain.builder().id(id).build().delete(iDeleteCardRepository);
    }
}
