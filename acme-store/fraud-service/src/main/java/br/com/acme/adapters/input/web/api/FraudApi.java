package br.com.acme.adapters.input.web.api;

import br.com.acme.adapters.input.web.request.FraudRequest;
import br.com.acme.adapters.input.web.response.FraudResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/api/v1/frauds")
public interface FraudApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<FraudResponse>create(@RequestBody FraudRequest fraudRequest);
}
