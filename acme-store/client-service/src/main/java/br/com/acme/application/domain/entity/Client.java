package br.com.acme.application.domain.entity;

import br.com.acme.application.domain.vo.Document;
import br.com.acme.application.domain.vo.Email;
import br.com.acme.application.domain.vo.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    private Long id;
    private String name;
    private Email email;
    private Document document;
    private Phone phone;
    private List<Card> card;

}
