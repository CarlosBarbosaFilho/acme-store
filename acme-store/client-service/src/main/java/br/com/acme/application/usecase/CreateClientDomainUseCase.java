package br.com.acme.application.usecase;

import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.ports.in.ICreateClientDomainUseCase;
import br.com.acme.application.ports.out.ICreateClientRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@UseCase
@AllArgsConstructor
public class CreateClientDomainUseCase implements ICreateClientDomainUseCase {

    private final ICreateClientRepository iCreateClientRepository;

    @Override
    public ClientDomain execute(ClientDomain clientDomain) {
        return clientDomain.save(iCreateClientRepository);
    }
}
