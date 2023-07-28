package br.com.acme.application.usecase;

import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.ports.in.IUpdateClientUseCase;
import br.com.acme.application.ports.out.ICreateClientRepository;
import br.com.acme.application.ports.out.IGetClientDomainGetByIdRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class UpdateClientDomainUseCase implements IUpdateClientUseCase {

    private final ICreateClientRepository iCreateClientRepository;
    private final IGetClientDomainGetByIdRepository iGetClientDomainGetByIdRepository;

    @Override
    public void execute(ClientDomain clientDomain, Long id) {
        clientDomain.setId(id);
        clientDomain.update(iGetClientDomainGetByIdRepository,
                iCreateClientRepository);
    }
}
