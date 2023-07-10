package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.FraudRepository;
import br.com.acme.application.domain.FraudDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IListFraudsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListFraudsRepositoryService implements IListFraudsRepository {

    private final FraudRepository fraudRepository;
    private final ConverterDTO converterDTO;

    @Override
    public List<FraudDomain> execute() {
        return (List<FraudDomain>) converterDTO
                .convertLIstObjects(this.fraudRepository.findAll(), FraudDomain.class);
    }
}
