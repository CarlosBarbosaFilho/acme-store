package br.com.acme.application.domain.entity;

import br.com.acme.application.ports.out.ILoginRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginDomain {

    private String email;
    private String password;

    public String login(ILoginRepository iLoginRepository) {
        return iLoginRepository.execute(this.email, this.password);
    }
}
