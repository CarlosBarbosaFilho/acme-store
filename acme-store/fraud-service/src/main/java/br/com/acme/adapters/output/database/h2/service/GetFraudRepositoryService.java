package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.FraudRepository;
import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IGetFraudByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetFraudRepositoryService implements IGetFraudByIdRepository {

    private final FraudRepository fraudRepository;
    private final ConverterDTO converterDTO;

    @Override
    public FraudDomain execute(Long id) {
        return (FraudDomain) converterDTO
                .convertObject(this.fraudRepository.findById(id).get(), FraudDomain.class);
    }
}
