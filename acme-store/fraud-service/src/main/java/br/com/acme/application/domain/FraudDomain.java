package br.com.acme.application.domain;

import br.com.acme.application.ports.out.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<FraudDomain> listFrauds(IListFraudsRepository iListFraudsRepository) {
        return iListFraudsRepository.execute();
    }

    public void delete(IDeleteFraudRepository iDeleteFraudRepository) {
        iDeleteFraudRepository.execute(this.id);
    }

    public void checkFraud(ICheckFraudRepository iCheckFraudRepository,
                           IGetFraudByIdRepository iGetFraudByIdRepository){
        var fraud = iGetFraudByIdRepository.execute(this.id);
        fraud.setId(this.id);
        fraud.setActive(!fraud.isActive());
        fraud.setUpdate_at(LocalDateTime.now());
        iGetFraudByIdRepository.execute(this.id);
        iCheckFraudRepository.execute(fraud);
    }

    public void update(IGetFraudByIdRepository iGetFraudByIdRepository,
                       ICreateFraudRepository iCreateFraudRepository) {
        var fraud = iGetFraudByIdRepository.execute(this.id);
        fraud.setId(this.id);
        fraud.setDocument(this.document);
        iGetFraudByIdRepository.execute(this.id);
        iCreateFraudRepository.execute(fraud);
    }

    public FraudDomain getFraud(IGetFraudByIdRepository iGetFraudByIdRepository){
        return iGetFraudByIdRepository.execute(this.id);
    }
}
