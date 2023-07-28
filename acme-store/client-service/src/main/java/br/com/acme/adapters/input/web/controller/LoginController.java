package br.com.acme.adapters.input.web.controller;

import br.com.acme.adapters.input.web.api.LoginApi;
import br.com.acme.adapters.input.web.api.request.LoginRequest;
import br.com.acme.adapters.input.web.api.response.ClientResponse;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.domain.exception.ClientNotFundException;
import br.com.acme.application.domain.exception.ErrorLoginClientException;
import br.com.acme.application.ports.in.ILoginUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class LoginController implements LoginApi {

    private final ILoginUseCase iLoginUseCase;

    @Override
    public ResponseEntity<String> login(LoginRequest loginRequest) {
        //HttpHeaders headersResponse = new HttpHeaders();
        var response = this.iLoginUseCase.execute(loginRequest.getEmail(), loginRequest.getPassword());
        //headersResponse.set("response-login", response);
        return ResponseEntity.ok()
                .body(response);
    }
}
