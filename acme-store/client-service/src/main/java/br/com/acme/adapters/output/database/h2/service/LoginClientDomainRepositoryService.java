package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.domain.exception.ErrorLoginClientException;
import br.com.acme.application.ports.out.ILoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginClientDomainRepositoryService implements ILoginRepository {

    private final ClientRepository clientRepository;

    @Override
    public String execute(String email, String password) throws ErrorLoginClientException {
        var client = this.clientRepository.findClientByEmailAndPassword(email, password);
        if (client == null){
            return "fail";
        }else {
            return "success";
        }
    }
}
