package com.techchallange.orders.adapters.web.mapper;

import com.techchallange.orders.adapters.web.dto.ComboDto;
import com.techchallange.orders.adapters.web.dto.UserDto;
import com.techchallange.orders.core.domains.Combo;
import com.techchallange.orders.core.domains.Cpf;
import com.techchallange.orders.core.domains.Email;
import com.techchallange.orders.core.domains.User;

import java.util.List;

import static java.util.Objects.isNull;

public class CreateOrderPortInUserWebMapper {

    public static User toDomain(UserDto user) {
        return isNull(user)
                ? null
                : User
                .builder()
                .withName(user.getName())
                .withCpf(new Cpf(user.getCpf()))
                .withEmail(new Email(user.getEmail()))
                .build();
    }
}
