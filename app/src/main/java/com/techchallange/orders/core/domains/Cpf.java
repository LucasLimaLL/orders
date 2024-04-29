package com.techchallange.orders.core.domains;

import lombok.Getter;

@Getter
public class Cpf {

    private final String number;

    public Cpf(String number) {
        //TODO validar CPF
        this.number = number;
    }
}
