package br.com.acme.application.usecase;

import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.ports.in.IDeleteFraudUseCase;
import br.com.acme.application.ports.out.IDeleteFraudRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class DeleteFraudUseCase implements IDeleteFraudUseCase {

    private final IDeleteFraudRepository iDeleteFraudRepository;

    @Override
    public void execute(Long id) {
        FraudDomain.builder()
                .id(id)
                .build().delete(iDeleteFraudRepository);
    }
}
