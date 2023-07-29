package br.com.acme.adapters.output.external.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CardsAvailableClient {
    private String card_name;
    private String flag_name;
    private BigDecimal card_limit;
    private BigDecimal income;
}
