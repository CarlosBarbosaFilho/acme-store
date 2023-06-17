package br.com.acme.adapters.input.web.controller;

import br.com.acme.adapters.input.web.api.ClientApi;
import br.com.acme.adapters.input.web.api.request.ClientRequest;
import br.com.acme.adapters.input.web.api.response.ClientResponse;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.in.ICreateClientDomainUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ClientController implements ClientApi {
    private final ICreateClientDomainUseCase iCreateClientDomainUseCase;
    private final ConverterDTO converterDTO;
    @Override
    public ResponseEntity<ClientResponse> create(ClientRequest clientRequest) {
        var domain = (ClientDomain) converterDTO
                .convertObject(clientRequest, ClientDomain.class);
        var response = (ClientResponse) converterDTO
                .convertObject(this.iCreateClientDomainUseCase.execute(domain), ClientResponse.class);

        return ResponseEntity.ok(response);
    }
}
