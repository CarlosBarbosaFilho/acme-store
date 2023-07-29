package br.com.acme.application.domain;

import br.com.acme.application.ports.out.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CardDomain {

    private Long id;
    private String card_name;
    private String card_flag;
    private BigDecimal income;
    private BigDecimal card_limit;

    public CardDomain save(ICreateCardRepository iCreateCardRepository){
        return iCreateCardRepository.execute(this);
    }

    public List<CardDomain> list(IListCardRepository iListCardRepository) {
        return iListCardRepository.execute();
    }

    public void delete(IDeleteCardRepository iDeleteCardRepository) {
        iDeleteCardRepository.execute(this.id);
    }

    public void update(IGetCardByIdRepository iGetCardByIdRepository,
                       ICreateCardRepository iCreateCardRepository) {
        var card = iGetCardByIdRepository.execute(this.id);
        card.setId(this.id);
        card.setCard_limit(this.card_limit);
        card.setCard_flag(this.card_flag);
        card.setCard_name(this.card_name);
        card.setIncome(this.income);
        iGetCardByIdRepository.execute(this.id);
        iCreateCardRepository.execute(card);
    }

    public List<CardDomain> listAvailableCardsClient(IListCardAvailableClientRepository iListCardAvailableClientRepository) {
        return iListCardAvailableClientRepository.execute(this.income.toString());
    }
}
