package br.com.acme.application.usecase;

import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.ports.in.ICreateFraudDomainUseCase;
import br.com.acme.application.ports.out.ICreateFraudRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@UseCase
@AllArgsConstructor
public class ICreateFraudUseCase implements ICreateFraudDomainUseCase {

    private final ICreateFraudRepository iCreateFraudRepository;
    @Override
    public FraudDomain execute(FraudDomain fraudDomain) {
        return fraudDomain.save(iCreateFraudRepository);
    }
}
