package br.com.acme.adapters.input.web.controller;

import br.com.acme.adapters.input.web.api.CardApi;
import br.com.acme.adapters.input.web.request.CardRequest;
import br.com.acme.adapters.input.web.response.CardResponse;
import br.com.acme.application.domain.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.in.ICreateCardDomainUseCase;
import br.com.acme.application.ports.in.IDeleteCardDomainUseCase;
import br.com.acme.application.ports.in.IListCardRepositoryUseCase;
import br.com.acme.application.ports.in.IUpdateCardDomainUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class CardController implements CardApi {
    private final ICreateCardDomainUseCase iCreateCardDomainUseCase;

    private final IListCardRepositoryUseCase iListCardRepositoryUseCase;

    private final IDeleteCardDomainUseCase iDeleteCardDomainUseCase;

    private final IUpdateCardDomainUseCase iUpdateCardDomainUseCase;
    private final ConverterDTO converterDTO;

    @Override
    public ResponseEntity<CardResponse> create(CardRequest cardRequest) {
        var domain = (CardDomain) converterDTO.convertObject(cardRequest, CardDomain.class);
        var response =  (CardResponse) converterDTO
                .convertObject(iCreateCardDomainUseCase.execute(domain), CardResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<CardResponse>> list() {
        var response_domain = this.iListCardRepositoryUseCase.execute();
        var response = (List<CardResponse>) converterDTO.convertLIstObjects(response_domain, CardResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity delete(Long id) {
        this.iDeleteCardDomainUseCase.execute(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity update(CardRequest request, Long id) {
        var domain = (CardDomain) converterDTO.convertObject(request, CardDomain.class);
        this.iUpdateCardDomainUseCase.execute(domain, id);
        return ResponseEntity.ok().build();
    }
}
