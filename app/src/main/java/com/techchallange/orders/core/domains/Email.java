package com.techchallange.orders.core.domains;

import lombok.Getter;

@Getter
public class Email {

    private final String email;

    public Email(String email) {
        // TODO validar email
        this.email = email;
    }
}
