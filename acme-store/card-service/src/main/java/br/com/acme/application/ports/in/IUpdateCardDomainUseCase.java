package br.com.acme.application.ports.in;

import br.com.acme.application.domain.CardDomain;

public interface IUpdateCardDomainUseCase {

    void execute(CardDomain cardDomain, Long id);
}
