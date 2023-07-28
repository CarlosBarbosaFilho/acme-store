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
    @NotNull(message = "name is empty")
    private String name;
    @NotBlank(message = "e-mail is empty")
    private String email;
    @NotBlank(message = "document is empty")
    private String document;
    @NotBlank(message = "phone is empty")
    private String phone;
    @NotBlank(message = "password is empty")
    private String password;
    @NotBlank(message = "income is empty")
    private String income;


}
