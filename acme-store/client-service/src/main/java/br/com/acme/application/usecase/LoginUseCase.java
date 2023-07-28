package br.com.acme.application.usecase;

import br.com.acme.application.domain.entity.LoginDomain;
import br.com.acme.application.ports.in.ILoginUseCase;
import br.com.acme.application.ports.out.ILoginRepository;
import br.com.acme.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class LoginUseCase implements ILoginUseCase {

    private ILoginRepository iLoginRepository;

    @Override
    public String execute(String email, String password) {
        return LoginDomain.builder()
                .email(email)
                .password(password)
                .build().login(iLoginRepository);
    }
}
