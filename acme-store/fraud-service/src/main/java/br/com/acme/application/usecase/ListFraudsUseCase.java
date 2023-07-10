package br.com.acme.application.usecase;

import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.ports.in.IListFraudsUseCase;
import br.com.acme.application.ports.out.IListFraudsRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@UseCase
public class ListFraudsUseCase implements IListFraudsUseCase {

    private final IListFraudsRepository iListFraudsRepository;

    @Override
    public List<FraudDomain> execute() {
        return FraudDomain.builder().build()
                .listFrauds(iListFraudsRepository);
    }
}
