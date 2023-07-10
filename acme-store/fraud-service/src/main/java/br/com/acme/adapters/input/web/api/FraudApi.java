package br.com.acme.adapters.input.web.api;

import br.com.acme.adapters.input.web.request.FraudRequest;
import br.com.acme.adapters.input.web.response.FraudResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/frauds")
@CrossOrigin(origins = "http://localhost:4200")
public interface FraudApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<FraudResponse>create(@RequestBody FraudRequest fraudRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<FraudResponse>> list();

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity delete(@PathVariable("id") Long id);

    @GetMapping("check-fraud/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity checkFraud(@PathVariable("id") Long id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity update(@RequestBody FraudRequest fraudRequest,
                                        @PathVariable("id") Long id);
}
