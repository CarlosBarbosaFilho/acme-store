package br.com.acme.application.usecase;

import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.ports.in.ICheckFraudUseCase;
import br.com.acme.application.ports.out.ICheckFraudRepository;
import br.com.acme.application.ports.out.IGetFraudByIdRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CheckFraudUseCase implements ICheckFraudUseCase {

    private final ICheckFraudRepository iCheckFraudRepository;
    private final IGetFraudByIdRepository iGetFraudByIdRepository;

    @Override
    public void execute(Long id) {
        FraudDomain.builder()
                .id(id)
                .build().checkFraud(iCheckFraudRepository, iGetFraudByIdRepository);
    }
}
