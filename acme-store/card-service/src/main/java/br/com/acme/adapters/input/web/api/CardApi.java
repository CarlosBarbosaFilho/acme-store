package br.com.acme.adapters.input.web.api;

import br.com.acme.adapters.input.web.request.CardRequest;
import br.com.acme.adapters.input.web.response.CardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/api/v1/cards")
public interface CardApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<CardResponse> create(@RequestBody CardRequest cardRequest);
}
