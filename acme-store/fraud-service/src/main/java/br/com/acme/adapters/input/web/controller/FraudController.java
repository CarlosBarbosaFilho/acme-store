package br.com.acme.adapters.input.web.controller;

import br.com.acme.adapters.input.web.api.FraudApi;
import br.com.acme.adapters.input.web.request.FraudRequest;
import br.com.acme.adapters.input.web.response.FraudResponse;
import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.usecase.ICreateFraudUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FraudController implements FraudApi {
    private final ICreateFraudUseCase iCreateFraudUseCase;
    private final ConverterDTO converterDTO;
    @Override
    public ResponseEntity<FraudResponse> create(FraudRequest fraudRequest) {
        var domain = (FraudDomain) converterDTO.convertObject(fraudRequest, FraudDomain.class);
        var response = (FraudResponse) converterDTO
                .convertObject(iCreateFraudUseCase.execute(domain), FraudResponse.class);
        return ResponseEntity.ok(response);
    }
}
