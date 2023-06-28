package br.com.acme.adapters.output.database.h2.entity;

import br.com.acme.adapters.output.entity.Card;
import br.com.acme.application.domain.vo.Phone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String document;
    private String phone;
}
