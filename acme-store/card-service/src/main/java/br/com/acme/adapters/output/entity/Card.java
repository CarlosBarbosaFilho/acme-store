package br.com.acme.adapters.output.entity;

import jakarta.persistence.Entity;
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
    private Long id;
    private String flag;
    private String number;
    private BigDecimal limit;
}
