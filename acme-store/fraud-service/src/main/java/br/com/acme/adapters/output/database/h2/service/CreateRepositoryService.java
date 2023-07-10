package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.entity.Fraud;
import br.com.acme.adapters.output.database.h2.repository.FraudRepository;
import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.ICreateFraudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateRepositoryService implements ICreateFraudRepository {

    private final FraudRepository fraudRepository;
    private final ConverterDTO converterDTO;
    @Override
    public FraudDomain execute(FraudDomain fraudDomain) {
        var entity = (Fraud) converterDTO.convertObject(fraudDomain, Fraud.class);
        return (FraudDomain) converterDTO
                .convertObject(this.fraudRepository.save(entity), FraudDomain.class);
    }
}
