package br.com.acme.adapters.input.web.api;

import br.com.acme.adapters.input.web.api.request.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/login")
@CrossOrigin(origins = "http://localhost:4200")
public interface LoginApi {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity login(@RequestBody LoginRequest loginRequest);
}
