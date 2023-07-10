package br.com.acme.adapters.input.web.controller;

import br.com.acme.adapters.input.web.api.FraudApi;
import br.com.acme.adapters.input.web.request.FraudRequest;
import br.com.acme.adapters.input.web.response.FraudResponse;
import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.in.*;
import br.com.acme.application.usecase.CreateFraudUseCase;
import br.com.acme.application.usecase.ListFraudsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FraudController implements FraudApi {
    private final ICreateFraudDomainUseCase createFraudUseCase;
    private final IListFraudsUseCase listFraudsUseCase;

    private final IUpdateFraudUseCase iUpdateFraudUseCase;
    private final ICheckFraudUseCase iCheckFraudUseCase;
    private final IDeleteFraudUseCase iDeleteFraudUseCase;
    private final ConverterDTO converterDTO;
    @Override
    public ResponseEntity<FraudResponse> create(FraudRequest fraudRequest) {
        var domain = (FraudDomain) converterDTO.convertObject(fraudRequest, FraudDomain.class);
        var response = (FraudResponse) converterDTO
                .convertObject(createFraudUseCase.execute(domain), FraudResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<FraudResponse>> list() {
        var domains = listFraudsUseCase.execute();
        var response = (List<FraudResponse>) converterDTO.convertLIstObjects(domains, FraudResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity delete(Long id) {
        this.iDeleteFraudUseCase.execute(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity checkFraud(Long id) {
        this.iCheckFraudUseCase.execute(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity update(FraudRequest fraudRequest, Long id) {
        var request = (FraudDomain) converterDTO.convertObject(fraudRequest, FraudDomain.class);
        this.iUpdateFraudUseCase.execute(request, id);
        return ResponseEntity.ok().build();
    }
}
