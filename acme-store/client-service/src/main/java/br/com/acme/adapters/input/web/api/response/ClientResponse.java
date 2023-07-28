package br.com.acme.adapters.input.web.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientResponse {
    private Long id;
    private String name;
    private String email;
    private String document;
    private String phone;
    private BigDecimal income;
    private String password;
}
