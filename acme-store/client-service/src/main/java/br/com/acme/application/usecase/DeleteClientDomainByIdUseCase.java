package br.com.acme.application.usecase;

import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.ports.in.IDeleteClientDomainByIdUseCase;
import br.com.acme.application.ports.out.IDeleteClientDomainByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteClientDomainByIdUseCase implements IDeleteClientDomainByIdUseCase {
    private final IDeleteClientDomainByIdRepository iDeleteClientDomainByIdRepository;
    @Override
    public void execute(Long id) {
        ClientDomain.builder()
                .id(id)
                .build()
                .deleteClientDomain(iDeleteClientDomainByIdRepository);
    }
}
