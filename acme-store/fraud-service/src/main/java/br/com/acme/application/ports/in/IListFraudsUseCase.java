package br.com.acme.application.ports.in;

import br.com.acme.application.domain.FraudDomain;

import java.util.List;

public interface IListFraudsUseCase {

    List<FraudDomain> execute();
}
