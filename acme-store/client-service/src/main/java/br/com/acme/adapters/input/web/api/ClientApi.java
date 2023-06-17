package br.com.acme.adapters.input.web.api;

import br.com.acme.adapters.input.web.api.request.ClientRequest;
import br.com.acme.adapters.input.web.api.response.ClientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/clients")
public interface ClientApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ClientResponse> create(@RequestBody ClientRequest clientRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ClientResponse>> list();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ClientResponse> get(@PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> delete(@PathVariable("id") Long id);


}
