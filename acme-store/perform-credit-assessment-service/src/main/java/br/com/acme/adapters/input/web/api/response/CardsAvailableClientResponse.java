package br.com.acme.adapters.input.web.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardsAvailableClientResponse {

    private String card_name;
    private String flag_name;
    private BigDecimal card_limit;
    private BigDecimal income;
}
