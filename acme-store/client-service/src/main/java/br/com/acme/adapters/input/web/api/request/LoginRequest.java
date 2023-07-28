package br.com.acme.adapters.input.web.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginRequest {

    @NotBlank(message = "email is empty")
    private String email;

    @NotBlank(message = "password is empty")
    private String password;
}
