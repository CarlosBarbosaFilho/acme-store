package br.com.acme.application.ports.out;

import br.com.acme.application.domain.FraudDomain;

import java.util.List;

public interface IListFraudsRepository {

    List<FraudDomain> execute();
}
