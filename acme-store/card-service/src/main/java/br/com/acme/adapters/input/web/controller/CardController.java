package br.com.acme.adapters.input.web.controller;

import br.com.acme.adapters.input.web.api.CardApi;
import br.com.acme.adapters.input.web.request.CardRequest;
import br.com.acme.adapters.input.web.response.CardResponse;
import br.com.acme.application.domain.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.in.ICreateCardDomainUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class CardController implements CardApi {
    private final ICreateCardDomainUseCase iCreateCardDomainUseCase;
    private final ConverterDTO converterDTO;

    @Override
    public ResponseEntity<CardResponse> create(CardRequest cardRequest) {
        var domain = (CardDomain) converterDTO.convertObject(cardRequest, CardDomain.class);
        var response =  (CardResponse) converterDTO
                .convertObject(iCreateCardDomainUseCase.execute(domain), CardResponse.class);
        return ResponseEntity.ok(response);
    }
}
