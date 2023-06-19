package br.com.acme.adapters.input.web.controller;

import br.com.acme.adapters.input.web.api.ClientApi;
import br.com.acme.adapters.input.web.api.exception.errors.ClientNotFundException;
import br.com.acme.adapters.input.web.api.request.ClientRequest;
import br.com.acme.adapters.input.web.api.response.ClientResponse;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.in.ICreateClientDomainUseCase;
import br.com.acme.application.ports.in.IDeleteClientDomainByIdUseCase;
import br.com.acme.application.ports.in.IGetClientDomainGetByIdUseCase;
import br.com.acme.application.ports.in.IListClientDomainUseCase;
import lombok.AllArgsConstructor;
import org.junit.platform.commons.function.Try;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ClientController implements ClientApi {
    private final ICreateClientDomainUseCase iCreateClientDomainUseCase;
    private final IListClientDomainUseCase iListClientDomainUseCase;
    private final IGetClientDomainGetByIdUseCase iGetClientDomainGetByIdUseCase;
    private final IDeleteClientDomainByIdUseCase iDeleteClientDomainByIdUseCase;

    private final ConverterDTO converterDTO;
    @Override
    public ResponseEntity<ClientResponse> create(ClientRequest clientRequest) {
            var domain = (ClientDomain) converterDTO.convertObject(clientRequest, ClientDomain.class);
            var response = this.iCreateClientDomainUseCase.execute(domain);
            return ResponseEntity.ok((ClientResponse) converterDTO.convertObject(response, ClientResponse.class));
    }

    @Override
    public ResponseEntity<List<ClientResponse>> list() {
        var response = (List<ClientResponse>)
                converterDTO.convertLIstObjects(this.iListClientDomainUseCase.execute(), ClientResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ClientResponse> get(Long id){
        try {
            var domain = (ClientDomain) this.iGetClientDomainGetByIdUseCase.execute(id);
            return ResponseEntity.ok((ClientResponse) converterDTO
                    .convertObject(domain, ClientResponse.class));
        }catch (ClientNotFundException e) {
            throw new ClientNotFundException(id);
        }
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        this.iDeleteClientDomainByIdUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
