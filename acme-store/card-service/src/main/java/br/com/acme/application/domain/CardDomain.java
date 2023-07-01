package br.com.acme.application.domain;

import br.com.acme.application.ports.out.ICreateCardRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
}
