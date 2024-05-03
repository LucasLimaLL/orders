package com.techchallange.orders.core.domains.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with", toBuilder = true)
public class User {

    private Cpf cpf;
    private String name;
    private Email email;
}
