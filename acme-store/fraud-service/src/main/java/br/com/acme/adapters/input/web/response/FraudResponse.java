package br.com.acme.adapters.input.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FraudResponse {

    private Long id;
    private String document;
    private boolean active = true;
    private LocalDateTime create_at = LocalDateTime.now();
    private LocalDateTime update_at = null;
}
