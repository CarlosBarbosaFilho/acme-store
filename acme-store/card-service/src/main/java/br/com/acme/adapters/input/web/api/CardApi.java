package br.com.acme.adapters.input.web.api;

import br.com.acme.adapters.input.web.request.CardRequest;
import br.com.acme.adapters.input.web.response.CardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/cards")
@CrossOrigin(origins = "http://localhost:4200")
public interface CardApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<CardResponse> create(@RequestBody CardRequest cardRequest);

    @GetMapping("/{income}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<CardResponse>> getCardsAvailableClient(@PathVariable("income") String income);
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<CardResponse>> list();

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity delete(@PathVariable("id") Long id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity update(@RequestBody CardRequest request, @PathVariable("id") Long id);
}
