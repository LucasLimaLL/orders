package com.techchallange.orders.adapters.persistence.mapper;

import com.techchallange.orders.adapters.persistence.entities.UserEntity;
import com.techchallange.orders.core.domains.user.Cpf;
import com.techchallange.orders.core.domains.user.Email;
import com.techchallange.orders.core.domains.user.User;

import static java.util.Objects.isNull;

public class ClientMapper {
    public static UserEntity toEntity(User requester) {
        return isNull(requester)
                ? null
                : UserEntity
                .builder()
                .withCpf(requester.getCpf().getNumber())
                .withName(requester.getName())
                .withEmail(requester.getEmail().getEmail())
                .build();
    }

    public static User toDomain(UserEntity requester) {
        return isNull(requester)
                ? null
                : User
                .builder()
                .withCpf(new Cpf(requester.getCpf()))
                .withName(requester.getName())
                .withEmail(new Email(requester.getEmail()))
                .build();
    }
}
