package br.com.acme.application.ports.in;

import br.com.acme.application.domain.FraudDomain;

public interface UpdateFraudUseCase {
    void execute(FraudDomain fraudDomain, Long id);
}
