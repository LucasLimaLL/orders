package com.techchallange.orders.core.domains;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

    private Cpf cpf;
    private String nome;
    private Email email;
}
