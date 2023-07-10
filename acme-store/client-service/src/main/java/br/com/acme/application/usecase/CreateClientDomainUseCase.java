package br.com.acme.application.usecase;

import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.domain.exception.EmailClientExistsException;
import br.com.acme.application.ports.in.ICreateClientDomainUseCase;
import br.com.acme.application.ports.out.ICheckExistsEmailRepository;
import br.com.acme.application.ports.out.ICreateClientRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateClientDomainUseCase implements ICreateClientDomainUseCase {

    private final ICreateClientRepository iCreateClientRepository;
    private final ICheckExistsEmailRepository iCheckExistsEmailRepository;

    @Override
    public ClientDomain execute(ClientDomain clientDomain){
        if (!iCheckExistsEmailRepository.execute(clientDomain.getEmail())){
            return clientDomain.save(iCreateClientRepository);
        }else {
            throw new EmailClientExistsException(clientDomain.getEmail());
        }

    }
}
