package br.com.acme.adapters.output.database.h2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Card {

    @Id
    @SequenceGenerator(
            name = "card_seq",
            sequenceName = "card_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "card_seq"
    )
    private Long id;
    private String card_name;
    private String card_flag;
    private BigDecimal income;
    private BigDecimal card_limit;

}
