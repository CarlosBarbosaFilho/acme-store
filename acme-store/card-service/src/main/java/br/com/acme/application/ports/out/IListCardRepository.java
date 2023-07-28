package br.com.acme.application.ports.out;

import br.com.acme.application.domain.CardDomain;

import java.util.List;

public interface IListCardRepository {

    List<CardDomain> execute();
}
