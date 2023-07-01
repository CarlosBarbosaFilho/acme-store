package br.com.acme.application.ports.out;

import br.com.acme.adapters.output.database.h2.entity.Card;
import br.com.acme.application.domain.CardDomain;

public interface ICreateCardRepository {
    CardDomain execute(CardDomain cardDomain);
}
