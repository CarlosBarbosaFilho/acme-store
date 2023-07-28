package br.com.acme.application.usecase;

import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.ports.in.IUpdateFraudUseCase;
import br.com.acme.application.ports.out.ICreateFraudRepository;
import br.com.acme.application.ports.out.IGetFraudByIdRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class UpdateFraudUseCase implements IUpdateFraudUseCase {

    private final ICreateFraudRepository iCreateFraudRepository;
    private final IGetFraudByIdRepository iGetFraudByIdRepository;

    @Override
    public void execute(FraudDomain fraudDomain, Long id) {
        fraudDomain.setId(id);
        fraudDomain.update(iGetFraudByIdRepository, iCreateFraudRepository);
    }
}
