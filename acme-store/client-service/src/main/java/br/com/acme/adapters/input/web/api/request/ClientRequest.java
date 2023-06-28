package br.com.acme.adapters.input.web.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientRequest {
    @NotNull(message = "name is not empty")
    private String name;
    @NotBlank(message = "e-mail is not blank")
    private String email;
    private String document;
    private String phone;
}
