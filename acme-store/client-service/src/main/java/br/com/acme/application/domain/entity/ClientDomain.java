package br.com.acme.application.domain.entity;

import br.com.acme.application.ports.out.ICreateClientRepository;
import br.com.acme.application.ports.out.IDeleteClientDomainByIdRepository;
import br.com.acme.application.ports.out.IGetClientDomainGetByIdRepository;
import br.com.acme.application.ports.out.IListClientDomainRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDomain {
    private Long id;
    private String name;
    private String email;
    private String document;
    private String phone;
    private String password;
    private BigDecimal income;

    public ClientDomain save(ICreateClientRepository iCreateClientRepository){
        return iCreateClientRepository.execute(this);
    }

    public List<ClientDomain> list(IListClientDomainRepository iListClientDomainRepository){
        return iListClientDomainRepository.execute();
    }

    public ClientDomain getById(IGetClientDomainGetByIdRepository iGetClientDomainGetByIdRepository) {
        return iGetClientDomainGetByIdRepository.execute(this.id);
    }

    public void deleteClientDomain(IDeleteClientDomainByIdRepository iDeleteClientDomainByIdRepository) {
        iDeleteClientDomainByIdRepository.execute(this.id);
    }

    public void update(IGetClientDomainGetByIdRepository iGetClientDomainGetByIdRepository,
                       ICreateClientRepository iCreateClientRepository) {
        var clientDomain = iGetClientDomainGetByIdRepository.execute(this.id);
        clientDomain.setId(this.id);
        clientDomain.setName(this.name);
        clientDomain.setDocument(this.document);
        clientDomain.setPhone(this.phone);
        clientDomain.setIncome(this.income);
        clientDomain.setEmail(this.email);
        clientDomain.setPassword(this.password);
        iGetClientDomainGetByIdRepository.execute(this.id);
        iCreateClientRepository.execute(clientDomain);
    }

}
