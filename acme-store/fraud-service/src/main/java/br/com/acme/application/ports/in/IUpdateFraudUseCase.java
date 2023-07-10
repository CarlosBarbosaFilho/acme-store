package br.com.acme.application.ports.in;

import br.com.acme.application.domain.FraudDomain;

public interface IUpdateFraudUseCase {
    void execute(FraudDomain fraudDomain, Long id);
}
