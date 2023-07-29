package br.com.acme.application.ports.out;

import br.com.acme.application.domain.CardDomain;

import java.math.BigDecimal;
import java.util.List;

public interface IListCardAvailableClientRepository {
    List<CardDomain> execute(String income);
}
