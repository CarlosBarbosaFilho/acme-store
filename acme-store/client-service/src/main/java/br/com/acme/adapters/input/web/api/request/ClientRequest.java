package br.com.acme.adapters.input.web.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientRequest {
    private String name;
    private String email;
    private String document;
    private String phone;
}
