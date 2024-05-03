package com.techchallange.orders.support;

import com.techchallange.orders.core.domains.user.Cpf;
import com.techchallange.orders.core.domains.user.Email;
import com.techchallange.orders.core.domains.user.User;

public class UserSupport {

    private UserSupport() {}

    public static User getUser() {
        return User
                .builder()
                .withName("Fulano da Silva")
                .withCpf(new Cpf("01234567890"))
                .withEmail(new Email("fulano@detal.com.br"))
                .build();
    }

}
