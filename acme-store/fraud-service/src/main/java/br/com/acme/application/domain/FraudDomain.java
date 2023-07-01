package br.com.acme.application.domain;

import br.com.acme.application.ports.out.ICreateFraudRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FraudDomain {

    private Long id;
    private String document;
    private boolean active = true;
    private LocalDateTime create_at = LocalDateTime.now();
    private LocalDateTime update_at = null;

    public FraudDomain save(ICreateFraudRepository iCreateFraudRepository){
        return iCreateFraudRepository.execute(this);
    }
    public FraudDomain checkActive(String document) {
        return null;
    }
    public boolean disableFraud(String document){
        return false;
    }
}
