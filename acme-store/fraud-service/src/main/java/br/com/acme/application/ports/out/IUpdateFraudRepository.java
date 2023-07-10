package br.com.acme.application.ports.out;

import br.com.acme.application.domain.FraudDomain;

public interface IUpdateFraudRepository {
    void execute(FraudDomain fraudDomain, Long id);
}
