package br.com.acme.adapters.input.web.request;

import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CardRequest {
    private String card_name;
    private String card_flag;
    private BigDecimal income;
    private BigDecimal card_limit;
}
