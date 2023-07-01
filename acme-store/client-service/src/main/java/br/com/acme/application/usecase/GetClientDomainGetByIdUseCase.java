package br.com.acme.application.usecase;

import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.ports.in.IGetClientDomainGetByIdUseCase;
import br.com.acme.application.ports.out.IGetClientDomainGetByIdRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@UseCase
@AllArgsConstructor
public class GetClientDomainGetByIdUseCase implements IGetClientDomainGetByIdUseCase {

    private final IGetClientDomainGetByIdRepository iGetClientDomainGetByIdRepository;
    @Override
    public ClientDomain execute(Long id) {
        return ClientDomain.builder()
                .id(id)
                .build().getById(iGetClientDomainGetByIdRepository);
    }
}
